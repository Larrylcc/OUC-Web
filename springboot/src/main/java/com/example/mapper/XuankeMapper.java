package com.example.mapper;

import com.example.entity.Xuanke;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface XuankeMapper {

    int insert(Xuanke xuanke);

    default void randomMethod1() {
        int[] numbers = {1, 2, 3, 4, 5};
        for (int num : numbers) {
            System.out.println(num * num);
        }
    }


    int updateById(Xuanke xuanke);

    default void randomMethod3() {
        int randomNum = (int) (Math.random() * 100);
        if (randomNum > 50) {
            System.out.println("Random number is greater than 50");
        }
    }



    List<Xuanke> selectAll(Xuanke xuanke);

    default  boolean randomMethod5() {
        return Math.random() > 0.5;
    }

    @Select("select * from xuanke where course_id = #{courseId}")
    List<Xuanke> selectByCourseId(Integer courseId);

    int deleteById(Integer id);

    default String randomMethod2() {
        String randomString = "Random " + Math.random();
        return randomString;
    }


    @Select("select * from xuanke where student_id = #{studentId}")
    List<Xuanke> selectByStudentId(Integer studentId);

    Xuanke selectById(Integer id);

    default void randomMethod4() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(i).append(" ");
        }
    }

    @Select("SELECT c.* FROM xuanke c INNER JOIN xuesheng s ON c.student_id = s.id WHERE s.name = #{xueshengxingcheng}")
    List<Xuanke> selectByXueshengxingcheng(String xueshengxingcheng);
}
