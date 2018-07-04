package main;

import main.entities.AccountInfo;
import main.mapper.AccountInfoMapper;
import main.mapper.AccountInfoMapperAnnotation;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.Instant;

/**
 * 每个基于 MyBatis 的应用都是以一个 SqlSessionFactory 的实例为中心的。
 * SqlSessionFactory 的实例可以通过 SqlSessionFactoryBuilder 获得。
 * 而 SqlSessionFactoryBuilder 则可以从 XML 配置文件或一个预先定制的 Configuration 的实例构建出 SqlSessionFactory 的实例。
 */
public class Main {

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

            // 基于XML
            // 方式一：
            //AccountInfo accountInfo = session.selectOne("main.mapper.AccountInfoMapper.getAccountInfoById", BigInteger.valueOf(3L));
            //System.out.println(accountInfo);
            // 方式二：
            //AccountInfoMapper accountInfoMapper = session.getMapper(AccountInfoMapper.class);

            //注意：增删改可以定义返回值类型，如以下类型：
            //Integer：代表受影响的行数
            //Long：代表受影响的行数
            //Boolean：受影响行数大于0返回true，否则返回false。

            // 添加
            save(session);

            // 修改
            //update(session);

            // 删除
            //delete(session);

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

    private static void delete(SqlSession session) {
        AccountInfoMapper accountInfoMapper = session.getMapper(AccountInfoMapper.class);
        accountInfoMapper.deleteAccountInfo(BigInteger.valueOf(9L));
        session.commit();
    }

    private static void update(SqlSession session) {
        AccountInfoMapper accountInfoMapper = session.getMapper(AccountInfoMapper.class);
        AccountInfo accountInfo = accountInfoMapper.getAccountInfoById(BigInteger.valueOf(3L));
        accountInfo.setBalance(BigDecimal.valueOf(999.55));
        accountInfoMapper.updateAccountInfo(accountInfo);
        session.commit();
    }

    private static void save(SqlSession session) {
        AccountInfoMapper accountInfoMapper = session.getMapper(AccountInfoMapper.class);
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setGmtCreate(Timestamp.from(Instant.now()));
        accountInfo.setGmtModified(Timestamp.from(Instant.now()));
        accountInfo.setName("MY");
        accountInfo.setBalance(BigDecimal.valueOf(20000L));
        //Integer：代表受影响的行数
        //Long：代表受影响的行数
        //Boolean：受影响行数大于0返回true，否则返回false。
        Boolean bigInteger = accountInfoMapper.saveAccountInfo(accountInfo);
        System.out.println("commit1: "+bigInteger);
        System.out.println("commit1: "+accountInfo);
        // 一定要记得手动提交
        session.commit();
        System.out.println("commit2: "+bigInteger);
        System.out.println("commit2: "+accountInfo);
    }
}
