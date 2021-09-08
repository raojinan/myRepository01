package com.itan.beanfactory.dao.impl;

import com.itan.beanfactory.dao.AccountDao;

public class AccountDaoImpl implements AccountDao {
    @Override
    public void update() {
        System.out.println("AccountDaoImpl-->update()");
    }
}
