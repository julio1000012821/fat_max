/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package managedbean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import config.Routes;
import config.api.Api;
import dao.PerfilDAO;
import entity.Cliente;
import entity.Perfil;
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
@Named(value = "perfilBean")
@ViewScoped
public class PerfilBean implements Serializable {

    /**
     * Creates a new instance of PerfilBean
     */
    private Perfil perfil;
    private List<Perfil> items, listaFiltrada;
    private PerfilDAO dao;
    public PerfilBean() {
    }
    
    @PostConstruct
    public void init(){
        dao = new PerfilDAO();
    }
    
    public List<Perfil> listar()
    {
        return dao.listar();
    }
    
    public Perfil pesquisar(int id)
    {
        try {
            return dao.pesquisar(id);
            
        } catch (IOException ex) {
            Logger.getLogger(PerfilBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
