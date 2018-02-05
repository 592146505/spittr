package com.roamer.spittr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

/**
 * Tiles配置
 *
 * @author roamer
 * @version V1.0
 * @date 2018/1/10
 */
@Configuration
@ComponentScan(basePackages = "com.roamer.spittr.web")
public class TilesConfig {

    /**
     * Apache Tiles文件定位于加载
     *
     * @return
     */
    @Bean
    public TilesConfigurer tilesConfigurer() {
        //负责定位和加载Tile定义并协调生成Tiles
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        //加载“/WEB-INF/”目录下的所有名字为tiles.xml的文件
        tilesConfigurer.setDefinitions("/WEB-INF/**/tiles.xml");
        //启用刷新功能
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }

    /**
     * Apache Tiles视图解析器
     *
     * @return
     */
    @Bean
    public ViewResolver viewResolver() {
        TilesViewResolver viewResolver = new TilesViewResolver();
        viewResolver.setOrder(1);
        return viewResolver;
    }

}
