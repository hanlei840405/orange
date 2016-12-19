package com.fruit.rest;

import com.fruit.entity.Student;
import com.fruit.mapper.StudentMapper;
import com.fruit.vo.StudentVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by JesseHan on 2016/12/19.
 */
@RestController
@RequestMapping("/api/student")
public class StudentRestController {
    @Autowired
    private StudentMapper studentMapper;

    @RequestMapping("/username/{username}")
    public StudentVo username(@PathVariable("username") String username) {
        Student student = studentMapper.getByUsername(username);
        StudentVo studentVo = new StudentVo();
        BeanUtils.copyProperties(student, studentVo);
        studentVo.add(linkTo(methodOn(StudentRestController.class).username(username)).withSelfRel());
        return studentVo;
    }

    @RequestMapping("/save")
    public StudentVo username(Student student) {
        studentMapper.insert(student);
        StudentVo studentVo = new StudentVo();
        BeanUtils.copyProperties(student, studentVo);
        studentVo.add(linkTo(methodOn(StudentRestController.class).username(student.getUsername())).withSelfRel());
        return studentVo;
    }
}
