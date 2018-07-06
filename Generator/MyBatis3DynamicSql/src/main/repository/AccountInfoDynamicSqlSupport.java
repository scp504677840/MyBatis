package main.repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.JDBCType;
import java.sql.Timestamp;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import javax.annotation.processing.Generated;

public final class AccountInfoDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-06T15:45:05.189668+08:00", comments="Source Table: account_info")
    public static final AccountInfo accountInfo = new AccountInfo();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-06T15:45:05.199974+08:00", comments="Source field: account_info.id")
    public static final SqlColumn<BigInteger> id = accountInfo.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-06T15:45:05.201362+08:00", comments="Source field: account_info.gmt_create")
    public static final SqlColumn<Timestamp> gmtCreate = accountInfo.gmtCreate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-06T15:45:05.201885+08:00", comments="Source field: account_info.gmt_modified")
    public static final SqlColumn<Timestamp> gmtModified = accountInfo.gmtModified;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-06T15:45:05.202304+08:00", comments="Source field: account_info.name")
    public static final SqlColumn<String> name = accountInfo.name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-06T15:45:05.202705+08:00", comments="Source field: account_info.balance")
    public static final SqlColumn<BigDecimal> balance = accountInfo.balance;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-06T15:45:05.199329+08:00", comments="Source Table: account_info")
    public static final class AccountInfo extends SqlTable {
        public final SqlColumn<BigInteger> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Timestamp> gmtCreate = column("gmt_create", JDBCType.TIMESTAMP);

        public final SqlColumn<Timestamp> gmtModified = column("gmt_modified", JDBCType.TIMESTAMP);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<BigDecimal> balance = column("balance", JDBCType.DECIMAL);

        public AccountInfo() {
            super("account_info");
        }
    }
}