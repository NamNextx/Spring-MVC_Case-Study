package com.codegym.cms.controller;

import com.codegym.cms.model.Category;
import com.codegym.cms.model.Note;
import com.codegym.cms.service.ICategoryService;
import com.codegym.cms.service.IinoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class Note_Controller {
    @Autowired
    private IinoteService iinoteService;

    @Autowired
    private ICategoryService iCategoryService;


    @ModelAttribute("categorys")
    public List<Category> categories()
    {
       return iCategoryService.findAll();
    }

    //Create note
    @GetMapping("/create-note")
    public ModelAndView modelAndView(){
        ModelAndView modelAndView = new ModelAndView("/note/create");
        modelAndView.addObject("note",new Note());
        return modelAndView;
    }
    @PostMapping("/create-new-note")
    public String createNote(Note note){
        iinoteService.save(note);
        return "redirect:/home";
    }



}
