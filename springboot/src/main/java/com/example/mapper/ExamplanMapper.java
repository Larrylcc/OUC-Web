package com.example.mapper;

import com.example.entity.Examplan;
import java.util.List;

/**
 * ExamplanMapper 接口，定义了对考试计划（Examplan）数据进行基本操作的方法。
 * 该接口与数据库交互，提供对考试计划数据的增、删、改、查操作。
 * 所有方法由 MyBatis 框架自动实现，用户可调用这些方法来执行相应的数据库操作。
 */
public interface ExamplanMapper {

    /**
     * 插入一条新的考试计划记录到数据库。
     * @param examplan 要插入的 Examplan 对象，包含了考试计划的详细信息。
     * @return 返回影响的行数，通常为 1 表示成功插入，若未插入返回 0。
     */
    int insert(Examplan examplan);

    /**
     * 根据指定的 ID 删除对应的考试计划记录。
     * @param id 要删除的考试计划的唯一标识符（ID）。
     * @return 返回影响的行数，通常为 1 表示成功删除，若未删除返回 0。
     */
    int deleteById(Integer id);

    /**
     * 更新指定 ID 的考试计划记录的信息。
     * @param examplan 包含更新数据的 Examplan 对象，该对象中的字段将被更新到数据库。
     * @return 返回影响的行数，通常为 1 表示成功更新，若未更新返回 0。
     */
    int updateById(Examplan examplan);

    /**
     * 根据考试计划的 ID 查询特定的考试计划。
     * @param id 需要查询的考试计划的唯一标识符（ID）。
     * @return 返回与指定 ID 对应的 Examplan 对象。如果未找到对应的考试计划，返回 null。
     */
    Examplan selectById(Integer id);

    /**
     * 查询所有符合条件的考试计划记录。
     * @param examplan 包含查询条件的 Examplan 对象，如果该对象为 null 或为空，则查询所有考试计划记录。
     * @return 返回所有符合条件的考试计划列表。如果没有符合条件的记录，返回空列表。
     */
    List<Examplan> selectAll(Examplan examplan);
}
