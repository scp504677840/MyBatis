package main;

import main.entities.AccountInfo;
import main.entities.AccountInfoExample;
import main.repository.AccountInfoMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

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
            AccountInfoExample example = new AccountInfoExample();

            //查询条件1
            AccountInfoExample.Criteria criteria = example.createCriteria();
            criteria.andNameLike("%T%");

            //查询条件2
            AccountInfoExample.Criteria criteria1 = example.createCriteria();
            criteria1.andBalanceBetween(BigDecimal.valueOf(10000L), BigDecimal.valueOf(50000L));

            //拼接查询条件
            example.or(criteria1);
            //==>  Preparing: select id, gmt_create, gmt_modified, name, balance from account_info WHERE ( name like ? ) or( balance between ? and ? )
            //==> Parameters: %T%(String), 10000(BigDecimal), 50000(BigDecimal)

            List<AccountInfo> accountInfoList = accountInfoMapper.selectByExample(example);
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
