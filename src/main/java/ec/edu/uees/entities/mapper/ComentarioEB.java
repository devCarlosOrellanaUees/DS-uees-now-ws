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
public class ComentarioEB {

    @Id
    @Column(name = "IDCOMENTARIO")
    private Integer idComentario;

    @Column(name = "AUTOR")
    private String autor;

    @Column(name = "TEXTO")
    private String texto;

    @Column(name = "FECHA")
    private LocalDateTime fecha;
}
