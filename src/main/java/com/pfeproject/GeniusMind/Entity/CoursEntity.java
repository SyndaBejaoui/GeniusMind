package com.pfeproject.GeniusMind.Entity;

import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="Cours")
public class CoursEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] fileContent;
}
