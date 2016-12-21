package com.fruit.mapper;

import com.fruit.entity.Category;
import com.fruit.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by JesseHan on 2016/12/19.
 */
@Mapper
public interface CategoryMapper {

    @Select("SELECT * FROM category WHERE id = #{id}")
    Student get(Long id);

    @Select("SELECT * FROM category WHERE code = #{code}")
    Student getByCode(String code);

    @Select("SELECT * FROM category WHERE category_id = #{categoryId} AND status=#{status} ORDER BY sequence")
    List<Category> findByParent(String categoryId, int status);

    @Select("SELECT * FROM category WHERE status = #{status} ORDER BY sequence")
    List<Category> findByStatus(int status);

    @Insert("INSERT INTO category (id, code, name, imgUrl, sequence, category_id, status, created, creator, version) VALUE (#{id}, #{code}, #{name}, #{imgUrl}, #{sequence}, #{categoryId}, #{status}, #{created}, #{creator},#{version})")
    int insert(Category category);

    @Update("UPDATE category SET name=#{name}, category_id=#{categoryId}, status=#{status}, modifier=#{modifier}, modified=#{modified}, version=#{version} WHERE id={id} AND version=#{version}")
    int update(Category category);

    @Delete("DELETE FROM category WHERE id=#{id} AND version=#{version}")
    int physicalDelete(Category category);
}
