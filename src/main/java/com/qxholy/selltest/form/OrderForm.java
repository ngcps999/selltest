/*
 * 日期：2020/1/27 下午12:19
 * 文件名：OrderForm.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/main/java/com/qxholy/selltest/form/OrderForm.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @Project selltest
 * @Package: com.qxholy.selltest.form
 * @Author XuDa
 * @Date 2020/1/27 12:19 下午
 */
@Data
public class OrderForm {

    /**
     * 买家姓名
     */
    @NotEmpty(message = "姓名必填")
    private String name;

    /**
     * 买家手机号
     */
    @NotEmpty(message = "手机号必填")
    private String phone;

    /**
     * 买家地址
     */
    @NotEmpty(message = "地址必填")
    private String address;

    /**
     * 买家微信openid
     */
    @NotEmpty(message = "openid必填")
    private String openid;

    /**
     * 购物车
     */
    @NotEmpty(message = "购物车不能为空")
    private String items;
}
