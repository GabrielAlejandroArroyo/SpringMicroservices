package com.microservice.student.persistence;

import com.microservice.student.entities.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    @Query("SELECT s from Student s WHERE s.courseId= :idCourse")
    List<Student> findAllStudent(Long idCourse);

    //List<Student> findAllByCourseId(Long idCourse);
}
