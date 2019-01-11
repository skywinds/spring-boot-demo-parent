package com.sas.sbdth.service;

import com.sas.sbdth.model.ProductInfo;

import java.util.List;

public interface IProductService {
    List<ProductInfo> findByPage(ProductInfo info);
}
