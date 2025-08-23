package com.example.service;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.Constants;
import com.example.common.enums.ResultCodeEnum;
import com.example.common.enums.RoleEnum;
import com.example.entity.Account;
import com.example.entity.Guanliyuan;
import com.example.exception.CustomException;
import com.example.mapper.GuanliyuanMapper;
import com.example.utils.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 管理员业务处理服务类，提供管理员的增、删、改、查及其他业务逻辑功能。
 * 主要负责对管理员的管理操作，包括账户的创建、删除、修改密码、登录验证等。
 */
@Service
public class GuanliyuanService {

    @Resource
    private GuanliyuanMapper guanliyuanMapper;  // 注入 AdminMapper 用于数据库操作

    /**
     * 新增管理员账户
     * 检查用户名是否已存在，如果存在则抛出异常。若没有设置密码，则使用默认密码。
     * 如果没有设置管理员名称，使用用户名作为名称。
     * 默认角色为 GUANLIYUAN，并将该管理员信息插入数据库。
     *
     * @param guanliyuan 新管理员的账户信息
     */
    public void add(Guanliyuan guanliyuan) {
        // 检查是否有相同的用户名
        Guanliyuan dbGuanliyuan = guanliyuanMapper.selectByUsername(guanliyuan.getUsername());
        if (ObjectUtil.isNotNull(dbGuanliyuan)) {
            throw new CustomException(ResultCodeEnum.YONGHUZHANGHUCUOWU);  // 用户名已存在
        }
        // 如果密码为空，使用默认密码
        if (ObjectUtil.isEmpty(guanliyuan.getPassword())) {
            guanliyuan.setPassword(Constants.USER_DEFAULT_PASSWORD);
        }
        // 如果名称为空，使用用户名作为名称
        if (ObjectUtil.isEmpty(guanliyuan.getName())) {
            guanliyuan.setName(guanliyuan.getUsername());
        }
        // 设置角色为管理员
        guanliyuan.setRole(RoleEnum.GUANLIYUAN.name());
        // 将管理员信息插入数据库
        guanliyuanMapper.insert(guanliyuan);
    }

    /**
     * 根据管理员ID删除指定的管理员账户
     *
     * @param id 管理员ID
     */
    public void deleteById(Integer id) {
        guanliyuanMapper.deleteById(id);  // 删除数据库中的管理员记录
    }

    /**
     * 批量删除管理员账户
     * 遍历删除多个管理员账户，通过ID进行删除操作。
     *
     * @param ids 要删除的管理员ID列表
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            guanliyuanMapper.deleteById(id);  // 删除每个管理员
        }
    }

    /**
     * 更新管理员信息
     * 根据传入的 `Admin` 对象更新数据库中的管理员信息。
     *
     * @param guanliyuan 更新后的管理员信息
     */
    public void updateById(Guanliyuan guanliyuan) {
        guanliyuanMapper.updateById(guanliyuan);  // 更新数据库中的管理员信息
    }

    /**
     * 根据ID查询管理员信息
     * 根据管理员的唯一ID查询该管理员的详细信息。
     *
     * @param id 管理员ID
     * @return 查询到的管理员信息
     */
    public Guanliyuan selectById(Integer id) {
        return guanliyuanMapper.selectById(id);  // 查询并返回管理员信息
    }

    /**
     * 查询所有管理员信息
     * 返回数据库中所有符合条件的管理员信息，可以用于列表展示。
     *
     * @param guanliyuan 查询条件，可以为空
     * @return 所有符合条件的管理员列表
     */
    public List<Guanliyuan> selectAll(Guanliyuan guanliyuan) {
        return guanliyuanMapper.selectAll(guanliyuan);  // 查询并返回所有管理员记录
    }

    /**
     * 分页查询管理员信息
     * 对管理员信息进行分页查询，适用于需要分页展示管理员列表的场景。
     *
     * @param guanliyuan 查询条件，可以为空
     * @param pageNum 页码
     * @param pageSize 每页记录数
     * @return 分页后的管理员信息列表
     */
    public PageInfo<Guanliyuan> selectPage(Guanliyuan guanliyuan, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);  // 启动分页查询
        List<Guanliyuan> list = guanliyuanMapper.selectAll(guanliyuan);  // 查询管理员列表
        return PageInfo.of(list);  // 将查询结果包装为分页信息返回
    }

    /**
     * 管理员登录
     * 校验管理员的用户名和密码是否匹配，并生成对应的登录 token 返回。
     *
     * @param account 登录时输入的账户信息
     * @return 登录成功的管理员账户信息，并附带token
     */
    public Account login(Account account) {
        // 根据用户名查询管理员信息
        Account dbAdmin = guanliyuanMapper.selectByUsername(account.getUsername());
        if (ObjectUtil.isNull(dbAdmin)) {
            throw new CustomException(ResultCodeEnum.YONGHUBUCUNZAI);  // 用户不存在
        }
        // 校验密码是否正确
        if (!account.getPassword().equals(dbAdmin.getPassword())) {
            throw new CustomException(ResultCodeEnum.MIMACUOWU);  // 密码错误
        }
        // 生成token，通常包含用户ID和角色信息
        String tokenData = dbAdmin.getId() + "-" + RoleEnum.GUANLIYUAN.name();
        String token = TokenUtils.createToken(tokenData, dbAdmin.getPassword());  // 根据密码生成 token
        dbAdmin.setToken(token);  // 将token设置到账户对象中
        return dbAdmin;  // 返回包含token的管理员账户信息
    }

    /**
     * 管理员注册
     * 将账户信息转换为管理员信息并调用 `add` 方法执行注册操作。
     *
     * @param account 注册时的账户信息
     */
    public void register(Account account) {
        Guanliyuan guanliyuan = new Guanliyuan();  // 创建管理员对象
        BeanUtils.copyProperties(account, guanliyuan);  // 将账户信息复制到管理员对象
        add(guanliyuan);  // 调用 add 方法执行注册
    }

    /**
     * 修改管理员密码
     * 校验旧密码是否正确，若正确则更新为新密码。
     *
     * @param account 修改密码时提供的账户信息，包含用户名、旧密码、新密码
     */
    public void updatePassword(Account account) {
        // 查询管理员信息
        Guanliyuan dbGuanliyuan = guanliyuanMapper.selectByUsername(account.getUsername());
        if (ObjectUtil.isNull(dbGuanliyuan)) {
            throw new CustomException(ResultCodeEnum.YONGHUBUCUNZAI);  // 用户不存在
        }
        // 校验旧密码是否正确
        if (!account.getPassword().equals(dbGuanliyuan.getPassword())) {
            throw new CustomException(ResultCodeEnum.MIMACUOWU);  // 旧密码错误
        }
        // 更新密码为新密码
        dbGuanliyuan.setPassword(account.getNewPassword());
        guanliyuanMapper.updateById(dbGuanliyuan);  // 更新数据库中的密码
    }

}
