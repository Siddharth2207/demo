package com.example.demo.repositories;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.models.Student;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, Long> {
	

}
	