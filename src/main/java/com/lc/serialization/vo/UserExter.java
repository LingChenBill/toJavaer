package com.lc.serialization.vo;

import lombok.Data;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * 实现一个序列化接口Externalizable.
 * 当使用Externalizable接口来进行序列化与反序列化的时候
 * 需要开发人员重写writeExternal与readExternal方法.
 *
 * @author: lingchen
 * @date: 2021/6/19
 */
@Data
public class UserExter implements Externalizable {

    /**
     * 姓名.
     */
    private String name;

    /**
     * 年龄.
     */
    private int age;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        // 注意写入的对象类型.
        out.writeObject(name);
        out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        age = in.readInt();
    }

    @Override
    public String toString() {
        return "User { " +
                "name = '" + name + "\'" +
                ", age = " + age +
                " }";
    }
}
