package com.example.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

/**
 * @author dake malone
 * @date 2023年01月31日 下午 5:04
 */

@Data
public class ProductInfo {
    private int id;
    private String sn;
    private String element;
    private String judgment;
    private String imgPath;
    private Date excDate;
}
