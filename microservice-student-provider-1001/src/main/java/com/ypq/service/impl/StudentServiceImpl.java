package com.ypq.service.impl;
 
import java.util.List;
 
import javax.annotation.Resource;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
 
import com.ypq.entity.Student;
import com.ypq.repository.StudentRepository;
import com.ypq.service.StudentService;
 
/**
 * 学生信息Service实现类
 * @author Administrator
 *
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService{

    @Resource
    private StudentRepository studentRepository;
     
    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }
 
    @Override
    public Student findById(Integer id) {
        Student student = new Student();
        student.setId(id);
        Example<Student> example = Example.of(student);
        return studentRepository.findOne(example).orElse(student);
    }
 
    @Override
    public List<Student> list() {
        return studentRepository.findAll();
    }
 
    @Override
    public void delete(Integer id) {
        Student student = new Student();
        student.setId(id);
        studentRepository.delete(student);
    }
 
}