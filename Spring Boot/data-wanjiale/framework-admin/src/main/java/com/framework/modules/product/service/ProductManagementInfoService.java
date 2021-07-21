package com.framework.modules.product.service;

import com.framework.dto.ProductInfoModel;
import com.framework.dto.ProductPageInfoModel;
import com.framework.dto.ProductQueryInfoModel;
import com.framework.modules.product.entity.ProductManagementInfoEntity;
import com.framework.modules.store.entity.StoreInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * @Author: liwan
 * @Description: 产品管理接口类
 * @Date: create in 2021/7/13 8:59
 */

public interface ProductManagementInfoService {
    //批量添加
    int insProductAll(ProductManagementInfoEntity list);

    //修改产品
    int upProduct(ProductManagementInfoEntity productManagementInfoEntity);

    //删除产品
    int delProduct(List<Integer> list);

    ProductManagementInfoEntity  query(Map<String, Object> params);

    ProductQueryInfoModel queryinfo(Integer id);


    List<ProductManagementInfoEntity> queryPageList(Map<String, Object> reqMap);
    int queryCount( Map<String, Object> reqMap);
}
