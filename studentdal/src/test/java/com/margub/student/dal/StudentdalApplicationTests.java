package com.margub.student.dal;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.margub.student.dal.entities.Student;
import com.margub.student.dal.repos.StudentRepository;

@SpringBootTest
class StudentdalApplicationTests {

    @Autowired
    private StudentRepository studentRepostiory;

    @Test
    public void testCreateStudent() {

        Student entity = new Student();
        entity.setName("JHone");
        entity.setCourse("Java web service");
        entity.setFee(30d);

        studentRepostiory.save(entity);
    }

    @Test
    public void testFindStudent() {
        Optional<Student> student = studentRepostiory.findById((long) 1d);
        if (student.isPresent()) {
            System.out.println(student.get().toString());
        }
    }


    @Test
    public void testUpdateStudent() {
        Optional<Student> student = studentRepostiory.findById((long) 1d);
        if (student.isPresent()) {
            Student studentObject = student.get();
            studentObject.setCourse("webserviceDatalayer");
            studentRepostiory.save(studentObject);
        }
    }


    @Test
    public void testDeleteStudent() {
        studentRepostiory.deleteById((long) 1d);

    }

}
