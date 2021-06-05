package com.ranishll.demoproject.controller;

import com.ranishll.demoproject.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/testing")
public class User {

    @Autowired
    private UserServices ddd;

    @GetMapping("/all")
    public String Allusers() throws Exception {
        //return "All users Returned";
        return ddd.findAllUsers();
    }
}
