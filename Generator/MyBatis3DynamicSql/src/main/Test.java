package main;

import main.entities.AccountInfo;
import main.repository.AccountInfoDynamicSqlSupport;
import main.repository.AccountInfoMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.select.MyBatis3SelectModelAdapter;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.where.condition.IsLessThan;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.List;

import static main.repository.AccountInfoDynamicSqlSupport.*;

public class Test {
    public static void main(String[] args) {
        InputStream in = null;
        SqlSession session = null;
        try {
            // 读取配置文件
            in = Resources.getResourceAsStream("mybatis-config.xml");
            // 构建SqlSessionFactory
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
            // 获取SqlSession
            session = sessionFactory.openSession();

            AccountInfoMapper accountInfoMapper = session.getMapper(AccountInfoMapper.class);

            //统计总记录数
            //fun1(accountInfoMapper);

            //检索所有记录
            //fun2(accountInfoMapper);

            //带查询条件where
            //fun3(accountInfoMapper);

            //where 和 or
            //fun4(accountInfoMapper);

            //where 和 or 和 orderBy
            //fun5(accountInfoMapper);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (session != null) {
                session.close();
            }
        }
    }

    private static void fun5(AccountInfoMapper accountInfoMapper) {
        //where 和 or 和 orderBy
        List<AccountInfo> accountInfoList = accountInfoMapper.selectByExample()
                .where(id, SqlBuilder.isLessThan(BigInteger.valueOf(3L)), SqlBuilder.and(name, SqlBuilder.isEqualTo("LLKK")))
                .or(name, SqlBuilder.isLike("%T%"))
                .orderBy(gmtCreate.descending())
                .build().execute();
        accountInfoList.forEach(System.out::println);
    }

    private static void fun4(AccountInfoMapper accountInfoMapper) {
        //where 和 or
        List<AccountInfo> accountInfoList = accountInfoMapper.selectByExample()
                .where(AccountInfoDynamicSqlSupport.id, SqlBuilder.isEqualTo(BigInteger.valueOf(3L)))
                .or(AccountInfoDynamicSqlSupport.name, SqlBuilder.isLike("%T%"))
                .build().execute();
        accountInfoList.forEach(System.out::println);
    }

    private static void fun3(AccountInfoMapper accountInfoMapper) {
        //带查询条件where
        List<AccountInfo> accountInfoList = accountInfoMapper.selectByExample()
                .where(AccountInfoDynamicSqlSupport.id, SqlBuilder.isEqualTo(BigInteger.valueOf(3L)))
                .build().execute();
        accountInfoList.forEach(System.out::println);
    }

    private static void fun2(AccountInfoMapper accountInfoMapper) {
        //检索所有记录
        List<AccountInfo> accountInfoList = accountInfoMapper.selectByExample().build().execute();
        accountInfoList.forEach(System.out::println);
    }

    private static void fun1(AccountInfoMapper accountInfoMapper) {
        //统计总记录数
        QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> queryExpressionDSL = accountInfoMapper.countByExample();
        Long count = queryExpressionDSL.build().execute();
        System.out.println(count);
    }
}
