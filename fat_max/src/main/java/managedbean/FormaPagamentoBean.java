/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package managedbean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import config.Routes;
import config.api.Api;
import entity.Cliente;
import entity.FormaPagamento;
import java.io.IOException;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;

/**
 *
 * @author juliosilva
 */
@Named(value = "formaPagamentoBean")
@ViewScoped
public class FormaPagamentoBean implements Serializable {

    /**
     * Creates a new instance of FormaPagamentoBean
     */
    FormaPagamento formaPagamento;
    List<FormaPagamento> listaFiltrada, items;
    public FormaPagamentoBean() {
    }
    
    @PostConstruct
    public void init(){
        formaPagamento = new FormaPagamento();
    }
    
        public List<FormaPagamento> getListaFiltrada() {
        return listaFiltrada;
    }

    public void setListaFiltrada(List<FormaPagamento> listaFiltrada) {
        this.listaFiltrada = listaFiltrada;
    }
    
    
    
    public List<FormaPagamento> listar()
    {
        try {
            Gson gson  = Api.getGson(Routes.formaPagamentoListar);
            return gson.fromJson(Api.reader, new TypeToken<List<FormaPagamento>>(){}.getType());
        } catch (ProtocolException ex) {
            Logger.getLogger(FormaPagamentoBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FormaPagamentoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ArrayList<>();
    }
    
}
