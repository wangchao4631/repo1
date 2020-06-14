package com.decorate.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@ApiModel(value="产品对象",description="产品对象")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value="主键ID",name="ID",example="1")
    private Integer ID;
    @ApiModelProperty(value="一级分类代码",name="Level1_categories_code",example="A")
    private String Level1_categories_code ;
    @ApiModelProperty(value="一级分类中文名称",name="Level1_categories_name",example="健康家居")
    private String Level1_categories_name;
    @ApiModelProperty(value="二级分类产品代码",name="categories_code",example="1")
    private String categories_code;
    @ApiModelProperty(value="二级分类产品中文名称",name="categories_name",example="板材")
    private String categories_name;
    @ApiModelProperty(value="产品详情代码",name="Product_details_code",example="1")
    private String Product_details_code;
    @ApiModelProperty(value="产品详情名称",name="Product_details_name",example="热熔胶")
    private String Product_details_name;
    @ApiModelProperty(value="产品详情图片",name="img_src",example="img/1.jpg")
    private String img_src;
    @ApiModelProperty(value="备用字段1",name="bak1",example="***")
    private String bak1;
    @ApiModelProperty(value="备用字段2",name="bak2",example="***")
    private String bak2;

    @Override
    public String toString() {
        return "Product{" +
                "ID=" + ID +
                ", Level1_categories_code='" + Level1_categories_code + '\'' +
                ", Level1_categories_name='" + Level1_categories_name + '\'' +
                ", categories_code='" + categories_code + '\'' +
                ", categories_name='" + categories_name + '\'' +
                ", Product_details_code='" + Product_details_code + '\'' +
                ", Product_details_name='" + Product_details_name + '\'' +
                ", img_src='" + img_src + '\'' +
                ", bak1='" + bak1 + '\'' +
                ", bak2='" + bak2 + '\'' +
                '}';
    }

    public Product() {
    }

    public Product(Integer ID, String level1_categories_code, String level1_categories_name, String categories_code, String categories_name, String product_details_code, String product_details_name, String img_src, String bak1, String bak2) {
        this.ID = ID;
        Level1_categories_code = level1_categories_code;
        Level1_categories_name = level1_categories_name;
        this.categories_code = categories_code;
        this.categories_name = categories_name;
        Product_details_code = product_details_code;
        Product_details_name = product_details_name;
        this.img_src = img_src;
        this.bak1 = bak1;
        this.bak2 = bak2;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getLevel1_categories_code() {
        return Level1_categories_code;
    }

    public void setLevel1_categories_code(String level1_categories_code) {
        Level1_categories_code = level1_categories_code;
    }

    public String getLevel1_categories_name() {
        return Level1_categories_name;
    }

    public void setLevel1_categories_name(String level1_categories_name) {
        Level1_categories_name = level1_categories_name;
    }

    public String getCategories_code() {
        return categories_code;
    }

    public void setCategories_code(String categories_code) {
        this.categories_code = categories_code;
    }

    public String getCategories_name() {
        return categories_name;
    }

    public void setCategories_name(String categories_name) {
        this.categories_name = categories_name;
    }

    public String getProduct_details_code() {
        return Product_details_code;
    }

    public void setProduct_details_code(String product_details_code) {
        Product_details_code = product_details_code;
    }

    public String getProduct_details_name() {
        return Product_details_name;
    }

    public void setProduct_details_name(String product_details_name) {
        Product_details_name = product_details_name;
    }

    public String getImg_src() {
        return img_src;
    }

    public void setImg_src(String img_src) {
        this.img_src = img_src;
    }

    public String getBak1() {
        return bak1;
    }

    public void setBak1(String bak1) {
        this.bak1 = bak1;
    }

    public String getBak2() {
        return bak2;
    }

    public void setBak2(String bak2) {
        this.bak2 = bak2;
    }
}
