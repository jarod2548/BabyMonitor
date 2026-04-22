package org.babymonitor.Course.api;

import jakarta.validation.Valid;
import org.babymonitor.Course.model.Course;
import org.babymonitor.Course.model.CourseDTO;
import org.babymonitor.Course.model.CourseResponseDTO;
import org.babymonitor.Course.service.CourseService;
import org.babymonitor.Security.UserPrincipal;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @PostMapping("/teacher/course")
    public ResponseEntity<CourseResponseDTO> maakCourse(@RequestBody
                                           @Valid
                                           CourseDTO dto,
                                                        @AuthenticationPrincipal UserPrincipal user){
        Course model = dto.naarModel();
        Course saved = courseService.maakCourse(model);

        return ResponseEntity.ok(new CourseResponseDTO(saved));
    }
}
