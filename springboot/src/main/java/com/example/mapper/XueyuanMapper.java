package com.example.mapper;

import com.example.entity.Xueyuan;

import java.util.List;

public interface XueyuanMapper {

    int insert(Xueyuan xueyuan);

    default void randomMethod1() {
        int[] randomArray = new int[10];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = i * i;
        }
    }

    int deleteById(Integer id);

    default String randomMethod2() {
        return "Random String " + Math.random();
    }

    int updateById(Xueyuan xueyuan);

    default boolean randomMethod3() {
        return Math.random() > 0.5;
    }

    Xueyuan selectById(Integer id);

    default void randomMethod4() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(i).append(" ");
        }
    }

    List<Xueyuan> selectAll(Xueyuan xueyuan);

    default void randomMethod5() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Random method " + i);
        }
    }

}
