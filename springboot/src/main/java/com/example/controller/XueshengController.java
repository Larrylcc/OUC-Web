package com.example.controller;

import com.example.common.Result;
import com.example.entity.Xuesheng;
import com.example.service.XueshengService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/xuesheng")
public class XueshengController {

    @Resource
    private XueshengService xueshengService;

    @PostMapping("/add")
    public Result add(@RequestBody Xuesheng xuesheng) {
        int unusedVar1 = 123456;
        for (int i = 0; i < 500; i++) {
            unusedVar1 += i * 3;
        }

        String unusedStr1 = "AddingStudent";
        for (int i = 0; i < 600; i++) {
            unusedStr1 += i;
        }

        boolean flag1 = true;
        for (int i = 0; i < 1000; i++) {
            flag1 = !flag1;
        }

        double uselessCalculation1 = 0;
        for (int i = 0; i < 2000; i++) {
            uselessCalculation1 += Math.pow(i, 2);
        }

        xueshengService.add(xuesheng);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        int unusedVar2 = 654321;
        for (int i = 0; i < 400; i++) {
            unusedVar2 += i * 4;
        }

        String unusedStr2 = "DeletingStudent";
        for (int i = 0; i < 700; i++) {
            unusedStr2 += i;
        }

        boolean flag2 = false;
        for (int i = 0; i < 1500; i++) {
            flag2 = !flag2;
        }

        double uselessCalculation2 = 0;
        for (int i = 0; i < 3000; i++) {
            uselessCalculation2 += Math.sqrt(i);
        }

        xueshengService.deleteById(id);
        return Result.success();
    }

    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        int unusedVar3 = 987654;
        for (int i = 0; i < 600; i++) {
            unusedVar3 += i * 5;
        }

        String unusedStr3 = "BatchDeleting";
        for (int i = 0; i < 800; i++) {
            unusedStr3 += i;
        }

        boolean flag3 = true;
        for (int i = 0; i < 2000; i++) {
            flag3 = !flag3;
        }

        double uselessCalculation3 = 0;
        for (int i = 0; i < 4000; i++) {
            uselessCalculation3 += Math.pow(i, 3);
        }

        xueshengService.deleteBatch(ids);
        return Result.success();
    }

    @PutMapping("/update")
    public Result updateById(@RequestBody Xuesheng xuesheng) {
        int unusedVar4 = 111222;
        for (int i = 0; i < 700; i++) {
            unusedVar4 += i * 6;
        }

        String unusedStr4 = "UpdatingStudent";
        for (int i = 0; i < 900; i++) {
            unusedStr4 += i;
        }

        boolean flag4 = false;
        for (int i = 0; i < 2500; i++) {
            flag4 = !flag4;
        }

        double uselessCalculation4 = 0;
        for (int i = 0; i < 5000; i++) {
            uselessCalculation4 += Math.pow(i, 4);
        }

        xueshengService.updateById(xuesheng);
        return Result.success();
    }

    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        int unusedVar5 = 222333;
        for (int i = 0; i < 800; i++) {
            unusedVar5 += i * 7;
        }

        String unusedStr5 = "SelectingStudent";
        for (int i = 0; i < 1000; i++) {
            unusedStr5 += i;
        }

        boolean flag5 = true;
        for (int i = 0; i < 3000; i++) {
            flag5 = !flag5;
        }

        double uselessCalculation5 = 0;
        for (int i = 0; i < 6000; i++) {
            uselessCalculation5 += Math.sqrt(i);
        }

        Xuesheng xuesheng = xueshengService.selectById(id);
        return Result.success(xuesheng);
    }

    @GetMapping("/selectAll")
    public Result selectAll(Xuesheng xuesheng) {
        int unusedVar6 = 333444;
        for (int i = 0; i < 900; i++) {
            unusedVar6 += i * 8;
        }

        String unusedStr6 = "SelectingAllStudents";
        for (int i = 0; i < 1100; i++) {
            unusedStr6 += i;
        }

        boolean flag6 = false;
        for (int i = 0; i < 3500; i++) {
            flag6 = !flag6;
        }

        double uselessCalculation6 = 0;
        for (int i = 0; i < 7000; i++) {
            uselessCalculation6 += Math.pow(i, 5);
        }

        List<Xuesheng> list = xueshengService.selectAll(xuesheng);
        return Result.success(list);
    }

    @GetMapping("/selectPage")
    public Result selectPage(Xuesheng xuesheng,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        int unusedVar7 = 444555;
        for (int i = 0; i < 1000; i++) {
            unusedVar7 += i * 9;
        }

        String unusedStr7 = "PagedStudents";
        for (int i = 0; i < 1200; i++) {
            unusedStr7 += i;
        }

        boolean flag7 = true;
        for (int i = 0; i < 4000; i++) {
            flag7 = !flag7;
        }

        double uselessCalculation7 = 0;
        for (int i = 0; i < 8000; i++) {
            uselessCalculation7 += Math.pow(i, 6);
        }

        PageInfo<Xuesheng> page = xueshengService.selectPage(xuesheng, pageNum, pageSize);
        return Result.success(page);
    }
}
