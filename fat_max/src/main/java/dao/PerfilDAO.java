/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import config.Routes;
import config.api.Api;
import entity.Perfil;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juliosilva
 */
public class PerfilDAO {
    
    public Perfil pesquisar(int id) throws ProtocolException, IOException
    {

        Gson gson  = Api.getGson(Routes.perfilListar + id);

        Perfil perfil = gson.fromJson(Api.reader, Perfil.class);
             
        return perfil;
    }
    
    public List<Perfil> listar()
    {
        try {
            Gson gson  = Api.getGson(Routes.perfilListar);
            return gson.fromJson(Api.reader, new TypeToken<List<Perfil>>(){}.getType());
        } catch (ProtocolException ex) {
            Logger.getLogger(Perfil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Perfil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ArrayList<>();
    }
}
