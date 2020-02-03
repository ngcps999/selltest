/*
 * 日期：2020/1/23 下午3:20
 * 文件名：CategoryServiceImpl.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/main/java/com/qxholy/selltest/service/impl/CategoryServiceImpl.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.service.impl;

import com.qxholy.selltest.domain.ProductCategory;
import com.qxholy.selltest.repository.ProductCategoryRespository;
import com.qxholy.selltest.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Project selltest
 * @Package: com.qxholy.selltest.service.impl
 * @Author XuDa
 * @Date 2020/1/23
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    ProductCategoryRespository respository;


    @Override
    public ProductCategory findById(Integer categoryId) {
        Optional<ProductCategory> optional = respository.findById(categoryId);
        if (optional.isPresent()){
            ProductCategory productCategory = optional.get();
            return productCategory;
        }
        return null;
    }

    @Override
    public List<ProductCategory> findAll() {
        return respository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return respository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return respository.save(productCategory);
    }
}
