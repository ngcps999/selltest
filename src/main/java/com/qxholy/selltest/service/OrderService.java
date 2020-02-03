/*
 * 日期：2020/1/25 上午10:43
 * 文件名：OrderService.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/main/java/com/qxholy/selltest/service/OrderService.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.service;

import com.qxholy.selltest.domain.OrderDetail;
import com.qxholy.selltest.domain.OrderMaster;
import com.qxholy.selltest.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Project selltest
 * @Package: com.qxholy.selltest.service
 * @Author XuDa
 * @Date 2020/1/25 10:43 上午
 */
public interface OrderService {
    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 查询单个订单
     * @param orderId
     * @return
     */
    OrderDTO findById(String orderId);

    /**
     * 查询订单列表
     * @param buyerOpenid
     * @param pageable
     * @return
     */
    Page<OrderDTO> findAll(String buyerOpenid, Pageable pageable);

    /**
     * 取消订单
     * @param orderDTO
     * @return
     */
    OrderDTO cancel(OrderDTO orderDTO);

    /**
     * 完结订单
     * @param orderDTO
     * @return
     */
    OrderDTO finish(OrderDTO orderDTO);

    /**
     * 支付订单
     * @param orderDTO
     * @return
     */
    OrderDTO paid(OrderDTO orderDTO);


    public Page<OrderDTO> findList(Pageable pageable);


}
