package com.wendy.test;

import com.wendy.dao.AccountDao;
import com.wendy.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Author : wendy_wan
 * Created : 2020/4/28 17:29
 */
public class TestMyBatis {

    @Test
    public void run1() throws IOException {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession session = factory.openSession();
        //获取到代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        //查询
        List<Account> list = dao.findAll();
        for (Account account : list) {
            System.out.println(account);
        }

        //关闭资源
        session.close();
        in.close();
    }

    @Test
    public void run2() throws IOException {
        Account account = new Account();
        account.setName("熊大");
        account.setMoney(789d);
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession session = factory.openSession();
        //获取到代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        //保存
        dao.saveAccount(account);

        //提交事务
        session.commit();
        //关闭资源
        session.close();
        in.close();
    }
}
