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
        SqlSession session = null;
        try {
            // 读取配置文件
            in = Resources.getResourceAsStream("mybatis-config.xml");
            // 构建SqlSessionFactory
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
            // 获取SqlSession
            session = sessionFactory.openSession();

            //一级缓存：session缓存。
            //缓存失效的四种情况：
            //1.session不同。
            //2.session相同，查询不同。
            //3.session相同，中间插入了增删改。（因为增删改有可能影响到已缓存的数据）
            //4.session相同，但是清空了缓存。
            AccountInfoMapper accountInfoMapper = session.getMapper(AccountInfoMapper.class);
            AccountInfo accountInfo1 = accountInfoMapper.getAccountInfoById(BigInteger.valueOf(3L));

            //清空缓存
            session.clearCache();

            AccountInfo accountInfo2 = accountInfoMapper.getAccountInfoById(BigInteger.valueOf(3L));
            System.out.println(accountInfo1 == accountInfo2);
            //false
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
