package ec.edu.uees.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "INSCRIPCION")
public class InscripcionDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscripcion")
    private Integer idInscripcion;

    @Column(name = "id_evento")
    private Integer idEvento;

    @Column(name = "id_usuario")
    private Integer idUsuario;

    private Integer estado;
    private LocalDateTime fecha;
}
