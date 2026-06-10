package org.babymonitor.Course.model.vraagData;

import jakarta.persistence.*;

@Entity
@Table(name = "vraagData")
public class VraagData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int nieuweHartbasis;
    private int nieuweHartVaribiliteit;
    private int nieuweHartTijd;
    private int weeSterkte;
    private int weeDuratie;
    private String weeType;
}
