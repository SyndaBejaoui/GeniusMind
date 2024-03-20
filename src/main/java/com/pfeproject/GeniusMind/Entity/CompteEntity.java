package com.pfeproject.GeniusMind.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CompteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idCompte;

    String userName;

    String email ;

    String password;

    String niveau;

    Boolean IsAdmin;

    Boolean IsEleve;

    Boolean IsEnseignant;

    @JsonIgnore
    @OneToOne(mappedBy = "compte")
   public UtilisateurEntity utilisateur;

}

