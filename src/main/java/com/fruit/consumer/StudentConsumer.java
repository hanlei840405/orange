package com.fruit.consumer;

import com.fruit.dto.StudentDto;
import com.fruit.entity.Student;
import com.fruit.mapper.StudentMapper;
import com.fruit.service.GeneratorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by hanlei6 on 2016/12/20.
 */
@Slf4j
@Component
public class StudentConsumer {
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private GeneratorService generatorService;

//    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "student", autoDelete = "true", durable = "true"), exchange = @Exchange(value = "edu", durable = "true", autoDelete = "true"), key = "insert"))
    @RabbitListener(queues = "queue.student")
    public void insert(StudentDto studentDto) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        student.setCreated(new Date());
        student.setStatus("1");
        student.setVersion(1);
        student.setId(generatorService.getId(Student.class.getSimpleName()));
        studentMapper.insert(student);
    }
}
