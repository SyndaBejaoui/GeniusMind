package com.pfeproject.GeniusMind.Entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long id;
    private String question;
    private String response1;
    private String response2;
    private String response3;
    private String correct;

    @ManyToOne
    private Level level;
}
