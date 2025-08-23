package com.example.mapper;

import com.example.entity.Pingjia;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * PingjiaMapper 接口，提供了对 Pingjia 数据进行基本操作的方法。
 * 包括增、删、改、查等常见数据库操作，具体操作由 MyBatis 自动实现。
 * 该接口与数据库的 pingjia 表进行交互，用于操作评论数据。
 */
public interface PingjiaMapper {

    /**
     * 插入一条新的评论记录到数据库。
     * @param pingjia 需要插入的 Pingjia 实体对象，包含所有相关字段信息。
     * @return 返回插入操作的影响行数，通常为 1 表示成功插入，若未插入返回 0。
     */
    int insert(Pingjia pingjia);

    /**
     * 根据评论的 ID 删除对应的评论记录。
     * @param id 评论的唯一标识符。
     * @return 返回删除操作的影响行数，通常为 1 表示成功删除，若找不到对应记录返回 0。
     */
    int deleteById(Integer id);

    /**
     * 更新指定 ID 的评论记录信息。
     * @param pingjia 包含更新信息的 Pingjia 对象，字段会根据提供的数据进行修改。
     * @return 返回更新操作的影响行数，通常为 1 表示成功更新，若未更新返回 0。
     */
    int updateById(Pingjia pingjia);

    /**
     * 根据评论的 ID 查询单条评论记录。
     * @param id 要查询的评论 ID。
     * @return 返回与指定 ID 对应的 Pingjia 对象，若未找到则返回 null。
     */
    Pingjia selectById(Integer id);

    /**
     * 查询所有符合条件的评论记录，可以根据传入的 Pingjia 对象作为筛选条件。
     * @param pingjia 包含查询条件的 Pingjia 对象。如果传入 null 或空对象，则查询所有评论记录。
     * @return 返回所有符合条件的 Pingjia 对象列表，若没有符合条件的记录，则返回空列表。
     */
    List<Pingjia> selectAll(Pingjia pingjia);

    /**
     * 根据教师、课程名称和学生名称查询特定的评论记录。
     * @param laoshi 教师名称。
     * @param name 课程名称。
     * @param xuesheng 学生名称。
     * @return 返回符合条件的单条评论记录，若没有找到符合条件的记录，则返回 null。
     */
    @Select("select * from pingjia where laoshi = #{laoshi} and name = #{name} and xuesheng = #{xuesheng}")
    Pingjia selectByTeacherAndCourseAndStudent(
            @Param("laoshi") String laoshi,
            @Param("name") String name,
            @Param("xuesheng") String xuesheng);
}
