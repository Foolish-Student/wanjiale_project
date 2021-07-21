package com.framework.dto;

import com.google.common.collect.Lists;

import java.util.List;

public class DatasourceTreeDto {
    private String label;
    private String value;
    private List<DatasourceTreeDto> children = Lists.newArrayList();

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<DatasourceTreeDto> getChildren() {
        return children;
    }

    public void setChildren(List<DatasourceTreeDto> children) {
        this.children = children;
    }
}
