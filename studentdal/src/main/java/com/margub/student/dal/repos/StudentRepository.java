package com.margub.student.dal.repos;

import org.springframework.data.repository.CrudRepository;

import com.margub.student.dal.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
