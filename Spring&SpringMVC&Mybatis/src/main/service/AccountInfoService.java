package main.service;

import main.entities.AccountInfo;

import java.math.BigInteger;

public interface AccountInfoService {

    AccountInfo getAccountInfoById(BigInteger id);

}
