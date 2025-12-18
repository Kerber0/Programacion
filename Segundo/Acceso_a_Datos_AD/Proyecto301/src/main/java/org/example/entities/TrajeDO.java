package org.example.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "Traje")
public class TrajeDO {
    @Id
    private int id;

    @Column(name = "especificacion")
    private String especificacion;

    @ToString.Exclude
    @OneToOne(mappedBy = "traje")
    private PersonajeDO personaje;

}
