/*
 * 日期：2020/2/5 上午8:02
 * 文件名：PayDTO.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/main/java/com/qxholy/selltest/dto/PayDTO.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.dto;

import lombok.Data;

/**
 * @Project selltest
 * @Package: com.qxholy.selltest.dto
 * @Author XuDa
 * @Date 2020/2/5 8:02 上午
 */
@Data
public class PayDTO {
    private String appId;
    private String mch_id;
    private String nonce_str;
    private String sign;
    private String body;
    private String out_trade_no;
    private String total_fee;
    private String spbill_create_ip;
    private String notify_url;
    private String trade_type;


}
