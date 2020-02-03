/*
 * 日期：2020/1/24 下午10:11
 * 文件名：OrderDetailRepositoryTest.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/test/java/com/qxholy/selltest/repository/OrderDetailRepositoryTest.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.repository;

import com.qxholy.selltest.domain.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Project selltest
 * @Package: com.qxholy.selltest.repository
 * @Author XuDa
 * @Date 2020/1/24 10:11 下午
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderDetailRepositoryTest {

    @Autowired
    OrderDetailRepository repository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1234567");
        orderDetail.setOrderId("1234567");
        orderDetail.setProductId("1234568");
        orderDetail.setProductName("xdxdxd");
        orderDetail.setProductPrice(new BigDecimal(35));
        orderDetail.setProductQuantity(12);
        orderDetail.setProductIcon("https://www.qxholy.com/xdxd.jpg");

        OrderDetail save = repository.save(orderDetail);
        Assert.assertNotNull(save);
    }

    @Test
    public void findByOrderId() {
        List<OrderDetail> orderDetailList = repository.findByOrderId("123456");
        Assert.assertNotEquals(0,orderDetailList.size());
    }
}
