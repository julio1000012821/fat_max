/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author juliosilva
 */

public class Fatura implements Serializable{
    private Integer idFatura;
    
    private Utilizador idUtilizador;
    
    private LocalDate dataRegisto;
    
    private Cliente idCliente;
    
    private Double valorTotal;

    private TipoFatura idTipoFatura;
    
    private String numeracao;
    
    private Moeda idMoeda;
    
    List<FaturaItem> items;

    public Integer getIdFatura() {
        return idFatura;
    }

    public void setIdFatura(Integer idFatura) {
        this.idFatura = idFatura;
    }

    public Utilizador getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(Utilizador idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public LocalDate getDataRegisto() {
        return dataRegisto;
    }

    public void setDataRegisto(LocalDate dataRegisto) {
        this.dataRegisto = dataRegisto;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public TipoFatura getIdTipoFatura() {
        return idTipoFatura;
    }

    public void setIdTipoFatura(TipoFatura idTipoFatura) {
        this.idTipoFatura = idTipoFatura;
    }

    public String getNumeracao() {
        return numeracao;
    }

    public void setNumeracao(String numeracao) {
        this.numeracao = numeracao;
    }

    public List<FaturaItem> getItems() {
        return items;
    }

    public void setItems(List<FaturaItem> items) {
        this.items = items;
    }

    public Moeda getIdMoeda() {
        return idMoeda;
    }

    public void setIdMoeda(Moeda idMoeda) {
        this.idMoeda = idMoeda;
    }
}
