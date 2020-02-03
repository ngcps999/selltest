/*
 * 日期：2020/1/25 下午2:25
 * 文件名：SellException.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/main/java/com/qxholy/selltest/exception/SellException.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.exception;

import com.qxholy.selltest.enums.ResultEnum;

/**
 * @Project selltest
 * @Package: com.qxholy.selltest.exception
 * @Author XuDa
 * @Date 2020/1/25 2:25 下午
 */
public class SellException extends RuntimeException {
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code,String message) {
        super(message);
        this.code = code;
    }
}
