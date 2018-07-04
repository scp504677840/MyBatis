package main.mapper;

import main.entities.AccountInfo;
import org.apache.ibatis.annotations.MapKey;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public interface AccountInfoMapper {

    /**
     * 获取单个对象的值并封装成map
     *
     * @param id 主键Id
     * @return 将单个对象的值封装成map
     */
    Map<String, Object> mapAccountInfo(BigInteger id);


    /**
     * 获取多条记录并以主键为key，对象为value封装成map
     *
     * @return 以主键为key，对象为value封装成map
     */
    @MapKey("id")
    Map<BigInteger,AccountInfo> mapAccountInfos();

}
