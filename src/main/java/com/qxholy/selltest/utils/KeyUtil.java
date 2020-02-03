/*
 * 日期：2020/1/25 下午3:54
 * 文件名：KeyUtil.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/main/java/com/qxholy/selltest/utils/KeyUtil.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.utils;

import java.util.Random;

/**
 * @Project selltest
 * @Package: com.qxholy.selltest.utils
 * @Author XuDa
 * @Date 2020/1/25 3:54 下午
 */
public class KeyUtil {

    /**
     * 生成唯一主键
     * 格式：时间+随机数
     *
     * @return
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
