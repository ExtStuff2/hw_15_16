package com.fun.postofficeapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostOfficeController {

    @GetMapping("office/check")
    public String checkPostOffice(){return "post office is up";}
}
