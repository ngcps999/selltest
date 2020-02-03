/*
 * 日期：2020/1/31 下午9:42
 * 文件名：MathUtil.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/main/java/com/qxholy/selltest/utils/MathUtil.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.utils;

/**
 * 比较两个金额是否相等
 * @Project selltest
 * @Package: com.qxholy.selltest.utils
 * @Author XuDa
 * @Date 2020/1/31 9:42 下午
 */
public class MathUtil {
    public static Boolean equals(Double d1, Double d2) {
        Double result = Math.abs(d1 - d2);
        if (result < 0.01) {
            return true;
        } else {
            return false;
        }

    }
}
