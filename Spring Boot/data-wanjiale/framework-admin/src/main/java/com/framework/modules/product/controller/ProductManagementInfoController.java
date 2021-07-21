package com.framework.modules.product.controller;

import com.alibaba.fastjson.JSON;
import com.framework.common.utils.R;
import com.framework.dto.ProductInfoModel;
import com.framework.dto.ProductPageInfoModel;
import com.framework.dto.ProductQueryInfoModel;
import com.framework.modules.product.entity.ProductManagementInfoEntity;
import com.framework.modules.product.service.ProductManagementInfoService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: liwan
 * @Description: 产品管理
 * @Date: create in 2021/7/13 9:02
 */

@RestController
public class ProductManagementInfoController {
    private static final Logger logger = LoggerFactory.getLogger(ProductManagementInfoController.class);

    @Autowired
    private ProductManagementInfoService productManagementInfoService;

    /*
     * @Author: liwan
     * @Description: 批量添加产品
     * @Params: list
     * @Return: {@link com.framework.common.utils.R}
     * @DateTime: 2021/7/13 9:14
     */
    @RequestMapping(value = "/product/insall", method = RequestMethod.POST)
    public R insProduct(@RequestBody ProductManagementInfoEntity list) {
        logger.info("...ProductManagementInfoEntity.insProduct...request params is {}", JSON.toJSONString(list));
        int ruslt = productManagementInfoService.insProductAll(list);
        return R.ok().put("ruslt", ruslt);
    }

    /*
     * @Author: liwan
     * @Description: 修改产品信息
     * @Params: productManagementInfoEntity
     * @Return: {@link com.framework.common.utils.R}
     * @DateTime: 2021/7/13 10:23
     */
    @RequestMapping(value = "/product/up", method = RequestMethod.POST)
    public R upProduct(@RequestBody ProductManagementInfoEntity productManagementInfoEntity) {
        logger.info("...ProductManagementInfoEntity.upProduct...request params is {}", JSON.toJSONString(productManagementInfoEntity));
        int ruslt = productManagementInfoService.upProduct(productManagementInfoEntity);
        return R.ok().put("ruslt", ruslt);
    }

    /*
     * @Author: liwan
     * @Description: 批量删除产品
     * @Params: list
     * @Return: {@link com.framework.common.utils.R}
     * @DateTime: 2021/7/13 11:44
     */
    @RequestMapping(value = "/product/del", method = RequestMethod.POST)
    public R delProduct( @RequestBody List<Integer> list) {
        logger.info("...ProductManagementInfoEntity.delProduct...request params is {}", JSON.toJSONString(list));
        int ruslt = productManagementInfoService.delProduct(list);
        return R.ok().put("ruslt", ruslt);
    }

    /*
     * @Author: liwan
     * @Description: 查询
     * @Params: params
     * @Return: {@link com.framework.common.utils.R}
     * @DateTime: 2021/7/14 14:12
     */
    @RequestMapping(value = "/product/query", method = RequestMethod.POST)
    public R query(@RequestBody Map<String, Object> params) {
        logger.info("...ProductManagementInfoEntity.query...request params is {}", JSON.toJSONString(params));
        ProductManagementInfoEntity  result = productManagementInfoService.query(params);
        return R.ok().put("reult", result);
    }

//    @RequestMapping(value = "/product/queryinfo/{id}", method = RequestMethod.POST)
//    public R queryinfo(@PathVariable("id") Integer id) {
    @RequestMapping(value = "/product/queryinfo", method = RequestMethod.POST)
    public R queryinfo(@RequestBody Integer id) {
            System.out.println("啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊");
            logger.info("...ProductManagementInfoEntity.queryinfo...request id is {}", JSON.toJSONString(id));
            ProductQueryInfoModel result = productManagementInfoService.queryinfo(id);
            return R.ok().put("reult", result);
    }




    /**
     * 角色列表查询
     * RequestBody传参示例，传递一个json对象
     */
    @RequestMapping("/product/list")
    public R list(@RequestBody ProductPageInfoModel productPageInfoModel){
        logger.info("...ProductManagementInfoEntity.list...request productPageInfoModel is {}", JSON.toJSONString(productPageInfoModel));
        if (productPageInfoModel == null) {
            return R.error("请求参数不能为空!");
        }

        // 封装分页参数查询
        int currPage = 1; // 当前页码
        int pageSize = 10; // 每页记录
        int start = 0; // 开始记录数
        if (!StringUtils.isEmpty(productPageInfoModel.getLimit())) {
            pageSize = Integer.parseInt(productPageInfoModel.getLimit());
        }
        if (!StringUtils.isEmpty(productPageInfoModel.getPage())) {
            currPage = Integer.parseInt(productPageInfoModel.getPage());
            start = (currPage - 1) * pageSize;
        }
        Map<String, Object> reqMap = new HashMap<>();
        reqMap.put("start", start);
        reqMap.put("limit", pageSize);

        // 封装页面查询参数，去mysql库查询
        reqMap.put("id", productPageInfoModel.getId());
        reqMap.put("productNum", productPageInfoModel.getProductNum());
        reqMap.put("productModel", productPageInfoModel.getProductModel());
        reqMap.put("productName", productPageInfoModel.getProductName());
        reqMap.put("productCategory", productPageInfoModel.getProductCategory());
        reqMap.put("barCode", productPageInfoModel.getBarCode());
        reqMap.put("productUnit", productPageInfoModel.getProductUnit());
        reqMap.put("productSize", productPageInfoModel.getProductSize());
        reqMap.put("productPrice", productPageInfoModel.getProductPrice());
        reqMap.put("productInvoicePrice", productPageInfoModel.getProductInvoicePrice());

        List<ProductManagementInfoEntity> data = productManagementInfoService.queryPageList(reqMap);

        // 查询记录总数
        int count = productManagementInfoService.queryCount(reqMap);


        Map<String, Object> map = new HashMap<>();
        map.put("totalCount", count);
        map.put("pageSize", pageSize);
        map.put("totalPage", (int) Math.ceil((double) count / pageSize));
        map.put("currPage", currPage);
        map.put("list", data);

        return R.ok().put("page", map);
    }

    @RequestMapping("/product/rolelist")
    public R getRolelist(@RequestBody Map<String, Object> reqMap){
        // 封装分页参数查询
        int pageSize = 100; // 每页记录
        int start = 0; // 开始记录数

        //Map<String, Object> reqMap = new HashMap<>();
        reqMap.put("start", start);
        reqMap.put("limit", pageSize);

        List<ProductManagementInfoEntity> data = productManagementInfoService.queryPageList(reqMap);

        // 查询记录总数
        int count = productManagementInfoService.queryCount(reqMap);

        Map<String, Object> map = new HashMap<>();
        map.put("totalCount", count);
        map.put("list", data);

        return R.ok().put("page", map);
    }

}
