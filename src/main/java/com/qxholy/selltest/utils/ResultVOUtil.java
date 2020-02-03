/*
 * 日期：2020/1/24 下午5:38
 * 文件名：ResultVOUtil.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/main/java/com/qxholy/selltest/utils/ResultVOUtil.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.utils;

import com.qxholy.selltest.VO.ResultVO;

/**
 * @Project selltest
 * @Package: com.qxholy.selltest.utils
 * @Author XuDa
 * @Date 2020/1/24 5:38 下午
 */
public class ResultVOUtil {

    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMessage("成功");
        return resultVO;
    }

    public static ResultVO success(){
        return success(null);
    }

    public static ResultVO error(Integer code,String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMessage(msg);
        return resultVO;
    }
}
