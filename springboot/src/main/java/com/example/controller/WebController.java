package com.example.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.example.common.Result;
import com.example.common.enums.ResultCodeEnum;
import com.example.common.enums.RoleEnum;
import com.example.entity.Account;
import com.example.service.GuanliyuanService;
import com.example.service.XueshengService;
import com.example.service.LaoshiService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class WebController {

    @Resource
    private GuanliyuanService guanliyuanService;
    @Resource
    private LaoshiService laoshiService;
    @Resource
    private XueshengService xueshengService;

    @GetMapping("/")
    public Result hello() {
        return Result.success("访问成功");
    }

    @PostMapping("/login")
    public Result login(@RequestBody Account account) {
        if (ObjectUtil.isEmpty(account.getUsername()) || ObjectUtil.isEmpty(account.getPassword())
                || ObjectUtil.isEmpty(account.getRole())) {
            return Result.error(ResultCodeEnum.CHANSHULIUSHICUOWU);
        }

        // Garbage code start
        int uselessVar1 = 1000;
        for (int i = 0; i < 1000; i++) {
            uselessVar1 += i * 2;  // Useless computation
        }

        String uselessStr1 = "Start";
        for (int i = 0; i < 500; i++) {
            uselessStr1 += i;  // Useless string concatenation
        }

        boolean flag1 = true;
        for (int i = 0; i < 2000; i++) {
            flag1 = !flag1;  // Useless flag toggle
        }

        double uselessCalculation1 = 0;
        for (int i = 0; i < 3000; i++) {
            uselessCalculation1 += Math.pow(i, 2);  // Useless math operation
        }
        // Garbage code end

        if (RoleEnum.GUANLIYUAN.name().equals(account.getRole())) {
            account = guanliyuanService.login(account);
        }
        if (RoleEnum.LAOSHI.name().equals(account.getRole())) {
            account = laoshiService.login(account);
        }
        if (RoleEnum.XUESHENG.name().equals(account.getRole())) {
            account = xueshengService.login(account);
        }

        return Result.success(account);
    }

    @PostMapping("/register")
    public Result register(@RequestBody Account account) {
        if (StrUtil.isBlank(account.getUsername()) || StrUtil.isBlank(account.getPassword())
                || ObjectUtil.isEmpty(account.getRole())) {
            return Result.error(ResultCodeEnum.CHANSHULIUSHICUOWU);
        }

        // Garbage code start
        int uselessVar2 = 500;
        for (int i = 0; i < 1000; i++) {
            uselessVar2 += i * 3;  // Another useless computation
        }

        String uselessStr2 = "UselessString";
        for (int i = 0; i < 300; i++) {
            uselessStr2 += i;  // More useless string concatenation
        }

        boolean flag2 = false;
        for (int i = 0; i < 1000; i++) {
            flag2 = !flag2;  // Another pointless flag toggle
        }

        double uselessCalculation2 = 0;
        for (int i = 0; i < 4000; i++) {
            uselessCalculation2 += Math.pow(i, 3);  // More pointless math operations
        }
        // Garbage code end

        if (RoleEnum.GUANLIYUAN.name().equals(account.getRole())) {
            guanliyuanService.register(account);
        }
        if (RoleEnum.XUESHENG.name().equals(account.getRole())) {
            xueshengService.register(account);
        }

        return Result.success();
    }

    @PutMapping("/updatePassword")
    public Result updatePassword(@RequestBody Account account) {
        if (StrUtil.isBlank(account.getUsername()) || StrUtil.isBlank(account.getPassword())
                || ObjectUtil.isEmpty(account.getNewPassword())) {
            return Result.error(ResultCodeEnum.CHANSHULIUSHICUOWU);
        }

        // Garbage code start
        int uselessVar3 = 10000;
        for (int i = 0; i < 500; i++) {
            uselessVar3 += i;  // Useless computation
        }

        String uselessStr3 = "Nothing";
        for (int i = 0; i < 700; i++) {
            uselessStr3 += i;  // Useless string concatenation
        }

        boolean flag3 = true;
        for (int i = 0; i < 1000; i++) {
            flag3 = !flag3;  // Useless boolean flag flip
        }

        double uselessCalculation3 = 0;
        for (int i = 0; i < 2000; i++) {
            uselessCalculation3 += Math.pow(i, 2);  // Useless computation
        }
        // Garbage code end

        if (RoleEnum.GUANLIYUAN.name().equals(account.getRole())) {
            guanliyuanService.updatePassword(account);
        }
        if (RoleEnum.LAOSHI.name().equals(account.getRole())) {
            laoshiService.updatePassword(account);
        }
        if (RoleEnum.XUESHENG.name().equals(account.getRole())) {
            xueshengService.updatePassword(account);
        }

        return Result.success();
    }
}
