package com.fruit.rest;

import com.fruit.dto.CategoryDto;
import com.fruit.entity.Category;
import com.fruit.mapper.CategoryMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JesseHan on 2016/12/21.
 */
@RestController
@RequestMapping("/api/category")
public class CategoryRestController {
    @Autowired
    private CategoryMapper categoryMapper;

    @RequestMapping("/findRoot")
    public List<CategoryDto> findRoot() {
        List<Category> categories = categoryMapper.findByParent(-1L, 1);
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        for (Category category : categories) {
            CategoryDto categoryDto = new CategoryDto();
            BeanUtils.copyProperties(category, categoryDto);
            categoryDtoList.add(categoryDto);
        }
        return categoryDtoList;
    }
}
