package org.babymonitor.Course.model;

import jakarta.validation.constraints.NotNull;

public class courseantwoordDTO {

    @NotNull
    private Long courseId;

    @NotNull
    private Long antwoordId;

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getAntwoordId() {
        return antwoordId;
    }

    public void setAntwoordId(Long antwoordId) {
        this.antwoordId = antwoordId;
    }
}
