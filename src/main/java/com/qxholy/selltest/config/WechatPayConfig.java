/*
 * 日期：2020/1/30 下午3:07
 * 文件名：WechatPayConfig.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/main/java/com/qxholy/selltest/config/WechatPayConfig.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.config;

import com.lly835.bestpay.config.WxPayConfig;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Project selltest
 * @Package: com.qxholy.selltest.config
 * @Author XuDa
 * @Date 2020/1/30 3:07 下午
 */
@Component
public class WechatPayConfig {

    @Autowired
    private WechatAccountConfig accountConfig;

    @Bean
    public BestPayServiceImpl bestPayService(){
        WxPayConfig wxPayConfig = new WxPayConfig();
        wxPayConfig.setAppId(accountConfig.getMpAppId());
        wxPayConfig.setAppSecret(accountConfig.getMpAppSecret());
        wxPayConfig.setMchId(accountConfig.getMchId());
        wxPayConfig.setMchKey(accountConfig.getMchKey());
        wxPayConfig.setKeyPath(accountConfig.getKeyPath());
        wxPayConfig.setNotifyUrl(accountConfig.getNotifyUrl());

        BestPayServiceImpl bestPayService = new BestPayServiceImpl();
        bestPayService.setWxPayConfig(wxPayConfig);
        return bestPayService;
    }

}
