package com.example.service;

import com.example.entity.Banji;
import com.example.mapper.BanjiMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 处理班级信息相关的业务逻辑，包括增删改查等操作。
 * 该服务层通过与Mapper接口的协作来操作数据库。
 */
@Service
public class BanjiService {

    // 注入班级信息的Mapper，用于与数据库进行交互
    @Resource
    private BanjiMapper banjiMapper;

    /**
     * 新增班级信息。
     * 该方法调用Mapper层的插入方法，将班级对象插入到数据库中。
     *
     * @param banji 待插入的班级对象
     */
    public void add(Banji banji) {
        // 调用Mapper的插入方法将班级信息保存到数据库
        banjiMapper.insert(banji);
    }

    /**
     * 根据班级ID删除班级信息。
     * 该方法通过班级ID定位班级记录，并将其从数据库中删除。
     *
     * @param id 待删除班级的ID
     */
    public void deleteById(Integer id) {
        // 使用班级ID删除对应的班级记录
        banjiMapper.deleteById(id);
    }

    /**
     * 批量删除多个班级信息。
     * 如果提供的班级ID列表非空，逐个调用`deleteById`方法进行删除。
     *
     * @param ids 待删除班级的ID列表
     */
    public void deleteBatch(List<Integer> ids) {
        // 判断传入的ID列表是否为空，避免空指针异常
        if (!CollectionUtils.isEmpty(ids)) {
            // 使用forEach遍历ID列表，并调用`deleteById`方法逐个删除
            ids.forEach(this::deleteById);
        }
    }

    /**
     * 根据班级ID更新班级信息。
     * 通过班级对象中的ID更新对应班级的记录。
     *
     * @param banji 待更新的班级对象，包含ID和更新的数据
     */
    public void updateById(Banji banji) {
        // 调用Mapper的更新方法，更新数据库中的班级信息
        banjiMapper.updateById(banji);
    }

    /**
     * 根据班级ID查询班级信息。
     * 该方法通过ID从数据库中查询单个班级信息。
     *
     * @param id 待查询的班级ID
     * @return 返回对应ID的班级对象
     */
    public Banji selectById(Integer id) {
        // 调用Mapper的方法，按ID查询班级信息
        return banjiMapper.selectById(id);
    }

    /**
     * 查询所有班级信息。
     * 该方法查询符合条件的所有班级信息。
     *
     * @param banji 查询条件，封装了班级的筛选字段
     * @return 返回所有符合条件的班级信息列表
     */
    public List<Banji> selectAll(Banji banji) {
        // 调用Mapper查询所有班级记录，并返回
        return banjiMapper.selectAll(banji);
    }

    /**
     * 分页查询班级信息。
     * 该方法结合PageHelper进行分页查询，返回指定页码和每页记录数的班级数据。
     *
     * @param banji 查询条件，封装了班级的筛选字段
     * @param pageNum 当前页码
     * @param pageSize 每页记录数
     * @return 返回分页后的班级信息
     */
    public PageInfo<Banji> selectPage(Banji banji, Integer pageNum, Integer pageSize) {
        // 使用PageHelper设置分页信息
        PageHelper.startPage(pageNum, pageSize);
        // 调用Mapper查询符合条件的班级记录列表
        List<Banji> list = banjiMapper.selectAll(banji);
        // 使用PageInfo将查询结果封装成分页信息对象并返回
        return PageInfo.of(list);
    }

}
