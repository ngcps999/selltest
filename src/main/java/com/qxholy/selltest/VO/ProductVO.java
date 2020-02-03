/*
 * 日期：2020/1/23 下午10:49
 * 文件名：ProductVO.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/main/java/com/qxholy/selltest/VO/ProductVO.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.qxholy.selltest.domain.ProductInfo;
import lombok.Data;

import java.util.List;

/**
 * @Project selltest
 * @Package: com.qxholy.selltest.VO
 * @Author XuDa
 * @Date 2020/1/23 10:49 下午
 */
@Data
public class ProductVO {
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
