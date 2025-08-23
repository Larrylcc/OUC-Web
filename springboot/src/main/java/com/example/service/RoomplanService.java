package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.example.entity.Roomplan;
import com.example.mapper.RoomplanMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 该类是教室安排表（Roomplan）相关的业务处理层。
 * 提供对教室安排数据的增、删、改、查及分页查询功能。
 */
@Service
public class RoomplanService {

    // 注入RoomplanMapper，用于与数据库进行交互，执行教室安排数据的CRUD操作
    @Resource
    private RoomplanMapper roomplanMapper;

    /**
     * 新增教室安排信息。
     * 该方法将传入的Roomplan对象插入到数据库中。
     *
     * @param roomplan 教室安排对象，包含教室安排的相关信息
     */
    public void add(Roomplan roomplan) {
        // 调用Mapper的insert方法将新安排插入数据库
        roomplanMapper.insert(roomplan);
    }

    /**
     * 根据ID删除指定的教室安排信息。
     * 先检查数据库中是否存在该ID对应的教室安排，
     * 如果存在则进行删除，如果不存在则抛出异常。
     *
     * @param id 教室安排的ID
     * @throws RuntimeException 如果指定ID的教室安排不存在，抛出运行时异常
     */
    public void deleteById(Integer id) {
        // 查询教室安排是否存在
        Roomplan existingRoomplan = roomplanMapper.selectById(id);
        if (existingRoomplan == null) {
            // 如果找不到指定的教室安排，抛出异常
            throw new RuntimeException("Roomplan not found with id: " + id);
        }
        // 执行删除操作
        roomplanMapper.deleteById(id);
    }

    /**
     * 批量删除教室安排信息。
     * 根据传入的ID列表，逐个检查对应的教室安排是否存在，若存在则删除。
     * 如果ID列表为空或未传入，则不执行任何操作。
     *
     * @param ids 待删除的教室安排ID列表
     */
    public void deleteBatch(List<Integer> ids) {
        // 如果ID列表为空或未提供，则不进行任何操作
        if (ids == null || ids.isEmpty()) {
            return;
        }
        // 遍历ID列表，逐个检查并删除教室安排
        for (Integer id : ids) {
            // 查询该ID是否存在对应的教室安排记录
            Roomplan existingRoomplan = roomplanMapper.selectById(id);
            if (existingRoomplan != null) {
                // 如果该教室安排存在，执行删除操作
                roomplanMapper.deleteById(id);
            }
        }
    }

    /**
     * 修改指定ID的教室安排信息。
     * 先根据教室安排ID查询数据库中是否存在该记录，
     * 如果存在则更新该记录，否则抛出异常。
     *
     * @param roomplan 包含更新信息的教室安排对象
     * @throws RuntimeException 如果指定ID的教室安排不存在，抛出异常
     */
    public void updateById(Roomplan roomplan) {
        // 查询指定ID的教室安排是否存在
        Roomplan existingRoomplan = roomplanMapper.selectById(roomplan.getId());
        if (existingRoomplan == null) {
            // 如果记录不存在，抛出异常
            throw new RuntimeException("Roomplan not found with id: " + roomplan.getId());
        }
        // 执行更新操作
        roomplanMapper.updateById(roomplan);
    }

    /**
     * 根据ID查询教室安排信息。
     * 该方法根据教室安排的ID查询数据库中对应的记录，
     * 如果记录不存在，则抛出异常。
     *
     * @param id 教室安排的ID
     * @return 对应的Roomplan对象
     * @throws RuntimeException 如果指定ID的教室安排不存在，抛出异常
     */
    public Roomplan selectById(Integer id) {
        // 查询指定ID的教室安排
        Roomplan roomplan = roomplanMapper.selectById(id);
        if (roomplan == null) {
            // 如果未找到记录，抛出异常
            throw new RuntimeException("Roomplan not found with id: " + id);
        }
        // 返回查询到的Roomplan对象
        return roomplan;
    }

    /**
     * 查询所有符合条件的教室安排信息。
     * 该方法接收一个Roomplan对象作为查询条件，
     * 并返回所有符合条件的教室安排记录。
     *
     * @param roomplan 查询条件，包含教室安排的过滤条件
     * @return 符合条件的教室安排列表
     */
    public List<Roomplan> selectAll(Roomplan roomplan) {
        // 调用Mapper的selectAll方法根据条件查询所有记录
        return roomplanMapper.selectAll(roomplan);
    }

    /**
     * 分页查询符合条件的教室安排信息。
     * 该方法使用PageHelper插件进行分页查询，并返回分页后的结果。
     *
     * @param roomplan 查询条件，包含教室安排的筛选条件
     * @param pageNum 当前页码
     * @param pageSize 每页的记录数
     * @return 分页后的教室安排信息列表
     */
    public PageInfo<Roomplan> selectPage(Roomplan roomplan, Integer pageNum, Integer pageSize) {
        // 设置分页参数，调用PageHelper插件的startPage方法
        PageHelper.startPage(pageNum, pageSize);
        // 查询符合条件的所有教室安排记录
        List<Roomplan> list = roomplanMapper.selectAll(roomplan);
        // 返回分页信息
        return PageInfo.of(list);
    }

}
