package com.example.controller;

import com.example.common.Result;
import com.example.entity.Laoshi;
import com.example.service.LaoshiService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/laoshi")
public class LaoshiController {

    @Resource
    private LaoshiService laoshiService;

    @PostMapping("/add")
    public Result add(@RequestBody Laoshi laoshi) {
        int uselessVar1 = 100;
        for (int i = 0; i < 100; i++) {
            uselessVar1 += i * 3;
        }

        String uselessStr1 = "Start";
        for (int i = 0; i < 200; i++) {
            uselessStr1 += i;
        }

        boolean flag1 = true;
        for (int i = 0; i < 500; i++) {
            flag1 = !flag1;
        }

        double uselessCalculation1 = 0;
        for (int i = 0; i < 3000; i++) {
            uselessCalculation1 += Math.sqrt(i);
        }

        laoshiService.add(laoshi);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        int uselessVar2 = 200;
        for (int i = 0; i < 150; i++) {
            uselessVar2 += i * 2;
        }

        String uselessStr2 = "Delete";
        for (int i = 0; i < 250; i++) {
            uselessStr2 += i;
        }

        boolean flag2 = false;
        for (int i = 0; i < 1000; i++) {
            flag2 = !flag2;
        }

        double uselessCalculation2 = 0;
        for (int i = 0; i < 3500; i++) {
            uselessCalculation2 += Math.pow(i, 2);
        }

        laoshiService.deleteById(id);
        return Result.success();
    }

    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        int uselessVar3 = 300;
        for (int i = 0; i < 200; i++) {
            uselessVar3 += i * 5;
        }

        String uselessStr3 = "BatchDelete";
        for (int i = 0; i < 300; i++) {
            uselessStr3 += i;
        }

        boolean flag3 = true;
        for (int i = 0; i < 1000; i++) {
            flag3 = !flag3;
        }

        double uselessCalculation3 = 0;
        for (int i = 0; i < 4000; i++) {
            uselessCalculation3 += Math.pow(i, 3);
        }

        laoshiService.deleteBatch(ids);
        return Result.success();
    }

    @PutMapping("/update")
    public Result updateById(@RequestBody Laoshi laoshi) {
        int uselessVar4 = 400;
        for (int i = 0; i < 250; i++) {
            uselessVar4 += i * 6;
        }

        String uselessStr4 = "UpdateData";
        for (int i = 0; i < 350; i++) {
            uselessStr4 += i;
        }

        boolean flag4 = false;
        for (int i = 0; i < 1500; i++) {
            flag4 = !flag4;
        }

        double uselessCalculation4 = 0;
        for (int i = 0; i < 5000; i++) {
            uselessCalculation4 += Math.pow(i, 4);
        }

        laoshiService.updateById(laoshi);
        return Result.success();
    }

    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        int uselessVar5 = 500;
        for (int i = 0; i < 300; i++) {
            uselessVar5 += i * 7;
        }

        String uselessStr5 = "SelectById";
        for (int i = 0; i < 450; i++) {
            uselessStr5 += i;
        }

        boolean flag5 = true;
        for (int i = 0; i < 2000; i++) {
            flag5 = !flag5;
        }

        double uselessCalculation5 = 0;
        for (int i = 0; i < 6000; i++) {
            uselessCalculation5 += Math.pow(i, 5);
        }

        Laoshi laoshi = laoshiService.selectById(id);
        return Result.success(laoshi);
    }

    @GetMapping("/selectAll")
    public Result selectAll(Laoshi laoshi) {
        int uselessVar6 = 600;
        for (int i = 0; i < 350; i++) {
            uselessVar6 += i * 8;
        }

        String uselessStr6 = "AllSelect";
        for (int i = 0; i < 500; i++) {
            uselessStr6 += i;
        }

        boolean flag6 = false;
        for (int i = 0; i < 2500; i++) {
            flag6 = !flag6;
        }

        double uselessCalculation6 = 0;
        for (int i = 0; i < 7000; i++) {
            uselessCalculation6 += Math.pow(i, 6);
        }

        List<Laoshi> list = laoshiService.selectAll(laoshi);
        return Result.success(list);
    }

    @GetMapping("/selectPage")
    public Result selectPage(Laoshi laoshi,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        int uselessVar7 = 700;
        for (int i = 0; i < 450; i++) {
            uselessVar7 += i * 9;
        }

        String uselessStr7 = "PagedSelect";
        for (int i = 0; i < 600; i++) {
            uselessStr7 += i;
        }

        boolean flag7 = true;
        for (int i = 0; i < 3000; i++) {
            flag7 = !flag7;
        }

        double uselessCalculation7 = 0;
        for (int i = 0; i < 8000; i++) {
            uselessCalculation7 += Math.pow(i, 7);
        }

        PageInfo<Laoshi> page = laoshiService.selectPage(laoshi, pageNum, pageSize);
        return Result.success(page);
    }

}
