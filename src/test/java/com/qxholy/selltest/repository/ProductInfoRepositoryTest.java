/*
 * 日期：2020/1/23 下午4:16
 * 文件名：ProductInfoRepositoryTest.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/test/java/com/qxholy/selltest/repository/ProductInfoRepositoryTest.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.repository;

import com.qxholy.selltest.domain.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Project selltest
 * @Package: com.qxholy.selltest.repository
 * @Author XuDa
 * @Date 2020/1/23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    ProductInfoRepository productInfoRepository;

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo("123456", "炒饭", new BigDecimal(20), 99, "好吃的炒饭", "http://www.qxholy.com/cf.jpg", 0, 2);
        Assert.assertNotNull(productInfoRepository.save(productInfo));
    }

    @Test
    public void findByProductStatus() {
        List<ProductInfo> productInfoList = productInfoRepository.findByProductStatus(0);
        Assert.assertNotEquals(0,productInfoList.size());
    }
}