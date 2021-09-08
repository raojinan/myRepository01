package com.itan.springAOP;

import org.springframework.stereotype.Service;

/**
 * @author raojinan
 * @version 1.0
 * @date 2021/8/16 11:48
 */
@Service
public class AopServiceImpl implements AopService {
    @Override
    public String save() {

        return "保存成功";

    }
}
