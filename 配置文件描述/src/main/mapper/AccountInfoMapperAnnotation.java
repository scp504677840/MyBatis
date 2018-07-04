package main.mapper;

import main.entities.AccountInfo;
import org.apache.ibatis.annotations.Select;

import java.math.BigInteger;

public interface AccountInfoMapperAnnotation {

    @Select("select * from account_info where id = #{id}")
    AccountInfo selectAccountInfo(BigInteger id);

}
