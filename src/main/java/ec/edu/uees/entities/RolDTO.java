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
@Table(name = "ROL")
public class RolDTO implements Serializable {

    @Id
    @Column(name = "id_rol")
    private Integer idRol;

    @Column(name = "rol")
    private String rol;
}
