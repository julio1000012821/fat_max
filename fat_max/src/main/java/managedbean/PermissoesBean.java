/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package managedbean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import config.Routes;
import config.api.Api;
import entity.MenuPerfil;
import entity.Menus;
import entity.Pagina;
import entity.Utilizador;
import java.io.IOException;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.primefaces.model.menu.Submenu;

/**
 *
 * @author juliosilva
 */
@Named(value = "permissoesBean")
@ViewScoped
public class PermissoesBean implements Serializable {

    /**
     * Creates a new instance of PermissoesBean
     */
    @Inject
    private LoginBean loginBean;
    private MenuModel model = new DefaultMenuModel(); 
    private String pagina;
    public PermissoesBean() {
    }
    
    @PostConstruct
    public void init()
    {
        try
        {
             //entityManager = new AreaEntityManager(); 
            
             model =  menuLateral(); 
        }
        catch(NullPointerException ex)
        {
            sendPage("index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(PermissoesBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public List<Pagina>  menuItems(int idMenu)
    {
        return  null;
        
        //paginasEntityManager.findMenu(idMenu, loginBean.utilizadorLogado().getIdPerfil());
    }
    
    public MenuModel menus() throws ProtocolException, IOException
    {
         
          
          DefaultMenuModel menuModelTemp = new DefaultMenuModel();
          List<Submenu> submenu = new ArrayList();
          Submenu submenuNivel1 = null;
          DefaultMenuItem menuItem = null;
          Utilizador utlizador = loginBean.utilizadorLogado();
          
          Gson gson  = Api.getGson("http://localhost/menu");
          List<Menus> lista = gson.fromJson(Api.reader, new TypeToken<List<Menus>>(){}.getType());
          
            System.out.println("lista:" + lista);
            int contadorSubmenuInfoGeral = 0;

              menuItem = DefaultMenuItem.builder().value("Início").icon("pi pi-home").build();
              menuItem.setAjax(true);
              menuItem.setStyle("font-size:13px;");
              menuItem.setProcess("@this");
              menuItem.setImmediate(true);
              
              menuItem.setUrl("home.xhtml");             
           
              menuItem.setIgnoreAutoUpdate(false);
              menuModelTemp.getElements().add(menuItem);
              
              System.out.println("elements : " +   menuModelTemp.getElements());
              System.out.println("elements8888 : " +   menuModelTemp);

//              
          for(Menus menu : lista)
          {
              submenuNivel1 = DefaultSubMenu.builder().label(menu.getNome()).build();
             
              submenu.add(submenuNivel1);
              
              //Gson gson  = Api.getGson("http://localhost/menu");
              List<Pagina> itensMenu  = new ArrayList<>();
                      
                      //= paginasEntityManager.findMenu(menu.getIdMenu(),utlizador.getIdPerfil().getIdPerfil());
    
              if(itensMenu.size() > 0)
              {
                    for(Pagina pagina : itensMenu)
                    {
                          menuItem = DefaultMenuItem.builder().value(pagina.getNome()).build();
                          menuItem.setProcess("@this");
                          menuItem.setAjax(true);
                          if( !Objects.equals(pagina.getUrl(), null) && !pagina.getUrl().isEmpty() )
                          {
                            menuItem.setUrl(pagina.getUrl());
                          }
//                          menuItem.setCommand("#{sendPage('" +  pagina.getUrl() + "')}");
                          menuItem.setIcon(pagina.getIcon() != null? pagina.getIcon():"");
                          menuItem.setImmediate(true);
                          menuItem.setStyle("font-size:13px;");
                          menuItem.setIgnoreAutoUpdate(false);
                          submenuNivel1.getElements().add(menuItem);
                    }
              }

//             submenu.get(contadorSubmenuInfoGeral).getElements().add(submenuNivel1);
                 ++contadorSubmenuInfoGeral;
          }
          
          
          submenu.forEach(sub -> {
              menuModelTemp.getElements().add(sub);
          });
          
          return menuModelTemp;
    }

    public MenuModel menuLateral() throws ProtocolException, IOException
    {
          DefaultMenuModel menuModelTemp = new DefaultMenuModel();
          List<Submenu> submenu = new ArrayList();
          Submenu submenuNivel1 = null;
          DefaultMenuItem menuItem = null;
          Utilizador utilizador = loginBean.utilizadorLogado();
//          System.out.println("menu:" + utilizador.getIdPerfil().getNome());
          Gson gson  = Api.getGson(Routes.menuListar);
          List<Menus> lista = gson.fromJson(Api.reader, new TypeToken<List<Menus>>(){}.getType());
//              
          for(Menus menu : lista)
          {
              submenuNivel1 = DefaultSubMenu.builder().label(menu.getNome()).build();
              submenu.add(submenuNivel1);

              gson  = Api.getGson(Routes.paginaListarPorPerfil +"menu=" + menu.getIdMenu() + "&perfil=" + utilizador.getIdPerfil().getIdPerfil());
              List<Pagina> itensMenu  = gson.fromJson(Api.reader, new TypeToken<List<Pagina>>(){}.getType());
                      //paginasEntityManager.findMenu(menu.getIdMenu(),utilizador.getIdPerfil().getIdPerfil());
              if(itensMenu.size() > 0)
              {
                    for(Pagina pagina : itensMenu)
                    {
                          menuItem = DefaultMenuItem.builder().value(pagina.getNome()).build();
                          menuItem.setProcess("@this");
                          menuItem.setAjax(true);
                          if( !Objects.equals(pagina.getUrl(), null) && !pagina.getUrl().isEmpty() )
                          {
                               menuItem.setUrl(pagina.getUrl());
                          }
//                          menuItem.setCommand("#{sendPage('" +  pagina.getUrl() + "')}");
                          menuItem.setIcon(pagina.getIcon() != null? pagina.getIcon():"");
                          menuItem.setImmediate(true);
                          menuItem.setStyle("font-size:13px;");
                          menuItem.setIgnoreAutoUpdate(false);
                          submenuNivel1.getElements().add(menuItem);
                    }
              }

//             submenu.get(contadorSubmenuInfoGeral).getElements().add(submenuNivel1);
          }
          
          
          submenu.forEach(sub -> {
              menuModelTemp.getElements().add(sub);
          });
          
          return menuModelTemp;
    }
    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }
    
    public void sendPage(String pagina) 
    {
        try 
        {
            FacesContext.getCurrentInstance().getExternalContext().redirect(pagina);
        } 
        catch (IOException ex)
        {
            
        }
    }
}
