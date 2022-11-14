package pe.isil.ep3grupo1.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_pais")
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;

    @OneToMany
    @JoinColumn(name = "id_cuidad")
    private Ciudad cuidad;

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
}
