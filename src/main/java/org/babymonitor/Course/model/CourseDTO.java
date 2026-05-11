package org.babymonitor.Course.model;

import jakarta.validation.constraints.NotNull;

public class CourseDTO {

    @NotNull
    private String titel;

    public Course naarModel(){
        return new Course(titel);
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }
}
