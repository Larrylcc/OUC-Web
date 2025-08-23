package com.example.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.example.common.enums.ResultCodeEnum;
import com.example.entity.Pingjia;
import com.example.exception.CustomException;
import com.example.mapper.PingjiaMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 处理评教信息的业务逻辑服务类。
 * 提供对评教数据的增、删、改、查以及分页查询等功能。
 */
@Service
public class PingjiaService {

    // 注入评论数据访问层接口，用于与数据库进行交互
    @Resource
    private PingjiaMapper pingjiaMapper;

    /**
     * 新增评教信息。
     * 在插入之前检查学生是否已经对该课程和教师进行过评教。
     * 如果已经评教，抛出自定义异常。
     *
     * @param pingjia 待新增的评教信息
     * @throws CustomException 如果该学生已对同一门课进行过评教
     */
    public void add(Pingjia pingjia) {
        // 检查该学生是否已经对该教师和课程进行评教
        Pingjia dbPingjia = pingjiaMapper.selectByTeacherAndCourseAndStudent(pingjia.getLaoshi(), pingjia.getName(), pingjia.getXuesheng());
        if (ObjectUtil.isNotEmpty(dbPingjia)) {
            // 如果已评教，则抛出异常
            throw new CustomException(ResultCodeEnum.PINGLCUOWU);
        }

        // 设置评教时间为当前时间
        pingjia.setTime(DateUtil.now());
        // 插入新的评教记录
        pingjiaMapper.insert(pingjia);
    }

    /**
     * 根据ID删除评教信息。
     * 调用数据访问层方法删除指定ID的评教记录。
     *
     * @param id 评教信息的唯一标识
     */
    public void deleteById(Integer id) {
        // 删除指定ID的评教记录
        pingjiaMapper.deleteById(id);
    }

    /**
     * 批量删除评教信息。
     * 对传入的多个ID进行逐个删除操作。
     *
     * @param ids 需要删除的评教信息ID列表
     */
    public void deleteBatch(List<Integer> ids) {
        // 遍历ID列表并逐一删除对应的评教记录
        for (Integer id : ids) {
            pingjiaMapper.deleteById(id);
        }
    }

    /**
     * 根据评教信息ID更新现有的评教信息。
     * 通过ID找到并更新该评教记录的信息。
     *
     * @param pingjia 更新的评教信息对象
     */
    public void updateById(Pingjia pingjia) {
        // 调用数据访问层方法更新评教记录
        pingjiaMapper.updateById(pingjia);
    }

    /**
     * 根据ID查询单条评教信息。
     * 提供按ID查询的功能，返回对应的评教记录。
     *
     * @param id 评教信息的唯一标识
     * @return 查询到的评教信息对象
     */
    public Pingjia selectById(Integer id) {
        // 查询并返回指定ID的评教记录
        return pingjiaMapper.selectById(id);
    }

    /**
     * 查询所有符合条件的评教信息。
     * 根据传入的评教信息对象条件进行查询，返回所有符合条件的评教记录。
     *
     * @param pingjia 查询条件，封装了筛选的评教信息
     * @return 符合条件的评教记录列表
     */
    public List<Pingjia> selectAll(Pingjia pingjia) {
        // 调用数据访问层查询所有符合条件的评教记录
        return pingjiaMapper.selectAll(pingjia);
    }

    /**
     * 分页查询评教信息。
     * 使用PageHelper插件进行分页查询，返回分页后的评教记录。
     *
     * @param pingjia 查询条件，封装了筛选的评教信息
     * @param pageNum 当前页码
     * @param pageSize 每页显示的记录数
     * @return 分页后的评教记录信息
     */
    public PageInfo<Pingjia> selectPage(Pingjia pingjia, Integer pageNum, Integer pageSize) {
        // 使用PageHelper进行分页查询
        PageHelper.startPage(pageNum, pageSize);
        // 查询符合条件的评教信息列表
        List<Pingjia> list = pingjiaMapper.selectAll(pingjia);
        // 返回分页后的结果
        return PageInfo.of(list);
    }
}
