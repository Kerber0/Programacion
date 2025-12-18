package org.example.entities;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor
public class ParticipaId implements Serializable {

    private int idPersonaje;
    private int idEvento;

}
