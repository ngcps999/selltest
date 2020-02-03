/*
 * 日期：2020/1/30 上午11:58
 * 文件名：PayService.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/main/java/com/qxholy/selltest/service/PayService.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.service;

import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;
import com.qxholy.selltest.dto.OrderDTO;

/**
 * 支付
 * @Project selltest
 * @Package: com.qxholy.selltest.service
 * @Author XuDa
 * @Date 2020/1/30 11:58 上午
 */
public interface PayService {

    PayResponse create(OrderDTO orderDTO);

    PayResponse notify(String notifyData);

    RefundResponse refund(OrderDTO orderDTO);


}
