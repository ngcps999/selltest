/*
 * 日期：2020/1/23 下午7:49
 * 文件名：ProductStatusEnum.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/main/java/com/qxholy/selltest/enums/ProductStatusEnum.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.enums;

import lombok.Getter;

import java.awt.print.Pageable;

/**
 * @Project selltest
 * @Package: com.qxholy.selltest.enums
 * @Author XuDa
 * @Date 2020/1/23
 */
@Getter
public enum ProductStatusEnum implements CodeEnum {
    UP(0, "上架"),
    DOWN(1, "下架");

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
