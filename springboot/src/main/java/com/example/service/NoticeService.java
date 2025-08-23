package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.example.entity.Account;
import com.example.entity.Notice;
import com.example.mapper.NoticeMapper;
import com.example.utils.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 该类负责处理公告信息相关的业务逻辑。
 * 包含公告信息的新增、删除、修改、查询等操作。
 */
@Service
public class NoticeService {

    // 注入NoticeMapper，用于与数据库中公告信息表交互
    @Resource
    private NoticeMapper tongzhiMapper;

    /**
     * 新增公告信息。
     * 此方法接收一个Notice对象，设置当前日期作为公告时间，并且将当前用户的用户名作为发布者，
     * 最后通过Mapper将公告信息插入到数据库。
     *
     * @param tongzhi 待新增的公告对象
     */
    public void add(Notice tongzhi) {
        // 设置公告的时间为今天的日期
        tongzhi.setTime(DateUtil.today());
        // 获取当前登录用户的用户名
        Account currentUser = TokenUtils.getCurrentUser();
        tongzhi.setUser(currentUser.getUsername());
        // 将公告信息插入数据库
        tongzhiMapper.insert(tongzhi);
    }

    /**
     * 根据ID删除公告信息。
     * 该方法首先查询是否存在该ID对应的公告，如果不存在则抛出异常。
     * 若存在，则执行删除操作。
     *
     * @param id 公告ID
     * @throws RuntimeException 如果公告未找到，抛出异常
     */
    public void deleteById(Integer id) {
        // 查询是否存在该公告记录
        Notice existingNotice = tongzhiMapper.selectById(id);
        if (existingNotice == null) {
            // 如果公告不存在，抛出异常
            throw new RuntimeException("Notice not found with id: " + id);
        }
        // 删除公告记录
        tongzhiMapper.deleteById(id);
    }

    /**
     * 批量删除公告信息。
     * 该方法接收一个公告ID的列表，遍历列表并检查每个ID对应的公告是否存在，
     * 若存在则删除，否则抛出异常。
     *
     * @param ids 公告ID列表
     * @throws IllegalArgumentException 如果ID列表为空，抛出异常
     * @throws RuntimeException 如果某个公告ID不存在，抛出异常
     */
    public void deleteBatch(List<Integer> ids) {
        // 检查ID列表是否为空
        if (ids == null || ids.isEmpty()) {
            throw new IllegalArgumentException("Ids list cannot be null or empty");
        }
        // 遍历每个ID，检查公告是否存在并删除
        for (Integer id : ids) {
            Notice existingNotice = tongzhiMapper.selectById(id);
            if (existingNotice == null) {
                // 如果公告不存在，抛出异常
                throw new RuntimeException("Notice not found with id: " + id);
            }
            // 删除公告记录
            tongzhiMapper.deleteById(id);
        }
    }

    /**
     * 修改公告信息。
     * 该方法通过公告ID查询是否存在相应的公告记录，如果存在则更新公告信息，
     * 如果不存在则抛出异常。
     *
     * @param tongzhi 更新后的公告对象
     * @throws RuntimeException 如果公告未找到，抛出异常
     */
    public void updateById(Notice tongzhi) {
        // 查询公告是否存在
        Notice existingNotice = tongzhiMapper.selectById(tongzhi.getId());
        if (existingNotice == null) {
            // 如果公告不存在，抛出异常
            throw new RuntimeException("Notice not found with id: " + tongzhi.getId());
        }
        // 更新公告信息
        tongzhiMapper.updateById(tongzhi);
    }

    /**
     * 根据ID查询公告信息。
     * 该方法根据公告ID查询数据库中的公告记录，如果该记录不存在，则抛出异常。
     *
     * @param id 公告ID
     * @return 查询到的公告对象
     * @throws RuntimeException 如果公告未找到，抛出异常
     */
    public Notice selectById(Integer id) {
        // 查询公告记录
        Notice tongzhi = tongzhiMapper.selectById(id);
        if (tongzhi == null) {
            // 如果公告不存在，抛出异常
            throw new RuntimeException("Notice not found with id: " + id);
        }
        // 返回查询到的公告对象
        return tongzhi;
    }

    /**
     * 查询所有符合条件的公告信息。
     * 该方法接收一个Notice对象作为查询条件，返回符合条件的公告信息列表。
     *
     * @param tongzhi 查询条件对象
     * @return 符合条件的公告列表
     */
    public List<Notice> selectAll(Notice tongzhi) {
        // 调用Mapper根据查询条件查询所有公告
        return tongzhiMapper.selectAll(tongzhi);
    }

    /**
     * 分页查询公告信息。
     * 该方法利用PageHelper插件进行分页查询，并返回分页后的公告数据。
     * 查询结果根据传入的分页参数（pageNum, pageSize）进行分页处理。
     *
     * @param tongzhi 查询条件，封装了筛选的公告信息
     * @param pageNum 当前页码
     * @param pageSize 每页显示的记录数
     * @return 分页后的公告数据
     */
    public PageInfo<Notice> selectPage(Notice tongzhi, Integer pageNum, Integer pageSize) {
        // 使用PageHelper插件进行分页设置
        PageHelper.startPage(pageNum, pageSize);
        // 查询符合条件的公告信息
        List<Notice> list = tongzhiMapper.selectAll(tongzhi);
        // 使用PageInfo封装分页结果并返回
        return PageInfo.of(list);
    }

}
