/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import config.Routes;
import config.api.Api;
import entity.FormaPagamento;
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
public class FormaPagamentoDAO {
    public FormaPagamento pesquisar(int id) throws ProtocolException, IOException
    {

        Gson gson  = Api.getGson(Routes.formaPagamentoListar + id);

        FormaPagamento formaPagamento = gson.fromJson(Api.reader, FormaPagamento.class);
             
        return formaPagamento;
    }
    
    public List<FormaPagamento> listar()
    {
        try {
            Gson gson  = Api.getGson(Routes.formaPagamentoListar);
            return gson.fromJson(Api.reader, new TypeToken<List<FormaPagamento>>(){}.getType());
        } catch (ProtocolException ex) {
            Logger.getLogger(FormaPagamento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FormaPagamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ArrayList<>();
    }
    
}
