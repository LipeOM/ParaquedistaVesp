package com.projeto.ParaquedistaVesp.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "salto")
public class Salto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "data")
    private Date data;

    @Column(name = "ativo")
    private Boolean ativo;

    @Column(name = "id_batalha")
    private Integer idBatalha;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    public Integer getIdBatalha() {
        return idBatalha;
    }

    public void setIdBatalha(Integer idBatalha) {
        this.idBatalha = idBatalha;
    }
}
