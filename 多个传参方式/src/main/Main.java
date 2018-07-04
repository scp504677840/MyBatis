package main;

import main.entities.AccountInfo;
import main.mapper.AccountInfoMapper;
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

            //演示第一种多个传参方式
            /*AccountInfoMapper accountInfoMapper = session.getMapper(AccountInfoMapper.class);
            AccountInfo accountInfo = accountInfoMapper.getAccountInfoByNameAndBalance("Jk", BigDecimal.valueOf(999.00));
            System.out.println(accountInfo);*/

            //演示第二种多个传参方式
            AccountInfoMapper accountInfoMapper = session.getMapper(AccountInfoMapper.class);
            Timestamp gmtCreate = Timestamp.valueOf("2018-06-27 22:48:28");
            Timestamp gmtModified = Timestamp.valueOf("2018-06-27 23:48:32");
            AccountInfo accountInfo = accountInfoMapper.getAccountInfoByGmtCreateAndGmtModified(gmtCreate, gmtModified);
            System.out.println(accountInfo);

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

}
