package ec.edu.uees.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "COMENTARIO")
public class ComentarioDTO implements Serializable {

    @Id
    @Column(name = "id_comentario")
    private Integer idComentario;

    private String comentario;

    @Column(name = "id_evento")
    private Integer idEvento;

    private LocalDateTime fecha;

    @Column(name = "id_usuario")
    private Integer idusuario;
}
