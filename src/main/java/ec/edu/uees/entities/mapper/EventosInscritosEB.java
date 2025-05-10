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
public class EventosInscritosEB {

    @Id
    @Column(name = "CODIGOEVENTO")
    private Integer codigoEvento;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "FECHAINICIO")
    private LocalDateTime fechaInicio;

    @Column(name = "FECHAFIN")
    private LocalDateTime fechaFin;

    @Column(name = "AFORO")
    private Integer aforo;

    @Column(name = "INSCRITOS")
    private Integer inscritos;

    @Column(name = "ESTADO")
    private Integer estado;

    @Column(name = "CATEGORIA")
    private String categoria;
}
