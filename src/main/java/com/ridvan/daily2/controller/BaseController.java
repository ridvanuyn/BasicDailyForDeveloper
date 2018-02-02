package com.ridvan.daily2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(value = "/")
public class BaseController {

    @RequestMapping("")
    public String baseConroller(){
        return "entries/listEntries";

    }


}
