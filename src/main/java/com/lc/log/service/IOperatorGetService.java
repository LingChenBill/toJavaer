package com.lc.log.service;


import com.lc.log.bean.Operator;

/**
 * @author: lingchen
 * @date: 2022/5/20
 */
public interface IOperatorGetService {
    /**
     * 可以在里面外部的获取当前登陆的用户.
     * 比如 UserContext.getCurrentUser().
     *
     * @return
     */
    Operator getUser();
}
