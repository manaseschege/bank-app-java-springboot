package com.zech.bank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {
@GetMapping("/notices")
    public  String getNoticeDetails(){
    return "Here are the notice details fro the db";
 }
}
