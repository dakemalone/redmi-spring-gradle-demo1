package com.example.demo.service.impl;

import com.example.demo.entity.BehindAoi;

import java.util.List;

/**
 * @author dake malone
 * @date 2023年02月08日 下午 3:26
 */
public interface BehindService {
    List<BehindAoi> queryAll();
    List<BehindAoi> queryAll(String sn);

}
