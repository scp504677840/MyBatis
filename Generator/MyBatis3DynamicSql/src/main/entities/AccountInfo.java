package main.entities;

import javax.annotation.processing.Generated;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

public class AccountInfo {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-06T15:45:05.160212+08:00", comments="Source field: account_info.id")
    private BigInteger id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-06T15:45:05.168115+08:00", comments="Source field: account_info.gmt_create")
    private Timestamp gmtCreate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-06T15:45:05.168871+08:00", comments="Source field: account_info.gmt_modified")
    private Timestamp gmtModified;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-06T15:45:05.169496+08:00", comments="Source field: account_info.name")
    private String name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-06T15:45:05.1702+08:00", comments="Source field: account_info.balance")
    private BigDecimal balance;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-06T15:45:05.166861+08:00", comments="Source field: account_info.id")
    public BigInteger getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-06T15:45:05.167859+08:00", comments="Source field: account_info.id")
    public void setId(BigInteger id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-06T15:45:05.168376+08:00", comments="Source field: account_info.gmt_create")
    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-06T15:45:05.168635+08:00", comments="Source field: account_info.gmt_create")
    public void setGmtCreate(Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-06T15:45:05.169093+08:00", comments="Source field: account_info.gmt_modified")
    public Timestamp getGmtModified() {
        return gmtModified;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-06T15:45:05.169307+08:00", comments="Source field: account_info.gmt_modified")
    public void setGmtModified(Timestamp gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-06T15:45:05.169699+08:00", comments="Source field: account_info.name")
    public String getName() {
        return name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-06T15:45:05.169971+08:00", comments="Source field: account_info.name")
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-06T15:45:05.170427+08:00", comments="Source field: account_info.balance")
    public BigDecimal getBalance() {
        return balance;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-06T15:45:05.170649+08:00", comments="Source field: account_info.balance")
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "AccountInfo{" +
                "id=" + id +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}