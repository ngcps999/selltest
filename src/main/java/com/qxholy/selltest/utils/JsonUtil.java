/*
 * 日期：2020/1/30 下午3:51
 * 文件名：JsonUtil.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/main/java/com/qxholy/selltest/utils/JsonUtil.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @Project selltest
 * @Package: com.qxholy.selltest.utils
 * @Author XuDa
 * @Date 2020/1/30 3:51 下午
 */
public class JsonUtil {

    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
