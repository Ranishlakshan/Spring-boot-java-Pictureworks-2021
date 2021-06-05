package com.ranishll.demoproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class First {

    @GetMapping("/")
    public String MainRequest(){
        return "This is main Page";
    }

    @GetMapping("/hellonima")
    public String Hello(){
        return "Hello Nimasha";
    }

}
