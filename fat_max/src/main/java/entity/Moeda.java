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
public class Moeda implements Serializable{
    
    private static final long serialVersionUID = 1L;

    Integer idMoeda;
    String nome;
    String valor;

    public Moeda() {
    }
    
    public Integer getIdMoeda() {
        return idMoeda;
    }

    public void setIdMoeda(Integer idMoeda) {
        this.idMoeda = idMoeda;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMoeda != null ? idMoeda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moeda)) {
            return false;
        }
        Moeda other = (Moeda) object;
        if ((this.idMoeda == null && other.idMoeda != null) || (this.idMoeda != null && !this.idMoeda.equals(other.idMoeda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Moeda[ idMoeda=" + idMoeda + " ]";
    }
}
