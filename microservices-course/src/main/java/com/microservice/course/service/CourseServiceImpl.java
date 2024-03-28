package com.microservice.course.service;

import com.microservice.course.client.StudentClient;
import com.microservice.course.dto.StudentDto;
import com.microservice.course.entities.Course;
import com.microservice.course.http.reponse.StudentByCourseResponse;
import com.microservice.course.persistence.ICoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements ICourseService{
    @Autowired
    private ICoursesRepository coursesRepository;
    @Autowired
    private StudentClient studentClient;

    @Override
    public List<Course> findAll() {
        return (List<Course>) coursesRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return coursesRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Course course) {
        coursesRepository.save(course);
    }

    @Override
    public StudentByCourseResponse findStudentsByIdCourse(Long idCouser) {
        // Consultar el course
        Course course = coursesRepository.findById(idCouser).orElse(new Course());
        // Obtener los estudiantes que se trae con el servicio FeignClient con studentClient
        List<StudentDto> studentDtoList = studentClient.findAllStudentByCourse(idCouser) ;
        return StudentByCourseResponse.builder()
                .courseName(course.getName())
                .courseName(course.getTeacher())
                .studentDtoList(studentDtoList)
                .build();
    }
}
