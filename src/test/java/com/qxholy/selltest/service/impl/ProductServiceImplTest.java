/*
 * 日期：2020/1/23 下午7:59
 * 文件名：ProductServiceImplTest.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/test/java/com/qxholy/selltest/service/impl/ProductServiceImplTest.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.service.impl;

import com.qxholy.selltest.domain.ProductInfo;
import com.qxholy.selltest.enums.ProductStatusEnum;
import com.qxholy.selltest.repository.ProductInfoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Project selltest
 * @Package: com.qxholy.selltest.service.impl
 * @Author XuDa
 * @Date 2020/1/23 7:59 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    ProductServiceImpl productService;

    @Test
    public void findById() {
        ProductInfo productInfo = productService.findById("123456");
        Assert.assertEquals("123456", productInfo.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfoList = productService.findUpAll();
        Assert.assertNotEquals(0, productInfoList.size());
    }

    @Test
    public void findAll() {
        PageRequest pageRequest = PageRequest.of(0, 2);
        Page<ProductInfo> productInfoPage = productService.findAll(pageRequest);
//        System.out.println(productInfoPage.getTotalElements());
        Assert.assertNotEquals(0,productInfoPage.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo("123457", "测试1", new BigDecimal(100), 32, "好吃", "https://www.qxholy.com/abc.jpg", ProductStatusEnum.DOWN.getCode(), 2);
        ProductInfo save = productService.save(productInfo);
        Assert.assertEquals("123457",productInfo.getProductId());
        Assert.assertNotNull(save);
    }
}