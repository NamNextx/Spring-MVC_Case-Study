package com.codegym.cms.service;

import com.codegym.cms.model.Category;
import com.codegym.cms.model.Note;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    void save(Category category);
    void remove( Long id);
    Category findById(Long id);
}
