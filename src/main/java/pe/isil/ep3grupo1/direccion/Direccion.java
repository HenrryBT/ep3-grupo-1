package pe.isil.ep3grupo1.direccion;

import pe.isil.ep3grupo1.ciudad.Ciudad;
import pe.isil.ep3grupo1.pais.Pais;

import javax.persistence.*;

@Entity
@Table(name = "tbl_Direccion")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String direaccion1;
    private String direccion2;
    private String nroDireccion;

    @ManyToOne
    @JoinColumn(name = "id_ciudad")
    private Ciudad ciudad;

    @ManyToOne
    @JoinColumn(name = "id_pais")
    private Pais pais;

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
