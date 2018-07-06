package main.repository;

import static main.repository.AccountInfoDynamicSqlSupport.*;

import java.math.BigInteger;
import java.util.List;
import javax.annotation.processing.Generated;
import main.entities.AccountInfo;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.delete.DeleteDSL;
import org.mybatis.dynamic.sql.delete.MyBatis3DeleteModelAdapter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategy;
import org.mybatis.dynamic.sql.select.MyBatis3SelectModelAdapter;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectDSL;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.MyBatis3UpdateModelAdapter;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

@Mapper
public interface AccountInfoMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-06T15:45:05.205734+08:00", comments="Source Table: account_info")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-06T15:45:05.219918+08:00", comments="Source Table: account_info")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-06T15:45:05.224169+08:00", comments="Source Table: account_info")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType= BigInteger.class)
    int insert(InsertStatementProvider<AccountInfo> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-06T15:45:05.22686+08:00", comments="Source Table: account_info")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="AccountInfoResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modified", property="gmtModified", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="balance", property="balance", jdbcType=JdbcType.DECIMAL)
    })
    List<AccountInfo> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-06T15:45:05.228287+08:00", comments="Source Table: account_info")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-06T15:45:05.229072+08:00", comments="Source Table: account_info")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(accountInfo);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-06T15:45:05.230409+08:00", comments="Source Table: account_info")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, accountInfo);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-06T15:45:05.233699+08:00", comments="Source Table: account_info")
    default int insert(AccountInfo record) {
        return insert(SqlBuilder.insert(record)
                .into(accountInfo)
                .map(gmtCreate).toProperty("gmtCreate")
                .map(gmtModified).toProperty("gmtModified")
                .map(name).toProperty("name")
                .map(balance).toProperty("balance")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-06T15:45:05.235412+08:00", comments="Source Table: account_info")
    default int insertSelective(AccountInfo record) {
        return insert(SqlBuilder.insert(record)
                .into(accountInfo)
                .map(gmtCreate).toPropertyWhenPresent("gmtCreate", record::getGmtCreate)
                .map(gmtModified).toPropertyWhenPresent("gmtModified", record::getGmtModified)
                .map(name).toPropertyWhenPresent("name", record::getName)
                .map(balance).toPropertyWhenPresent("balance", record::getBalance)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-06T15:45:05.236672+08:00", comments="Source Table: account_info")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<AccountInfo>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, id, gmtCreate, gmtModified, name, balance)
                .from(accountInfo);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-06T15:45:05.237855+08:00", comments="Source Table: account_info")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<AccountInfo>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, id, gmtCreate, gmtModified, name, balance)
                .from(accountInfo);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-06T15:45:05.239834+08:00", comments="Source Table: account_info")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(AccountInfo record) {
        return UpdateDSL.updateWithMapper(this::update, accountInfo)
                .set(gmtCreate).equalTo(record::getGmtCreate)
                .set(gmtModified).equalTo(record::getGmtModified)
                .set(name).equalTo(record::getName)
                .set(balance).equalTo(record::getBalance);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2018-07-06T15:45:05.241062+08:00", comments="Source Table: account_info")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(AccountInfo record) {
        return UpdateDSL.updateWithMapper(this::update, accountInfo)
                .set(gmtCreate).equalToWhenPresent(record::getGmtCreate)
                .set(gmtModified).equalToWhenPresent(record::getGmtModified)
                .set(name).equalToWhenPresent(record::getName)
                .set(balance).equalToWhenPresent(record::getBalance);
    }
}