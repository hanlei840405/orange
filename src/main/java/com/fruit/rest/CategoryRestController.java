package com.fruit.rest;

import com.fruit.dto.CategoryDto;
import com.fruit.entity.Category;
import com.fruit.mapper.CategoryMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

    /**
     * 根据上级类目查询直属类目集合
     *
     * @param categoryCode
     * @return
     */
    @RequestMapping("/categories/{categoryCode}")
    public List<CategoryDto> categories(@PathVariable("categoryCode") String categoryCode) {
        List<Category> categories = categoryMapper.findByParent(categoryCode, 1);
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        for (Category category : categories) {
            CategoryDto categoryDto = new CategoryDto();
            BeanUtils.copyProperties(category, categoryDto);
            categoryDtoList.add(categoryDto);
        }
        return categoryDtoList;
    }
}
