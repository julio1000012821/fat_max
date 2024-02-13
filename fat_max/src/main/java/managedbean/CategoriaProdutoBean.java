/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package managedbean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import config.Routes;
import config.api.Api;
import entity.CategoriaProduto;
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
@Named(value = "categoriaProdutoBean")
@ViewScoped
public class CategoriaProdutoBean implements Serializable {

    /**
     * Creates a new instance of CategoriaProdutoBean
     */
    private CategoriaProduto categoria;
    private List<CategoriaProduto> items, listaFiltrada;
    public CategoriaProdutoBean() {
    }
    
    @PostConstruct
    public void init(){
        categoria = new CategoriaProduto();
    }

    public List<CategoriaProduto> getListaFiltrada() {
        return listaFiltrada;
    }

    public void setListaFiltrada(List<CategoriaProduto> listaFiltrada) {
        this.listaFiltrada = listaFiltrada;
    }

    public CategoriaProduto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProduto categoria) {
        this.categoria = categoria;
    }

    public List<CategoriaProduto> getItems() {
        return items;
    }

    public void setItems(List<CategoriaProduto> items) {
        this.items = items;
    }
    
    public void salvar(){
        
        try {
            
            JSONObject json = new JSONObject();
            json.put("nome", categoria.getNome());
            Api.post(json, Routes.categoriaProdutoRegistar);
        } 
        catch (UnsupportedEncodingException ex){
            
            ex.printStackTrace();
        }
    }
    
    public List<CategoriaProduto> listar(){
        try {
            Gson gson  = Api.getGson(Routes.categoriaProdutoListar);
            return gson.fromJson(Api.reader, new TypeToken<List<CategoriaProduto>>(){}.getType());
        } catch (ProtocolException ex) {
            Logger.getLogger(CategoriaProdutoBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CategoriaProdutoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }
    
    public void remover(CategoriaProduto item){
        
        try 
        {
            Api.Delete(Routes.categoriaProdutoEliminar + item.getIdCategoriaProduto());
        } catch (ProtocolException ex) {
            Logger.getLogger(CategoriaProdutoBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CategoriaProdutoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
