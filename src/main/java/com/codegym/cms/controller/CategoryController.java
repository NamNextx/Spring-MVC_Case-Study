package com.codegym.cms.controller;

import com.codegym.cms.model.Category;
import com.codegym.cms.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;

    @ModelAttribute("categorys")
    public List<Category> categories()
    {
        List<Category> categoryList = iCategoryService.findAll();
        if (categoryList.isEmpty()){
                return null;
        }
        else return iCategoryService.findAll();
    }

    // create category
    @GetMapping("/create-category")
    public ModelAndView createCategory(){
        Category category = new Category();
        ModelAndView model_create = new ModelAndView("/category/create");
        model_create.addObject("category",category);
        return model_create;
    }
    @PostMapping("/create-category")
    public String createCategory(Category category, RedirectAttributes redirect){
        iCategoryService.save(category);
        return "redirect:/home";
    }

    @GetMapping("/home")
    public ModelAndView modelAndView(){
        ModelAndView modelAndView = new ModelAndView("/home/home");
        modelAndView.addObject("categorys",categories());
        return modelAndView;

    }

    @GetMapping(value = "/delete-category/{id}")
    public String listResponseEntity(@PathVariable Long id){
        Category category = iCategoryService.findById(id);
        if (category != null){
            iCategoryService.remove(id);
            return "redirect: /home";
        }
        return null;
    }

    @GetMapping("/edit-category/{id}")
    public ModelAndView editCategory(@PathVariable Long id){
        ModelAndView editCategory_ModelAndView = new ModelAndView("/category/edit_category");
        Category categoryEdit = iCategoryService.findById(id);
        if (categoryEdit == null) {
            editCategory_ModelAndView.addObject("error-404");
            return editCategory_ModelAndView;
        }else {
            editCategory_ModelAndView.addObject("category",categoryEdit);
            return editCategory_ModelAndView;
        }

    }

    @PostMapping("/category-edit")
    public String updateCategory(@ModelAttribute Category category){
       Category category1 =  iCategoryService.findById(category.getId());
       if (category1 !=null){
           iCategoryService.save(category);
           return "redirect:/home";
       }
       return null;
    }
}
