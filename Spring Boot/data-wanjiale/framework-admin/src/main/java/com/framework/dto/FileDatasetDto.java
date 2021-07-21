package com.framework.dto;

import org.springframework.web.multipart.MultipartFile;

public class FileDatasetDto {
    private String categoryId;
    private String name;
    private String note;
    private MultipartFile file;

    public FileDatasetDto() {
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
