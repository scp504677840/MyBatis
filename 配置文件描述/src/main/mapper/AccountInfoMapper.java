package main.mapper;

import main.entities.AccountInfo;

import java.math.BigInteger;

public interface AccountInfoMapper {

    AccountInfo getAccountInfoById(BigInteger id);

}
