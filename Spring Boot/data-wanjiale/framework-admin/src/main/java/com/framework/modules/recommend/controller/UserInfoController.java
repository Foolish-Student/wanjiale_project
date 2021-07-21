package com.framework.modules.recommend.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.framework.modules.recommend.entity.UserInfoEntity;
import com.framework.modules.recommend.service.UserInfoService;
import com.framework.common.utils.PageUtils;
import com.framework.common.utils.R;



/**
 * InnoDB free: 352256 kB
 *
 * @author MIT
 * @email framework@gmail.com
 * @date 2021-06-06 09:17:04
 */
@RestController
@RequestMapping("recommend/userinfo")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{userId}")
    public R info(@PathVariable("userId") Integer userId){
        UserInfoEntity userInfo = userInfoService.selectById(userId);

        return R.ok().put("userInfo", userInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody UserInfoEntity userInfo){
        userInfoService.insert(userInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody UserInfoEntity userInfo){
        userInfoService.updateAllColumnById(userInfo);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] userIds){
        userInfoService.deleteBatchIds(Arrays.asList(userIds));

        return R.ok();
    }


    @RequestMapping("/init")
    public R initData(){
        List<UserInfoEntity> userList   = new ArrayList<>();
        UserInfoEntity  user;
        // 根据路 t_user_course_score_ref表用户id，初始化数据
        List<Integer> resultList = userInfoService.getUserIdList();
        if (!CollectionUtils.isEmpty(resultList)){
            for (Integer userId : resultList){
                user = new  UserInfoEntity();
                user.setUserId(userId);
                user.setLoginName("LoginName_"+userId);
                user.setPassword("pwd_"+userId);
                user.setUserName("UserName_"+userId);
                userList.add(user);
            }

            if (!CollectionUtils.isEmpty(userList)){
                userInfoService.insertBatch(userList);
            }
        }

        return R.ok().put("userList", userList.size());
    }

}
