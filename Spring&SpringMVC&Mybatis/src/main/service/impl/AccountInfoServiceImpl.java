package main.service.impl;

import main.entities.AccountInfo;
import main.repository.AccountInfoMapper;
import main.service.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service("accountInfoService")
public class AccountInfoServiceImpl implements AccountInfoService {

    @Autowired
    private AccountInfoMapper accountInfoMapper;

    @Override
    public AccountInfo getAccountInfoById(BigInteger id) {
        return accountInfoMapper.getAccountInfoById(id);
    }
}
