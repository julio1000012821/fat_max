/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author juliosilva
 */
public class Utilizador implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private Integer idUtilizador;
    
    private String nome;

    private String senha;
    
    private Perfil idPerfil;
    
    public Utilizador(){
        
    }

    public Integer getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(Integer idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Perfil getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Perfil idPerfil) {
        this.idPerfil = idPerfil;
    }

    @Override
    public String toString() {
        return "Utilizador{" + "idUtilizador=" + idUtilizador + ", nome=" + nome + ", senha=" + senha + ", idPerfil=" + idPerfil + '}';
    }
    
    
    
}
