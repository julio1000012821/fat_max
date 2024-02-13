/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author juliosilva
 */
@FacesConverter(value = "categoriaProdutoConverter")
public class CategoriaProdutoConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
//    @Override
//    public Object getAsObject(FacesContext context, UIComponent component, String value) {
//        
//        if (value != null && !value.equals(""))
//        {
//            try
//            {
//                Integer id = Integer.parseInt(value);
//                CategoriaProduto modelo = new AreaEntityManager().findById(id);
//                return modelo;
//            } 
//            catch (NumberFormatException e)
//            {
//               e.printStackTrace();
//            } 
//        }
//        
//        return null;
//    }
//
//    @Override
//    public String getAsString(FacesContext context, UIComponent component, Object value) {
//        if (value != null && !value.equals(""))
//        {
//            TbAreas modelo = (TbAreas) value;
//            if (modelo.getIdAreas() != null)
//            {
//                return modelo.getIdAreas().toString();
//            }
//        }
//        return null;
//    }
}
