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
import entity.Cliente;
import entity.Produto;
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
@Named(value = "clienteBean")
@ViewScoped
public class ClienteBean implements Serializable {

    /**
     * Creates a new instance of ClienteBean
     */
    
    private Cliente cliente;
    private List<Cliente> items, listaFiltrada;

    public ClienteBean() {
        
    }
    
    @PostConstruct
    public void init(){
        cliente = new Cliente();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getItems() {
        return items;
    }

    public void setItems(List<Cliente> items) {
        this.items = items;
    }

    public List<Cliente> getListaFiltrada() {
        return listaFiltrada;
    }

    public void setListaFiltrada(List<Cliente> listaFiltrada) {
        this.listaFiltrada = listaFiltrada;
    }
    
    
    
    public List<Cliente> listar()
    {
        try {
            Gson gson  = Api.getGson(Routes.clienteListar);
            return gson.fromJson(Api.reader, new TypeToken<List<Cliente>>(){}.getType());
        } catch (ProtocolException ex) {
            Logger.getLogger(ClienteBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClienteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ArrayList<>();
    }
    
    public void remover(Cliente item){
        
        try {
            Api.Delete(Routes.clienteEliminar + item.getIdCliente());
            
        } catch (ProtocolException ex) {
            Logger.getLogger(ProdutoBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProdutoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void salvar(){
        
        try {
            
            JSONObject json = new JSONObject();
            json.put("nome",cliente.getNome());
            json.put("nif", cliente.getNif());
            json.put("email", cliente.getEmail());
            json.put("contacto", cliente.getContacto());
            json.put("contactoAlternativo", cliente.getContactoAlternativo());

            json.put("endereco", cliente.getEndereco());
            Api.post(json, Routes.clienteRegistar);
        } catch (UnsupportedEncodingException ex) {
            
            ex.printStackTrace();
        }
    }

    
}
