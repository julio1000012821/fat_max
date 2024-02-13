/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import config.Routes;
import config.api.Api;
import entity.Cliente;
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
public class ClienteDAO {
    
    public Cliente pesquisar(int id) throws ProtocolException, IOException
    {

        Gson gson  = Api.getGson(Routes.clienteListar + id);

        Cliente cliente = gson.fromJson(Api.reader, Cliente.class);
             
        return cliente;
    }
    
    public List<Cliente> listar()
    {
        try {
            Gson gson  = Api.getGson(Routes.clienteListar);
            return gson.fromJson(Api.reader, new TypeToken<List<Cliente>>(){}.getType());
        } catch (ProtocolException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ArrayList<>();
    }
}
