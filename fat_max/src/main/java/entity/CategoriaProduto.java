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
public class CategoriaProduto implements Serializable{
    private static final long serialVersionUID = 1L;
    Integer idCategoriaProduto;
    String nome;

    public Integer getIdCategoriaProduto() {
        return idCategoriaProduto;
    }

    public void setIdCategoriaProduto(Integer idCategoriaProduto) {
        this.idCategoriaProduto = idCategoriaProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
