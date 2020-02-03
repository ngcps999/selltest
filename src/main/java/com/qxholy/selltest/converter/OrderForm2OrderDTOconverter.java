/*
 * 日期：2020/1/27 下午12:36
 * 文件名：OrderForm2OrderDTOconverter.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/main/java/com/qxholy/selltest/converter/OrderForm2OrderDTOconverter.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qxholy.selltest.domain.OrderDetail;
import com.qxholy.selltest.dto.OrderDTO;
import com.qxholy.selltest.enums.ResultEnum;
import com.qxholy.selltest.exception.SellException;
import com.qxholy.selltest.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project selltest
 * @Package: com.qxholy.selltest.converter
 * @Author XuDa
 * @Date 2020/1/27 12:36 下午
 */
@Slf4j
public class OrderForm2OrderDTOconverter {

    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        } catch (Exception e) {
            log.error("【对象转换】错误，string={}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
