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
import entity.Utilizador;
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
import util.MessageUtil;

/**
 *
 * @author juliosilva
 */
@Named(value = "utilizadorBean")
@ViewScoped
public class UtilizadorBean implements Serializable {

    /**
     * Creates a new instance of UtilizadorBean
     */
    
    private Utilizador utilizador;
    private List<Utilizador> items, listaFiltrada;
    private String confirmarSenha;
    
    public UtilizadorBean() {
    }
       
    @PostConstruct
    public void init(){
        utilizador = new Utilizador();
        items = listar(); 
    }

    
    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    public List<Utilizador> getItems() {
        return items;
    }

    public void setItems(List<Utilizador> items) {
        this.items = items;
    }

    public List<Utilizador> getListaFiltrada() {
        return listaFiltrada;
    }

    public void setListaFiltrada(List<Utilizador> listaFiltrada) {
        this.listaFiltrada = listaFiltrada;
    }

    public String getConfirmarSenha() {
        return confirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }
    
    public List<Utilizador> listar()
    {
        try {
            Gson gson  = Api.getGson(Routes.utilizadorListar);
            return gson.fromJson(Api.reader, new TypeToken<List<Utilizador>>(){}.getType());
        } catch (ProtocolException ex) {
            Logger.getLogger(Utilizador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Utilizador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ArrayList<>();
    }
    
    public void remover(Utilizador item){
        
        try {
            Api.Delete(Routes.utilizadorEliminar + item.getIdUtilizador());
            
        } catch (ProtocolException ex) {
            Logger.getLogger(ProdutoBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProdutoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void salvar(){
        
        try 
        {
            if(!utilizador.getSenha().equals(confirmarSenha)) {
                
                MessageUtil.Erro("Erro", "As senhas não são iguais");
                return;
            }
            
            JSONObject json = new JSONObject();
            json.put("nome", utilizador.getNome());
            json.put("senha", utilizador.getSenha());
            json.put("idPerfil", utilizador.getIdPerfil().getIdPerfil());

            Api.post(json, Routes.utilizadorRegistar);
        } catch (UnsupportedEncodingException ex) {
            
            ex.printStackTrace();
        }
    }
}
