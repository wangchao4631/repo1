package com.decorate.service.impl;

import com.decorate.dao.ProductDao;
import com.decorate.pojo.Product;
import com.decorate.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    ProductDao productDao;
    @Override
    public List<Product> getByLevel1_categories_code(String Level1_categories_code) {
        List<Product> products = productDao.getByLevel1_categories_code(Level1_categories_code);

        return products;
    }

    /**
     * 查询首页产品信息 展示在首页的
     * @return
     */
    @Override
    public List<Product> showIndexPage() {
        return productDao.showIndexPage();
    }

    /**
     * 首页展示装修案例
     * @return
     */
    @Override
    public List<Product> showIndexZxPage() {
        return productDao.showIndexZxPage();
    }

    /**
     * 根据产品id查询产品详情
     * @param id
     * @return
     */
    @Override
    public Product getProductById(String id) {
        return productDao.getProductById(id);
    }

    /**
     * 查询二级目录标题
     * @return
     */
    @Override
    public List<Product> getProduct(String Level1_categories_name,String categories_name) {
        if (categories_name==null) {
            return productDao.getProduct(Level1_categories_name);
        }
        return productDao.getAllProductBycategories_name(Level1_categories_name,categories_name);
    }

    /**
     * 查询所有产品及建材家居
     * @return
     */
    @Override
    public List<Product> getAllProduct(String Level1_categories_name,String categories_name) {
        if (categories_name==null) {
            return productDao.getAllProduct(Level1_categories_name);
        }
        return productDao.getAllProductBycategories_name(Level1_categories_name,categories_name);
    }
}