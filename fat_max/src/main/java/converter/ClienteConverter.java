/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.ClienteDAO;
import entity.Cliente;
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
@FacesConverter(value = "clienteConverter")
public class ClienteConverter implements Converter{
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        if (value != null && !value.equals("") && !value.equals("Selecione..."))
        {
            try
            {
                Integer id = Integer.parseInt(value);
                Cliente modelo = new ClienteDAO().pesquisar(id);

                return modelo;
            } 
            catch (NumberFormatException e)
            {
               e.printStackTrace();
            } catch (IOException ex) {
                Logger.getLogger(ClienteConverter.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && !value.equals(""))
        {
            Cliente modelo = (Cliente) value;
            if (modelo.getIdCliente()!= null)
            {
                return modelo.getIdCliente().toString();
            }
        }
        return null;
    }
    
}
