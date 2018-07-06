package main;

import main.entities.AccountInfo;
import main.repository.AccountInfoMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.List;
import java.util.function.Consumer;

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

            // 获取Mapper
            AccountInfoMapper accountInfoMapper = session.getMapper(AccountInfoMapper.class);
            List<AccountInfo> accountInfoList = accountInfoMapper.selectAll();
            accountInfoList.forEach(accountInfo -> {
                System.out.println(accountInfo);
            });
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
