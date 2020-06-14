package com.decorate.controller;

import com.decorate.pojo.Product;
import com.decorate.service.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller


public class ProductController {
    @Autowired
    IProductService iProductService;

    @RequestMapping("/")
    public String getIndex(ModelMap modelMap) {
        List<Product> products = iProductService.showIndexPage();
        List<Product> products1 = iProductService.showIndexZxPage();
        modelMap.put("productcp", products);
        modelMap.put("productanli", products1);
        System.out.println("进入方法");
        return "index";
    }

    /**
     * 根据产品id查询产品详情
     *
     * @param id
     * @param modelMap
     * @return
     */
    @RequestMapping("/Productdetails/{id}")
    public String getProduct_details(@PathVariable("id") String id, ModelMap modelMap) {
        if (id == null) {
            return "redirect:/";
        }
        Product productById = iProductService.getProductById(id);
        if (productById == null) {
            return "redirect:/";
        }
        //获得推荐
        List<Product> allProduct = iProductService.getAllProduct(productById.getLevel1_categories_name(), productById.getCategories_name());
        if (allProduct.size()>3){
            ArrayList<Product> list = new ArrayList<>();
            list.add(allProduct.get(0));
            list.add(allProduct.get(1));
            list.add(allProduct.get(2));
            modelMap.put("tuijian",list);
        }else {
            modelMap.put("tuijian",allProduct);
        }
        //获得上一篇，下一篇信息
        int i = Integer.parseInt(id);
        Product productById1 = iProductService.getProductById((i-1)+"");
        Product productById2 = iProductService.getProductById((i+1)+"");
//        if (productById1!=null){
//            modelMap.put("shangyipian",productById1);
//        }else {
//            Product product = new Product();
//            product.setProduct_details_name("没有更多了");
//            modelMap.put("shangyipian",product);
//        }
//
//        if (productById2!=null){
//            modelMap.put("xiayipian",productById2);
//        }else {
//            Product product = new Product();
//            product.setProduct_details_name("没有更多了");
//            modelMap.put("xiayipian",product);
//
//        }
        modelMap.put("shangyipian",productById1);
        modelMap.put("xiayipian",productById2);
        modelMap.put("Productdetails", productById);
        System.out.println("进入页面详情");
        return "Product_details";
    }

    @RequestMapping("/Product/{Level1_categories_name}/{categoriesname}")
    public String getProduct(@PathVariable("Level1_categories_name") String Level1_categories_name, ModelMap modelMap,@PathVariable("categoriesname") String categoriesname) {
        //查询标题
        List<Product> product = iProductService.getProduct(Level1_categories_name,null);
        //所有产品及建材家居
        List<Product> allProduct = iProductService.getAllProduct(Level1_categories_name,categoriesname);
        if (Level1_categories_name==null||product.size()==0||allProduct.size()==0){
            return "redirect:/";
        }
        String categories_name=product.get(1).getLevel1_categories_name();
        modelMap.put("categories_name1",categories_name);
        modelMap.put("titlepro",product);
        modelMap.put("allpro",allProduct);
        return "product";
    }

    @RequestMapping("/Product/{Level1_categories_name}")
    public String getProducts(@PathVariable("Level1_categories_name") String Level1_categories_name, ModelMap modelMap) {
        //查询标题
        List<Product> product = iProductService.getProduct(Level1_categories_name,null);
        //所有产品及建材家居
        List<Product> allProduct = iProductService.getAllProduct(Level1_categories_name,null);
        if (Level1_categories_name==null||product.size()==0||allProduct.size()==0){
            return "redirect:/";
        }
        String categories_name=product.get(1).getLevel1_categories_name();
        modelMap.put("categories_name1",categories_name);
        modelMap.put("titlepro",product);
        modelMap.put("allpro",allProduct);
        return "product";
    }

    /**
     * 关于我们
     * @return
     */
    @RequestMapping("/AboutUs")
    public String AboutUs(){
        return "About_us";
    }

    /**
     * 公司荣誉
     * @return
     */
    @RequestMapping("/Company_honor")
    public String Company_honor(){
        return "Company_honor";
    }

    /**
     * 联系我们
     * @return
     */
    @RequestMapping("/contact")
    public String Contact(){
        return "Contact";
    }
}