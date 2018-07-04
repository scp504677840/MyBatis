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
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
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

            // 单条记录
            AccountInfoMapper accountInfoMapper = session.getMapper(AccountInfoMapper.class);
            Map<String, Object> map = accountInfoMapper.mapAccountInfo(BigInteger.valueOf(3L));
            System.out.println(map);
            //{gmt_create=2018-07-02 04:08:58.0, balance=999.55, name=LLKK, id=3, gmt_modified=2018-07-02 04:08:58.0}

            // 多条记录
            Map<BigInteger, AccountInfo> accountInfos = accountInfoMapper.mapAccountInfos();
            accountInfos.forEach((bigInteger, accountInfo) -> {
                System.out.println(bigInteger + " --- " + accountInfo);
            });
            //1 --- AccountInfo{id=1, gmtCreate=2018-06-27 22:48:28.0, gmtModified=2018-06-27 23:48:32.0, name='Tom', balance=5555.00}
            //3 --- AccountInfo{id=3, gmtCreate=2018-07-02 04:08:58.0, gmtModified=2018-07-02 04:08:58.0, name='LLKK', balance=999.55}
            //4 --- AccountInfo{id=4, gmtCreate=2018-07-02 03:34:31.0, gmtModified=2018-07-02 03:34:31.0, name='TL', balance=5555.00}
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
