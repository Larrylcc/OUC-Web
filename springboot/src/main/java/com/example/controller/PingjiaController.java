package com.example.controller;

import com.example.common.Result;
import com.example.entity.Pingjia;
import com.example.service.PingjiaService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 评教信息表控制器，提供关于评教数据的增删改查接口
 */
@RestController
@RequestMapping("/pingjia")
public class PingjiaController {

    @Resource
    private  PingjiaService pingjiaService;  // 服务层，用于处理评教数据的相关操作

    /**
     * 添加新的评教记录
     * @param pingjia 包含评教信息的Comment对象
     * @return 操作结果
     */
    @PostMapping("/add")
    public Result createComment(@RequestBody Pingjia pingjia) {
        pingjiaService.add(pingjia);  // 调用服务层方法执行添加操作
        return Result.success();  // 返回成功响应
    }

    /**
     * 根据ID删除评教记录
     * @param id 评教记录的ID
     * @return 操作结果
     */
    @DeleteMapping("/delete/{id}")
    public Result removeComment(@PathVariable Integer id) {
        pingjiaService.deleteById(id);  // 调用服务层方法删除记录
        return Result.success();  // 返回成功响应
    }

    /**
     * 批量删除评教记录
     * @param ids 评教记录的ID列表
     * @return 操作结果
     */
    @DeleteMapping("/delete/batch")
    public Result batchRemoveComments(@RequestBody List<Integer> ids) {
        pingjiaService.deleteBatch(ids);  // 调用服务层批量删除方法
        return Result.success();  // 返回成功响应
    }

    /**
     * 更新评教记录信息
     * @param pingjia 包含更新信息的Comment对象
     * @return 操作结果
     */
    @PutMapping("/update")
    public Result updateComment(@RequestBody Pingjia pingjia) {
        pingjiaService.updateById(pingjia);  // 调用服务层更新记录
        return Result.success();  // 返回成功响应
    }

    /**
     * 根据ID获取评教记录信息
     * @param id 评教记录的ID
     * @return 查询到的评教记录
     */
    @GetMapping("/selectById/{id}")
    public Result getCommentById(@PathVariable Integer id) {
        Pingjia pingjia = pingjiaService.selectById(id);  // 调用服务层获取记录
        return Result.success(pingjia);  // 返回查询结果
    }

    /**
     * 获取所有评教记录
     * @param pingjia 用于查询的筛选条件（如有）
     * @return 所有评教记录列表
     */
    @GetMapping("/selectAll")
    public Result getAllComments(Pingjia pingjia) {
        List<Pingjia> pingjiaList = pingjiaService.selectAll(pingjia);  // 获取所有评教记录
        return Result.success(pingjiaList);  // 返回记录列表
    }

    /**
     * 分页获取评教记录
     * @param pingjia 查询条件
     * @param pageNum 当前页码，默认值为1
     * @param pageSize 每页显示的记录数量，默认值为10
     * @return 分页结果
     */
    @GetMapping("/selectPage")
    public Result getPagedComments(Pingjia pingjia,
                                   @RequestParam(defaultValue = "1") Integer pageNum,
                                   @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Pingjia> page = pingjiaService.selectPage(pingjia, pageNum, pageSize);  // 获取分页数据
        return Result.success(page);  // 返回分页结果
    }
}
