package main.mapper;

import main.entities.AccountInfo;
import org.apache.ibatis.annotations.Param;

public interface AccountInfoMapper {

    AccountInfo getAccountInfoByName(@Param("name") String name);

}
