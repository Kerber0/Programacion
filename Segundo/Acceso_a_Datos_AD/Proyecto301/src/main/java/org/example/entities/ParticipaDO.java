package org.example.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "Participa")
public class ParticipaDO {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private ParticipaId id;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="id_personaje")
    @MapsId("idPersonaje")
    private PersonajeDO personaje;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="id_evento")
    @MapsId("idEvento")
    private EventoDO evento;

    @Column(name="fecha")
    private LocalDate fecha;

    @Column(name="rol")
    private String rol;
}
