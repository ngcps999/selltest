/*
 * 日期：2020/2/6 下午4:03
 * 文件名：SellerInfo.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/main/java/com/qxholy/selltest/domain/SellerInfo.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Project selltest
 * @Package: com.qxholy.selltest.domain
 * @Author XuDa
 * @Date 2020/2/6 4:03 下午
 */
@Data
@Entity
@DynamicUpdate
public class SellerInfo {
    @Id
    private String sellerId;

    private String username;

    private String password;

    private String openid;
}
