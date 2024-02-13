/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author juliosilva
 */
public class MessageUtil {
    public MessageUtil(String summary, String detail, FacesMessage.Severity typeErro) 
    {
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage mensage = new FacesMessage(typeErro, summary, detail);
        context.addMessage(null, mensage);
    }

    public static void Erro(String summary, String detail) {

        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage mensage = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
        context.addMessage(null, mensage);
    }

    public static void Info(String summary, String detail) {

        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage mensage = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        context.addMessage(null, mensage);
    }

    public static void Alert(String summary, String detail) {

        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage mensage = new FacesMessage(FacesMessage.SEVERITY_WARN, summary, detail);
        context.addMessage(null, mensage);
    }
}
