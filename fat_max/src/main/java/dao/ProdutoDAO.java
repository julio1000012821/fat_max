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
import entity.Produto;
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
public class ProdutoDAO {
    
    public Produto pesquisar(int id) throws ProtocolException, IOException
    {

        Gson gson  = Api.getGson(Routes.produtoListar + id);

        Produto modelo = gson.fromJson(Api.reader, Produto.class);
             
        return modelo;
    }
    
    public List<Produto> listar()
    {
        try {
            Gson gson  = Api.getGson(Routes.produtoListar);
            return gson.fromJson(Api.reader, new TypeToken<List<Produto>>(){}.getType());
        } catch (ProtocolException ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ArrayList<>();
    }
}
