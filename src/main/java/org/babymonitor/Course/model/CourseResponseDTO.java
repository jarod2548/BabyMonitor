package org.babymonitor.Course.model;

import jakarta.validation.constraints.NotNull;

public class CourseResponseDTO {
    private String titel;
    private Long id;

    public CourseResponseDTO(Course model){
        titel = model.getTitel();
        id = model.getId();
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
