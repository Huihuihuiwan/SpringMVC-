package com.wendy.service.impl;

import com.wendy.domain.Account;
import com.wendy.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author : wendy_wan
 * Created : 2020/4/28 15:42
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Override
    public List<Account> findAll() {
        System.out.println("业务层：查询所有账户...");
        return null;
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层：保存账户...");
    }
}
