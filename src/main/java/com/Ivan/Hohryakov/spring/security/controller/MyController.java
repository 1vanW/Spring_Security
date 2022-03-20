package com.Ivan.Hohryakov.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/")
    public String getInfoForEmps(){

        return "view-for-all-employee";
    }

    @GetMapping("/hr-info")
    public String getInfoSalary(){

        return "view-for-hr";
    }

    @GetMapping("/manager-info")
    public String getInfoOnlyForManagers(){

        return "view-for-managers";

    }
}
