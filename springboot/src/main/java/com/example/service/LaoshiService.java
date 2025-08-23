package com.example.service;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.Constants;
import com.example.common.enums.ResultCodeEnum;
import com.example.common.enums.RoleEnum;
import com.example.entity.Account;
import com.example.entity.Laoshi;
import com.example.exception.CustomException;
import com.example.mapper.LaoshiMapper;
import com.example.utils.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 教师业务处理服务类
 **/
@Service
public class LaoshiService {

    @Resource
    private LaoshiMapper laoshiMapper;

    /**
     * 新增教师信息
     * @param laoshi 新教师对象
     */
    public void add(Laoshi laoshi) {
        // 检查用户名是否已存在
        Laoshi dbLaoshi = laoshiMapper.selectByUsername(laoshi.getUsername());
        if (ObjectUtil.isNotNull(dbLaoshi)) {
            throw new CustomException(ResultCodeEnum.YONGHUBUCUNZAI);  // 用户已存在
        }

        // 设置默认密码，如果没有提供密码
        if (ObjectUtil.isEmpty(laoshi.getPassword())) {
            laoshi.setPassword(Constants.USER_DEFAULT_PASSWORD);  // 使用默认密码
        }

        // 如果没有提供教师姓名，默认使用用户名
        if (ObjectUtil.isEmpty(laoshi.getName())) {
            laoshi.setName(laoshi.getUsername());
        }

        // 设置角色为教师
        laoshi.setRole(RoleEnum.LAOSHI.name());

        // 插入教师数据
        laoshiMapper.insert(laoshi);
    }

    /**
     * 根据ID删除教师信息
     * @param id 教师ID
     */
    public void deleteById(Integer id) {
        // 查找教师
        Laoshi laoshi = laoshiMapper.selectById(id);
        if (ObjectUtil.isNull(laoshi)) {
            throw new CustomException(ResultCodeEnum.YONGHUBUCUNZAI);  // 教师不存在
        }

        // 删除教师
        laoshiMapper.deleteById(id);
    }

    /**
     * 批量删除教师信息
     * @param ids 教师ID列表
     */
    public void deleteBatch(List<Integer> ids) {
        // 遍历所有ID，逐个删除
        for (Integer id : ids) {
            Laoshi laoshi = laoshiMapper.selectById(id);
            // 如果教师存在，则删除
            if (ObjectUtil.isNotNull(laoshi)) {
                laoshiMapper.deleteById(id);
            }
        }
    }

    /**
     * 更新教师信息
     * @param laoshi 更新后的教师对象
     */
    public void updateById(Laoshi laoshi) {
        // 查找教师
        Laoshi dbLaoshi = laoshiMapper.selectById(laoshi.getId());
        if (ObjectUtil.isNull(dbLaoshi)) {
            throw new CustomException(ResultCodeEnum.YONGHUBUCUNZAI);  // 教师不存在
        }

        // 更新教师数据
        laoshiMapper.updateById(laoshi);
    }

    /**
     * 根据ID查询教师信息
     * @param id 教师ID
     * @return 查询到的教师信息
     */
    public Laoshi selectById(Integer id) {
        // 查找教师
        Laoshi laoshi = laoshiMapper.selectById(id);
        if (ObjectUtil.isNull(laoshi)) {
            throw new CustomException(ResultCodeEnum.YONGHUBUCUNZAI);  // 教师不存在
        }
        return laoshi;
    }

    /**
     * 查询所有教师信息
     * @param laoshi 查询条件
     * @return 教师信息列表
     */
    public List<Laoshi> selectAll(Laoshi laoshi) {
        return laoshiMapper.selectAll(laoshi);
    }

    /**
     * 分页查询教师信息
     * @param laoshi 查询条件
     * @param pageNum 当前页码
     * @param pageSize 每页数据条数
     * @return 分页后的教师信息
     */
    public PageInfo<Laoshi> selectPage(Laoshi laoshi, Integer pageNum, Integer pageSize) {
        // 启动分页
        PageHelper.startPage(pageNum, pageSize);

        // 获取教师数据
        List<Laoshi> list = laoshiMapper.selectAll(laoshi);

        // 返回分页信息
        return PageInfo.of(list);
    }

    /**
     * 教师登录功能
     * @param account 登录账户信息
     * @return 登录成功后的账户信息（包含token）
     */
    public Account login(Account account) {
        // 根据用户名查找教师账户
        Account dbTeacher = laoshiMapper.selectByUsername(account.getUsername());
        if (ObjectUtil.isNull(dbTeacher)) {
            throw new CustomException(ResultCodeEnum.YONGHUBUCUNZAI);  // 教师不存在
        }

        // 校验密码是否正确
        if (!account.getPassword().equals(dbTeacher.getPassword())) {
            throw new CustomException(ResultCodeEnum.MIMACUOWU);  // 密码错误
        }

        // 生成token数据
        String tokenData = dbTeacher.getId() + "-" + RoleEnum.LAOSHI.name();
        String token = TokenUtils.createToken(tokenData, dbTeacher.getPassword());

        // 设置返回的token
        dbTeacher.setToken(token);

        // 返回包含token的账户信息
        return dbTeacher;
    }

    /**
     * 修改教师密码
     * @param account 账户信息，包含新密码
     */
    public void updatePassword(Account account) {
        // 查找教师账户
        Laoshi dbLaoshi = laoshiMapper.selectByUsername(account.getUsername());
        if (ObjectUtil.isNull(dbLaoshi)) {
            throw new CustomException(ResultCodeEnum.YONGHUBUCUNZAI);  // 教师不存在
        }

        // 校验旧密码是否正确
        if (!account.getPassword().equals(dbLaoshi.getPassword())) {
            throw new CustomException(ResultCodeEnum.MIMACUOWU);  // 旧密码错误
        }

        // 更新教师密码
        dbLaoshi.setPassword(account.getNewPassword());
        laoshiMapper.updateById(dbLaoshi);
    }
}
