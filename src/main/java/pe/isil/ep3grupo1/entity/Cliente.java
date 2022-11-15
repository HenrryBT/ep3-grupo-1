package pe.isil.ep3grupo1.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_cliente", uniqueConstraints = {
        @UniqueConstraint(name = "email", columnNames = "email")
})
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombres;
    private String apellidos;

    private String email;

    @ManyToOne
    @JoinColumn(name = "id_direccion")
    private Direccion direccion;
    private Date fechaCreacion;
    private String usuarioCreador;

    @PostPersist
    public void postPersist() {
        this.fechaCreacion = new Date();
        this.usuarioCreador = "SYS-USER";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioCreador() {
        return usuarioCreador;
    }

    public void setUsuarioCreador(String usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
}
