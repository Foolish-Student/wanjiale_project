package com.framework.modules.member.controller;

import com.alibaba.fastjson.JSON;
import com.framework.common.utils.R;
import com.framework.dto.MemberUserInfoQueryModel;
import com.framework.modules.member.entity.MemberUserInfoEntity;
import com.framework.modules.member.service.MemberUserInfoService;
import io.swagger.annotations.Api;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


/**
 * 会员管理
 *
 * @author MIT
 * @email framework@gmail.com
 * @date 2021-06-06 09:17:04
 */
@RestController
@RequestMapping("/member/user")
public class MemberUserManageController {
    private static final Logger logger = LoggerFactory.getLogger(MemberUserManageController.class);

    // 所有的需要引用service类，或dao类，全部放在这里，用@Autowired注解注入
    @Autowired
    private MemberUserInfoService memberUserInfoService;

    /**
     * 子账户列表
     * RequestBody传参示例，传递一个json对象
     */
    @RequestMapping("/list")
    public R list(@RequestBody MemberUserInfoQueryModel memberUserInfoQueryModel){

        logger.info("...MemberUserManageController.list...request params is {}", JSON.toJSONString(memberUserInfoQueryModel));

        if (memberUserInfoQueryModel == null) {
            return R.error("请求参数不能为空!");
        }

        // 封装分页参数查询
        int currPage = 1; // 当前页码
        int pageSize = 10; // 每页记录
        int start = 0; // 开始记录数
        if (!StringUtils.isEmpty(memberUserInfoQueryModel.getLimit())) {
            pageSize = Integer.parseInt(memberUserInfoQueryModel.getLimit());
        }
        if (!StringUtils.isEmpty(memberUserInfoQueryModel.getPage())) {
            currPage = Integer.parseInt(memberUserInfoQueryModel.getPage());
            start = (currPage - 1) * pageSize;
        }
        Map<String, Object> reqMap = new HashMap<>();
        reqMap.put("start", start);
        reqMap.put("limit", pageSize);

        // 封装页面查询参数，去mysql库查询
        reqMap.put("loginName", memberUserInfoQueryModel.getLoginName());
        reqMap.put("userName", memberUserInfoQueryModel.getUserName());
        reqMap.put("roleName", memberUserInfoQueryModel.getRoleName());
        reqMap.put("sex", memberUserInfoQueryModel.getSex());
        reqMap.put("mobile", memberUserInfoQueryModel.getSex());
        reqMap.put("status", memberUserInfoQueryModel.getStatus());

        List<MemberUserInfoEntity> data = memberUserInfoService.queryPageList(reqMap);

        // 查询记录总数
        int count = memberUserInfoService.queryCount(reqMap);
        logger.info("...MemberUserManageController.list data..count  is {}", count);

        Map<String, Object> map = new HashMap<>();
        map.put("totalCount", count);
        map.put("pageSize", pageSize);
        map.put("totalPage", (int) Math.ceil((double) count / pageSize));
        map.put("currPage", currPage);
        map.put("list", data);

        return R.ok().put("page", map);
    }


    @RequestMapping("/userlist")
    public R getUserlist(@RequestBody Map<String, Object> reqMap){
        logger.info("...MemberUserManageController.getUserlist ...start .....");
        // 封装分页参数查询
        int pageSize = 100; // 每页记录
        int start = 0; // 开始记录数

        //Map<String, Object> reqMap = new HashMap<>();
        reqMap.put("start", start);
        reqMap.put("limit", pageSize);

        List<MemberUserInfoEntity> data = memberUserInfoService.queryPageList(reqMap);

        // 查询记录总数
        int count = memberUserInfoService.queryCount(reqMap);
        logger.info("...MemberUserManageController.list data..count  is {}", count);

        Map<String, Object> map = new HashMap<>();
        map.put("totalCount", count);
        map.put("list", data);

        return R.ok().put("page", map);
    }


    /**
     * 单个详情信息
     * path路径传参示例,传递一个int类型变量
     */
    @RequestMapping("/info/{userId}")
    public R info(@PathVariable("userId") Integer userId){
        logger.info("...MemberUserManageController.info data..userId  is {}", userId);
        MemberUserInfoEntity userInfo = memberUserInfoService.selectById(userId);
        return R.ok().put("userInfo", userInfo);
    }

    /**
     * 保存
     * RequestBody传参示例，传递一个json对象
     */
    @RequestMapping("/save")
    public R save(@RequestBody MemberUserInfoEntity userInfo){
        userInfo.setPassword("password");
        memberUserInfoService.insert(userInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MemberUserInfoEntity userInfo){
        memberUserInfoService.updateAllColumnById(userInfo);//全部更新
        
        return R.ok();
    }

    /**
     * 修改密码
     */
    @RequestMapping("/update/password")
    public R updatePassword(@RequestBody Map<String,Object> reqMap){
        if(reqMap.get("userId") == null || reqMap.get("oldPassword") == null ||  reqMap.get("password") == null )
            return R.error("参数有误");
        int userId = (int)reqMap.get("userId");
        String oldPassword = (String) reqMap.get("oldPassword");
        String password = (String) reqMap.get("password");
        try{
            memberUserInfoService.updatePassword(userId,oldPassword,password);
        }catch (Exception e){
            return R.error(e.getMessage());
        }
        return R.ok();
    }
    /**
     * 删除
     * RequestBody传参示例，传递一个数组
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] userIds){
        memberUserInfoService.deleteBatchIds(Arrays.asList(userIds));

        return R.ok();
    }


    /**
     * 启用用户
     * RequestBody传参示例，传递一个数组
     * “启用”英文为"enable" ，禁用”英文为 "disable" 。
     */
    @RequestMapping("/enable")
    public R enableUser(@RequestBody Integer[] userIds){
        memberUserInfoService.enableBatchIds(Arrays.asList(userIds));

        return R.ok();
    }

    /**
     * 禁用用户
     * RequestBody传参示例，传递一个数组
     * “启用”英文为"enable" ，禁用”英文为 "disable" 。
     */
    @RequestMapping("/disable")
    public R disableUser(@RequestBody Integer[] userIds){
        memberUserInfoService.disableBatchIds(Arrays.asList(userIds));

        return R.ok();
    }



}
