package com.lc.log.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户信息.
 *
 * @author: lingchen
 * @date: 2022/5/20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operator {
    private String name;

    private String login;
}
