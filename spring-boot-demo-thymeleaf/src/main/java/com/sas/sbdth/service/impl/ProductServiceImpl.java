package com.sas.sbdth.service.impl;

import com.sas.sbdth.model.ProductInfo;
import com.sas.sbdth.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Override
    public List<ProductInfo> findByPage(ProductInfo info) {
        List<ProductInfo> result = new ArrayList<>();
        result.add(new ProductInfo(1L, "101", "杀毒", "杀毒描述", "AV"));
        result.add(new ProductInfo(2L, "102", "vault", "vault描述", "VT"));
        result.add(new ProductInfo(3L, "103", "ATP", "ATP描述", "ATP"));
        return result;
    }
}
