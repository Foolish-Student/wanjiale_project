package com.framework.dto;

import java.io.Serializable;

public class DataIdDto implements Serializable {
    // 数据ID
    private String dataId;

    // 审批人
    private String pendingApproval;

    // 审批描述
    private String remark;

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
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
