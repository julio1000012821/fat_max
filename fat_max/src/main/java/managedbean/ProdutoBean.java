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
@Named(value = "produtoBean")
@ViewScoped
public class ProdutoBean implements Serializable {

    /**
     * Creates a new instance of ProdutoBean
     */
    private Produto produto;
    private List<Produto> items, listaFiltrada;
    CategoriaProduto categoria;
    int idCategoria;
    public ProdutoBean() {
        
    }
    
    @PostConstruct
    public void init(){
        items = listar();
        produto = new Produto();
        categoria = new CategoriaProduto();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getItems() {
        return items;
    }

    public void setItems(List<Produto> items) {
        this.items = items;
    }

    public List<Produto> getListaFiltrada() {
        return listaFiltrada;
    }

    public void setListaFiltrada(List<Produto> listaFiltrada) {
        this.listaFiltrada = listaFiltrada;
    }

    public CategoriaProduto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProduto categoria) {
        this.categoria = categoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    public void exportarExcel(){
        
        try {
            Api.export(Routes.produtoExportarExcel);
            
        } catch (ProtocolException ex) {
            Logger.getLogger(ProdutoBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProdutoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public List<Produto> listar(){
        try {
            Gson gson  = Api.getGson(Routes.produtoListar);
            return gson.fromJson(Api.reader, new TypeToken<List<Produto>>(){}.getType());
        } catch (ProtocolException ex) {
            Logger.getLogger(ProdutoBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProdutoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ArrayList<>();
    }
    
    public void remover(Produto item){
        
        try {
            Api.Delete(Routes.produtoEliminar + item.getIdProduto());
            
        } catch (ProtocolException ex) {
            Logger.getLogger(ProdutoBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProdutoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void salvar(){
        
        try {
            
            JSONObject json = new JSONObject();
            json.put("descricao", produto.getDescricao());
            json.put("idCategoriaProduto", idCategoria);
            json.put("quantidade", produto.getQuantidade());
            json.put("precoCompra", produto.getPrecoCompra());
            json.put("precoVenda", produto.getPrecoVenda());
            json.put("quantidadeExistente", produto.getQuantidadeExistente());
            json.put("idUtilizador", 13);
            Api.post(json, Routes.produtoRegistar);
        } catch (UnsupportedEncodingException ex) {
            
            ex.printStackTrace();
        }
    }
    
}
