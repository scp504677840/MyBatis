package main.controller;

import main.entities.AccountInfo;
import main.service.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigInteger;

@Controller
public class AccountInfoController {

    @Autowired
    private AccountInfoService accountInfoService;

    @ResponseBody
    @RequestMapping("/hi")
    public AccountInfo hi() {
        return accountInfoService.getAccountInfoById(BigInteger.valueOf(3L));
    }

}
