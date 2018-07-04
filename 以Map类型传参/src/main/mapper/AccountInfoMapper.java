package main.mapper;

import main.entities.AccountInfo;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Map;

public interface AccountInfoMapper {

    /**
     * 根据账户名称和账户余额查询账户信息
     * 演示科目：传参为Map
     *
     * @param param 查询参数
     * @return 账户信息
     */
    AccountInfo getAccountInfoByNameAndBalance(Map<String, Object> param);

    AccountInfo getAccountInfoById(BigInteger id);

    Boolean saveAccountInfo(AccountInfo accountInfo);

    Boolean updateAccountInfo(AccountInfo accountInfo);

    Boolean deleteAccountInfo(BigInteger id);

}
