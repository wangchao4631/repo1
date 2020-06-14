package com.decorate.service;

import com.decorate.pojo.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Api(value="产品页面查询接口",description = "主要提供产品查询功能")
public interface IProductService {
    /**
     * 根据一级分类id查询
     * @param Level1_categories_code
     * @return
     */
    @ApiOperation("根据一级分类ID查询产品信息")
    List<Product> getByLevel1_categories_code(String Level1_categories_code);

    /**
     * 首页产品展示
     * @return
     */
    @ApiOperation("首页产品展示")
    List<Product> showIndexPage();

    /**
     * 首页展示产品
     * @return
     */
    @ApiOperation("首页装修案例展示")
    List<Product> showIndexZxPage();

    /**
     * 根据产品id查询详情
     * @param id
     * @return
     */
    Product getProductById( String id);

    /**
     * 查询二级标题目录
     * @return
     */
    List<Product>getProduct(String Level1_categories_name,String categories_name);

    /**
     * 查询所有产品及建材家居
     * @return
     */
    List<Product>getAllProduct(String Level1_categories_name,String categories_name);
}
