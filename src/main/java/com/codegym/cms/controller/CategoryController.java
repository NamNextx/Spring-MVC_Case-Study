package com.codegym.cms.controller;

import com.codegym.cms.model.Category;
import com.codegym.cms.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;

    // create category
    @GetMapping("/create-category")
    public ModelAndView modelAndView(){
        Category category = new Category();
        ModelAndView model_create = new ModelAndView("/category/create");
        model_create.addObject("category",category);
        return model_create;
    }
}
