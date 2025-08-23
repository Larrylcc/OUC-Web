package com.example.mapper;

import com.example.entity.Speciality;

import java.util.List;

/**
 * SpecialityMapper 接口用于操作与专业（Speciality）相关的数据库操作。
 * 提供了基本的增、删、改、查操作方法，用于与数据库进行交互。
 * 该接口的实现类会通过 MyBatis 或类似框架执行相应的 SQL 查询和操作。
 */
public interface SpecialityMapper {

    /**
     * 插入一条新的专业记录到数据库中。
     * 该方法接受一个 `Speciality` 对象，并将其插入到数据库中，创建一条新的专业记录。
     *
     * @param speciality 要插入的专业对象，包含专业的详细信息。
     * @return 返回影响的行数，通常为 1 表示成功插入，若没有插入则返回 0。
     */
    int insert(Speciality speciality);

    /**
     * 根据给定的 ID 删除指定的专业记录。
     * 该方法接收一个专业 ID，并删除数据库中对应的记录。
     *
     * @param id 要删除的专业记录的唯一标识符（ID）。
     * @return 返回受影响的行数，通常为 1 表示删除成功，若未找到对应记录则返回 0。
     */
    int deleteById(Integer id);

    /**
     * 根据给定的专业对象更新数据库中对应的专业记录。
     * 该方法接收一个 `Speciality` 对象，更新其对应的数据库记录。
     *
     * @param speciality 包含更新数据的专业对象，用于更新数据库中的记录。
     * @return 返回受影响的行数，通常为 1 表示更新成功，若未更新任何记录则返回 0。
     */
    int updateById(Speciality speciality);

    /**
     * 根据给定的 ID 查询对应的专业记录。
     * 该方法根据专业 ID 查询数据库中的记录，返回对应的 `Speciality` 对象。
     *
     * @param id 要查询的专业 ID。
     * @return 返回查询到的 `Speciality` 对象，如果没有找到对应的记录，则返回 null。
     */
    Speciality selectById(Integer id);

    /**
     * 查询所有符合条件的专业记录。
     * 该方法根据传入的 `Speciality` 对象作为查询条件，查询所有符合条件的专业记录。
     *
     * @param speciality 用于查询条件的 `Speciality` 对象，通常是根据某些字段进行过滤。
     * @return 返回符合条件的 `Speciality` 对象列表，如果没有找到记录，则返回空列表。
     */
    List<Speciality> selectAll(Speciality speciality);

}
