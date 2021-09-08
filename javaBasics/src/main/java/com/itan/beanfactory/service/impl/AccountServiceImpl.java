package com.itan.beanfactory.service.impl;


import com.itan.beanfactory.dao.AccountDao;
import com.itan.beanfactory.service.AccountService;
import com.itan.beanfactory.utils.BeanFactory02;

public class AccountServiceImpl implements AccountService {
    @Override
    public void update() {
        AccountDao accountDao = (AccountDao) BeanFactory02.getById("accountDao");
        accountDao.update();
        System.out.println("AccountServiceImpl-->update()");
    }
}
