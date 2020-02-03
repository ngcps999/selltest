/*
 * 日期：2020/1/24 下午9:17
 * 文件名：OrderDetail.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/main/java/com/qxholy/selltest/domain/OrderDetail.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @Project selltest
 * @Package: com.qxholy.selltest.domain
 * @Author XuDa
 * @Date 2020/1/24 9:17 下午
 */
@Entity
@Data
public class OrderDetail {

    /**
     * 订单详情Id
     */
    @Id
    private String detailId;

    /**
     * 订单Id
     */
    private String orderId;

    /**
     * 商品Id
     */
    private String productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品单价
     */
    private BigDecimal productPrice;

    /**
     * 商品数量
     */
    private Integer productQuantity;

    /**
     * 商品小图
     */
    private String productIcon;
}
