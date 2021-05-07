package com.hyb.ssm.controller;


import com.hyb.ssm.domain.Product;
import com.hyb.ssm.service.IProductService;
import com.hyb.ssm.utils.DateStringEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

//    @InitBinder//spring类型转换
//    public void initBinder(WebDataBinder binder) {
//        binder.registerCustomEditor(Date.class,new DateStringEditor());
//
//    }

    //产品添加
    @RequestMapping("/save.do")
    public String save(Product product) throws Exception {
        productService.save(product);
        return "redirect:findAll.do";

    }

    //查询全部产品
    @RequestMapping("/findAll.do")
    @RolesAllowed("ADMIN")//该方法只要具有"ADMIN"权限就可以访问
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> ps = productService.findAll();

        mv.addObject("productList",ps);
        mv.setViewName("product-list");

        return mv;

    }
}
