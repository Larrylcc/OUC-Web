package com.example.mapper;

import com.example.entity.Notice;
import java.util.List;

/**
 * NoticeMapper 接口，提供对通知（Notice）数据进行基本的增、删、改、查操作。
 * 该接口与数据库交互，通过 MyBatis 框架提供持久化操作方法。
 * 所有方法由 MyBatis 自动实现，用于管理通知相关数据。
 */
public interface NoticeMapper {

    /**
     * 插入一条新的通知记录到数据库。
     * 通过传入一个包含通知详细信息的 Notice 对象，系统会在数据库中创建一条新的记录。
     *
     * @param notice 要插入的 Notice 对象，包含通知的各个字段（如标题、内容等）。
     * @return 返回影响的行数，通常为 1 表示成功插入，若无记录插入则返回 0。
     */
    int insert(Notice notice);

    /**
     * 根据通知的 ID 删除指定的通知记录。
     * 此方法会根据给定的 ID 删除数据库中的一条通知记录。
     *
     * @param id 需要删除的通知的唯一标识符（ID）。
     * @return 返回影响的行数，通常为 1 表示成功删除，若未找到记录删除则返回 0。
     */
    int deleteById(Integer id);

    /**
     * 更新指定 ID 的通知记录。
     * 该方法通过传入一个新的 Notice 对象，更新数据库中与该 ID 对应的通知信息。
     *
     * @param notice 包含新数据的 Notice 对象，数据库中会根据该对象的字段更新相应的记录。
     * @return 返回影响的行数，通常为 1 表示成功更新，若未更新则返回 0。
     */
    int updateById(Notice notice);

    /**
     * 根据通知的 ID 查询对应的通知详细信息。
     * 该方法会从数据库中获取与指定 ID 对应的通知记录。
     *
     * @param id 需要查询的通知的唯一标识符（ID）。
     * @return 返回与指定 ID 对应的 Notice 对象。如果未找到对应的记录，返回 null。
     */
    Notice selectById(Integer id);

    /**
     * 查询所有符合条件的通知记录。
     * 如果传入的 Notice 对象不为 null，则会根据对象中的字段值作为查询条件。
     * 如果传入的对象为空，则查询所有通知记录。
     *
     * @param notice 查询条件的 Notice 对象，如果为空则查询所有通知。
     * @return 返回符合条件的通知列表。如果没有找到记录，返回空列表。
     */
    List<Notice> selectAll(Notice notice);
}
