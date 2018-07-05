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
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

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

            AccountInfoMapper accountInfoMapper = session.getMapper(AccountInfoMapper.class);
            List<AccountInfo> accountInfoList = accountInfoMapper.getAccountInfoLikeName("T");
            accountInfoList.forEach(accountInfo -> {
                System.out.println(accountInfo);
            });

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("发生异常");
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
