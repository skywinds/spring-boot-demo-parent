package com.sas.sbdcc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheInfoController {

    @Autowired
    CacheManager cacheManager;


    @GetMapping("/cache")
    public void getCacheInfo(){
        cacheManager.getCacheNames().forEach(System.out::println);
    }
}
