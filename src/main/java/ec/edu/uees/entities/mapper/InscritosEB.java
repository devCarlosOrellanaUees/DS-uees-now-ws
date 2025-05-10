package ec.edu.uees.entities.mapper;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class InscritosEB {

    @Id
    @Column(name = "IDPERSONA")
    private Integer idPersona;

    @Column(name = "NOMBRES")
    private String nombres;

    @Column(name = "CEDULA")
    private String cedula;

    @Column(name = "CORREO")
    private String correo;

    @Column(name = "TELEFONO")
    private String telefono;

    @Column(name = "FECHA")
    private LocalDateTime fecha;


}