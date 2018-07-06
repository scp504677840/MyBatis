package main.repository;

import main.entities.AccountInfo;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;

public interface AccountInfoMapper {

    AccountInfo getAccountInfoById(@Param("id") BigInteger id);

}