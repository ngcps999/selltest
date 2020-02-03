/*
 * 日期：2020/1/24 下午9:05
 * 文件名：OrderStatusEnum.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/main/java/com/qxholy/selltest/enums/OrderStatusEnum.java
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
 * @Date 2020/1/24 9:05 下午
 */
@Getter
public enum OrderStatusEnum implements CodeEnum {
    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "已取消"),
    ;

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static OrderStatusEnum getOrderStatusEnum(Integer code) {
        for (OrderStatusEnum orderStatusEnum : OrderStatusEnum.values()) {
            if (orderStatusEnum.getCode().equals(code)) {
                return orderStatusEnum;
            }
        }
        return null;
    }
}
