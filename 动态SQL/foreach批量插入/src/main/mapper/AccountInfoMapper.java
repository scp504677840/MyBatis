package main.mapper;

import main.entities.AccountInfo;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.List;

public interface AccountInfoMapper {

    List<AccountInfo> getAccountInfoForeach(@Param("ids") List<BigInteger> ids);

    void batchSaveAccountInfos(@Param("accountInfos") List<AccountInfo> accountInfos);

}
