/*
 * 日期：2020/2/2 下午7:56
 * 文件名：EnumUtil.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/main/java/com/qxholy/selltest/utils/EnumUtil.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.utils;

import com.qxholy.selltest.enums.CodeEnum;

/**
 * @Project selltest
 * @Package: com.qxholy.selltest.utils
 * @Author XuDa
 * @Date 2020/2/2 7:56 下午
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
