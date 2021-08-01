/*
 * Copyright(C) 2000-2020 THS Technology Limited Company, http://www.ths.com.cn
 * 添加缓存：http://localhost:8082/provide/addcache?cacheName=JDP.PROJECT&key=test&value=%E5%AE%89%E5%BB%BA%E5%8D%8E
 * 获取缓存：http://localhost:8082/provide/getcache?cacheName=JDP.PROJECT&key=test
 * 删除缓存：http://localhost:8082/provide/evictcache?cacheName=JDP.PROJECT&key=test
 * 模糊匹配删除缓存：http://localhost:8082/provide/evictlikecache?cacheName=JDP.PROJECT&key=te
 */
package com.boot.siluboot.demo.provide.controller.proinfo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ths.boot.core.base.controller.BaseController;
import ths.boot.core.config.cache.JdpCache;

import java.util.Map;

@Slf4j
@RestController
@RefreshScope
public class PropertiesController extends BaseController {
    @Value("${spring.cache.type}")
    public String datasourcePrimary;

    /**
     * 添加缓存
     * @param cacheName
     * @param key
     * @param value
     */
    @RequestMapping("/provide/addcache")
    public Object addcache(@RequestParam(required=false) String cacheName
            , @RequestParam(required=true) Object key
            , @RequestParam(required=true) Object value){
        JdpCache.put(cacheName,key,value);
        return JdpCache.get(cacheName,key);
    }

    /**
     * 获取缓存
     * @param cacheName
     * @param key
     * @return
     */
    @RequestMapping("/provide/getcache")
    public Object getcache(@RequestParam(required=false) String cacheName
            , @RequestParam(required=true) Object key){
        return JdpCache.get(cacheName,key);
    }

    /**
     * 删除指定缓存
     * @param cacheName
     * @param key
     * @return
     */
    @RequestMapping("/provide/evictcache")
    public Object evictCache(@RequestParam(required=false) String cacheName
            , @RequestParam(required=true) Object key){
        JdpCache.evict(cacheName,key);
        return JdpCache.get(cacheName,key);
    }

    /**
     * 模糊匹配删除缓存
     * @param cacheName
     * @param key
     * @return
     */
    @RequestMapping("/provide/evictlikecache")
    public String evictLikeCache(@RequestParam(required=false) String cacheName
            , @RequestParam(required=true) Object key){
        JdpCache.evictLike(cacheName,key);
        return "清理成功";
    }



    @RequestMapping("/provide/testRequestBody")
    public String testRequestBody(@RequestBody Map<String,Object> paramMap,String b){
        System.err.println("aaa:"+paramMap);
        return b;
    }

    @RequestMapping("/provide/testRequestBody1")
    public String testRequestBody1(Map<String,Object> paramMap,String b){
        System.err.println("aaa:"+paramMap);
        return b;
    }




}
