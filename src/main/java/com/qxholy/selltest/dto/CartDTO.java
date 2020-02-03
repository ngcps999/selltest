/*
 * 日期：2020/1/25 下午4:13
 * 文件名：CartDTO.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/main/java/com/qxholy/selltest/dto/CartDTO.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.dto;

import lombok.Data;

/**
 * @Project selltest
 * @Package: com.qxholy.selltest.dto
 * @Author XuDa
 * @Date 2020/1/25 4:13 下午
 */
@Data
public class CartDTO {

    /**
     * 商品Id
     */
    private String productId;

    /**
     * 商品数量
     */
    private Integer productQuantity;

    public CartDTO() {
    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
