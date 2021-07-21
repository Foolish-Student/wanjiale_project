package com.framework.modules.recommend.controller;


import com.framework.common.utils.PageUtils;
import com.framework.common.utils.R;
import com.framework.modules.recommend.entity.CourseInfoEntity;
import com.framework.modules.recommend.service.CourseInfoService;
import com.framework.user.SsoService;
import com.framework.user.SsoUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * InnoDB free: 352256 kB
 *
 * @author MIT
 * @email framework@gmail.com
 * @date 2021-06-06 09:17:03
 */
@RestController
@RequestMapping("recommend/courseinfo")
public class CourseInfoController {
    private static final Logger logger = LoggerFactory.getLogger(CourseInfoController.class);

    @Autowired
    private CourseInfoService courseInfoService;

    @Autowired
    public SsoService ssoService;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = courseInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{courseId}")
    public R info(@PathVariable("courseId") Integer courseId){
        CourseInfoEntity courseInfo = courseInfoService.selectById(courseId);

        return R.ok().put("courseInfo", courseInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CourseInfoEntity courseInfo){
        courseInfoService.insert(courseInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CourseInfoEntity courseInfo){
        courseInfoService.updateAllColumnById(courseInfo);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] courseIds){
        courseInfoService.deleteBatchIds(Arrays.asList(courseIds));

        return R.ok();
    }

    @RequestMapping("/init")
    public R initData(){
        List<CourseInfoEntity> courseList   = new ArrayList<>();
        CourseInfoEntity  courseInfo;
        // 根据路 t_user_course_score_ref表用户id，初始化数据
        List<Integer> resultList = courseInfoService.getCourseIdList();
        if (!CollectionUtils.isEmpty(resultList)){
            for (Integer courseId : resultList){
                courseInfo = new  CourseInfoEntity();
                courseInfo.setCourseId(courseId);
                courseInfo.setCourseTitle("可信软件工程能力赋能课程-"+courseId);
                courseInfo.setCourseDesc("可信软件工程能力赋能课程-"+courseId);
                courseInfo.setCourseJpegUrl("CourseJpegUrl-"+courseId);
                courseInfo.setTechnicalLabel("HTML/CSS");
                courseInfo.setExtendedLabel("其他");
                courseInfo.setAscriptionDepartment("@北京HIG研发部");
                courseInfo.setSystemScore("10.0");
                courseInfo.setPraisePoints(23);
                courseInfo.setSubscribersTotal(78);
                courseInfo.setCreateBy("100");
                courseInfo.setCreateTime(new Date());
                courseInfo.setUpdateBy("100");
                courseInfo.setUpdateTime(new Date());
                courseList.add(courseInfo);
            }

            if (!CollectionUtils.isEmpty(courseList)){
                courseInfoService.insertBatch(courseList);
            }
        }

        return R.ok().put("courseList", courseList.size());
    }

    /**
     * 功能描述:  猜你喜欢的课程接口
     * @author tangfl
     * @date 2021/6/7
     * @param
     * @return com.framework.common.utils.R
     */
    @RequestMapping("/guessLikes")
    public R guessYouLikeCourses(){
        // 获取当前用户信息
        SsoUser user  = ssoService.getSession();
        logger.info("CourseInfoController...guessYouLikeCourses()...userId： {}; loginName :{}",user.getUserId(),user.getLoginName());

        //从redis中获取当前用户的课程评分结果
        List<Integer> courseList   = new LinkedList<>();
        Set<ZSetOperations.TypedTuple<Object>>  redisSet;
        if (redisTemplate.hasKey("tjuser:"+ user.getUserId())){
            // redisTemplate.opsForZSet().reverseRangeWithScores(key, start,end)
            redisSet  = redisTemplate.opsForZSet().reverseRangeByScoreWithScores("tjuser:"+ user.getUserId(),0,100,0,10);
            logger.info("CourseInfoController...guessYouLikeCourses()...redisSet.size： {}",redisTemplate.opsForZSet().size("tjuser:"+ user.getUserId()));

            for (ZSetOperations.TypedTuple<Object> temp : redisSet){
                logger.info("CourseInfoController...guessYouLikeCourses()...temp.getValue()： {} ,temp.getScore()： {}",temp.getValue(),temp.getScore());
                courseList.add(Integer.valueOf(temp.getValue().toString().trim()));
            }
        }

        logger.info("CourseInfoController...guessYouLikeCourses()...courseList.size()： {}",courseList.size());
        if (courseList.size() > 0){
            // 通过用户id在Redis获取喜欢的课程id列表，按照分数从高到低排序
            logger.info("CourseInfoController...guessYouLikeCourses()...courseList： {}",courseList);
        }

        // 通过课程id查询课程列表信息返回给前端
        List<CourseInfoEntity>  resultList = null;
        if (!CollectionUtils.isEmpty(courseList)){
            resultList = courseInfoService.getCourseListById(courseList);
        }

        return R.ok().put("data",resultList);
    }


    /**
     * 功能描述:  猜你喜欢的课程接口,测试接口，绕过用户鉴权
     * @author tangfl
     * @date 2021/6/9
     * @param
     * @return com.framework.common.utils.R
     */
    @RequestMapping("/guessLike/{userId}")
    public R guessYouLikeCoursesByGet(@PathVariable("userId") String userId){
        // 获取当前用户信息
        logger.info("CourseInfoController...guessYouLikeCoursesByGet()...userId： {}",userId);

        //将推荐结果存入redis
        List<Integer> courseList   = new LinkedList<>();
        Set<ZSetOperations.TypedTuple<Object>>  redisSet;
        if (redisTemplate.hasKey("tjuser:"+ userId)){
            redisSet  = redisTemplate.opsForZSet().reverseRangeByScoreWithScores("tjuser:"+ userId,0,100,0,10);
            logger.info("CourseInfoController...guessYouLikeCoursesByGet()...redisSet.size： {}",redisTemplate.opsForZSet().size("tjuser:"+ userId));

            for (ZSetOperations.TypedTuple<Object> temp : redisSet){
                logger.info("CourseInfoController...guessYouLikeCoursesByGet()...temp.getValue()： {} ,temp.getScore()： {}",temp.getValue(),temp.getScore());
                courseList.add(Integer.valueOf(temp.getValue().toString().trim()));
            }
        }else{
            logger.info("CourseInfoController...guessYouLikeCoursesByGet()... redis not exist this userId data");
        }

        if (courseList.size() > 0){
            // 通过用户id在Redis获取喜欢的课程id列表，按照分数从高到低排序
            logger.info("CourseInfoController...guessYouLikeCoursesByGet()...courseList： {}",courseList);
        }

        // 通过课程id查询课程列表信息返回给前端
        List<CourseInfoEntity>  resultList = null;
        if (!CollectionUtils.isEmpty(courseList)){
            resultList = courseInfoService.getCourseListById(courseList);
        }

        return R.ok().put("data",resultList);
    }


}
