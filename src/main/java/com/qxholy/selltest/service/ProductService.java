/*
 * 日期：2020/1/23 下午7:12
 * 文件名：ProductInfoService.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/main/java/com/qxholy/selltest/service/ProductInfoService.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.service;

import com.qxholy.selltest.domain.ProductInfo;
import com.qxholy.selltest.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.awt.*;
import java.util.List;

/**
 * @Project selltest
 * @Package: com.qxholy.selltest.service
 * @Author XuDa
 * @Date 2020/1/23
 */
public interface ProductService {

    ProductInfo findById(String productId);

    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);

    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);

    //上架
    ProductInfo onSale(String productId);

    //下架
    ProductInfo offSale(String productId);

}
