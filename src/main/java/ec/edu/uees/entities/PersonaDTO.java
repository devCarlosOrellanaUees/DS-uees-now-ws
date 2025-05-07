package ec.edu.uees.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "PERSONA")
public class PersonaDTO implements Serializable {

    @Id
    @Column(name = "id_persona")
    private Integer idPersona;

    private String nombres;
    private String cedula;
    private String correo;
    private String telefono;
}