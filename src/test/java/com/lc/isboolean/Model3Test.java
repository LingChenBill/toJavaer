package com.lc.isboolean;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.extern.java.Log;

/**
 * 序列化测试.
 * @description:
 * @author: lingchen
 * @date: 2020/12/24
 */
@Log
public class Model3Test {

    /**
     * 在fastjson和jackson的结果中,原来类中的isSuccess字段被序列化成success.
     * 而Gson中只有isSuccess字段.
     * @param args
     * @throws JsonProcessingException
     */
    public static void main(String[] args) throws JsonProcessingException {
        // 定义一个Model3类型.
        Model3 model3 = new Model3();
        model3.setSuccess(true);
        // 使用Fastjson序列化model3成字符串并输出.
        // {"success":true}
        log.info("Serializable Result with fastjson: " + JSON.toJSONString(model3));

        // 使用Gson序列化model3成字符串并输出.
        // {"isSuccess":true}
        Gson gson = new Gson();
        log.info("Serializable Result with gson: " + gson.toJson(model3));

        // 使用jackson序列化model3成字符串并输出.
        // {"success":true}
        ObjectMapper om = new ObjectMapper();
        log.info("Serializable Result with jackson: " + om.writeValueAsString(model3));

        // 使用fastjson进行序列化,再使用Gson反序列化会发生什么.
        Model3 model31 = new Model3();
        model31.setSuccess(true);
        Gson gson1 = new Gson();
        // Model3[isSuccess=false]
        log.info("" + gson1.fromJson(JSON.toJSONString(model31), Model3.class));
    }
}