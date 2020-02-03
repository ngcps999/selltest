/*
 * 日期：2020/1/28 上午10:44
 * 文件名：BuyerService.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/main/java/com/qxholy/selltest/service/BuyerService.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.service;

import com.qxholy.selltest.dto.OrderDTO;

/**
 * 买家
 *
 * @Project selltest
 * @Package: com.qxholy.selltest.service
 * @Author XuDa
 * @Date 2020/1/28 10:44 上午
 */
public interface BuyerService {

    /**
     * 查询一个订单
     */
    OrderDTO findByOrderId(String openid, String orderId);

    /**
     * 取消订单
     */
    OrderDTO cancelOrder(String openid, String orderId);


}
