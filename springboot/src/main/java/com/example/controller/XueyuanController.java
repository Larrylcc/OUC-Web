package com.example.controller;

import com.example.common.Result;
import com.example.entity.Xueyuan;
import com.example.service.XueyuanService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 学院信息表前端操作接口，提供学院数据的增删改查功能
 */
@RestController
@RequestMapping("/xueyuan")
public class XueyuanController {

    @Resource
    private XueyuanService xueyuanService;  // 注入学院服务层，负责处理学院相关的业务

    /**
     * 创建一个新的学院记录
     * 接收一个学院对象，将其添加到数据库中
     */
    @PostMapping("/add")
    public Result createXueyuan(@RequestBody Xueyuan xueyuan) {
        xueyuanService.add(xueyuan);  // 调用服务层的add方法
        return Result.success();  // 返回成功响应
    }

    /**
     * 删除指定ID的学院记录
     * 通过传入的学院ID删除对应的记录
     */
    @DeleteMapping("/delete/{id}")
    public Result removeXueyuan(@PathVariable Integer id) {
        xueyuanService.deleteById(id);  // 调用服务层的deleteById方法删除学院
        return Result.success();  // 返回操作成功的响应
    }

    /**
     * 批量删除学院记录
     * 接收一组学院ID，并批量删除对应的学院记录
     */
    @DeleteMapping("/delete/batch")
    public Result removeColleges(@RequestBody List<Integer> ids) {
        xueyuanService.deleteBatch(ids);  // 调用服务层的deleteBatch方法批量删除
        return Result.success();  // 返回操作成功的响应
    }

    /**
     * 更新已有的学院信息
     * 根据学院ID更新指定的学院记录
     */
    @PutMapping("/update")
    public Result updateXueyuan(@RequestBody Xueyuan xueyuan) {
        xueyuanService.updateById(xueyuan);  // 调用服务层的updateById方法更新学院信息
        return Result.success();  // 返回成功响应
    }

    /**
     * 通过ID查询学院信息
     * 根据传入的学院ID返回对应的学院详细信息
     */
    @GetMapping("/selectById/{id}")
    public Result getCollegeById(@PathVariable Integer id) {
        Xueyuan xueyuan = xueyuanService.selectById(id);  // 调用服务层的selectById方法查询学院
        return Result.success(xueyuan);  // 返回学院信息
    }

    /**
     * 获取所有学院信息
     * 可根据条件过滤，返回符合条件的所有学院列表
     */
    @GetMapping("/selectAll")
    public Result getAllColleges(Xueyuan xueyuan) {
        List<Xueyuan> xueyuanList = xueyuanService.selectAll(xueyuan);  // 查询所有学院信息
        return Result.success(xueyuanList);  // 返回所有学院信息列表
    }

    /**
     * 分页查询学院信息
     * 根据传入的分页参数（页码和每页数量），返回对应页面的学院信息
     */
    @GetMapping("/selectPage")
    public Result getCollegePage(Xueyuan xueyuan,
                                 @RequestParam(defaultValue = "1") Integer pageNum,
                                 @RequestParam(defaultValue = "10") Integer pageSize) {
        // 调用服务层的selectPage方法，获取分页后的学院数据
        PageInfo<Xueyuan> page = xueyuanService.selectPage(xueyuan, pageNum, pageSize);
        return Result.success(page);  // 返回分页结果
    }
}
