package com.fruit.service.impl;

import com.fruit.entity.Category;
import com.fruit.mapper.CategoryMapper;
import com.fruit.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by JesseHan on 2016/12/21.
 */
@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> findRoots() {
        List<Category> categories = categoryMapper.findByParent(-1L, 1);
        for (Category category : categories) {
            category.getElements().addAll(categoryMapper.findByParent(category.getId(), 1));
        }
        return categories;
    }
}
