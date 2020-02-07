/*
 * 日期：2020/1/22 上午11:56
 * 文件名：ProductCategoryRespositoryTest.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/test/java/com/qxholy/selltest/repository/ProductCategoryRespositoryTest.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.repository;

import com.qxholy.selltest.domain.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


/**
 * @Project selltest
 * @Package: com.qxholy.selltest.repository
 * @Author XuDa
 * @Date 2020/1/22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRespositoryTest {

    @Autowired
    ProductCategoryRespository respository;

    @Test
    public void findByIdRepo() {
        Optional<ProductCategory> optional = respository.findById(1);
        if (optional.isPresent()) {
            ProductCategory productCategory = optional.get();
            System.out.println(productCategory.toString());
        }
    }

    @Test
    public void saveTest(){
        Optional<ProductCategory> optional = respository.findById(1);
        if (optional.isPresent()){
            ProductCategory productCategory = optional.get();
            productCategory.setCategoryName("热销");
            respository.save(productCategory);
        }
    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(1,2,3,4);
        List<ProductCategory> productCategoryList = respository.findByCategoryTypeIn(list);
        for (ProductCategory productCategory : productCategoryList) {
            System.out.println(productCategory.toString());
        }
        Assert.assertNotEquals(0,productCategoryList.size());
    }
}