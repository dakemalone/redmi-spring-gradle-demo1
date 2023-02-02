package com.example.demo.controller;

import com.example.demo.service.AnalysisSourceFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class BaseController {

    private AnalysisSourceFile analysisSourceFile;
    public BaseController(@Autowired AnalysisSourceFile analysisSourceFile){
        this.analysisSourceFile = analysisSourceFile;
    }
    @RequestMapping("/hello")
    public String hello(){
        return analysisSourceFile.get().toString();
    }
}
