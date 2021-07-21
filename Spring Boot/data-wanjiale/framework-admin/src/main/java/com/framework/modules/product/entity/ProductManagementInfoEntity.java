package com.framework.modules.product.entity;

/**
 * @Author: liwan
 * @Description: 产品管理
 * @Date: create in 2021/7/13 8:43
 */
public class ProductManagementInfoEntity {
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
    private String productBugPrice;     //提货价
    private String productWeight;       //重量（Kg）
    private String productBulk;         //体积（m3）
    private String productLength;       //长度（cm)
    private String productWidth;        //宽度（cm）
    private String deliverFromGodown;   //出货仓库
    private String expiryDate;          //失效日期
    private String productAfterSale;    //售后产品型号

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

    public String getProductBugPrice() {
        return productBugPrice;
    }

    public void setProductBugPrice(String productBugPrice) {
        this.productBugPrice = productBugPrice;
    }

    public String getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(String productWeight) {
        this.productWeight = productWeight;
    }

    public String getProductBulk() {
        return productBulk;
    }

    public void setProductBulk(String productBulk) {
        this.productBulk = productBulk;
    }

    public String getProductLength() {
        return productLength;
    }

    public void setProductLength(String productLength) {
        this.productLength = productLength;
    }

    public String getProductWidth() {
        return productWidth;
    }

    public void setProductWidth(String productWidth) {
        this.productWidth = productWidth;
    }

    public String getDeliverFromGodown() {
        return deliverFromGodown;
    }

    public void setDeliverFromGodown(String deliverFromGodown) {
        this.deliverFromGodown = deliverFromGodown;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getProductAfterSale() {
        return productAfterSale;
    }

    public void setProductAfterSale(String productAfterSale) {
        this.productAfterSale = productAfterSale;
    }
}
