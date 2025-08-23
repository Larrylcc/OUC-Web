package com.example.controller;

import com.example.common.Result;
import com.example.entity.Guanliyuan;
import com.example.service.GuanliyuanService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * 管理员管理接口，提供增、删、改、查等操作
 * 该接口提供了与管理员相关的所有操作，包括单个操作和批量操作
 */
@RestController
@RequestMapping("/guanliyuan")
public class GuanliyuanController {

    @Resource
    private GuanliyuanService guanliyuanService;  // 注入AdminService用于处理业务逻辑

    /**
     * 新增管理员
     * 接收一个Admin对象，通过POST请求创建新管理员
     */
    @PostMapping("/add")
    public Result addAdmin(@RequestBody Guanliyuan guanliyuan) {
        guanliyuanService.add(guanliyuan);  // 调用Service层方法进行添加
        return Result.success();  // 返回成功结果
    }

    /**
     * 删除管理员
     * 根据管理员的ID删除对应的管理员信息
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteAdminById(@PathVariable Integer id) {
        guanliyuanService.deleteById(id);  // 调用Service层方法删除
        return Result.success();  // 返回成功结果
    }

    /**
     * 批量删除管理员
     * 接收一个管理员ID列表，批量删除对应的管理员
     */
    @DeleteMapping("/delete/batch")
    public Result deleteAdmins(@RequestBody List<Integer> ids) {
        guanliyuanService.deleteBatch(ids);  // 调用Service层批量删除
        return Result.success();  // 返回成功结果
    }

    /**
     * 更新管理员信息
     * 根据提供的Admin对象更新管理员信息
     */
    @PutMapping("/update")
    public Result updateAdmin(@RequestBody Guanliyuan guanliyuan) {
        guanliyuanService.updateById(guanliyuan);  // 调用Service层方法更新
        return Result.success();  // 返回成功结果
    }

    /**
     * 根据ID查询管理员信息
     * 根据管理员ID获取对应的管理员信息
     */
    @GetMapping("/selectById/{id}")
    public Result getAdminById(@PathVariable Integer id) {
        Guanliyuan guanliyuan = guanliyuanService.selectById(id);  // 调用Service层查询管理员
        return Result.success(guanliyuan);  // 返回管理员信息
    }

    /**
     * 查询所有管理员信息
     * 获取所有管理员数据，可根据条件进行过滤
     */
    @GetMapping("/selectAll")
    public Result getAllAdmins(Guanliyuan guanliyuan) {
        List<Guanliyuan> guanliyuanList = guanliyuanService.selectAll(guanliyuan);  // 查询所有管理员，支持条件筛选
        return Result.success(guanliyuanList);  // 返回查询结果
    }

    /**
     * 分页查询管理员
     * 根据分页参数（页码和每页数量）进行分页查询
     */
    @GetMapping("/selectPage")
    public Result getAdminsByPage(Guanliyuan guanliyuan,
                                  @RequestParam(defaultValue = "1") Integer pageNum,
                                  @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Guanliyuan> page = guanliyuanService.selectPage(guanliyuan, pageNum, pageSize);  // 分页查询
        return Result.success(page);  // 返回分页结果
    }
}
