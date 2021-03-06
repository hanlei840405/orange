package com.fruit.rest;

import com.fruit.dto.StudentDto;
import com.fruit.entity.Student;
import com.fruit.mapper.StudentMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by JesseHan on 2016/12/19.
 */
@RestController
@RequestMapping("/api/student")
public class StudentRestController {
    @Autowired
    private StudentMapper studentMapper;

    @RequestMapping("/username/{username}")
    public StudentDto username(@PathVariable("username") String username) {
        Student student = studentMapper.getByUsername(username);
        StudentDto studentDto = new StudentDto();
        if (student != null) {
            BeanUtils.copyProperties(student, studentDto);
        }
        return studentDto;
    }
}
