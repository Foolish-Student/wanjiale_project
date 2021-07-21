package com.framework.modules.recommend.controller;

import com.framework.common.utils.PageUtils;
import com.framework.common.utils.R;
import com.framework.modules.recommend.entity.UserCourseScoreRefEntity;
import com.framework.modules.recommend.service.UserCourseScoreRefService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 用户课程评分表; InnoDB free: 352256 kB
 *
 * @author MIT
 * @email framework@gmail.com
 * @date 2021-06-06 09:17:04
 */
@RestController
@RequestMapping("recommend/usercoursescoreref")
public class UserCourseScoreRefController {
    private static final Logger logger = LoggerFactory.getLogger(UserCourseScoreRefController.class);
    @Autowired
    private UserCourseScoreRefService userCourseScoreRefService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = userCourseScoreRefService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{userId}")
    public R info(@PathVariable("userId") Integer userId) {
        UserCourseScoreRefEntity userCourseScoreRef = userCourseScoreRefService.selectById(userId);

        return R.ok().put("userCourseScoreRef", userCourseScoreRef);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody UserCourseScoreRefEntity userCourseScoreRef) {
        userCourseScoreRefService.insert(userCourseScoreRef);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody UserCourseScoreRefEntity userCourseScoreRef) {
        userCourseScoreRefService.updateAllColumnById(userCourseScoreRef);//全部更新

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] userIds) {
        userCourseScoreRefService.deleteBatchIds(Arrays.asList(userIds));

        return R.ok();
    }


    @RequestMapping("/init")
    public R initData(@RequestParam("fileUrl") String fileUrl) {
        // 根据路径初始化数据  t_user_course_score_ref
        List<UserCourseScoreRefEntity> resultList = getInitDataList(fileUrl);
        if (!CollectionUtils.isEmpty(resultList)) {
            userCourseScoreRefService.insertBatch(resultList);
        }

        return R.ok();
    }


    public List getInitDataList(String fileUrl) {
        List<UserCourseScoreRefEntity> resultList = new ArrayList<>();

        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null; //用于包装InputStreamReader,提高处理性能。因为BufferedReader有缓冲的，而InputStreamReader没有。
        try {
            String str = "";
            String str1 = "";
            UserCourseScoreRefEntity userCourseScoreRefEntity;

            // "c:\\小志.txt"
            fileUrl = "D:\\推荐系统初始化数据TXT版.txt";
            fis = new FileInputStream(fileUrl);// FileInputStream
            // 从文件系统中的某个文件中获取字节
            isr = new InputStreamReader(fis);// InputStreamReader 是字节流通向字符流的桥梁,
            br = new BufferedReader(isr);// 从字符输入流中读取文件中的内容,封装了一个new InputStreamReader的对象
            while ((str = br.readLine()) != null) {
                //str1 += str + "\n";

                String[] rowData = str.split("\\s+");
                userCourseScoreRefEntity = new UserCourseScoreRefEntity();
                logger.info(" rowData[0]: {},rowData[1]: {},rowData[2]: {},rowData[3]: {}", rowData[0], rowData[1], rowData[2], rowData[3]);
                // i:1,  rowData: [196	242	3	881250949]
                // i:2,  rowData: [186	302	3	891717742]

                userCourseScoreRefEntity.setUserId(Integer.parseInt(rowData[0].trim()));
                userCourseScoreRefEntity.setCourseId(Integer.parseInt(rowData[1].trim()));
                userCourseScoreRefEntity.setCourseScore(Integer.parseInt(rowData[2].trim()));
                userCourseScoreRefEntity.setCreateTime(Integer.parseInt(rowData[3].trim()));
                resultList.add(userCourseScoreRefEntity);

            }

            // 当读取的一行不为空时,把读到的str的值赋给str1
            // System.out.println(str1);// 打印出str1
        } catch (FileNotFoundException e) {
            System.out.println("找不到指定文件");
        } catch (IOException e) {
            System.out.println("读取文件失败");
        } finally {
            try {
                br.close();
                isr.close();
                fis.close();
                // 关闭的时候最好按照先后顺序关闭最后开的先关闭所以先关s,再关n,最后关m
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return resultList;
    }


}
