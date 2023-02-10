package com.example.demo.service.impl;

import com.example.demo.pojo.OptionFtp;
import com.example.demo.service.AnalysisSourceFile;
import com.example.demo.util.FTPUtil;
import com.example.demo.util.SourceFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author dake malone
 * @date 2023年02月02日 下午 1:56
 */
@Service
public class AnalysisSourceFileImpl implements AnalysisSourceFile {
    private OptionFtp optionFtp;
    public AnalysisSourceFileImpl (@Autowired OptionFtp optionFtp){
        this.optionFtp = optionFtp;
    }

    @Override
    public ArrayList get() {

        ArrayList list = null;
        InputStream in = FTPUtil.download(optionFtp,"P000S001003528031B001627.bzmd","/lily");
        list = SourceFileReader.PathIterator(in);
        return list;
    }
}
