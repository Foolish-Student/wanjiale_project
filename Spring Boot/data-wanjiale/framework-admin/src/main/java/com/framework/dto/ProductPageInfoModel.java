package com.framework.dto;

/**
 * @Author: liwan
 * @Description:
 * @Date: create in 2021/7/15 9:51
 */
public class ProductPageInfoModel {

    /**
     * 当前页码
     */
    private String page;
    /**
     * 每页记录
     */
    private String limit;




    private Integer id;                 //主键
    private String productNum;           //产品编码
    private String productModel;        //产品型号
    private String productName;         //产品名称
    private String productCategory;     //类目
    private String barCode;             //条形码
    private String productUnit;         //单位
    private String productSize;         //规格
    private String productPrice;        //零售价（元）
    private String productInvoicePrice; //开票价（元）

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductInvoicePrice() {
        return productInvoicePrice;
    }

    public void setProductInvoicePrice(String productInvoicePrice) {
        this.productInvoicePrice = productInvoicePrice;
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
