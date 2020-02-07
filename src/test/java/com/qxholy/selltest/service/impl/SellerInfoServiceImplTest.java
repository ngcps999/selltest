/*
 * 日期：2020/2/6 下午4:20
 * 文件名：SellerInfoServiceImplTest.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/test/java/com/qxholy/selltest/service/impl/SellerInfoServiceImplTest.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.service.impl;

import com.qxholy.selltest.domain.SellerInfo;
import com.qxholy.selltest.service.SellerInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Project selltest
 * @Package: com.qxholy.selltest.service.impl
 * @Author XuDa
 * @Date 2020/2/6 4:20 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SellerInfoServiceImplTest {

    private final static String openid = "abc";

    @Autowired
    private SellerInfoService sellerInfoService;

    @Test
    public void findSellerInfoByOpenid() {
        SellerInfo sellerInfoByOpenid = sellerInfoService.findSellerInfoByOpenid(openid);
        Assert.assertEquals(openid, sellerInfoByOpenid.getOpenid());
    }
}