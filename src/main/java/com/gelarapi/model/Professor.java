package com.gelarapi.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "professor")
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "@class", defaultImpl = Professor.class)
public class Professor extends Usuario {

    @Column
    private String RP;

    @Column
    private Date dataContratação;

    public String getRP() {
        return RP;
    }

    public void setRP(String RP) {
        this.RP = RP;
    }

    public Date getDataContratação() {
        return dataContratação;
    }

    public void setDataContratação(Date dataContratação) {
        this.dataContratação = dataContratação;
    }
}
