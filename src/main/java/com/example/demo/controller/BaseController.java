package com.example.demo.controller;

import cn.hutool.db.PageResult;
import com.example.demo.entity.BehindAoi;
import com.example.demo.pojo.OptionFtp;
import com.example.demo.service.AnalysisSourceFile;
import com.example.demo.service.BehindAOIService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@Controller
public class BaseController {

    private AnalysisSourceFile analysisSourceFile;
    private BehindAOIService behindAOIService;

    public BaseController(@Autowired AnalysisSourceFile analysisSourceFile,
                          @Autowired BehindAOIService behindAOIService){
        this.analysisSourceFile = analysisSourceFile;
        this.behindAOIService = behindAOIService;
    }
    @RequestMapping("/hello")
    public String hello(){
        return analysisSourceFile.get().toString();
    }
    @RequestMapping("/getoption")
    public String getOption(){
        return null;
    }
    @RequestMapping("/selectAll")
    public void selectAll(HttpServletRequest request, HttpServletResponse response){
        String num = request.getParameter("num");
        if (num == null) {
            num = "1";
        }
        Page<?> page = PageHelper.startPage(Integer.valueOf(num),5);
        List<BehindAoi> behindAoiList = behindAOIService.queryAllBehindAOI();
        PageInfo<?> pageInfo = page.toPageInfo();

        request.setAttribute("behindAoiList",behindAoiList);
        request.setAttribute("pageHelper",pageInfo);
    }

//    方法二：使用service查询到的结果存储在自定义的类中然后返回给前端
    @RequestMapping("/getAll")
    public PageResult<List<BehindAoi>> queryByProjectName(Integer pageNo, Integer pageSize, String projectName) {
        PageResult<List<BehindAoi>> result = new PageResult<>();
        try {
            PageHelper.startPage(pageNo, pageSize);
            List<BehindAoi> behindAoiList = behindAOIService.queryAllBehindAOI(/*projectName*/); //设置完上边的PageHelper之后查询的时候，查询语句会自动加入 limits startpage   count,查询结果就是正确的结果
            PageInfo<BehindAoi> pageInfo = new PageInfo<>(behindAoiList);
            result.setTotal((int) pageInfo.getTotal());
            result.setTotalPage(pageInfo.getPages());
            result.setPage(pageInfo.getPageNum());
            result.setPageSize(pageInfo.getPageSize());
            result.set(pageInfo.getPageNum(),behindAoiList);
        } finally {
            PageHelper.clearPage();
        }
        return result;
    }

}
