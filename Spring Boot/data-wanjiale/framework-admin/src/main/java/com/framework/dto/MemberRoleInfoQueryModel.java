package com.framework.dto;

/**
 * @Author: 表示作者是谁
 * @Description: 描述
 */
public class MemberRoleInfoQueryModel {
    /**
     * 当前页码
     */
    private String page;
    /**
     * 每页记录
     */
    private String limit;
    private String roleName;
    private Integer status;

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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
