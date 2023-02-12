package com.example.demo.controller;

import com.example.demo.model.NumberDpzs;
import com.example.demo.pojo.PageResult;
import com.example.demo.service.NumberService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class NumberController {
    @Autowired
    private NumberService numberService;

    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    public String get(@PathVariable("id") Integer id){
        log.info("进来了。。。");
        return numberService.get(id).toString();
    }
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public String getAll(){
        return numberService.getAll().toString();
    }

    @RequestMapping(value = "/getPage",method = RequestMethod.GET)
    public List<NumberDpzs> findNumberByPage(@RequestParam Integer currentPage,
                                             @RequestParam Integer pageSize){
        PageHelper.startPage(currentPage,pageSize);
        return numberService.getAll();
    }
    @RequestMapping(value = "/getPager",method = RequestMethod.GET)
    public PageResult queryByProjectName(@RequestParam Integer pageNo,
                                         @RequestParam Integer pageSize) {
        PageResult result = new PageResult();
        try {
            PageHelper.startPage(pageNo, pageSize);
            List<NumberDpzs> behindAoiList = numberService.getAll(/*projectName*/); //设置完上边的PageHelper之后查询的时候，查询语句会自动加入 limits startpage   count,查询结果就是正确的结果
            PageInfo<NumberDpzs> pageInfo = new PageInfo(behindAoiList);
            result.setTotal((int) pageInfo.getTotal());
            result.setTotalPage(pageInfo.getPages());
            result.setPage(pageInfo.getPageNum());
            result.setSize(pageInfo.getPageSize());
            result.setRows(pageInfo.getList());
        } finally {
            PageHelper.clearPage();
        }
        return result;
    }
}
