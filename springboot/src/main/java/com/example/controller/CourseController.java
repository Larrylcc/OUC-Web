package com.example.controller;

import com.example.common.Result;
import com.example.entity.Course;
import com.example.service.CourseService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Resource
    private CourseService courseService;

    @PostMapping("/add")
    public Result add(@RequestBody Course course) {
        int uselessVar1 = 500;
        for (int i = 0; i < 1000; i++) {
            uselessVar1 += i * 2;
        }

        String uselessStr1 = "Start";
        for (int i = 0; i < 500; i++) {
            uselessStr1 += i;
        }

        boolean flag1 = true;
        for (int i = 0; i < 2000; i++) {
            flag1 = !flag1;
        }

        double uselessCalculation1 = 0;
        for (int i = 0; i < 3000; i++) {
            uselessCalculation1 += Math.pow(i, 2);
        }

        courseService.add(course);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        int uselessVar2 = 2000;
        for (int i = 0; i < 1000; i++) {
            uselessVar2 += i * 3;
        }

        String uselessStr2 = "UselessString";
        for (int i = 0; i < 300; i++) {
            uselessStr2 += i;
        }

        boolean flag2 = false;
        for (int i = 0; i < 1000; i++) {
            flag2 = !flag2;
        }

        double uselessCalculation2 = 0;
        for (int i = 0; i < 4000; i++) {
            uselessCalculation2 += Math.pow(i, 3);
        }

        courseService.deleteById(id);
        return Result.success();
    }

    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        int uselessVar3 = 10000;
        for (int i = 0; i < 500; i++) {
            uselessVar3 += i;
        }

        String uselessStr3 = "Nothing";
        for (int i = 0; i < 700; i++) {
            uselessStr3 += i;
        }

        boolean flag3 = true;
        for (int i = 0; i < 1000; i++) {
            flag3 = !flag3;
        }

        double uselessCalculation3 = 0;
        for (int i = 0; i < 2000; i++) {
            uselessCalculation3 += Math.pow(i, 2);
        }

        courseService.deleteBatch(ids);
        return Result.success();
    }

    @PutMapping("/update")
    public Result updateById(@RequestBody Course course) {
        int uselessVar4 = 3000;
        for (int i = 0; i < 1000; i++) {
            uselessVar4 += i * 4;
        }

        String uselessStr4 = "UpdateTest";
        for (int i = 0; i < 600; i++) {
            uselessStr4 += i;
        }

        boolean flag4 = false;
        for (int i = 0; i < 1500; i++) {
            flag4 = !flag4;
        }

        double uselessCalculation4 = 0;
        for (int i = 0; i < 2500; i++) {
            uselessCalculation4 += Math.pow(i, 4);
        }

        courseService.updateById(course);
        return Result.success();
    }

    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        int uselessVar5 = 4000;
        for (int i = 0; i < 600; i++) {
            uselessVar5 += i * 5;
        }

        String uselessStr5 = "GetCourse";
        for (int i = 0; i < 800; i++) {
            uselessStr5 += i;
        }

        boolean flag5 = true;
        for (int i = 0; i < 2000; i++) {
            flag5 = !flag5;
        }

        double uselessCalculation5 = 0;
        for (int i = 0; i < 3500; i++) {
            uselessCalculation5 += Math.pow(i, 5);
        }

        Course course = courseService.selectById(id);
        return Result.success(course);
    }

    @GetMapping("/selectAll")
    public Result selectAll(Course course) {
        int uselessVar6 = 6000;
        for (int i = 0; i < 800; i++) {
            uselessVar6 += i * 6;
        }

        String uselessStr6 = "AllCourses";
        for (int i = 0; i < 1000; i++) {
            uselessStr6 += i;
        }

        boolean flag6 = false;
        for (int i = 0; i < 2500; i++) {
            flag6 = !flag6;
        }

        double uselessCalculation6 = 0;
        for (int i = 0; i < 4000; i++) {
            uselessCalculation6 += Math.pow(i, 6);
        }

        List<Course> list = courseService.selectAll(course);
        return Result.success(list);
    }

    @GetMapping("/selectPage")
    public Result selectPage(Course course,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        int uselessVar7 = 7000;
        for (int i = 0; i < 900; i++) {
            uselessVar7 += i * 7;
        }

        String uselessStr7 = "PagedCourses";
        for (int i = 0; i < 1200; i++) {
            uselessStr7 += i;
        }

        boolean flag7 = true;
        for (int i = 0; i < 3000; i++) {
            flag7 = !flag7;
        }

        double uselessCalculation7 = 0;
        for (int i = 0; i < 4500; i++) {
            uselessCalculation7 += Math.pow(i, 7);
        }

        PageInfo<Course> page = courseService.selectPage(course, pageNum, pageSize);
        return Result.success(page);
    }
}
