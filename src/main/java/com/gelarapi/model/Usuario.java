package com.gelarapi.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "@class", defaultImpl = Usuario.class)
public class Usuario extends BaseModel implements UserDetails {

    @Id
    @Column(nullable = false)
    @SequenceGenerator(name = "id", sequenceName = "usuario_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id")
    private Long id;

    @Column
    private String nome;

    @Column
    private String login;

    @Column
    private String senha;

    @Column
    private String telefone;

    @Column
    private String celular;

    @Column
    private String cpf;

    @Column
    private String email;


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) { this.senha = senha; }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public Long getId() {
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
