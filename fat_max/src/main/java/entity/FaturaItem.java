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
public class FaturaItem implements Serializable{
    private static final long serialVersionUID = 1L;
    
    Integer idFaturaItem;
    Integer idFactura;
    double total;
    Produto idProduto;
    Integer quantidade;

    public Integer getIdFaturaItem() {
        return idFaturaItem;
    }

    public void setIdFaturaItem(Integer idFaturaItem) {
        this.idFaturaItem = idFaturaItem;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Produto getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
 
    
    
}
