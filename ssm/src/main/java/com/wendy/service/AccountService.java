package com.wendy.service;

import com.wendy.domain.Account;

import java.util.List;

/**
 * Author : wendy_wan
 * Created : 2020/4/28 15:41
 */
public interface AccountService {
    //查询所有账户
    public List<Account> findAll();

    //保存账户信息
    public void saveAccount(Account account);
}
