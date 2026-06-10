package org.babymonitor.Course.model;

import jakarta.persistence.*;
import org.babymonitor.Course.model.antwoord.Antwoord;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "titel")
  private String titel;

  @Column(name = "compleet")
  private boolean compleet;

  @ManyToMany
  @JoinTable(
      name = "course_antwoord",
      joinColumns = @JoinColumn(name = "course_id"),
      inverseJoinColumns = @JoinColumn(name = "antwoord_id"))
  private Set<Antwoord> antwoorden = new HashSet<>();

  public Course(String titel, boolean IsCompleet) {
    this.titel = titel;
    compleet = IsCompleet;
  }

  public Course() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitel() {
    return titel;
  }

  public void setTitel(String titel) {
    this.titel = titel;
  }

  public Set<Antwoord> getAntwoorden() {
    return antwoorden;
  }

  public void setAntwoorden(Set<Antwoord> antwoorden) {
    this.antwoorden = antwoorden;
  }

  public void setCompleet(boolean compleet) {
    this.compleet = compleet;
  }

  public boolean isCompleet() {
    return compleet;
  }
}
