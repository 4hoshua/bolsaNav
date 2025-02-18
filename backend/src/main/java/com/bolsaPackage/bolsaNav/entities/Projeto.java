package com.bolsaPackage.bolsaNav.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "projeto")
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String orientador;
    private String departamento;

    public Projeto() {}

    public Projeto(Long id, String nome, String orientador, String departamento) {
        this.id = id;
        this.nome = nome;
        this.orientador = orientador;
        this.departamento = departamento;
    }

    @OneToMany
    @JoinTable(name = "projeto_plano_de_trabalho",
            joinColumns = @JoinColumn(name = "projeto_id"),
            inverseJoinColumns = @JoinColumn(name = "plano_de_trabalho_id")
    )
    private Set<PlanoDeTrabalho> planoDeTrabalhoSet = new HashSet<>();

    public Set<PlanoDeTrabalho> getPlanoDeTrabalhoSet() {return planoDeTrabalhoSet;}

    public void setPlanoDeTrabalhoSet(Set<PlanoDeTrabalho> planoDeTrabalhoSet) {this.planoDeTrabalhoSet = planoDeTrabalhoSet;}

    public Long getId() { return id;}

    public void setId(Long id) { this.id = id;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getOrientador() {return orientador;}

    public void setOrientador(String orientador) {this.orientador = orientador;}

    public String getDepartamento() {return departamento;}

    public void setDepartamento(String departamento) {this.departamento = departamento;}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Projeto other = (Projeto) obj;

        if (id == null) {
            return other.id == null;
        } else return id.equals(other.id);
    }
}
