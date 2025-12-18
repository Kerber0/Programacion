package org.example.entities;
import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "Personaje")
public class PersonajeDO {

    @Id
    @NonNull
    @EqualsAndHashCode.Include
    private int id;

    @NonNull
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @NonNull
    @Column(name = "alias", nullable = false)
    private String alias;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(
            name = "Personaje_Habilidad",
            joinColumns = @JoinColumn(name = "id_personaje"),
            inverseJoinColumns = @JoinColumn(name = "id_habilidad")
    )
    private Set<HabilidadDO> habilidades = new HashSet<>();

    @ToString.Exclude
    @OneToOne(optional = true)
    @JoinColumn(name = "id_traje", referencedColumnName = "id")
    private TrajeDO traje;

    @ToString.Exclude
    @OneToMany(mappedBy = "personaje")
    private Set<ParticipaDO> participaciones = new HashSet<>();
}
