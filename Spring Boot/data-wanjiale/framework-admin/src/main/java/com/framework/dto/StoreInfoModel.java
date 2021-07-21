package com.framework.dto;

import java.util.Date;

/**
 * @Author: liwan
 * @Description:
 * @Date: create in 2021/7/15 9:02
 */
public class StoreInfoModel {

    /**
     * 当前页码
     */
    private String page;
    /**
     * 每页记录
     */
    private String limit;


    private int shopId;		            //序号
    private String shopCategory;	    //网店平台类别
    private String shopUrl;		        //网址
    private String account;		        //账号
    private String password;		    //密码
    private int status;		            //状态
    private Date updateTime;		    //修改时间
    private String updateBy;		    //修改人
    private Date createTime;	        //创建时间
    private String createBy;	        //创建人

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getShopCategory() {
        return shopCategory;
    }

    public void setShopCategory(String shopCategory) {
        this.shopCategory = shopCategory;
    }

    public String getShopUrl() {
        return shopUrl;
    }

    public void setShopUrl(String shopUrl) {
        this.shopUrl = shopUrl;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }
}
