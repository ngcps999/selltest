/*
 * 日期：2020/1/23 下午4:14
 * 文件名：ProductInfoRepository.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/main/java/com/qxholy/selltest/repository/ProductInfoRepository.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.repository;

import com.qxholy.selltest.domain.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Project selltest
 * @Package: com.qxholy.selltest.repository
 * @Author XuDa
 * @Date 2020/1/23
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
