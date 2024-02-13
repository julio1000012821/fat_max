/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package managedbean;

import com.google.gson.Gson;
import config.api.Api;
import entity.Utilizador;
import java.io.IOException;
import javax.inject.Named;
import java.io.Serializable;
import java.net.MalformedURLException;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author juliosilva
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    /**
     * Creates a new instance of LoginBean
     */
    String nome;
    String senha;
    public LoginBean() {
        
    }
    
    @PostConstruct
    public void init(){
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    private Utilizador utilizadorExiste() throws MalformedURLException, IOException 
    {        
        Gson gson = Api.getGson("http://localhost/utilizador/login?nome="+ nome.trim() +"&senha="+ senha.trim() +"");
        if (gson != null) {
          Utilizador user = gson.fromJson(Api.reader, Utilizador.class);
          return user;
        }
        
        return null;
    }
    
    public void login() throws MalformedURLException, IOException{
        
        
        FacesContext fc = FacesContext.getCurrentInstance();
         try
         {
              Utilizador utilizador = utilizadorExiste();
              if(utilizador != null)
              {  
                  HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
                  session.setAttribute("utilizador", utilizador);
                  sendPage("home.xhtml");
              }
//              else
//              {
//                   MessageUtil.Erro("Erro de Login", "Os dados estão incorretos, insere novamente");
//              }
         }  
         catch(Exception ex)
         {
            ex.printStackTrace();
         }
    }
    
    public String userName()
    {
        String nome =  utilizadorLogado().getNome().trim();
//        String primeiroNome = nome.substring(0, nome.indexOf(" ") );
//        String ultimoNome = nome.substring(nome.lastIndexOf(" "));
        
        return  nome;
    }
    
    public String getHome()
    {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
        Utilizador utilizador = (Utilizador) session.getAttribute("utilizador");
        
        return "home";
    }
    
   public void logout()
    {
       FacesContext fc = FacesContext.getCurrentInstance();
//       boolean valor = utilizadoresLogados.remove(utilizadorLogado);
//       for(int i = 0; i<utilizadoresLogados.size(); i++)
//       {
//           if(utilizadoresLogados.get(i).getIdUtilizador().getIdUtilizador() == utilizadorLogado.getIdUtilizador())
//           {
//              utilizadoresLogados.remove(i);
//              break;
//           } 
//       }
//       --total_utilizadores_activos;  
       HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
       session.invalidate();
       sendPage("index.xhtml");
    }
    
    public Utilizador utilizadorLogado()
    {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
        Utilizador utilizador = (Utilizador) session.getAttribute("utilizador");
        
        return utilizador;
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
