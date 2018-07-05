package main.mapper;

import main.entities.AccountInfo;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface AccountInfoMapper {

    List<AccountInfo> getAccountInfoWithName(@Param("balance") BigDecimal balance, @Param("name") String name);

}
