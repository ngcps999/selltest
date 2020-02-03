/*
 * 日期：2020/1/28 下午3:57
 * 文件名：WechatAccountConfig.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/main/java/com/qxholy/selltest/config/WechatAccountConfig.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Project selltest
 * @Package: com.qxholy.selltest.config
 * @Author XuDa
 * @Date 2020/1/28 3:57 下午
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {

    private String mpAppId;

    private String mpAppSecret;

    private String mchId;
    private String mchKey;
    private String keyPath;
    private String notifyUrl;
}
