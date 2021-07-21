package com.framework.modules.recommend.dao;

import com.framework.modules.recommend.entity.CourseInfoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * InnoDB free: 352256 kB
 * 
 * @author MIT
 * @email framework@gmail.com
 * @date 2021-06-06 09:17:03
 */
@Repository
public interface CourseInfoDao extends BaseMapper<CourseInfoEntity> {

    List<Integer> getCourseIdList();

    List<CourseInfoEntity> getCourseListById(@Param("list") List<Integer> courseIdList);
	
}
