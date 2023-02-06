package com.example.demo.service.impl;

import com.example.demo.pojo.OptionFtp;
import com.example.demo.service.AnalysisSourceFile;
import com.example.demo.util.FTPUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author dake malone
 * @date 2023年02月02日 下午 1:56
 */
@Service
public class AnalysisSourceFileImpl implements AnalysisSourceFile {
    @Override
    public LinkedList get() {
        OptionFtp optionFtp = new OptionFtp();
        optionFtp.setIp("172.20.10.13");
        optionFtp.setPort("21");
        optionFtp.setUser("ftpuser");
        optionFtp.setPassword("123456");
        return FTPUtil.download(optionFtp,"P000S001003528031B001627.bzmd","/lily");

    }
}
