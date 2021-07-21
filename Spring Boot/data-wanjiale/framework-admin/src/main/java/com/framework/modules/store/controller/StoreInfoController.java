package com.framework.modules.store.controller;

import com.alibaba.fastjson.JSON;
import com.framework.dto.MemberRoleInfoQueryModel;
import com.framework.dto.StoreInfoModel;
import com.framework.modules.member.entity.MemberRoleInfoEntity;
import com.framework.modules.product.controller.ProductManagementInfoController;
import com.framework.modules.store.entity.StoreInfoEntity;
import com.framework.modules.store.service.StoreInfoService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.framework.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: liwan
 * @Description:
 * @Date: create in 2021/7/13 13:31
 */
@RestController
public class StoreInfoController {
    private static final Logger logger = LoggerFactory.getLogger(ProductManagementInfoController.class);

    @Autowired
    private StoreInfoService storeInfoService;

    /*
     * @Author: liwan
     * @Description: 新增网店
     * @Params: storeInfoEntity
     * @Return: {@link com.framework.common.utils.R}
     * @DateTime: 2021/7/13 13:56
     */
    @RequestMapping(value = "/store/add", method = RequestMethod.POST)
    public R addStore(@RequestBody StoreInfoEntity storeInfoEntity) {
        logger.info("...StoreInfoService.addStore...request params is {}", JSON.toJSONString(storeInfoEntity));
        int ruslt = storeInfoService.addStore(storeInfoEntity);
        return R.ok().put("ruslt", ruslt);
    }

    /*
    * @Author: liwan
    * @Description: 修改网店
    * @Params: storeInfoEntity
    * @Return: {@link com.framework.common.utils.R}
    * @DateTime: 2021/7/13 14:02
    */
    @RequestMapping(value = "/store/up", method = RequestMethod.POST)
    public R upStore(@RequestBody StoreInfoEntity storeInfoEntity) {
        logger.info("...StoreInfoService.upStore...request params is {}", JSON.toJSONString(storeInfoEntity));
        int ruslt = storeInfoService.upStore(storeInfoEntity);
        return R.ok().put("ruslt", ruslt);
    }

    /*
     * @Author: liwan
     * @Description: 删除网店
     * @Params: list
     * @Return: {@link com.framework.common.utils.R}
     * @DateTime: 2021/7/14 8:51
     */
    @RequestMapping(value = "/store/del", method = RequestMethod.POST)
    public R delStore(@RequestBody List<Integer> list) {
        logger.info("...StoreInfoService.delStore...request params is {}", JSON.toJSONString(list));
        int ruslt = storeInfoService.delStore(list);
        return R.ok().put("ruslt", ruslt);
    }

    /*
     * @Author: liwan
     * @Description: 批量启动
     * @Params: list
     * @Return: {@link com.framework.common.utils.R}
     * @DateTime: 2021/7/14 10:44
     */
    @RequestMapping(value = "/store/start", method = RequestMethod.POST)
    public R start(@RequestBody List<Integer> list) {
        logger.info("...StoreInfoService.start...request params is {}", JSON.toJSONString(list));
        int ruslt = storeInfoService.start(list);
        return R.ok().put("ruslt", ruslt);
    }

    /*
     * @Author: liwan
     * @Description: 批量禁用
     * @Params: list
     * @Return: {@link com.framework.common.utils.R}
     * @DateTime: 2021/7/14 10:48
     */
    @RequestMapping(value = "/store/stop", method = RequestMethod.POST)
    public R stop(@RequestBody List<Integer> list) {
        logger.info("...StoreInfoService.stop...request params is {}", JSON.toJSONString(list));
        int ruslt = storeInfoService.stop(list);
        return R.ok().put("ruslt", ruslt);
    }



    /**
     * 角色列表查询
     * RequestBody传参示例，传递一个json对象
     */
    @RequestMapping("/list")
    public R list(@RequestBody StoreInfoModel storeInfoModel){
        if (storeInfoModel == null) {
            return R.error("请求参数不能为空!");
        }

        // 封装分页参数查询
        int currPage = 1; // 当前页码
        int pageSize = 10; // 每页记录
        int start = 0; // 开始记录数
        if (!StringUtils.isEmpty(storeInfoModel.getLimit())) {
            pageSize = Integer.parseInt(storeInfoModel.getLimit());
        }
        if (!StringUtils.isEmpty(storeInfoModel.getPage())) {
            currPage = Integer.parseInt(storeInfoModel.getPage());
            start = (currPage - 1) * pageSize;
        }
        Map<String, Object> reqMap = new HashMap<>();
        reqMap.put("start", start);
        reqMap.put("limit", pageSize);

        // 封装页面查询参数，去mysql库查询
        reqMap.put("shopId", storeInfoModel.getShopId());
        reqMap.put("shopCategory", storeInfoModel.getShopCategory());
        reqMap.put("shopUrl", storeInfoModel.getShopUrl());
        reqMap.put("account", storeInfoModel.getAccount());
        reqMap.put("password", storeInfoModel.getPassword());
        reqMap.put("status", storeInfoModel.getStatus());
        reqMap.put("updateTime", storeInfoModel.getUpdateTime());
        reqMap.put("updateBy", storeInfoModel.getUpdateBy());

        List<StoreInfoEntity> data = storeInfoService.queryPageList(reqMap);

        // 查询记录总数
        int count = storeInfoService.queryCount(reqMap);


        Map<String, Object> map = new HashMap<>();
        map.put("totalCount", count);
        map.put("pageSize", pageSize);
        map.put("totalPage", (int) Math.ceil((double) count / pageSize));
        map.put("currPage", currPage);
        map.put("list", data);

        return R.ok().put("page", map);
    }

    @RequestMapping("/rolelist")
    public R getRolelist(@RequestBody Map<String, Object> reqMap){
        // 封装分页参数查询
        int pageSize = 100; // 每页记录
        int start = 0; // 开始记录数

        //Map<String, Object> reqMap = new HashMap<>();
        reqMap.put("start", start);
        reqMap.put("limit", pageSize);

        List<StoreInfoEntity> data = storeInfoService.queryPageList(reqMap);

        // 查询记录总数
        int count = storeInfoService.queryCount(reqMap);

        Map<String, Object> map = new HashMap<>();
        map.put("totalCount", count);
        map.put("list", data);

        return R.ok().put("page", map);
    }
}
