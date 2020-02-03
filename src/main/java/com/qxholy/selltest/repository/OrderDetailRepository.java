/*
 * 日期：2020/1/24 下午9:40
 * 文件名：OrderDetailRepository.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/main/java/com/qxholy/selltest/repository/OrderDetailRepository.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.repository;

import com.qxholy.selltest.domain.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Project selltest
 * @Package: com.qxholy.selltest.repository
 * @Author XuDa
 * @Date 2020/1/24 9:40 下午
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
    List<OrderDetail> findByOrderId(String orderId);
}
