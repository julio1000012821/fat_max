/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package managedbean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import config.Routes;
import config.api.Api;
import entity.Moeda;
import java.io.IOException;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.primefaces.shaded.json.JSONObject;

/**
 *
 * @author juliosilva
 */
@Named(value = "moedaBean")
@ViewScoped
public class MoedaBean implements Serializable {

    /**
     * Creates a new instance of MoedaBean
     */
    private Moeda moeda;
    private List<Moeda> items, listaFiltrada;
    
    public MoedaBean() {
    }
    
    @PostConstruct
    public void init(){
        moeda = new Moeda();
    }

    public Moeda getMoeda() {
        return moeda;
    }

    public void setMoeda(Moeda moeda) {
        this.moeda = moeda;
    }

    public List<Moeda> getItems() {
        return items;
    }

    public void setItems(List<Moeda> items) {
        this.items = items;
    }

    public List<Moeda> getListaFiltrada() {
        return listaFiltrada;
    }

    public void setListaFiltrada(List<Moeda> listaFiltrada) {
        this.listaFiltrada = listaFiltrada;
    }
    
    public void salvar(){
        
        try {
            
            JSONObject json = new JSONObject();
            json.put("nome", moeda.getNome());
            json.put("valor", moeda.getValor());

            Api.post(json, Routes.moedaRegistar);
        } 
        catch (UnsupportedEncodingException ex){
            
            ex.printStackTrace();
        }
    }
    
    public List<Moeda> listar(){
        try {
            Gson gson  = Api.getGson(Routes.moedaListar);
            return gson.fromJson(Api.reader, new TypeToken<List<Moeda>>(){}.getType());
        } catch (ProtocolException ex) {
            Logger.getLogger(MoedaBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MoedaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }
    
    public void remover(Moeda item){
        
        try 
        {
            Api.Delete(Routes.moedaEliminar + item.getIdMoeda());
        } catch (ProtocolException ex) {
            Logger.getLogger(MoedaBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MoedaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
}
