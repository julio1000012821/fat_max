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
public class Pagina implements Serializable{
    
    private static final long serialVersionUID = 1L;

    Integer idPagina;
    String nome;
    String url;
    String descricao;
    Menus idMenu;
    Integer estado;
    String icon;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getIdPagina() {
        return idPagina;
    }

    public void setIdPagina(Integer idPagina) {
        this.idPagina = idPagina;
    }

    public Menus getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Menus idMenu) {
        this.idMenu = idMenu;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
