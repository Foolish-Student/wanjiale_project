package com.framework.dto;

import java.io.Serializable;

public class IdDto implements Serializable {
    // 表数据ID
    private String tableId;

    // 审批人
    private String pendingApproval;

    // 审批描述
    private String remark;

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getPendingApproval() {
        return pendingApproval;
    }

    public void setPendingApproval(String pendingApproval) {
        this.pendingApproval = pendingApproval;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
