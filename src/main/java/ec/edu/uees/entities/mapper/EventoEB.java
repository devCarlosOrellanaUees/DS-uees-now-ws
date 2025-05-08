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
public class EventoEB {

    @Id
    @Column(name = "IDEVENTO")
    private Integer idEvento;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "FECHAINICIO")
    private LocalDateTime fechaInicio;

    @Column(name = "FECHAFIN")
    private LocalDateTime fechaFin;

    @Column(name = "CANTIDADAFORO")
    private Integer cantidadAforo;

    @Column(name = "ESTADO")
    private Integer estado;

    @Column(name = "BANNER")
    private String banner;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "NOMBRECATEGORIA")
    private String nombreCategoria;

    @Column(name = "INSCRITOS")
    private Integer inscritos;
}
