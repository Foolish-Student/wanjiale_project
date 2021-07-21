package com.framework.modules.recommend.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户课程评分表; InnoDB free: 352256 kB
 * 
 * @author MIT
 * @email framework@gmail.com
 * @date 2021-06-06 09:17:04
 */
@TableName("t_user_course_score_ref")
public class UserCourseScoreRefEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户id
	 */
	@TableId(type = IdType.UUID)
	private Integer userId;
	/**
	 * 课程id
	 */
	private Integer courseId;
	/**
	 * 系统评分 1-5
	 */
	private Integer courseScore;
	/**
	 * 时间戳
	 */
	private Integer createTime;

	/**
	 * 设置：用户id
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户id
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置：课程id
	 */
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	/**
	 * 获取：课程id
	 */
	public Integer getCourseId() {
		return courseId;
	}
	/**
	 * 设置：系统评分 1-5
	 */
	public void setCourseScore(Integer courseScore) {
		this.courseScore = courseScore;
	}
	/**
	 * 获取：系统评分 1-5
	 */
	public Integer getCourseScore() {
		return courseScore;
	}
	/**
	 * 设置：时间戳
	 */
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：时间戳
	 */
	public Integer getCreateTime() {
		return createTime;
	}
}
