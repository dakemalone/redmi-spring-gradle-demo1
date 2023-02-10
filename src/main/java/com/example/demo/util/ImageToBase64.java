package com.example.demo.util;

import cn.hutool.core.img.ImgUtil;
import com.example.demo.pojo.OptionFtp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * @author dake malone
 * @date 2023年02月06日 上午 11:30
 */
@Component
public class ImageToBase64 {
    private OptionFtp optionFtp;
    public ImageToBase64(@Autowired OptionFtp optionFtp){
        this.optionFtp = optionFtp;
    }
    public String getEventPicture(){
        InputStream in = FTPUtil.download(optionFtp,"P000S001003528031B001627.bzmd","/lily");
        BufferedImage bufferedImage = ImgUtil.read(in);
        return ImgUtil.toBase64(bufferedImage,"png");
    }
}
