package ec.edu.uees.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "USUARIO")
public class UsuarioDTO implements Serializable {
    @Id
    @Column(name = "id_usuario")
    private Integer idUsuario;

    private String user;
    private String password;

    @Column(name = "id_rol")
    private Integer idRol;

    @Column(name = "id_persona")
    private Integer idPersona;

}