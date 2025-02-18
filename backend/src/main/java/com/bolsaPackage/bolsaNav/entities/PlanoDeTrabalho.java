package com.bolsaPackage.bolsaNav.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "planodetrabalho")
public class PlanoDeTrabalho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String bolsa;

    public PlanoDeTrabalho() {}

    public PlanoDeTrabalho(Long id, String nome, String bolsa) {
        this.id = id;
        this.nome = nome;
        this.bolsa = bolsa;
    }

    @ManyToOne
    private Projeto projeto;

    public Projeto getProjeto() {return projeto;}

    public void setProjeto(Projeto projeto) {this.projeto = projeto;}

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getBolsa() {return bolsa;}

    public void setBolsa(String bolsa) {this.bolsa = bolsa;}

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

        PlanoDeTrabalho other = (PlanoDeTrabalho) obj;

        if (id == null) {
            return other.id == null;
        } else return id.equals(other.id);
    }
}
