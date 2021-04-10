package com.lc.inoutstream.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * 用户Dto.
 * @description:
 * @author: lingchen
 * @date: 2021/4/10
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User implements Serializable {

    private String name;

    private int age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
