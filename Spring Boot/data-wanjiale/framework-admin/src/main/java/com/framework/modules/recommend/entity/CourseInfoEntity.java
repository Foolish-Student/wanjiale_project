package com.framework.modules.recommend.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * InnoDB free: 352256 kB
 * 
 * @author MIT
 * @email framework@gmail.com
 * @date 2021-06-06 09:17:03
 */
@TableName("t_course_info")
public class CourseInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 课程id
	 */
	@TableId(type = IdType.UUID)
	private Integer courseId;
	/**
	 * 标题
	 */
	private String courseTitle;
	/**
	 * 图片地址
	 */
	private String courseJpegUrl;
	/**
	 * 课程描述
	 */
	private String courseDesc;
	/**
	 * 技术标签
	 */
	private String technicalLabel;
	/**
	 * 扩展标签
	 */
	private String extendedLabel;
	/**
	 * 点赞数
	 */
	private Integer praisePoints;
	/**
	 * 学习人数
	 */
	private Integer subscribersTotal;
	/**
	 * 系统评分
	 */
	private String systemScore;
	/**
	 * 归属部门
	 */
	private String ascriptionDepartment;
	/**
	 * 创建人
	 */
	private String createBy;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新人
	 */
	private String updateBy;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	/**
	 * 状态   0：有效  1： 无效
	 */
	private Integer status;

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
	 * 设置：标题
	 */
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	/**
	 * 获取：标题
	 */
	public String getCourseTitle() {
		return courseTitle;
	}
	/**
	 * 设置：图片地址
	 */
	public void setCourseJpegUrl(String courseJpegUrl) {
		this.courseJpegUrl = courseJpegUrl;
	}
	/**
	 * 获取：图片地址
	 */
	public String getCourseJpegUrl() {
		return courseJpegUrl;
	}
	/**
	 * 设置：课程描述
	 */
	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}
	/**
	 * 获取：课程描述
	 */
	public String getCourseDesc() {
		return courseDesc;
	}
	/**
	 * 设置：技术标签
	 */
	public void setTechnicalLabel(String technicalLabel) {
		this.technicalLabel = technicalLabel;
	}
	/**
	 * 获取：技术标签
	 */
	public String getTechnicalLabel() {
		return technicalLabel;
	}
	/**
	 * 设置：扩展标签
	 */
	public void setExtendedLabel(String extendedLabel) {
		this.extendedLabel = extendedLabel;
	}
	/**
	 * 获取：扩展标签
	 */
	public String getExtendedLabel() {
		return extendedLabel;
	}
	/**
	 * 设置：点赞数
	 */
	public void setPraisePoints(Integer praisePoints) {
		this.praisePoints = praisePoints;
	}
	/**
	 * 获取：点赞数
	 */
	public Integer getPraisePoints() {
		return praisePoints;
	}
	/**
	 * 设置：学习人数
	 */
	public void setSubscribersTotal(Integer subscribersTotal) {
		this.subscribersTotal = subscribersTotal;
	}
	/**
	 * 获取：学习人数
	 */
	public Integer getSubscribersTotal() {
		return subscribersTotal;
	}
	/**
	 * 设置：系统评分
	 */
	public void setSystemScore(String systemScore) {
		this.systemScore = systemScore;
	}
	/**
	 * 获取：系统评分
	 */
	public String getSystemScore() {
		return systemScore;
	}
	/**
	 * 设置：归属部门
	 */
	public void setAscriptionDepartment(String ascriptionDepartment) {
		this.ascriptionDepartment = ascriptionDepartment;
	}
	/**
	 * 获取：归属部门
	 */
	public String getAscriptionDepartment() {
		return ascriptionDepartment;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreateBy() {
		return createBy;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：更新人
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	/**
	 * 获取：更新人
	 */
	public String getUpdateBy() {
		return updateBy;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：状态   0：有效  1： 无效
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态   0：有效  1： 无效
	 */
	public Integer getStatus() {
		return status;
	}
}
