package main.mapper;

import main.entities.AccountInfo;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface AccountInfoMapper {

    AccountInfo getAccountInfoByNameAndBalance(@Param("name") String name, BigDecimal balance);

    AccountInfo getAccountInfoByNameAndBalance(String name, @Param("a") AccountInfo accountInfo);

    AccountInfo getAccountInfoByIds(Collection<BigInteger> ids);

    AccountInfo getAccountInfoByIds(List<BigInteger> ids);

    AccountInfo getAccountInfoByIds(Set<BigInteger> ids);

}
