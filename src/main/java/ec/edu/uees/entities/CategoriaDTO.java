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
@Table(name = "CATEGORIA")
public class CategoriaDTO implements Serializable {

    @Id
    @Column(name = "id_categoria")
    private Integer idCategoria;

    private String nombre;
    private String descripcion;
}
