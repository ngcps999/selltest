/*
 * 日期：2020/1/25 下午10:21
 * 文件名：OrderServiceImplTest.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/test/java/com/qxholy/selltest/service/impl/OrderServiceImplTest.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.service.impl;

import com.qxholy.selltest.domain.OrderDetail;
import com.qxholy.selltest.dto.OrderDTO;
import com.qxholy.selltest.enums.OrderStatusEnum;
import com.qxholy.selltest.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Project selltest
 * @Package: com.qxholy.selltest.service.impl
 * @Author XuDa
 * @Date 2020/1/25 10:21 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    OrderServiceImpl orderService;

    public static String BUYER_OPENID = "123321";

    public static final String ORDER_ID = "1580024196874224491";

    @Test
    @Transactional
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("大巨鼓");
        orderDTO.setBuyerAddress("启心网络");
        orderDTO.setBuyerPhone("18952054728");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setProductId("123457");
        orderDetail1.setProductQuantity(1);

        OrderDetail orderDetail2 = new OrderDetail();
        orderDetail2.setProductId("123456");
        orderDetail2.setProductQuantity(2);

        orderDetailList.add(orderDetail1);
        orderDetailList.add(orderDetail2);

        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result = orderService.create(orderDTO);
        log.info("【创建订单】result={}", result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findById() {
        OrderDTO orderDTO = orderService.findById(ORDER_ID);
        log.info("【查询单个订单】result={}", orderDTO);
        Assert.assertEquals(ORDER_ID, orderDTO.getOrderId());
    }

    @Test
    public void findAll() {
        PageRequest request = PageRequest.of(0, 2);
        Page<OrderDTO> orderDTOPage = orderService.findAll(BUYER_OPENID, request);
        Assert.assertNotEquals(0, orderDTOPage.getTotalElements());
    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = orderService.findById(ORDER_ID);
        OrderDTO cancel = orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(), cancel.getOrderStatus());
    }

    @Test
    public void finish() {
        OrderDTO orderDTO = orderService.findById(ORDER_ID);
        OrderDTO finish = orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(), finish.getOrderStatus());
    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderService.findById(ORDER_ID);
        OrderDTO paid = orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(), paid.getPayStatus());
    }

    @Test
    public void findList() {
        PageRequest request = PageRequest.of(0,2);
        Page<OrderDTO> orderDTOPage = orderService.findList(request);
        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
    }
}