/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.MoedaDAO;
import dao.PerfilDAO;
import entity.Moeda;
import entity.Perfil;
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
@FacesConverter(value = "moedaConverter")
public class MoedaConverter implements Converter{
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        if (value != null && !value.equals("") && !value.equals("Selecione..."))
        {
            try
            {
                Integer id = Integer.parseInt(value);
                Moeda modelo = new MoedaDAO().pesquisar(id);
                return modelo;
            } 
            catch (NumberFormatException e)
            {
               e.printStackTrace();
            } catch (IOException ex) {
                Logger.getLogger(MoedaConverter.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && !value.equals(""))
        {
            Moeda modelo = (Moeda) value;
            if (modelo.getIdMoeda()!= null)
            {
                return modelo.getIdMoeda().toString();
            }
        }
        return null;
    }
}
