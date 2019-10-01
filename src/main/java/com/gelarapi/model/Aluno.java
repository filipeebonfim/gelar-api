package com.gelarapi.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "aluno")
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "@class", defaultImpl = Aluno.class)
public class Aluno extends Usuario {

    @Column
    private String RA;

    @Column
    private Date dataNascimento;

    public String getRA() {
        return RA;
    }

    public void setRA(String RA) {
        this.RA = RA;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
