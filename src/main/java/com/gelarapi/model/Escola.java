package com.gelarapi.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "escola")
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "@class", defaultImpl = Escola.class)
public class Escola extends BaseModel {

    @Id
    @Column(nullable = false)
    @SequenceGenerator(name = "id", sequenceName = "escola_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id")
    private Long id;

    @Column
    private String nome;

    @Column
    private String teste;

    @OneToOne
    @JoinColumn(name = "idDiretor")
    private Administrador diretor;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "idEndereco")
    private Endereco endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTeste() {
        return teste;
    }

    public void setTeste(String teste) {
        this.teste = teste;
    }

    public Administrador getDiretor() {
        return diretor;
    }

    public void setDiretor(Administrador diretor) {
        this.diretor = diretor;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
