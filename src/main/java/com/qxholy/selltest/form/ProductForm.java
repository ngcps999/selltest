/*
 * 日期：2020/2/6 上午10:56
 * 文件名：ProductForm.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/main/java/com/qxholy/selltest/form/ProductForm.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.form;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Project selltest
 * @Package: com.qxholy.selltest.form
 * @Author XuDa
 * @Date 2020/2/6 10:56 上午
 */
@Data
public class ProductForm {

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
     * 类目编号
     */
    private Integer categoryType;


}
