package org.babymonitor.Course.model;

import jakarta.validation.constraints.NotNull;

public class CourseDTO {

  @NotNull private String titel;
  @NotNull private boolean isCompleet;

  public Course naarModel() {
    return new Course(titel, isCompleet);
  }

  public String getTitel() {
    return titel;
  }

  public void setTitel(String titel) {
    this.titel = titel;
  }

  public boolean isCompleet() {
    return isCompleet;
  }

  public void setCompleet(boolean compleet) {
    isCompleet = compleet;
  }
}
