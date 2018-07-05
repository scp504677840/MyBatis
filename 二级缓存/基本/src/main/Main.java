package main;

import main.entities.AccountInfo;
import main.mapper.AccountInfoMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;

/**
 * 每个基于 MyBatis 的应用都是以一个 SqlSessionFactory 的实例为中心的。
 * SqlSessionFactory 的实例可以通过 SqlSessionFactoryBuilder 获得。
 * 而 SqlSessionFactoryBuilder 则可以从 XML 配置文件或一个预先定制的 Configuration 的实例构建出 SqlSessionFactory 的实例。
 */
public class Main {

    public static void main(String[] args) {
        InputStream in = null;
        try {
            // 读取配置文件
            in = Resources.getResourceAsStream("mybatis-config.xml");
            // 构建SqlSessionFactory
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);

            /*
            二级缓存：namespace缓存。
            二级缓存描述：首先会使用一级缓存，只有session关闭了，才会把一级缓存放到二级缓存中。
            如何开启二级缓存？
            1.在全局配置文件中配置<setting name="cacheEnabled" value="true"/>
            2.在Mapper配置文件中配置<cache/>
            3.实体类实现序列化public class AccountInfo implements Serializable
             */

            // 获取SqlSession
            SqlSession session1 = sessionFactory.openSession();
            AccountInfoMapper accountInfoMapper1 = session1.getMapper(AccountInfoMapper.class);
            AccountInfo accountInfo1 = accountInfoMapper1.getAccountInfoById(BigInteger.valueOf(3L));
            System.out.println(accountInfo1);
            //关闭session
            session1.close();

            // 获取SqlSession
            SqlSession session2 = sessionFactory.openSession();
            AccountInfoMapper accountInfoMapper2 = session2.getMapper(AccountInfoMapper.class);
            AccountInfo accountInfo2 = accountInfoMapper2.getAccountInfoById(BigInteger.valueOf(3L));
            System.out.println(accountInfo2);
            //关闭session
            session2.close();

            System.out.println(accountInfo1 == accountInfo2);
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
        }
    }

}
