/*
 * 日期：2020/1/30 下午3:26
 * 文件名：PayServiceImplTest.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/test/java/com/qxholy/selltest/service/impl/PayServiceImplTest.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.service.impl;

import com.qxholy.selltest.dto.OrderDTO;
import com.qxholy.selltest.service.OrderService;
import com.qxholy.selltest.service.PayService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @Project selltest
 * @Package: com.qxholy.selltest.service.impl
 * @Author XuDa
 * @Date 2020/1/30 3:26 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PayServiceImplTest {

    @Autowired
    private PayService payService;

    @Autowired
    private OrderService orderService;

    @Test
    public void create() {
        OrderDTO orderDTO = orderService.findById("1580124167795873616");
        payService.create(orderDTO);
    }

    @Test
    public void refund() {
        OrderDTO orderDTO = orderService.findById("1580547645468832638");
        payService.refund(orderDTO);

    }
}