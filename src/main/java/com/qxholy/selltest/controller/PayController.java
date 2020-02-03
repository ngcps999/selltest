/*
 * 日期：2020/1/29 下午3:50
 * 文件名：PayController.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/main/java/com/qxholy/selltest/controller/PayController.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.controller;

import com.lly835.bestpay.model.PayResponse;
import com.qxholy.selltest.dto.OrderDTO;
import com.qxholy.selltest.enums.ResultEnum;
import com.qxholy.selltest.exception.SellException;
import com.qxholy.selltest.service.OrderService;
import com.qxholy.selltest.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @Project selltest
 * @Package: com.qxholy.selltest.controller
 * @Author XuDa
 * @Date 2020/1/29 3:50 下午
 */
@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;

    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("returnUrl") String returnUrl,
                               Map<String, Object> map) {
        //1.查询订单
        OrderDTO orderDTO = orderService.findById(orderId);
        if (orderDTO == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        //2.发起支付
        PayResponse payResponse = payService.create(orderDTO);

        map.put("payResponse", payResponse);
        map.put("returnUrl", returnUrl);

        return new ModelAndView("pay/create", map);
    }

    @PostMapping("/notify")
    public ModelAndView notify(@RequestBody String notifyData) {
        payService.notify(notifyData);
        return new ModelAndView("pay/success");
    }


}
