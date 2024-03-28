package com.microservice.course.http.reponse;

import com.microservice.course.dto.StudentDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentByCourseResponse {
    private String courseName;
    private String teacher;
    private List<StudentDto> studentDtoList;
}
