package com.wendy.dao;

import com.wendy.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Author : wendy_wan
 * Created : 2020/4/28 15:31
 */
//账户的dao接口
public interface AccountDao {

    //查询所有账户
    @Select("select * from account")
    public List<Account> findAll();

    //保存账户信息
    @Insert("insert into account (name,money) values(#{name}, #{money})")
    public void saveAccount(Account account);
}
