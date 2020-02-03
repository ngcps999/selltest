/*
 * 日期：2020/1/24 下午9:44
 * 文件名：OrderMasterRepositoryTest.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/test/java/com/qxholy/selltest/repository/OrderMasterRepositoryTest.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.repository;

import com.qxholy.selltest.domain.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Project selltest
 * @Package: com.qxholy.selltest.repository
 * @Author XuDa
 * @Date 2020/1/24 9:44 下午
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123457");
        orderMaster.setBuyerName("dddd");
        orderMaster.setBuyerPhone("18952054728");
        orderMaster.setBuyerAddress("xxxxx");
        orderMaster.setBuyerOpenid("188888");
        orderMaster.setOrderAmount(new BigDecimal(23));

        OrderMaster save = repository.save(orderMaster);
        Assert.assertNotNull(save);
    }

    @Test
    public void findByBuyerOpenid() {
        PageRequest request = PageRequest.of(0,5);
        Page<OrderMaster> result = repository.findByBuyerOpenid("188888", request);
        Assert.assertNotEquals(0,result.getTotalElements());
    }
}