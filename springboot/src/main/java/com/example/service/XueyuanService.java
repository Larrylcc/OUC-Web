package com.example.service;

import com.example.entity.Xueyuan;
import com.example.mapper.XueyuanMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

/**
 * 处理学院信息相关的业务逻辑，提供增、删、改、查等服务操作。
 * 本服务层通过调用Mapper层接口与数据库交互，处理具体的数据库操作。
 */
@Service
public class XueyuanService {

    // 注入学院信息的Mapper，用于操作数据库
    @Resource
    private XueyuanMapper xueyuanMapper;

    /**
     * 新增学院信息。
     * 在插入之前进行非空校验，确保传入的学院对象不为null。
     *
     * @param xueyuan 待插入的学院对象
     * @throws IllegalArgumentException 如果传入的学院对象为null
     */
    public void add(Xueyuan xueyuan) {
        // 校验传入参数，确保学院对象不为null
        Assert.notNull(xueyuan, "College cannot be null");
        // 调用Mapper插入学院信息到数据库
        xueyuanMapper.insert(xueyuan);
    }

    /**
     * 根据学院ID删除学院信息。
     * 先进行非空校验，确保传入的ID不为null。
     *
     * @param id 待删除的学院ID
     * @throws IllegalArgumentException 如果传入的ID为null
     */
    public void deleteById(Integer id) {
        // 校验ID，确保其不为null
        Assert.notNull(id, "ID cannot be null");
        // 调用Mapper根据ID删除对应的学院信息
        xueyuanMapper.deleteById(id);
    }

    /**
     * 批量删除多个学院信息。
     * 对传入的学院ID列表进行非空校验，确保其不为空。
     * 然后遍历ID列表逐个删除。
     *
     * @param ids 待删除的学院ID列表
     * @throws IllegalArgumentException 如果传入的ID列表为空
     */
    public void deleteBatch(List<Integer> ids) {
        // 校验ID列表，确保其不为空
        Assert.notEmpty(ids, "ID list cannot be empty");
        // 遍历ID列表，逐个调用deleteById方法删除
        ids.forEach(this::deleteById);
    }

    /**
     * 根据学院ID更新学院信息。
     * 先进行非空校验，确保传入的学院对象不为null。
     *
     * @param xueyuan 待更新的学院对象
     * @throws IllegalArgumentException 如果传入的学院对象为null
     */
    public void updateById(Xueyuan xueyuan) {
        // 校验传入的学院对象，确保其不为null
        Assert.notNull(xueyuan, "College cannot be null");
        // 调用Mapper更新数据库中的学院信息
        xueyuanMapper.updateById(xueyuan);
    }

    /**
     * 根据学院ID查询学院信息。
     * 先进行非空校验，确保传入的ID不为null。
     *
     * @param id 查询的学院ID
     * @return 返回对应ID的学院对象
     * @throws IllegalArgumentException 如果传入的ID为null
     */
    public Xueyuan selectById(Integer id) {
        // 校验ID，确保其不为null
        Assert.notNull(id, "ID cannot be null");
        // 调用Mapper查询数据库中的学院信息
        return xueyuanMapper.selectById(id);
    }

    /**
     * 查询所有符合条件的学院信息。
     * 该方法不做参数校验，直接将传入的学院对象作为查询条件。
     *
     * @param xueyuan 查询条件，封装了学院信息的筛选字段
     * @return 返回符合条件的所有学院信息列表
     */
    public List<Xueyuan> selectAll(Xueyuan xueyuan) {
        // 调用Mapper查询所有符合条件的学院信息
        return xueyuanMapper.selectAll(xueyuan);
    }

    /**
     * 分页查询学院信息。
     * 使用PageHelper进行分页查询，返回指定页码和每页大小的数据。
     *
     * @param xueyuan 查询条件，封装了学院信息的筛选字段
     * @param pageNum 当前页码
     * @param pageSize 每页记录数
     * @return 返回分页后的学院信息列表
     */
    public PageInfo<Xueyuan> selectPage(Xueyuan xueyuan, Integer pageNum, Integer pageSize) {
        // 使用PageHelper开始分页，传入当前页码和每页记录数
        PageHelper.startPage(pageNum, pageSize);
        // 调用Mapper查询符合条件的所有学院信息
        List<Xueyuan> list = xueyuanMapper.selectAll(xueyuan);
        // 使用PageInfo封装查询结果，并返回分页信息
        return PageInfo.of(list);
    }
}
