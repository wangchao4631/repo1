package com.decorate.dao;


import com.decorate.pojo.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface ProductDao {
    @Select("select * from product where Level1_categories_code=#{Level1_categories_code}")
    List<Product> getByLevel1_categories_code(@Param("Level1_categories_code") String Level1_categories_code);

    /**
     * 首页展示产品（健康家居or装修材料）
     * @return
     */
    @Select("select * from product where Level1_categories_code in ('A','B') and bak1=1 ")
    List<Product> showIndexPage();

    /**
     * 首页展示产品装修案例
     * @return
     */
    @Select("select * from product where Level1_categories_code='C' and bak1=1 ")
    List<Product> showIndexZxPage();

    @Select("select * from product where id=#{id}")
    Product getProductById(@Param("id") String id);

    /**
     * 查询二级分类标题
     * @return
     */
    @Select("select Level1_categories_name, categories_name from product where Level1_categories_name=#{Level1_categories_name} group by categories_name")
    List<Product>getProduct(@Param("Level1_categories_name") String Level1_categories_name);

    @Select("select Level1_categories_name, categories_name from product where Level1_categories_name=#{Level1_categories_name} and categories_name=#{categories_name}  group by categories_name")
    List<Product>getProductBycategories_name(@Param("Level1_categories_name") String Level1_categories_name,@Param("categories_name") String categories_name);

    /**
     * 查询所有产品及建材家居
     * @return
     */
    @Select("select * from product where Level1_categories_name=#{Level1_categories_name} ")
    List<Product>getAllProduct(@Param("Level1_categories_name") String Level1_categories_name);

    @Select("select * from product where Level1_categories_name=#{Level1_categories_name} and categories_name=#{categories_name}")
    List<Product>getAllProductBycategories_name (@Param("Level1_categories_name") String Level1_categories_name,@Param("categories_name") String categories_name);
}
