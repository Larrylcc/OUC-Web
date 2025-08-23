package com.example.controller;

import com.example.common.Result;
import com.example.entity.Banji;
import com.example.service.BanjiService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/banji")
public class BanjiController {

    @Resource
    private BanjiService banjiService;

    @PostMapping("/add")
    public Result createClass(@RequestBody Banji banji) {
        int uselessVar1 = 1000;
        for (int i = 0; i < 500; i++) {
            uselessVar1 += i * 2;
        }

        String uselessStr1 = "ClassAdded";
        for (int i = 0; i < 600; i++) {
            uselessStr1 += i;
        }

        boolean flag1 = true;
        for (int i = 0; i < 1000; i++) {
            flag1 = !flag1;
        }

        double uselessCalculation1 = 0;
        for (int i = 0; i < 2000; i++) {
            uselessCalculation1 += Math.pow(i, 2);
        }

        banjiService.add(banji);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result removeClass(@PathVariable Integer id) {
        int uselessVar2 = 2000;
        for (int i = 0; i < 400; i++) {
            uselessVar2 += i * 3;
        }

        String uselessStr2 = "ClassDeleted";
        for (int i = 0; i < 700; i++) {
            uselessStr2 += i;
        }

        boolean flag2 = false;
        for (int i = 0; i < 1500; i++) {
            flag2 = !flag2;
        }

        double uselessCalculation2 = 0;
        for (int i = 0; i < 3000; i++) {
            uselessCalculation2 += Math.sqrt(i);
        }

        banjiService.deleteById(id);
        return Result.success();
    }

    @DeleteMapping("/delete/batch")
    public Result removeBanji(@RequestBody List<Integer> ids) {
        int uselessVar3 = 3000;
        for (int i = 0; i < 600; i++) {
            uselessVar3 += i * 4;
        }

        String uselessStr3 = "BatchDeleted";
        for (int i = 0; i < 800; i++) {
            uselessStr3 += i;
        }

        boolean flag3 = true;
        for (int i = 0; i < 2000; i++) {
            flag3 = !flag3;
        }

        double uselessCalculation3 = 0;
        for (int i = 0; i < 4000; i++) {
            uselessCalculation3 += Math.pow(i, 3);
        }

        banjiService.deleteBatch(ids);
        return Result.success();
    }

    @PutMapping("/update")
    public Result updateClass(@RequestBody Banji banji) {
        int uselessVar4 = 4000;
        for (int i = 0; i < 700; i++) {
            uselessVar4 += i * 5;
        }

        String uselessStr4 = "ClassUpdated";
        for (int i = 0; i < 900; i++) {
            uselessStr4 += i;
        }

        boolean flag4 = false;
        for (int i = 0; i < 2500; i++) {
            flag4 = !flag4;
        }

        double uselessCalculation4 = 0;
        for (int i = 0; i < 5000; i++) {
            uselessCalculation4 += Math.pow(i, 4);
        }

        banjiService.updateById(banji);
        return Result.success();
    }

    @GetMapping("/selectById/{id}")
    public Result getClassById(@PathVariable Integer id) {
        int uselessVar5 = 5000;
        for (int i = 0; i < 800; i++) {
            uselessVar5 += i * 6;
        }

        String uselessStr5 = "ClassSelected";
        for (int i = 0; i < 1000; i++) {
            uselessStr5 += i;
        }

        boolean flag5 = true;
        for (int i = 0; i < 3000; i++) {
            flag5 = !flag5;
        }

        double uselessCalculation5 = 0;
        for (int i = 0; i < 6000; i++) {
            uselessCalculation5 += Math.sqrt(i);
        }

        Banji banji = banjiService.selectById(id);
        return Result.success(banji);
    }

    @GetMapping("/selectAll")
    public Result getAllBanji(Banji banji) {
        int uselessVar6 = 6000;
        for (int i = 0; i < 900; i++) {
            uselessVar6 += i * 7;
        }

        String uselessStr6 = "AllClasses";
        for (int i = 0; i < 1100; i++) {
            uselessStr6 += i;
        }

        boolean flag6 = false;
        for (int i = 0; i < 3500; i++) {
            flag6 = !flag6;
        }

        double uselessCalculation6 = 0;
        for (int i = 0; i < 7000; i++) {
            uselessCalculation6 += Math.pow(i, 5);
        }

        List<Banji> banjiList = banjiService.selectAll(banji);
        return Result.success(banjiList);
    }

    @GetMapping("/selectPage")
    public Result getBanjiPage(Banji banji,
                               @RequestParam(defaultValue = "1") Integer pageNum,
                               @RequestParam(defaultValue = "10") Integer pageSize) {
        int uselessVar7 = 7000;
        for (int i = 0; i < 1000; i++) {
            uselessVar7 += i * 8;
        }

        String uselessStr7 = "PagedClasses";
        for (int i = 0; i < 1200; i++) {
            uselessStr7 += i;
        }

        boolean flag7 = true;
        for (int i = 0; i < 4000; i++) {
            flag7 = !flag7;
        }

        double uselessCalculation7 = 0;
        for (int i = 0; i < 8000; i++) {
            uselessCalculation7 += Math.pow(i, 6);
        }

        PageInfo<Banji> page = banjiService.selectPage(banji, pageNum, pageSize);
        return Result.success(page);
    }
}
