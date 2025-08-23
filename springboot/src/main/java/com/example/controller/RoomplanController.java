package com.example.controller;

import com.example.common.Result;
import com.example.entity.Roomplan;
import com.example.service.RoomplanService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 教室安排表前端操作接口
 * 该控制器提供对教室安排的增删改查接口，允许前端进行教室安排的管理操作。
 **/
@RestController
@RequestMapping("/roomplan")  // 设置请求路径的前缀，所有的路由都会以 /roomplan 开头
public class RoomplanController {

    // 注入RoomplanService，用于处理业务逻辑
    @Resource
    private RoomplanService roomplanService;

    /**
     * 新增教室安排
     * 通过该接口，前端可以提交新的教室安排记录，后台将保存该记录。
     *
     * @param roomplan 新的教室安排对象，包含需要保存的数据
     * @return 返回操作结果，成功时返回一个成功的状态
     */
    @PostMapping("/add")  // POST请求，路由路径是 /roomplan/add
    public Result add(@RequestBody Roomplan roomplan) {
        roomplanService.add(roomplan);  // 调用Service层的add方法保存新的教室安排
        return Result.success();  // 返回成功的结果
    }

    /**
     * 根据ID删除教室安排
     * 通过该接口，前端可以删除指定ID的教室安排记录。
     *
     * @param id 教室安排记录的唯一标识符
     * @return 返回操作结果，成功时返回一个成功的状态
     */
    @DeleteMapping("/delete/{id}")  // DELETE请求，路径中包含ID
    public Result deleteById(@PathVariable Integer id) {
        roomplanService.deleteById(id);  // 调用Service层的方法删除指定ID的记录
        return Result.success();  // 返回成功的操作结果
    }

    /**
     * 批量删除教室安排
     * 通过该接口，前端可以批量删除多个指定ID的教室安排记录。
     *
     * @param ids 包含多个教室安排ID的列表
     * @return 返回操作结果，成功时返回一个成功的状态
     */
    @DeleteMapping("/delete/batch")  // DELETE请求，批量删除
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        roomplanService.deleteBatch(ids);  // 调用Service层方法批量删除记录
        return Result.success();  // 返回成功的操作结果
    }

    /**
     * 修改教室安排
     * 通过该接口，前端可以修改指定ID的教室安排记录。
     *
     * @param roomplan 包含修改内容的教室安排对象
     * @return 返回操作结果，成功时返回一个成功的状态
     */
    @PutMapping("/update")  // PUT请求，用于更新已有资源
    public Result updateById(@RequestBody Roomplan roomplan) {
        roomplanService.updateById(roomplan);  // 调用Service层的方法更新教室安排
        return Result.success();  // 返回操作成功的结果
    }

    /**
     * 根据ID查询教室安排
     * 通过该接口，前端可以根据指定ID查询对应的教室安排详情。
     *
     * @param id 教室安排记录的唯一标识符
     * @return 返回查询到的教室安排对象
     */
    @GetMapping("/selectById/{id}")  // GET请求，查询指定ID的记录
    public Result selectById(@PathVariable Integer id) {
        Roomplan roomplan = roomplanService.selectById(id);  // 调用Service层查询指定ID的教室安排
        return Result.success(roomplan);  // 返回查询到的教室安排
    }

    /**
     * 查询所有教室安排
     * 通过该接口，前端可以查询所有符合条件的教室安排记录。
     *
     * @param roomplan 查询条件，包含可选的筛选字段（如教室名称、日期等）
     * @return 返回符合条件的教室安排列表
     */
    @GetMapping("/selectAll")  // GET请求，用于查询所有记录
    public Result selectAll(Roomplan roomplan) {
        List<Roomplan> list = roomplanService.selectAll(roomplan);  // 调用Service层获取所有教室安排
        return Result.success(list);  // 返回查询到的教室安排列表
    }

    /**
     * 分页查询教室安排
     * 通过该接口，前端可以分页查询教室安排记录。
     *
     * @param roomplan 查询条件，包含筛选条件
     * @param pageNum 当前页码，默认为1
     * @param pageSize 每页显示的记录数，默认为10
     * @return 返回分页查询结果，包含当前页的数据和分页信息
     */
    @GetMapping("/selectPage")  // GET请求，进行分页查询
    public Result selectPage(Roomplan roomplan,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        // 调用Service层的方法进行分页查询，返回分页结果
        PageInfo<Roomplan> page = roomplanService.selectPage(roomplan, pageNum, pageSize);
        return Result.success(page);  // 返回分页查询结果
    }
}
