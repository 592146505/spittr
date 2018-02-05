package com.roamer.spittr.dao;

import com.roamer.spittr.pojo.Spitter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author roamer
 * @version V1.0
 * @date 2018/1/11
 */
public interface SpitterRepository extends JpaRepository<Spitter, Long>, SpitterSweeper {

    /**
     * 根据username获取Spitter
     *
     * @param username
     * @return
     */
    Spitter findByUsername(String username);
}
