package org.example.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "Evento")
public class EventoDO {

    @Id
    @EqualsAndHashCode.Include
    private int id;

    @Column
    private String nombre;

    @Column
    private String lugar;

    @ToString.Exclude
    @OneToMany(mappedBy = "evento")
    private Set<ParticipaDO> participaciones = new HashSet<>();
}
