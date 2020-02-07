/*
 * 日期：2020/2/6 下午3:46
 * 文件名：CategoryForm.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/main/java/com/qxholy/selltest/form/CategoryForm.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.form;

import lombok.Data;

/**
 * @Project selltest
 * @Package: com.qxholy.selltest.form
 * @Author XuDa
 * @Date 2020/2/6 3:46 下午
 */
@Data
public class CategoryForm {

    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;
}
