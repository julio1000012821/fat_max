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
public class TipoFatura implements Serializable{
    
    private Integer idTipoFatura;
    
    private String nome;
    
    private Integer numero;

    public TipoFatura(Integer idTipoFatura) {
        this.idTipoFatura = idTipoFatura;
    }

    public Integer getIdTipoFatura() {
        return idTipoFatura;
    }

    public void setIdTipoFatura(Integer idTipoFatura) {
        this.idTipoFatura = idTipoFatura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    
    
}
