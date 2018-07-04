package main.mapper;

import main.entities.AccountInfo;

import java.math.BigInteger;

public interface AccountInfoMapper {

    AccountInfo getAccountInfoById(BigInteger id);

    Boolean saveAccountInfo(AccountInfo accountInfo);

    Boolean updateAccountInfo(AccountInfo accountInfo);

    Boolean deleteAccountInfo(BigInteger id);

}
