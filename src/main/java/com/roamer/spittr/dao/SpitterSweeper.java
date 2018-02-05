package com.roamer.spittr.dao;

import com.roamer.spittr.pojo.Spitter;

/**
 * @author roamer
 * @version V1.0
 * @date 2018/1/31
 */
public interface SpitterSweeper {
    /**
     * 根据LastName获取Spitter
     * @param LastName
     * @return
     */
    Spitter findByLastName(String LastName);
}
