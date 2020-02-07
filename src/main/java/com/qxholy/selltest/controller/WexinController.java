/*
 * 日期：2020/2/3 下午7:32
 * 文件名：WexinController.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/main/java/com/qxholy/selltest/controller/WexinController.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.github.wxpay.sdk.WXPayConfig;
import com.github.wxpay.sdk.WXPayUtil;
import com.google.gson.JsonObject;
import com.qxholy.selltest.dto.PayDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @Project selltest
 * @Package: com.qxholy.selltest.controller
 * @Author XuDa
 * @Date 2020/2/3 7:32 下午
 */
@Controller
@RequestMapping("/weixin")
@Slf4j
public class WexinController {

    @GetMapping("/authXd")
    public ModelAndView auth(@RequestParam("code") String code,
                             Map<String, String> map) {
        log.info("code={}", code);
        map.put("code", code);

        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxebfd78fa1898d74b&secret=010c2d97fb1fb0433039024c499b497e&code=" + code + "&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        map.put("response", response);
        log.info("response={}", response);
        JSONObject jsonObject = JSONObject.parseObject(response);
        String access_token = jsonObject.getString("access_token");
        String openid = jsonObject.getString("openid");
        map.put("access_token", access_token);
        map.put("openid", openid);

        String url1 = "https://api.weixin.qq.com/sns/userinfo?access_token=" + access_token + "&openid=" + openid + "&lang=zh_CN";
        String response1 = restTemplate.getForObject(url1, String.class);
        map.put("response1", response1);
        log.info("response1={}", response1);

        return new ModelAndView("common/code", map);
    }

    @PostMapping("/pay")
    public ModelAndView payPostTest(@RequestBody PayDTO payDTO,
                                    Map<String, Object> map) throws Exception {
        payDTO.setAppId("wxebfd78fa1898d74b");
        payDTO.setMch_id("1541092771");
        String nonceStr = WXPayUtil.generateNonceStr();
        payDTO.setNonce_str(nonceStr);
        Map<String, String> data = new HashMap<>();
        data.put("appId", "wxebfd78fa1898d74b");
        data.put("mch_id", "1541092771");
        data.put("nonce_str", nonceStr);
        data.put("body", "aaa");
        data.put("out_trade_no", "1580870423231940218");
        data.put("total_fee", "0.01");
        data.put("spbill_create_ip", "127.0.0.1");
        data.put("notify_url", "");
        data.put("trade_type", "JSAPI");
        data.put("openid", "ou1Huv0d-MIHp81VBubEACTJM3HY");
        String key = "SDysjdsr1225SDysjdsr1225SDysjdsr";
        payDTO.setSign(WXPayUtil.generateSignature(data, key));
        payDTO.setBody("aaa");
        payDTO.setOut_trade_no("1580870423231940218");
        payDTO.setTotal_fee("0.01");
        payDTO.setSpbill_create_ip("127.0.0.1");
        payDTO.setNotify_url("");
        payDTO.setTrade_type("JSAPI");

        String url1 = "https://api.mch.weixin.qq.com/pay/unifiedorder";
        RestTemplate restTemplate = new RestTemplate();
        String response1 = restTemplate.getForObject(url1, String.class);
        map.put("response1", response1);
        log.info("response1={}", response1);
        return new ModelAndView("common/code1", map);
    }

    private String openId(@RequestParam("code") String code,
                          Map<String, String> map) {
        log.info("code={}", code);
        map.put("code", code);

        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxebfd78fa1898d74b&secret=010c2d97fb1fb0433039024c499b497e&code=" + code + "&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        JSONObject jsonObject = JSONObject.parseObject(response);
        String openid = jsonObject.getString("openid");

        return openid;
    }

}
