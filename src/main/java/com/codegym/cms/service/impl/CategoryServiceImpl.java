package com.codegym.cms.service.impl;

import com.codegym.cms.model.Category;
import com.codegym.cms.repository.IcategoryRepository;
import com.codegym.cms.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private IcategoryRepository icategoryRepository;
    @Override


    public List<Category> findAll() {
        return (List<Category>) icategoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
        icategoryRepository.save(category);
    }

    @Override
    public void remove(Long id) {
        icategoryRepository.delete(id);
    }

    @Override
    public Category findById(Long id) {
        return icategoryRepository.findOne(id);
    }
}
