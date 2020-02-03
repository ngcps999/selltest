/*
 * 日期：2020/1/23 下午7:46
 * 文件名：ProductServiceImpl.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/main/java/com/qxholy/selltest/service/impl/ProductServiceImpl.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.service.impl;

import com.qxholy.selltest.domain.ProductInfo;
import com.qxholy.selltest.dto.CartDTO;
import com.qxholy.selltest.enums.ProductStatusEnum;
import com.qxholy.selltest.enums.ResultEnum;
import com.qxholy.selltest.exception.SellException;
import com.qxholy.selltest.repository.ProductInfoRepository;
import com.qxholy.selltest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @Project selltest
 * @Package: com.qxholy.selltest.service.impl
 * @Author XuDa
 * @Date 2020/1/23
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductInfoRepository repository;

    @Override
    public ProductInfo findById(String productId) {
        Optional<ProductInfo> optional = repository.findById(productId);
        if (optional.isPresent()){
            ProductInfo productInfo = optional.get();
            return productInfo;
        }
        return null;
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            Optional<ProductInfo> optional = repository.findById(cartDTO.getProductId());
            ProductInfo productInfo = null;
            if (optional.isPresent()){
                productInfo = optional.get();
            }
            if (productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            Optional<ProductInfo> optional = repository.findById(cartDTO.getProductId());
            if (optional.isPresent()){
                ProductInfo productInfo = optional.get();
                if (productInfo == null){
                    throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
                }
                Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
                if (result < 0){
                    throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
                }
                productInfo.setProductStock(result);
                repository.save(productInfo);
            }
        }
    }
}
