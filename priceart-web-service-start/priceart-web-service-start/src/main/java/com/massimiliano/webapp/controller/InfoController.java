package com.massimiliano.webapp.controller;


import com.massimiliano.webapp.appconf.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class InfoController {


    @Autowired
    private AppConfig config;

    @GetMapping("/info")
    public Map<String, String> getInfo() {

        Map<String, String> map = new HashMap<String, String>();

        map.put("listino", config.getListino());

        return map;
    }
}
