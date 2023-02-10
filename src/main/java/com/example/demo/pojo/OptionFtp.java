package com.example.demo.pojo;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;



@Data
@ConfigurationProperties(prefix = "ftp.option")
@Component
public class OptionFtp {
    private String ip;
    private String port;
    private String user;
    private String password;

}
