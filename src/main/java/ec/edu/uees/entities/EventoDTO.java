package ec.edu.uees.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "EVENTO")
public class EventoDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evento")
    private Integer idEvento;

    private String nombre;

    @Column(name = "fecha_inicio")
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDateTime fechaFin;

    @Column(name = "descripción")
    private String descripcion;

    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "cantidad_aforo")
    private Integer cantidadAforo;

    private Integer estado;
    private String banner;

}