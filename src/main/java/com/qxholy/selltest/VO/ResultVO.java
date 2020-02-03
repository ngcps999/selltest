/*
 * 日期：2020/1/23 下午10:05
 * 文件名：ResultVO.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/main/java/com/qxholy/selltest/VO/ResultVO.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.VO;

import lombok.Data;

/**
 * @Project selltest
 * @Package: com.qxholy.selltest.VO
 * @Author XuDa
 * @Date 2020/1/23 10:05 下午
 */
@Data
public class ResultVO<T> {
    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 具体内容
     */
    private T data;
}
