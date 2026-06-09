package org.babymonitor.Course.model;

public class CourseResponseDTO {
  private String titel;
  private Long id;
  private boolean isCompleet;

  public CourseResponseDTO(Course model) {
    titel = model.getTitel();
    id = model.getId();
    isCompleet = model.isCompleet();
  }


  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public boolean IsCompleet() {
    return isCompleet;
  }
}
