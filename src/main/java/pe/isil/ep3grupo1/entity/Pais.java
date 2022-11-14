package pe.isil.ep3grupo1.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_pais")
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public void setUsuarioCreador(String usuarioCreador) {this.usuarioCreador = usuarioCreador;}
}
