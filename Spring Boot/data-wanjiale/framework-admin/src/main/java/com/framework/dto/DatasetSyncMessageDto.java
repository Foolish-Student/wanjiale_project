package com.framework.dto;

import java.util.Date;

public class DatasetSyncMessageDto {
    private String datasetId;
    private String dataSourceId;
    private String dbType;
    private String datasetNameCn;
    private String datasetNameEn;
    private String dbName;
    private String schemaName;
    private Date createTime;
    private String syncAction;//insert, update ,delete
    private String dataType;//DATASOURCE, DATASET
    private String tenantId;//租户id
    private String tenantName;
    private String userId;
    private String userName;
    private String resourceScope;

    public String getDatasetId() {
        return datasetId;
    }

    public void setDatasetId(String datasetId) {
        this.datasetId = datasetId;
    }

    public String getDataSourceId() {
        return dataSourceId;
    }

    public void setDataSourceId(String dataSourceId) {
        this.dataSourceId = dataSourceId;
    }

    public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    public String getDatasetNameCn() {
        return datasetNameCn;
    }

    public void setDatasetNameCn(String datasetNameCn) {
        this.datasetNameCn = datasetNameCn;
    }

    public String getDatasetNameEn() {
        return datasetNameEn;
    }

    public void setDatasetNameEn(String datasetNameEn) {
        this.datasetNameEn = datasetNameEn;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSyncAction() {
        return syncAction;
    }

    public void setSyncAction(String syncAction) {
        this.syncAction = syncAction;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getResourceScope() {
        return resourceScope;
    }

    public void setResourceScope(String resourceScope) {
        this.resourceScope = resourceScope;
    }
}
