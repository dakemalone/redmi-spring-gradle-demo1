package com.example.demo.service.impl;

import com.example.demo.pojo.OptionFtp;
import com.example.demo.service.AnalysisSourceFile;
import com.example.demo.util.FTPUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author dake malone
 * @date 2023年02月02日 下午 1:56
 */
@Service
public class AnalysisSourceFileImpl implements AnalysisSourceFile {
    @Override
    public HashMap<String, String> get() {
        OptionFtp optionFtp = new OptionFtp();
        optionFtp.setIp("192.168.206.177");
        optionFtp.setPort("21");
        optionFtp.setUser("ftpuser");
        optionFtp.setPassword("123456");
        return FTPUtil.download(optionFtp,"P000S001003528031B001627.bzmd","/lily");

    }
}
