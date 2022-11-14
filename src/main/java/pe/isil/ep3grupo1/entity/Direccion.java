package pe.isil.ep3grupo1.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_direccion")
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String direaccion1;
    private String direccion2;
    private String nroDireccion;
    private Date fechaCreacion;
    private String usuarioCreador;
    @Column(name = "id_ciudad")
    private Ciudad ciudad;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

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

    public String getDireaccion1() {
        return direaccion1;
    }

    public void setDireaccion1(String direaccion1) {
        this.direaccion1 = direaccion1;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
