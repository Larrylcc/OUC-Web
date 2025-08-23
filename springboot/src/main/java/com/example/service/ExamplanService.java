package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.example.entity.Account;
import com.example.entity.Examplan;
import com.example.mapper.ExamplanMapper;
import com.example.utils.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 处理考试安排相关的业务逻辑。
 * 该类提供了对考试安排数据表（Examplan）的增删改查功能，封装了与数据库交互的具体操作。
 */
@Service
public class ExamplanService {

    // 注入ExamplanMapper，负责与数据库中的考试安排表进行交互
    @Resource
    private ExamplanMapper examplanMapper;

    /**
     * 新增考试安排。
     * 此方法接收一个Examplan对象并将其插入到数据库。
     * 在插入前，自动设置当前时间戳作为考试安排的时间。
     *
     * @param examplan 待新增的考试安排对象
     */
    public void add(Examplan examplan) {
        // 设置当前时间为考试安排的时间
        examplan.setTime(DateUtil.now());
        // 调用Mapper将考试安排数据插入到数据库
        examplanMapper.insert(examplan);
    }

    /**
     * 根据ID删除指定的考试安排。
     * 该方法接收一个ID作为参数，并删除数据库中与该ID对应的考试安排记录。
     *
     * @param id 需要删除的考试安排ID
     */
    public void deleteById(Integer id) {
        // 调用Mapper删除指定ID的考试安排
        examplanMapper.deleteById(id);
    }

    /**
     * 批量删除考试安排。
     * 该方法接收一个ID列表，并删除列表中每个ID对应的考试安排记录。
     *
     * @param ids 需要删除的考试安排ID列表
     */
    public void deleteBatch(List<Integer> ids) {
        // 遍历ID列表，逐个删除对应的考试安排
        for (Integer id : ids) {
            examplanMapper.deleteById(id);
        }
    }

    /**
     * 更新考试安排信息。
     * 该方法接收一个更新后的Examplan对象，根据该对象中的信息更新数据库中相应的记录。
     *
     * @param examplan 更新后的考试安排对象
     */
    public void updateById(Examplan examplan) {
        // 调用Mapper根据ID更新考试安排
        examplanMapper.updateById(examplan);
    }

    /**
     * 根据ID查询单个考试安排。
     * 该方法通过传入的ID获取对应的考试安排信息。
     *
     * @param id 需要查询的考试安排ID
     * @return 对应ID的考试安排对象
     */
    public Examplan selectById(Integer id) {
        // 调用Mapper查询指定ID的考试安排记录
        return examplanMapper.selectById(id);
    }

    /**
     * 查询所有符合条件的考试安排。
     * 该方法接收一个Examplan对象作为查询条件，返回符合条件的考试安排记录列表。
     * 如果传入的examplan对象为空，则查询所有考试安排。
     *
     * @param examplan 查询条件，封装了筛选的考试安排信息
     * @return 符合条件的考试安排记录列表
     */
    public List<Examplan> selectAll(Examplan examplan) {
        // 调用Mapper查询所有符合条件的考试安排记录
        return examplanMapper.selectAll(examplan);
    }

    /**
     * 分页查询考试安排信息。
     * 该方法利用PageHelper插件进行分页查询，并返回分页后的考试安排数据。
     * 查询结果根据传入的分页参数（pageNum, pageSize）进行分页处理。
     *
     * @param examplan 查询条件，封装了筛选的考试安排信息
     * @param pageNum 当前页码
     * @param pageSize 每页显示的记录数
     * @return 分页后的考试安排数据
     */
    public PageInfo<Examplan> selectPage(Examplan examplan, Integer pageNum, Integer pageSize) {
        // 使用PageHelper插件设置分页参数
        PageHelper.startPage(pageNum, pageSize);
        // 查询符合条件的考试安排记录
        List<Examplan> list = examplanMapper.selectAll(examplan);
        // 使用PageInfo封装分页结果并返回
        return PageInfo.of(list);
    }
}
