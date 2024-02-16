package com.zech.bank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
@GetMapping("/myAccount")
    public  String geyAccountDetails(){
    return "Here are the account details fro the db";
}
}
