package com.example.service;

import com.example.entity.Speciality;
import com.example.mapper.SpecialityMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 处理专业信息表相关业务的服务类
 * 提供增、删、改、查、分页查询等功能，操作专业信息。
 */
@Service
public class SpecialityService {

    // 注入专业信息表的数据库操作接口
    @Resource
    private SpecialityMapper specialityMapper;

    /**
     * 新增专业信息。
     * 该方法将新专业信息插入到数据库中。
     *
     * @param speciality 专业对象，包含新增的专业信息
     */
    public void add(Speciality speciality) {
        try {
            specialityMapper.insert(speciality);  // 调用mapper插入新记录
        } catch (Exception e) {
            // 捕获异常并重新抛出带有详细信息的异常
            throw new RuntimeException("Error adding speciality: " + e.getMessage(), e);
        }
    }

    /**
     * 根据ID删除专业信息。
     * 1. 先检查该专业是否存在。
     * 2. 如果存在，则删除该专业信息。
     *
     * @param id 专业ID
     */
    public void deleteById(Integer id) {
        try {
            // 查询该ID的专业是否存在
            Speciality existingSpeciality = specialityMapper.selectById(id);
            if (existingSpeciality == null) {
                throw new RuntimeException("Speciality not found with id: " + id);  // 如果专业不存在，抛出异常
            }
            specialityMapper.deleteById(id);  // 删除该专业
        } catch (Exception e) {
            // 捕获异常并重新抛出带有详细信息的异常
            throw new RuntimeException("Error deleting speciality by id: " + id + ", " + e.getMessage(), e);
        }
    }

    /**
     * 批量删除专业信息。
     * 1. 遍历ID列表，对每个专业执行删除操作。
     * 2. 如果某个专业不存在，抛出异常并停止删除。
     *
     * @param ids 专业ID列表
     */
    public void deleteBatch(List<Integer> ids) {
        try {
            // 遍历ID列表逐个删除
            for (Integer id : ids) {
                Speciality existingSpeciality = specialityMapper.selectById(id);
                if (existingSpeciality == null) {
                    throw new RuntimeException("Speciality not found with id: " + id);  // 如果专业不存在，抛出异常
                }
                specialityMapper.deleteById(id);  // 删除该专业
            }
        } catch (Exception e) {
            // 捕获异常并重新抛出带有详细信息的异常
            throw new RuntimeException("Error deleting specialities in batch: " + e.getMessage(), e);
        }
    }

    /**
     * 根据ID更新专业信息。
     * 1. 查询该专业是否存在，如果不存在则抛出异常。
     * 2. 如果存在，更新该专业的相关信息。
     *
     * @param speciality 专业对象，包含更新后的专业信息
     */
    public void updateById(Speciality speciality) {
        try {
            // 查询该专业是否存在
            Speciality existingSpeciality = specialityMapper.selectById(speciality.getId());
            if (existingSpeciality == null) {
                throw new RuntimeException("Speciality not found with id: " + speciality.getId());  // 专业不存在，抛出异常
            }
            specialityMapper.updateById(speciality);  // 更新专业信息
        } catch (Exception e) {
            // 捕获异常并重新抛出带有详细信息的异常
            throw new RuntimeException("Error updating speciality by id: " + speciality.getId() + ", " + e.getMessage(), e);
        }
    }

    /**
     * 根据ID查询单个专业信息。
     * 如果该ID的专业不存在，抛出异常。
     *
     * @param id 专业ID
     * @return 专业对象
     */
    public Speciality selectById(Integer id) {
        try {
            // 根据ID查询专业信息
            Speciality speciality = specialityMapper.selectById(id);
            if (speciality == null) {
                throw new RuntimeException("Speciality not found with id: " + id);  // 如果专业不存在，抛出异常
            }
            return speciality;  // 返回查询到的专业信息
        } catch (Exception e) {
            // 捕获异常并重新抛出带有详细信息的异常
            throw new RuntimeException("Error retrieving speciality by id: " + id + ", " + e.getMessage(), e);
        }
    }

    /**
     * 查询所有符合条件的专业信息。
     * 根据传入的专业对象的字段进行模糊查询（如：按专业名称、学科等筛选）。
     *
     * @param speciality 查询条件对象（可以包含多个字段进行筛选）
     * @return 专业信息列表
     */
    public List<Speciality> selectAll(Speciality speciality) {
        try {
            // 查询所有符合条件的专业信息
            return specialityMapper.selectAll(speciality);
        } catch (Exception e) {
            // 捕获异常并重新抛出带有详细信息的异常
            throw new RuntimeException("Error retrieving all specialities: " + e.getMessage(), e);
        }
    }

    /**
     * 分页查询符合条件的专业信息。
     * 1. 根据提供的页码和每页记录数进行分页。
     * 2. 使用 PageHelper 来实现分页查询。
     *
     * @param speciality 查询条件（可为空）
     * @param pageNum 当前页码
     * @param pageSize 每页显示的记录数
     * @return 分页后的专业信息
     */
    public PageInfo<Speciality> selectPage(Speciality speciality, Integer pageNum, Integer pageSize) {
        try {
            // 设置分页信息
            PageHelper.startPage(pageNum, pageSize);
            // 查询所有符合条件的专业信息
            List<Speciality> list = specialityMapper.selectAll(speciality);
            // 返回分页信息
            return PageInfo.of(list);
        } catch (Exception e) {
            // 捕获异常并重新抛出带有详细信息的异常
            throw new RuntimeException("Error retrieving specialities with pagination: " + e.getMessage(), e);
        }
    }
}
