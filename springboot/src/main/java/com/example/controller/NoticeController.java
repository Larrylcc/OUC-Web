package com.example.controller;

import com.example.common.Result;
import com.example.entity.Notice;
import com.example.service.NoticeService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * 公告信息表前端操作接口
 * 该控制器处理与公告信息相关的前端请求，包括新增、删除、修改、查询等操作。
 **/
@RestController
@RequestMapping("/notice")
public class NoticeController {

    // 注入NoticeService，用于处理业务逻辑
    @Resource
    private NoticeService noticeService;

    /**
     * 新增公告
     * 接收一个公告对象，将其保存到数据库。
     *
     * @param notice 要新增的公告对象
     * @return 返回操作结果，成功时返回成功状态
     */
    @PostMapping("/add")
    public Result add(@RequestBody Notice notice) {
        noticeService.add(notice);  // 调用Service层方法，保存公告对象
        return Result.success();    // 返回操作成功的结果
    }

    /**
     * 删除指定ID的公告
     * 根据公告的ID，删除相应的公告记录。
     *
     * @param id 公告的唯一标识符（ID）
     * @return 返回操作结果，成功时返回成功状态
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        noticeService.deleteById(id);  // 调用Service层方法删除公告
        return Result.success();       // 返回操作成功的结果
    }

    /**
     * 批量删除公告
     * 根据传入的公告ID列表，批量删除公告记录。
     *
     * @param ids 包含多个公告ID的列表
     * @return 返回操作结果，成功时返回成功状态
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        noticeService.deleteBatch(ids);  // 调用Service层方法批量删除公告
        return Result.success();         // 返回操作成功的结果
    }

    /**
     * 修改公告信息
     * 根据传入的公告对象，更新对应公告的信息。
     *
     * @param notice 包含修改内容的公告对象
     * @return 返回操作结果，成功时返回成功状态
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody Notice notice) {
        noticeService.updateById(notice);  // 调用Service层方法更新公告信息
        return Result.success();           // 返回操作成功的结果
    }

    /**
     * 根据ID查询公告
     * 根据公告的ID，查询对应的公告详情。
     *
     * @param id 公告的唯一标识符（ID）
     * @return 返回查询到的公告对象
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Notice notice = noticeService.selectById(id);  // 调用Service层方法查询公告
        return Result.success(notice);  // 返回查询到的公告对象
    }

    /**
     * 查询所有公告
     * 获取所有公告的列表，可以根据条件过滤。
     *
     * @param notice 查询条件，包含公告筛选字段（例如公告标题、内容等）
     * @return 返回符合条件的公告列表
     */
    @GetMapping("/selectAll")
    public Result selectAll(Notice notice) {
        List<Notice> list = noticeService.selectAll(notice);  // 调用Service层方法查询所有公告
        return Result.success(list);  // 返回查询到的公告列表
    }

    /**
     * 分页查询公告
     * 根据传入的分页参数（页码和每页记录数）以及筛选条件，分页查询公告。
     *
     * @param notice 查询条件，包含公告筛选字段
     * @param pageNum 当前页码，默认为1
     * @param pageSize 每页显示的记录数，默认为10
     * @return 返回分页查询结果，包括当前页的公告数据以及分页信息
     */
    @GetMapping("/selectPage")
    public Result selectPage(Notice notice,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        // 调用Service层方法进行分页查询，返回分页数据
        PageInfo<Notice> page = noticeService.selectPage(notice, pageNum, pageSize);
        return Result.success(page);  // 返回分页查询结果
    }

}
