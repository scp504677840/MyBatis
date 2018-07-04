package main.mapper;

import main.entities.AccountInfo;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface AccountInfoMapper {

    AccountInfo getAccountInfoByNameAndBalance(@Param("name") String name, @Param("balance") BigDecimal balance);

}
