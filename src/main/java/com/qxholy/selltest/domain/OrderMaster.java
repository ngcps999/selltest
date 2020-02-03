/*
 * 日期：2020/1/24 下午8:59
 * 文件名：OrderMaster.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/main/java/com/qxholy/selltest/domain/OrderMaster.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.domain;

import com.qxholy.selltest.enums.OrderStatusEnum;
import com.qxholy.selltest.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Project selltest
 * @Package: com.qxholy.selltest.domain
 * 订单主表
 * @Author XuDa
 * @Date 2020/1/24 8:59 下午
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    /**
     * 订单Id
     */
    @Id
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
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /**
     * 支付状态，默认为0未支付
     */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /**
     * 创建时间
     */
    @CreationTimestamp
    private Date createTime;

    /**
     * 更新时间
     */
    @UpdateTimestamp
    private Date updateTime;

}
