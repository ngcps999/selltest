/*
 * 日期：2020/1/24 下午9:12
 * 文件名：PayStatusEnum.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/main/java/com/qxholy/selltest/enums/PayStatusEnum.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.enums;

import lombok.Getter;

/**
 * @Project selltest
 * @Package: com.qxholy.selltest.enums
 * @Author XuDa
 * @Date 2020/1/24 9:12 下午
 */
@Getter
public enum PayStatusEnum implements CodeEnum{
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    ;

    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
