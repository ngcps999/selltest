/*
 * 日期：2020/1/23 下午3:18
 * 文件名：CategoryService.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/main/java/com/qxholy/selltest/service/CategoryService.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.service;

import com.qxholy.selltest.domain.ProductCategory;

import java.util.List;

/**
 * @Project selltest
 * @Package: com.qxholy.selltest.service
 * @Author XuDa
 * @Date 2020/1/23
 */
public interface CategoryService {

    ProductCategory findById(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);

}
