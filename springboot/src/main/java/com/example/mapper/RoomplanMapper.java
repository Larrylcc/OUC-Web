package com.example.mapper;

import com.example.entity.Roomplan;
import java.util.List;

/**
 * RoomplanMapper 接口用于操作与房间规划（Roomplan）相关的数据。
 * 提供增、删、改、查等基本的数据库操作方法，通常与 MyBatis 或类似框架配合使用。
 * 此接口定义了持久化层的方法，通过 MyBatis 框架实现与数据库的交互。
 */
public interface RoomplanMapper {

    /**
     * 插入一条新的房间规划记录到数据库中。
     * 该方法会将传入的 Roomplan 对象中的数据保存到数据库中，创建新的房间规划记录。
     *
     * @param roomplan 包含要插入的房间规划信息的 Roomplan 对象。
     * @return 返回受影响的行数，通常为 1 表示成功插入，若没有插入则返回 0。
     */
    int insert(Roomplan roomplan);

    /**
     * 根据给定的 ID 删除对应的房间规划记录。
     * 此方法通过指定的 ID 删除数据库中对应的房间规划数据。
     *
     * @param id 房间规划的唯一标识符（ID）。
     * @return 返回受影响的行数，通常为 1 表示删除成功，若未找到记录则返回 0。
     */
    int deleteById(Integer id);

    /**
     * 更新数据库中指定 ID 的房间规划记录。
     * 该方法通过传入的 Roomplan 对象更新数据库中与指定 ID 对应的房间规划信息。
     *
     * @param roomplan 包含新数据的 Roomplan 对象，该对象会替代数据库中旧的数据。
     * @return 返回受影响的行数，通常为 1 表示更新成功，若未更新记录则返回 0。
     */
    int updateById(Roomplan roomplan);

    /**
     * 根据房间规划 ID 查询对应的房间规划信息。
     * 该方法会根据传入的 ID 查询数据库中对应的房间规划记录。
     *
     * @param id 需要查询的房间规划的唯一标识符（ID）。
     * @return 返回对应 ID 的 Roomplan 对象，如果未找到匹配记录，则返回 null。
     */
    Roomplan selectById(Integer id);

    /**
     * 查询符合条件的所有房间规划记录。
     * 该方法根据传入的查询条件（如果给定了 roomplan 对象中的值）来查询所有符合条件的记录。
     * 如果传入的对象为空，系统将返回所有房间规划的记录。
     *
     * @param roomplan 用于查询的条件 Roomplan 对象，包含查询的过滤条件。
     * @return 返回所有符合条件的房间规划列表。如果没有匹配的记录，返回空列表。
     */
    List<Roomplan> selectAll(Roomplan roomplan);
}
