/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.ProdutoDAO;
import entity.Produto;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author juliosilva
 */
@FacesConverter(value = "produtoConverter")
public class ProdutoConverter implements Converter{
   @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        if (value != null && !value.equals("") && !value.equals("Selecione..."))
        {
            try
            {
                Integer id = Integer.parseInt(value);
                Produto modelo = new ProdutoDAO().pesquisar(id);
                return modelo;
            } 
            catch (NumberFormatException e)
            {
               e.printStackTrace();
            } catch (IOException ex) {
                Logger.getLogger(PerfilConverter.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && !value.equals(""))
        {
            Produto modelo = (Produto) value;
            if (modelo.getIdProduto()!= null)
            {
                return modelo.getIdProduto().toString();
            }
        }
        return null;
    } 
}
