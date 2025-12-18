package org.example.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Habilidad")
public class HabilidadDO {

    @Id
    @NonNull
    @EqualsAndHashCode.Include
    private int id;

    @Column
    @NonNull
    private String nombre;

    @Column
    @NonNull
    private String descripcion;

    @ToString.Exclude
    @ManyToMany(mappedBy = "habilidades")
    private Set<PersonajeDO> personajes = new HashSet<>();
}
