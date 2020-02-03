/*
 * 日期：2020/1/23 下午9:59
 * 文件名：BuyerProductController.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/main/java/com/qxholy/selltest/controller/BuyerProductController.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.controller;

import com.qxholy.selltest.VO.ProductInfoVO;
import com.qxholy.selltest.VO.ProductVO;
import com.qxholy.selltest.VO.ResultVO;
import com.qxholy.selltest.domain.ProductCategory;
import com.qxholy.selltest.domain.ProductInfo;
import com.qxholy.selltest.service.CategoryService;
import com.qxholy.selltest.service.ProductService;
import com.qxholy.selltest.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project selltest
 * @Package: com.qxholy.selltest.controller
 * @Author XuDa
 * @Date 2020/1/23 9:59 下午
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list() {
        //1.查询所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //2.查询类目（一次性查询)
        List<Integer> categoryTypeList = new ArrayList<>();
        for (ProductInfo productInfo : productInfoList) {
            categoryTypeList.add(productInfo.getCategoryType());
        }
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        //3.数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }
}
