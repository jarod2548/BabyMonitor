package org.babymonitor.Course.api;

import jakarta.validation.Valid;
import org.babymonitor.Course.model.Course;
import org.babymonitor.Course.model.CourseDTO;
import org.babymonitor.Course.model.CourseResponseDTO;
import org.babymonitor.Course.model.courseantwoordDTO;
import org.babymonitor.Course.service.CourseService;
import org.babymonitor.Security.UserPrincipal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/teacher/course")
    public ResponseEntity<CourseResponseDTO> maakCourse(@RequestBody @Valid CourseDTO dto,
            @AuthenticationPrincipal UserPrincipal user) {
        Course model = dto.naarModel();
        Course saved = courseService.maakCourse(model);

        return ResponseEntity.status(HttpStatus.CREATED).body(new CourseResponseDTO(saved));
    }

    @GetMapping("user/courses")
    public ResponseEntity<List<CourseResponseDTO>> leesCourses(@AuthenticationPrincipal UserPrincipal user) {
        List<Course> models = courseService.leesCourses();
        List<CourseResponseDTO> response = new ArrayList<CourseResponseDTO>();
        for (Course model : models) {
            response.add(new CourseResponseDTO(model));
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/teacher/courseantwoord")
    public ResponseEntity<String> linkCourseAntwoord(@RequestBody @Valid courseantwoordDTO dto,
            @AuthenticationPrincipal UserPrincipal user) {
        courseService.linkantwoordentocourse(dto.getCourseId(), dto.getAntwoordId());
        return ResponseEntity.ok("Link created successfully");
    }
}
