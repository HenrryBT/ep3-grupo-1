package pe.isil.ep3grupo1.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_direccion")
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String direccion1;
    private String direccion2;
    private String nroDireccion;
    private Date fechaCreacion;
    private String usuarioCreador;
    @ManyToOne
    @JoinColumn(name = "id_ciudad")
    private Ciudad ciudad;
    @ManyToOne
    @JoinColumn(name = "id_pais")
    private Pais pais;

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

    public String getDireccion1() {
        return direccion1;
    }

    public void setDireccion1(String direccion1) {
        this.direccion1 = direccion1;
    }

    public String getDireccion2() {
        return direccion2;
    }

    public void setDireccion2(String direccion2) {
        this.direccion2 = direccion2;
    }

    public String getNroDireccion() {
        return nroDireccion;
    }

    public void setNroDireccion(String nroDireccion) {
        this.nroDireccion = nroDireccion;
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

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
