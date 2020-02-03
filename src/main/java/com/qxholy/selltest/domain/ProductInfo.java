/*
 * 日期：2020/1/23 下午4:02
 * 文件名：ProductInfo.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/main/java/com/qxholy/selltest/domain/ProductInfo.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @Project selltest
 * 商品
 * @Package: com.qxholy.selltest.domain
 * @Author XuDa
 * @Date 2020/1/23
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo {
    @Id
    private String productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 单价
     */
    private BigDecimal productPrice;

    /**
     * 库存
     */
    private Integer productStock;

    /**
     * 描述
     */
    private String productDescription;

    /**
     * 小图
     */
    private String productIcon;

    /**
     * 商品状态，0正常，1下架
     */
    private Integer productStatus;

    /**
     * 类目编号
     */
    private Integer categoryType;

    public ProductInfo() {
    }

    public ProductInfo(String productId, String productName, BigDecimal productPrice, Integer productStock, String productDescription, String productIcon, Integer productStatus, Integer categoryType) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.productDescription = productDescription;
        this.productIcon = productIcon;
        this.productStatus = productStatus;
        this.categoryType = categoryType;
    }
}
