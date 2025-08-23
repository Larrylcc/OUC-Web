package com.example.controller;

import com.example.common.Result;
import com.example.entity.Examplan;
import com.example.service.ExamplanService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 考试安排表前端操作接口
 * 该控制器处理关于考试安排的所有前端请求，包括新增、删除、修改、查询等操作。
 **/
@RestController
@RequestMapping("/examplan")
public class ExamplanController {

    // 注入ExamplanService以处理业务逻辑
    @Resource
    private ExamplanService examplanService;

    /**
     * 新增考试安排
     * 接收一个Examplan对象并将其保存到数据库中
     *
     * @param examplan 需要新增的考试安排对象
     * @return 返回操作结果，成功时返回成功状态
     */
    @PostMapping("/add")
    public Result add(@RequestBody Examplan examplan) {
        examplanService.add(examplan);  // 调用Service层方法将考试安排添加到数据库
        return Result.success();        // 返回成功的响应结果
    }

    /**
     * 根据ID删除考试安排
     * 通过指定的ID删除相应的考试安排记录
     *
     * @param id 要删除的考试安排ID
     * @return 返回操作结果，成功时返回成功状态
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        examplanService.deleteById(id);  // 调用Service层方法执行删除操作
        return Result.success();         // 返回成功的响应结果
    }

    /**
     * 批量删除考试安排
     * 接收多个ID的列表，删除相应的考试安排记录
     *
     * @param ids 包含多个考试安排ID的列表
     * @return 返回操作结果，成功时返回成功状态
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        examplanService.deleteBatch(ids);  // 调用Service层方法批量删除考试安排
        return Result.success();           // 返回成功的响应结果
    }

    /**
     * 更新考试安排
     * 根据传入的Examplan对象修改对应的考试安排信息
     *
     * @param examplan 包含更新数据的考试安排对象
     * @return 返回操作结果，成功时返回成功状态
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody Examplan examplan) {
        examplanService.updateById(examplan);  // 调用Service层方法更新考试安排
        return Result.success();               // 返回成功的响应结果
    }

    /**
     * 根据ID查询考试安排
     * 通过指定的ID获取对应的考试安排信息
     *
     * @param id 要查询的考试安排ID
     * @return 返回查询到的考试安排对象
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Examplan examplan = examplanService.selectById(id);  // 调用Service层方法查询考试安排
        return Result.success(examplan);  // 返回查询到的考试安排对象
    }

    /**
     * 查询所有考试安排
     * 获取所有考试安排的列表，支持条件查询
     *
     * @param examplan 查询条件，包含考试安排的筛选字段
     * @return 返回符合条件的所有考试安排列表
     */
    @GetMapping("/selectAll")
    public Result selectAll(Examplan examplan) {
        List<Examplan> list = examplanService.selectAll(examplan);  // 调用Service层方法查询所有考试安排
        return Result.success(list);  // 返回查询结果，所有符合条件的考试安排
    }

    /**
     * 分页查询考试安排
     * 根据传入的分页参数和筛选条件分页获取考试安排数据
     *
     * @param examplan 查询条件，包含考试安排的筛选字段
     * @param pageNum 当前页码，默认为1
     * @param pageSize 每页记录数，默认为10
     * @return 返回分页查询结果，包括当前页的考试安排数据和分页信息
     */
    @GetMapping("/selectPage")
    public Result selectPage(Examplan examplan,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        // 调用Service层方法进行分页查询，获取分页数据
        PageInfo<Examplan> page = examplanService.selectPage(examplan, pageNum, pageSize);
        return Result.success(page);  // 返回分页查询结果
    }
}
