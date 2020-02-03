/*
 * 日期：2020/1/25 上午10:48
 * 文件名：OrderDTO.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/main/java/com/qxholy/selltest/dto/OrderDTO.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.qxholy.selltest.domain.OrderDetail;
import com.qxholy.selltest.enums.OrderStatusEnum;
import com.qxholy.selltest.enums.PayStatusEnum;
import com.qxholy.selltest.utils.EnumUtil;
import com.qxholy.selltest.utils.serializer.Date2LongSerializer;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Project selltest
 * @Package: com.qxholy.selltest.dto
 * @Author XuDa
 * @Date 2020/1/25 10:48 上午
 */
@Data
public class OrderDTO {

    /**
     * 订单Id
     */
    private String orderId;

    /**
     * 买家名称
     */
    private String buyerName;

    /**
     * 买家手机号
     */
    private String buyerPhone;

    /**
     * 买家地址
     */
    private String buyerAddress;

    /**
     * 买家微信OpenId
     */
    private String buyerOpenid;

    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;

    /**
     * 订单状态，默认0为新下单
     */
    private Integer orderStatus;

    /**
     * 支付状态，默认为0未支付
     */
    private Integer payStatus;

    /**
     * 创建时间
     */
    @JsonSerialize(using = Date2LongSerializer.class)
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonSerialize(using = Date2LongSerializer.class)
    @UpdateTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    private List<OrderDetail> orderDetailList;

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }
}
