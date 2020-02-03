/*
 * 日期：2020/1/26 下午8:25
 * 文件名：OrderMaster2OrderDTOConverter.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/main/java/com/qxholy/selltest/converter/OrderMaster2OrderDTOConverter.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.converter;

import com.qxholy.selltest.domain.OrderMaster;
import com.qxholy.selltest.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Project selltest
 * @Package: com.qxholy.selltest.converter
 * @Author XuDa
 * @Date 2020/1/26 8:25 下午
 */
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO convert(OrderMaster orderMaster) {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList) {
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for (OrderMaster orderMaster : orderMasterList) {
            OrderDTO orderDTO = convert(orderMaster);
            orderDTOList.add(orderDTO);
        }
        return orderDTOList;
    }
}
