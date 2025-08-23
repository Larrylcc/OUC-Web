package com.example.controller;

import com.example.common.Result;
import com.example.entity.Xuanke;
import com.example.entity.Curriculum;
import com.example.service.XuankeService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 选课信息管理接口，提供添加、删除、修改、查询及分页查询等操作
 * 用于操作选课信息，并与前端进行交互
 */
@RestController
@RequestMapping("/xuanke")
public class XuankeController {

    @Resource
    private XuankeService xuankeService;  // 注入XuankeService，处理业务逻辑

    /**
     * 新增选课信息
     * 接收一个Xuanke对象，通过POST请求创建一条选课记录
     */
    @PostMapping("/add")
    public Result addXuanke(@RequestBody Xuanke xuanke) {
        xuankeService.add(xuanke);  // 调用XuankeService添加选课记录
        return Result.success();  // 返回成功响应
    }

    /**
     * 删除选课信息
     * 根据提供的ID删除对应的选课记录
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteXuanke(@PathVariable Integer id) {
        xuankeService.deleteById(id);  // 调用Service删除记录
        return Result.success();  // 返回删除成功的响应
    }

    /**
     * 批量删除选课信息
     * 接收一个ID列表，批量删除对应的选课记录
     */
    @DeleteMapping("/delete/batch")
    public Result deleteChoices(@RequestBody List<Integer> ids) {
        xuankeService.deleteBatch(ids);  // 调用Service进行批量删除
        return Result.success();  // 返回成功响应
    }

    /**
     * 更新选课信息
     * 根据Xuanke对象更新选课记录
     */
    @PutMapping("/update")
    public Result updateXuanke(@RequestBody Xuanke xuanke) {
        xuankeService.updateById(xuanke);  // 调用Service更新记录
        return Result.success();  // 返回成功响应
    }

    /**
     * 根据ID查询选课信息
     * 根据传入的选课ID获取相应的选课记录
     */
    @GetMapping("/selectById/{id}")
    public Result getChoiceById(@PathVariable Integer id) {
        Xuanke xuanke = xuankeService.selectById(id);  // 调用Service查询记录
        return Result.success(xuanke);  // 返回查询到的记录
    }

    /**
     * 查询所有选课信息
     * 根据条件筛选并返回所有符合条件的选课记录
     */
    @GetMapping("/selectAll")
    public Result getAllChoices(Xuanke xuanke) {
        List<Xuanke> xuankes = xuankeService.selectAll(xuanke);  // 查询所有选课信息
        return Result.success(xuankes);  // 返回查询结果
    }

    /**
     * 获取所有课程信息
     * 查询所有可选的课程信息
     */
    @GetMapping("/getCurriculum")
    public Result getCurriculum() {
        List<Curriculum> curriculums = xuankeService.getCurriculum();  // 获取所有课程信息
        return Result.success(curriculums);  // 返回课程信息列表
    }

    /**
     * 分页查询选课信息
     * 根据分页参数（页码和每页显示数量）分页查询选课记录
     */
    @GetMapping("/selectPage")
    public Result getChoicesByPage(Xuanke xuanke,
                                   @RequestParam(defaultValue = "1") Integer pageNum,
                                   @RequestParam(defaultValue = "10") Integer pageSize) {
        // 调用分页查询方法，获取指定页码和页数的选课记录
        PageInfo<Xuanke> page = xuankeService.selectPage(xuanke, pageNum, pageSize);
        return Result.success(page);  // 返回分页结果
    }
}
