package com.ikkat.los.formapplication.applicationcollateral.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "formapplication_collateral", schema = "public")
public class ApplicationCollateral implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="formapplication_collateral_id_seq")
    private Long id;
    private Long idcompany;
    private Long idapplication;
    private String collateral;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdcompany() {
        return idcompany;
    }

    public void setIdcompany(Long idcompany) {
        this.idcompany = idcompany;
    }

    public Long getIdapplication() {
        return idapplication;
    }

    public void setIdapplication(Long idapplication) {
        this.idapplication = idapplication;
    }

    public String getCollateral() {
        return collateral;
    }

    public void setCollateral(String collateral) {
        this.collateral = collateral;
    }
}
