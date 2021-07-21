package com.framework.modules.product.service.impl;

import com.framework.dto.ProductInfoModel;
import com.framework.dto.ProductPageInfoModel;
import com.framework.dto.ProductQueryInfoModel;
import com.framework.modules.product.dao.ProductManagementInfoDao;
import com.framework.modules.product.entity.ProductManagementInfoEntity;
import com.framework.modules.product.service.ProductManagementInfoService;
import com.framework.modules.store.entity.StoreInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: liwan
 * @Description: 产品管理实现类
 * @Date: create in 2021/7/13 8:58
 */
@Service
public class ProductManagementInfoServiceImpl implements ProductManagementInfoService {

    @Autowired
    private ProductManagementInfoDao productManagementInfoDao;

    @Override
    public int insProductAll(ProductManagementInfoEntity list) {
        System.out.println(list);
        return productManagementInfoDao.insProductAll(list);
    }

    @Override
    public int upProduct(ProductManagementInfoEntity productManagementInfoEntity) {
        return productManagementInfoDao.upProduct(productManagementInfoEntity);
    }

    @Override
    public int delProduct(List<Integer> list) {
        return productManagementInfoDao.delProduct(list);
    }

    @Override
    public ProductManagementInfoEntity  query(Map<String, Object> params) {
        System.out.println("呜呜哇哇呜呜" + params);
        ProductManagementInfoEntity  query = productManagementInfoDao.query(params);
        return query;
    }

    @Override
    public ProductQueryInfoModel queryinfo(Integer id) {
        ProductQueryInfoModel queryinfo = productManagementInfoDao.queryinfo(id);
        return queryinfo;
    }


    @Override
    public List<ProductManagementInfoEntity> queryPageList(Map<String, Object> reqMap) {
        return productManagementInfoDao.queryPageList(reqMap);
    }

    @Override
    public int queryCount(Map<String, Object> reqMap) {
        System.out.println("aaaaaaaaaaaaaaaaaaaa"+ reqMap);
        return productManagementInfoDao.queryCount(reqMap);
    }
}
