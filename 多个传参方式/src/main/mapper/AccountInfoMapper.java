package main.mapper;

import main.entities.AccountInfo;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

public interface AccountInfoMapper {

    /**
     * 根据账户名称和账户余额查询账户信息
     * 演示科目：多个传参时，mybatis的Mapper如何包装参数？
     * 第一种方式：将参数包装成map类型，key是param1,param2...，value是入参。
     * [param1:name,param2:balance]
     * 第二种方式：将参数包装成map类型，key是@param("name"),@param("balance")，value是入参。
     * [name:name,balance:balance]
     *
     * @param name    账户名称
     * @param balance 账户余额
     * @return 账户信息
     */
    AccountInfo getAccountInfoByNameAndBalance(String name, BigDecimal balance);

    AccountInfo getAccountInfoByGmtCreateAndGmtModified(@Param("gmtCreate") Timestamp gmtCreate, @Param("gmtModified") Timestamp gmtModified);

    AccountInfo getAccountInfoById(BigInteger id);

    Boolean saveAccountInfo(AccountInfo accountInfo);

    Boolean updateAccountInfo(AccountInfo accountInfo);

    Boolean deleteAccountInfo(BigInteger id);

}
