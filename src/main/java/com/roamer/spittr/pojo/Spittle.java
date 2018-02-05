package com.roamer.spittr.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author roamer
 * @version V1.0
 * @date 2018/1/11
 */
@Data
public class Spittle {
    private final Long id;
    private final String message;
    private final Date time;
    private Double latituda;
    private Double longituda;

    public Spittle(String message, Date time) {
        this(message, time, null, null);
    }

    public Spittle(String message, Date time, Double latituda, Double longituda) {
        this.id = null;
        this.message = message;
        this.time = time;
        this.latituda = latituda;
        this.longituda = longituda;
    }
}
