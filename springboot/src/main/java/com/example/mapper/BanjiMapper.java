package com.example.mapper;

import com.example.entity.Banji;

import java.util.List;

/**
 * BanjiMapper 接口，定义了对 Banji 数据进行基本操作的方法。
 * 包括对 Banji 实体的增、删、改、查等常见数据库操作。
 * 此接口通过 MyBatis 来执行 SQL 语句与数据库进行交互。
 */
public interface BanjiMapper {

    /**
     * 插入一条新的 Banji 数据记录。
     * @param banji 包含要插入信息的 Banji 对象。
     * @return 返回插入操作影响的行数，通常是 1 表示成功插入。
     */
    int insert(Banji banji);

    /**
     * 根据 Banji 的 ID 删除一条记录。
     * @param id 需要删除的 Banji 记录的唯一标识符（ID）。
     * @return 返回删除操作影响的行数，通常是 1 表示成功删除。
     */
    int deleteById(Integer id);

    /**
     * 更新指定 Banji 记录的信息。
     * @param banji 更新后的 Banji 对象，包含修改后的字段信息。
     * @return 返回更新操作影响的行数，通常是 1 表示成功更新。
     */
    int updateById(Banji banji);

    /**
     * 根据 Banji 的 ID 查询单个 Banji 记录。
     * @param id 要查询的 Banji 的唯一标识符（ID）。
     * @return 返回对应 ID 的 Banji 对象，如果没有记录则返回 null。
     */
    Banji selectById(Integer id);

    /**
     * 查询所有 Banji 记录，支持根据传入的 Banji 对象作为查询条件进行筛选。
     * @param banji 包含查询条件的 Banji 对象。如果为 null 或空，则查询所有记录。
     * @return 返回所有符合条件的 Banji 记录的列表。
     */
    List<Banji> selectAll(Banji banji);

}
