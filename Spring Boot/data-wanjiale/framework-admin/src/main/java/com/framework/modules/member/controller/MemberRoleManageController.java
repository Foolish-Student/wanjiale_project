package com.framework.modules.member.controller;

import com.alibaba.fastjson.JSON;
import com.framework.common.utils.R;
import com.framework.dto.MemberRoleInfoQueryModel;
import com.framework.dto.MemberUserInfoQueryModel;
import com.framework.modules.member.entity.MemberRoleInfoEntity;
import com.framework.modules.member.entity.MemberUserInfoEntity;
import com.framework.modules.member.service.MemberRoleInfoService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 会员角色管理
 * @Author: 表示作者是谁
 * @Description: 描述：角色
 */

@RestController
@RequestMapping("/member/role")
public class MemberRoleManageController {
    private static final Logger logger = LoggerFactory.getLogger(MemberRoleManageController.class);

    // 所有的需要引用service类，或dao类，全部放在这里，用@Autowired注解注入
    @Autowired
    private MemberRoleInfoService memberRoleInfoService;

    /**
     * 单个详情信息
     * path路径传参示例,传递一个int类型变量
     */
    @RequestMapping("/info/{roleId}")
    public R info(@PathVariable("roleId") Integer roleId){
        logger.info("...MemberRoleManageController.info data..roleId  is {}", roleId);
        MemberRoleInfoEntity roleInfo = memberRoleInfoService.selectById(roleId);
        return R.ok().put("roleInfo", roleInfo);
    }
    /**
     * 新增
     * RequestBody传参示例，传递一个json对象
     */
    @RequestMapping("/save")
    public R save(@RequestBody MemberRoleInfoEntity roleInfo){
//        userInfo.setPassword("password");
        memberRoleInfoService.insert(roleInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MemberRoleInfoEntity roleInfo){
        memberRoleInfoService.updateAllColumnById(roleInfo);//全部更新

        return R.ok();
    }
    /**
     * 删除（批量）
     * RequestBody传参示例，传递一个数组
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] roleIds){
        memberRoleInfoService.deleteBatchIds(Arrays.asList(roleIds));

        return R.ok();
    }

    /**
     * 启用用户
     * RequestBody传参示例，传递一个数组
     * “启用”英文为"enable" ，禁用”英文为 "disable" 。
     */
    @RequestMapping("/enable")
    public R enableRole(@RequestBody Integer[] roleIds){
        memberRoleInfoService.enableBatchIds(Arrays.asList(roleIds));

        return R.ok();
    }
    /**
     * 禁用用户
     * RequestBody传参示例，传递一个数组
     * “启用”英文为"enable" ，禁用”英文为 "disable" 。
     */
    @RequestMapping("/disable")
    public R disableRole(@RequestBody Integer[] roleIds){
        memberRoleInfoService.disableBatchIds(Arrays.asList(roleIds));

        return R.ok();
    }

    /**
     * 角色列表查询
     * RequestBody传参示例，传递一个json对象
     */
    @RequestMapping("/list")
    public R list(@RequestBody MemberRoleInfoQueryModel memberRoleInfoQueryModel){
        if (memberRoleInfoQueryModel == null) {
            return R.error("请求参数不能为空!");
        }

        // 封装分页参数查询
        int currPage = 1; // 当前页码
        int pageSize = 10; // 每页记录
        int start = 0; // 开始记录数
        if (!StringUtils.isEmpty(memberRoleInfoQueryModel.getLimit())) {
            pageSize = Integer.parseInt(memberRoleInfoQueryModel.getLimit());
        }
        if (!StringUtils.isEmpty(memberRoleInfoQueryModel.getPage())) {
            currPage = Integer.parseInt(memberRoleInfoQueryModel.getPage());
            start = (currPage - 1) * pageSize;
        }
        Map<String, Object> reqMap = new HashMap<>();
        reqMap.put("start", start);
        reqMap.put("limit", pageSize);

        // 封装页面查询参数，去mysql库查询
        reqMap.put("roleName", memberRoleInfoQueryModel.getRoleName());
        reqMap.put("status", memberRoleInfoQueryModel.getStatus());

        List<MemberRoleInfoEntity> data = memberRoleInfoService.queryPageList(reqMap);

        // 查询记录总数
        int count = memberRoleInfoService.queryCount(reqMap);


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

        List<MemberRoleInfoEntity> data = memberRoleInfoService.queryPageList(reqMap);

        // 查询记录总数
        int count = memberRoleInfoService.queryCount(reqMap);

        Map<String, Object> map = new HashMap<>();
        map.put("totalCount", count);
        map.put("list", data);

        return R.ok().put("page", map);
    }
}
