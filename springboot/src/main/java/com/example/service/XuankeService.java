package com.example.service;

import com.example.common.enums.ResultCodeEnum;
import com.example.common.enums.RoleEnum;
import com.example.common.enums.SegmentEnum;
import com.example.common.enums.WeekEnum;
import com.example.entity.Account;
import com.example.entity.Xuanke;
import com.example.entity.Course;
import com.example.entity.Curriculum;
import com.example.exception.CustomException;
import com.example.mapper.XuankeMapper;
import com.example.mapper.CourseMapper;
import com.example.utils.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 选课信息表业务处理
 **/
@Service
public class XuankeService {

    @Resource
    private XuankeMapper xuankeMapper;
    @Resource
    private CourseMapper courseMapper;

    /**
     * 新增
     */
    public void add(Xuanke xuanke) {
        // 当前选的课
        Course course = courseMapper.selectById(xuanke.getCourseId());
        // 1. 先判断一下该门课选满了没有
        // 1) 我们可以在选课信息表里面查询该门课被选的次数（用这种方式）
        // 2) 这种方式大家自己去尝试：在课程信息表里面加个字段（已选人数），判断当前这门课的这个已选人数字段是否已经等于上课人数字段的值
        List<Xuanke> list = xuankeMapper.selectByCourseId(xuanke.getCourseId());
        if (course.getRenshu().equals(list.size())) {
            throw new CustomException(ResultCodeEnum.KECHENGCUOWU);
        }

        // 2. 判断该学生选的这么课的开课时间有没有和他之前选的课有冲突
        List<Xuanke> sList = xuankeMapper.selectByStudentId(xuanke.getStudentId());
        for (Xuanke dbXuanke : sList) {
            Course tmpCourse = courseMapper.selectById(dbXuanke.getCourseId());
            if (course.getXingqi().equals(tmpCourse.getXingqi()) && course.getSegment().equals(tmpCourse.getSegment())) {
                throw new CustomException("-1", "您之前已经选过" + tmpCourse.getName() + ", 与该门课的上课时间冲突，请重新选择");
            }
        }

        xuankeMapper.insert(xuanke);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        xuankeMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            xuankeMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(Xuanke xuanke) {
        xuankeMapper.updateById(xuanke);
    }

    /**
     * 根据ID查询
     */
    public Xuanke selectById(Integer id) {
        return xuankeMapper.selectById(id);
    }

    /**
     * 查询所有
     */
    public List<Xuanke> selectAll(Xuanke xuanke) {
        return xuankeMapper.selectAll(xuanke);
    }

    /**
     * 分页查询***
     */
    public PageInfo<Xuanke> selectPage(Xuanke xuanke, Integer pageNum, Integer pageSize) {
        Account currentUser = TokenUtils.getCurrentUser();
        if (RoleEnum.LAOSHI.name().equals(currentUser.getRole())) {
            xuanke.setTeacherId(currentUser.getId());
        }
        if (RoleEnum.XUESHENG.name().equals(currentUser.getRole())) {
            xuanke.setStudentId(currentUser.getId());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Xuanke> list = xuankeMapper.selectAll(xuanke);
        return PageInfo.of(list);
    }


    /**
     * 生成对应学生的选课课表
     */
    public List<Curriculum> getCurriculum() {
        Account currentUser = TokenUtils.getCurrentUser();
        // 查询出该学生所有的选课信息
        Xuanke xuanke = new Xuanke();
        xuanke.setStudentId(currentUser.getId());
        List<Xuanke> xuankeList = xuankeMapper.selectAll(xuanke);

        List<Curriculum> list = new ArrayList<>();
        // 按照第几大节和周几来处理数据（总共有5大节，8列数据）
        // 第一大节（08:00 ~ 09:30）
        Curriculum first = new Curriculum();
        first.setSegment(SegmentEnum.DIYIJIE.segment);
        processXingqi(first, getWeekChoiceList(xuankeList, SegmentEnum.DIYIJIE.segment));
        list.add(first);

        // 第二大节（09:40 ~ 12:00）
        Curriculum second = new Curriculum();
        second.setSegment(SegmentEnum.DIERJIE.segment);
        processXingqi(second, getWeekChoiceList(xuankeList, SegmentEnum.DIERJIE.segment));
        list.add(second);

        // 第三大节（14:00 ~ 15:30）
        Curriculum third = new Curriculum();
        third.setSegment(SegmentEnum.DISANJIE.segment);
        processXingqi(third, getWeekChoiceList(xuankeList, SegmentEnum.DISANJIE.segment));
        list.add(third);

        // 第四大节（15:40 ~ 17:00）
        Curriculum forth = new Curriculum();
        forth.setSegment(SegmentEnum.DISIJIE.segment);
        processXingqi(forth, getWeekChoiceList(xuankeList, SegmentEnum.DISIJIE.segment));
        list.add(forth);

        // 第五大节（18:00 ~ 20:00）
        Curriculum fifth = new Curriculum();
        fifth.setSegment(SegmentEnum.DIWUJIE.segment);
        processXingqi(fifth, getWeekChoiceList(xuankeList, SegmentEnum.DIWUJIE.segment));
        list.add(fifth);

        return list;
    }

    /**
     * 处理当前第几大节的所有选课信息（周一到周日）
     */
    private List<Xuanke> getWeekChoiceList(List<Xuanke> xuankeList, String segment) {
        return xuankeList.stream().filter(x -> x.getSegment().equals(segment)).collect(Collectors.toList());
    }

    /**
     * 处理周一到周日的数据
     */
    private void processXingqi(Curriculum curriculum, List<Xuanke> xuankeList) {
        // 周一
        Optional<Xuanke> first = xuankeList.stream().filter(x -> x.getXingqi().equals(WeekEnum.XQY.xingqi)).findFirst();
        first.ifPresent(xuanke -> curriculum.setMonday(xuanke.getName() + " (" + xuanke.getJiaoshimingcheng() + ")"));
        // 周二
        Optional<Xuanke> second = xuankeList.stream().filter(x -> x.getXingqi().equals(WeekEnum.XQE.xingqi)).findFirst();
        second.ifPresent(xuanke -> curriculum.setTuesday(xuanke.getName() + " (" + xuanke.getJiaoshimingcheng() + ")"));
        // 周三
        Optional<Xuanke> third = xuankeList.stream().filter(x -> x.getXingqi().equals(WeekEnum.XQS.xingqi)).findFirst();
        third.ifPresent(xuanke -> curriculum.setWednesday(xuanke.getName() + " (" + xuanke.getJiaoshimingcheng() + ")"));
        // 周四
        Optional<Xuanke> forth = xuankeList.stream().filter(x -> x.getXingqi().equals(WeekEnum.THURSDAY.xingqi)).findFirst();
        forth.ifPresent(xuanke -> curriculum.setThursday(xuanke.getName() + " (" + xuanke.getJiaoshimingcheng() + ")"));
        // 周五
        Optional<Xuanke> fifth = xuankeList.stream().filter(x -> x.getXingqi().equals(WeekEnum.FRIDAY.xingqi)).findFirst();
        fifth.ifPresent(xuanke -> curriculum.setFriday(xuanke.getName() + " (" + xuanke.getJiaoshimingcheng() + ")"));
        // 周六
        Optional<Xuanke> sixth = xuankeList.stream().filter(x -> x.getXingqi().equals(WeekEnum.SATURDAY.xingqi)).findFirst();
        sixth.ifPresent(xuanke -> curriculum.setSaturday(xuanke.getName() + " (" + xuanke.getJiaoshimingcheng() + ")"));
        // 周日
        Optional<Xuanke> seventh = xuankeList.stream().filter(x -> x.getXingqi().equals(WeekEnum.SUNDAY.xingqi)).findFirst();
        seventh.ifPresent(xuanke -> curriculum.setSunday(xuanke.getName() + " (" + xuanke.getJiaoshimingcheng() + ")"));
    }
}