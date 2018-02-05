package com.roamer.spittr.dao;

import com.roamer.spittr.pojo.Spittle;

import java.util.List;

/**
 * @author roamer
 * @version V1.0
 * @date 2018/1/11
 */
public interface SpittleRepository {
    /**
     * 获取pojo
     *
     * @param max
     * @param count
     * @return
     */
    List<Spittle> findSpittles(long max, int count);

    /**
     * 根据Id获取pojo
     *
     * @param spittleId
     * @return
     */
    Spittle findOne(long spittleId);
}
