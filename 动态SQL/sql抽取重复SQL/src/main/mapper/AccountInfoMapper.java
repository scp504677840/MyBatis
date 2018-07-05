package main.mapper;

import main.entities.AccountInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountInfoMapper {

    List<AccountInfo> getAccountInfoLikeName(@Param("name") String name);

}
