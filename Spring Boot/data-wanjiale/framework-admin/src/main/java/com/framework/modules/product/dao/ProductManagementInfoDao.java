package com.framework.modules.product.dao;

import com.framework.dto.ProductInfoModel;
import com.framework.dto.ProductPageInfoModel;
import com.framework.dto.ProductQueryInfoModel;
import com.framework.modules.product.entity.ProductManagementInfoEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author: liwan
 * @Description: 产品管理持久化层
 * @Date: create in 2021/7/13 9:01
 */
@Repository
public interface ProductManagementInfoDao {
    //添加
    int insProductAll(ProductManagementInfoEntity list);

    //修改产品
    int upProduct(ProductManagementInfoEntity productManagementInfoEntity);

    //删除产品
    int delProduct(List<Integer> list);

    //查询@Param("params")
    ProductManagementInfoEntity  query(Map<String, Object> params);

    //明细查询
    ProductQueryInfoModel queryinfo(@Param("id") Integer id);

    List<ProductManagementInfoEntity> queryPageList( Map<String, Object> reqMap);
    int queryCount( Map<String, Object> reqMap);
}
