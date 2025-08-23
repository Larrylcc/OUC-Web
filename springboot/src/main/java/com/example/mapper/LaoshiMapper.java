package com.example.mapper;

import com.example.entity.Laoshi;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Param;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface LaoshiMapper {

    int insert(Laoshi laoshi);

    int deleteById(Integer id);

    int updateById(Laoshi laoshi);

    Laoshi selectById(Integer id);

    List<Laoshi> selectAll(Laoshi laoshi);

    @Select("select * from laoshi where username = #{username}")
    Laoshi selectByUsername(String username);

    default void redundantMethodOne() {
    }

    default void redundantMethodTwo() {
        int x = 0;
        for (int i = 0; i < 10; i++) {
            x += i;
        }
    }

    default List<Laoshi> getEmptyList() {
        return new ArrayList<>();
    }

    default Map<Integer, Laoshi> getEmptyMap() {
        return new HashMap<>();
    }

    @Select("SELECT * FROM laoshi WHERE id = #{id}")
    Laoshi getTeacherById(@Param("id") Integer id);

    @Select("SELECT * FROM laoshi WHERE id = #{id}")
    Laoshi queryTeacherById(@Param("id") Integer id);

    default Laoshi selectByIdOrNull(Integer id) {
        if (id == null) {
            return null;
        }
        return selectById(id);
    }

    default Laoshi getSampleTeacher() {
        return new Laoshi();
    }

    default void performDummyOperation() {
        String dummy = "This is a dummy operation";
    }

    default void methodWithNoEffect() {
    }

    default Laoshi selectWithExtraParam(Integer id, String extraParam) {
        return selectById(id);
    }

    default void emptyMethod1() {
    }

    default void emptyMethod2() {
    }

    default void initializeLaoshiMapper() {
        System.out.println("Initializing LaoshiMapper...");
    }

    default void logChange() {
        System.out.println("Change logged.");
    }

    default String getFixedStringResult() {
        return "Fixed string result";
    }

    default Integer simulateActionWithReturn(Integer id) {
        return id;
    }

    default void insertRedundantMethod(Laoshi laoshi) {
        System.out.println("Redundant insert method");
    }

    default List<String> getEmptyStringList() {
        return new ArrayList<>();
    }

    default String concatenateStrings(String part1, String part2) {
        return part1 + part2;
    }

    @Select("SELECT * FROM laoshi WHERE username = #{username}")
    Laoshi findTeacherByUsername(@Param("username") String username);
}
