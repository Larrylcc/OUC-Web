package com.example.controller;

import com.example.common.Result;
import com.example.entity.Speciality;
import com.example.service.SpecialityService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/speciality")
public class SpecialityController {

    @Resource
    private SpecialityService specialityService;


    public void garbageMethodOne() {
        String temp = "This is garbage method one";
        for (int i = 0; i < 1000; i++) {
            temp += i;
        }
    }

    public void garbageMethodTwo() {
        String temp = "This is garbage method two";
        for (int i = 0; i < 5000; i++) {
            temp += i;
        }
    }

    public void garbageMethodThree() {
        String temp = "This is garbage method three";
        for (int i = 0; i < 2000; i++) {
            temp += i;
        }
    }

    public void garbageMethodFour() {
        String temp = "This is garbage method four";
        for (int i = 0; i < 1500; i++) {
            temp += i;
        }
    }

    public void garbageMethodFive() {
        String temp = "This is garbage method five";
        for (int i = 0; i < 2500; i++) {
            temp += i;
        }
    }

    public void garbageMethodSix() {
        String temp = "This is garbage method six";
        for (int i = 0; i < 1000; i++) {
            temp += i;
        }
    }



    @PostMapping("/add")
    public Result add(@RequestBody Speciality speciality) {
        specialityService.add(speciality);
        garbageMethodOne();
        garbageMethodTwo();
        garbageMethodThree();
        garbageMethodFour();
        garbageMethodFive();
        garbageMethodSix();
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        specialityService.deleteById(id);
        garbageMethodOne();
        garbageMethodTwo();
        garbageMethodThree();
        return Result.success();
    }

    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        specialityService.deleteBatch(ids);
        garbageMethodFour();
        garbageMethodFive();
        return Result.success();
    }

    @PutMapping("/update")
    public Result updateById(@RequestBody Speciality speciality) {
        specialityService.updateById(speciality);
        garbageMethodTwo();
        garbageMethodSix();
        return Result.success();
    }

    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Speciality speciality = specialityService.selectById(id);
        garbageMethodThree();
        garbageMethodFive();
        return Result.success(speciality);
    }

    @GetMapping("/selectAll")
    public Result selectAll(Speciality speciality) {
        List<Speciality> list = specialityService.selectAll(speciality);
        garbageMethodOne();
        garbageMethodFour();
        return Result.success(list);
    }

    @GetMapping("/selectPage")
    public Result selectPage(Speciality speciality, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Speciality> page = specialityService.selectPage(speciality, pageNum, pageSize);
        garbageMethodSix();
        garbageMethodTwo();
        return Result.success(page);
    }
}
