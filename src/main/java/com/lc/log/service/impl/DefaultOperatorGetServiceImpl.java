package com.lc.log.service.impl;

import com.lc.log.bean.Operator;
import com.lc.log.service.IOperatorGetService;
import com.lc.log.utils.UserUtils;

import java.util.Optional;

/**
 * @author: lingchen
 * @date: 2022/5/20
 */
public class DefaultOperatorGetServiceImpl implements IOperatorGetService {
    @Override
    public Operator getUser() {
        // 获取用户上下文的方法.
        return Optional.ofNullable(UserUtils.getUser())
                .map(a -> new Operator(a.getName(), a.getLogin()))
                .orElseThrow(() -> new IllegalArgumentException("user is null"));
    }
}
