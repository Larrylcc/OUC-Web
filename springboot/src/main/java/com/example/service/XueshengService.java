package com.example.service;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.Constants;
import com.example.common.enums.ResultCodeEnum;
import com.example.common.enums.RoleEnum;
import com.example.entity.Account;
import com.example.entity.Xuesheng;
import com.example.exception.CustomException;
import com.example.mapper.XueshengMapper;
import com.example.utils.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 学生业务逻辑处理服务类，提供学生信息的增、删、改、查等功能。
 */
@Service
public class XueshengService {

    // 注入学生数据库操作映射接口
    @Resource
    private XueshengMapper xueshengMapper;

    /**
     * 新增学生
     * 1. 首先检查用户名是否已经存在。
     * 2. 如果密码为空，使用默认密码。
     * 3. 如果姓名为空，使用用户名作为默认姓名。
     * 4. 设置角色为学生。
     *
     * @param xuesheng 新增的学生对象
     */
    public void add(Xuesheng xuesheng) {
        try {
            // 检查用户名是否已经存在
            Xuesheng dbXuesheng = xueshengMapper.selectByUsername(xuesheng.getUsername());
            if (ObjectUtil.isNotNull(dbXuesheng)) {
                throw new CustomException(ResultCodeEnum.YONGHUZHANGHUCUOWU);  // 用户已存在，抛出异常
            }

            // 如果密码为空，设置默认密码
            if (ObjectUtil.isEmpty(xuesheng.getPassword())) {
                xuesheng.setPassword(Constants.USER_DEFAULT_PASSWORD);
            }

            // 如果姓名为空，使用用户名作为姓名
            if (ObjectUtil.isEmpty(xuesheng.getName())) {
                xuesheng.setName(xuesheng.getUsername());
            }

            // 设置角色为学生
            xuesheng.setRole(RoleEnum.XUESHENG.name());

            // 执行插入操作
            xueshengMapper.insert(xuesheng);
        } catch (Exception e) {
            // 异常捕获并抛出
            throw new RuntimeException("Error adding xuesheng: " + e.getMessage(), e);
        }
    }

    /**
     * 根据ID删除学生
     * 1. 查询学生是否存在，如果不存在抛出异常。
     * 2. 如果存在，则删除该学生。
     *
     * @param id 要删除的学生ID
     */
    public void deleteById(Integer id) {
        try {
            // 查找学生是否存在
            Xuesheng dbXuesheng = xueshengMapper.selectById(id);
            if (ObjectUtil.isNull(dbXuesheng)) {
                throw new CustomException(ResultCodeEnum.YONGHUBUCUNZAI);  // 学生不存在，抛出异常
            }

            // 删除学生信息
            xueshengMapper.deleteById(id);
        } catch (Exception e) {
            // 捕获异常并抛出详细信息
            throw new RuntimeException("Error deleting xuesheng by id: " + id + ", " + e.getMessage(), e);
        }
    }

    /**
     * 批量删除学生
     * 逐个调用 `deleteById` 方法删除学生记录
     *
     * @param ids 要删除的学生ID列表
     */
    public void deleteBatch(List<Integer> ids) {
        try {
            // 遍历ID列表，逐个删除学生
            for (Integer id : ids) {
                deleteById(id);
            }
        } catch (Exception e) {
            // 捕获异常并抛出
            throw new RuntimeException("Error deleting students in batch: " + e.getMessage(), e);
        }
    }

    /**
     * 根据ID更新学生信息
     * 1. 查找学生是否存在，如果不存在抛出异常。
     * 2. 如果存在，执行更新操作。
     *
     * @param xuesheng 更新的学生对象，包含ID和修改信息
     */
    public void updateById(Xuesheng xuesheng) {
        try {
            // 查找学生是否存在
            Xuesheng dbXuesheng = xueshengMapper.selectById(xuesheng.getId());
            if (ObjectUtil.isNull(dbXuesheng)) {
                throw new CustomException(ResultCodeEnum.YONGHUZHANGHUCUOWU);  // 学生不存在，抛出异常
            }

            // 更新学生信息
            xueshengMapper.updateById(xuesheng);
        } catch (Exception e) {
            // 捕获异常并抛出
            throw new RuntimeException("Error updating xuesheng by id: " + xuesheng.getId() + ", " + e.getMessage(), e);
        }
    }

    /**
     * 根据学生ID查询学生信息
     * 如果学生不存在，抛出异常。
     *
     * @param id 学生ID
     * @return 返回查询到的学生对象
     */
    public Xuesheng selectById(Integer id) {
        try {
            // 根据ID查询学生信息
            Xuesheng xuesheng = xueshengMapper.selectById(id);
            if (ObjectUtil.isNull(xuesheng)) {
                throw new CustomException(ResultCodeEnum.YONGHUBUCUNZAI);  // 学生不存在，抛出异常
            }
            return xuesheng;  // 返回学生信息
        } catch (Exception e) {
            // 捕获异常并抛出
            throw new RuntimeException("Error retrieving xuesheng by id: " + id + ", " + e.getMessage(), e);
        }
    }

    /**
     * 查询所有学生信息
     * 根据传入的条件（如姓名、学号等）筛选学生数据。
     *
     * @param xuesheng 查询条件的学生对象
     * @return 返回符合条件的学生列表
     */
    public List<Xuesheng> selectAll(Xuesheng xuesheng) {
        try {
            return xueshengMapper.selectAll(xuesheng);  // 执行查询
        } catch (Exception e) {
            // 捕获异常并抛出
            throw new RuntimeException("Error retrieving all students: " + e.getMessage(), e);
        }
    }

    /**
     * 分页查询学生信息
     * 使用PageHelper进行分页，返回学生的分页数据。
     *
     * @param xuesheng 查询条件
     * @param pageNum 当前页码
     * @param pageSize 每页显示的记录数
     * @return 返回分页后的学生信息
     */
    public PageInfo<Xuesheng> selectPage(Xuesheng xuesheng, Integer pageNum, Integer pageSize) {
        try {
            // 设置分页参数
            PageHelper.startPage(pageNum, pageSize);
            // 查询所有符合条件的学生信息
            List<Xuesheng> list = xueshengMapper.selectAll(xuesheng);
            // 返回分页结果
            return PageInfo.of(list);
        } catch (Exception e) {
            // 捕获异常并抛出
            throw new RuntimeException("Error retrieving students with pagination: " + e.getMessage(), e);
        }
    }

    /**
     * 学生登录
     * 1. 查询学生是否存在，若不存在抛出异常。
     * 2. 校验密码是否正确，若不匹配抛出异常。
     * 3. 生成token并返回。
     *
     * @param account 登录时传入的账户信息
     * @return 返回包含登录信息（如token）的学生账户对象
     */
    public Account login(Account account) {
        try {
            // 查询用户名是否存在
            Account dbStudent = xueshengMapper.selectByUsername(account.getUsername());
            if (ObjectUtil.isNull(dbStudent)) {
                throw new CustomException(ResultCodeEnum.YONGHUZHANGHUCUOWU);  // 用户不存在，抛出异常
            }

            // 校验密码是否正确
            if (!account.getPassword().equals(dbStudent.getPassword())) {
                throw new CustomException(ResultCodeEnum.MIMACUOWU);  // 密码错误，抛出异常
            }

            // 生成token，token包含学生ID和角色信息
            String tokenData = dbStudent.getId() + "-" + RoleEnum.XUESHENG.name();
            String token = TokenUtils.createToken(tokenData, dbStudent.getPassword());

            // 设置token
            dbStudent.setToken(token);
            return dbStudent;  // 返回包含token的学生信息
        } catch (Exception e) {
            // 捕获异常并抛出
            throw new RuntimeException("Error logging in: " + e.getMessage(), e);
        }
    }

    /**
     * 学生注册
     * 1. 将账户信息转换为学生对象。
     * 2. 调用新增学生的业务逻辑。
     *
     * @param account 注册时传入的账户信息
     */
    public void register(Account account) {
        try {
            // 将账户信息复制到学生对象
            Xuesheng xuesheng = new Xuesheng();
            BeanUtils.copyProperties(account, xuesheng);
            // 调用add方法新增学生
            add(xuesheng);
        } catch (Exception e) {
            // 捕获异常并抛出
            throw new RuntimeException("Error registering xuesheng: " + e.getMessage(), e);
        }
    }

    /**
     * 修改学生密码
     * 1. 校验学生用户名和密码是否正确。
     * 2. 如果密码正确，更新学生密码。
     *
     * @param account 包含用户名、当前密码和新密码的账户对象
     */
    public void updatePassword(Account account) {
        try {
            // 查询学生信息
            Xuesheng dbXuesheng = xueshengMapper.selectByUsername(account.getUsername());
            if (ObjectUtil.isNull(dbXuesheng)) {
                throw new CustomException(ResultCodeEnum.YONGHUBUCUNZAI);  // 用户不存在，抛出异常
            }

            // 校验当前密码是否正确
            if (!dbXuesheng.getPassword().equals(account.getPassword())) {
                throw new CustomException(ResultCodeEnum.MIMACUOWU);  // 当前密码错误，抛出异常
            }

            // 更新密码
            dbXuesheng.setPassword(account.getNewPassword());  // 设置新密码
            xueshengMapper.updateById(dbXuesheng);  // 执行更新操作
        } catch (Exception e) {
            // 捕获异常并抛出
            throw new RuntimeException("Error updating xuesheng password: " + e.getMessage(), e);
        }
    }

}
