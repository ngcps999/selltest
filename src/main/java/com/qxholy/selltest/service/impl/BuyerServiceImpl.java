/*
 * 日期：2020/1/28 上午10:48
 * 文件名：BuyerServiceImpl.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/main/java/com/qxholy/selltest/service/impl/BuyerServiceImpl.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.service.impl;

import com.qxholy.selltest.dto.OrderDTO;
import com.qxholy.selltest.enums.ResultEnum;
import com.qxholy.selltest.exception.SellException;
import com.qxholy.selltest.service.BuyerService;
import com.qxholy.selltest.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Project selltest
 * @Package: com.qxholy.selltest.service.impl
 * @Author XuDa
 * @Date 2020/1/28 10:48 上午
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    private final OrderService orderService;

    public BuyerServiceImpl(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public OrderDTO findByOrderId(String openid, String orderId) {
        return checkOrderOwner(openid, orderId);
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openid, orderId);
        if (orderDTO == null) {
            log.error("【取消订单】查不到该订单，orderId={}", openid);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }

    private OrderDTO checkOrderOwner(String openid, String orderId) {
        OrderDTO orderDTO = orderService.findById(orderId);
        if (orderDTO == null) {
            return null;
        }
        //判断是否是自己的订单
        if (!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)) {
            log.error("【查询订单】订单的openid不一致. openid={},orderDTO={}", openid, orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
