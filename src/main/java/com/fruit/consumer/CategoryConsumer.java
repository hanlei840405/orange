package com.fruit.consumer;

import com.fruit.dto.CategoryDto;
import com.fruit.entity.Category;
import com.fruit.mapper.CategoryMapper;
import com.fruit.service.GeneratorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by hanlei6 on 2016/12/22.
 */
@Slf4j
@Component
public class CategoryConsumer {
    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private GeneratorService generatorService;

    @RabbitListener(queues = "queue.category.insert")
    public void insert(CategoryDto categoryDto) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDto, category);
        category.setCreated(new Date());
        category.setStatus("1");
        category.setVersion(1);
        category.setId(generatorService.getId(Category.class.getSimpleName()));
        categoryMapper.insert(category);
    }
}
