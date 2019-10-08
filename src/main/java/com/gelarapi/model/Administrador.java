package com.gelarapi.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;

@Entity
@Table(name = "administrador")
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "@class", defaultImpl = Administrador.class)
public class Administrador extends Usuario {

    @Column
    private Boolean isDiretor;

    public Boolean getIsDiretor() {
        return isDiretor;
    }

    public void setIsDiretor(Boolean diretor) {
        isDiretor = diretor;
    }
}
