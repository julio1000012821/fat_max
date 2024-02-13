/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author juliosilva
 */
public class Util {
    
    public static List<Integer> listarAnos()
    {
          int ano_actual = Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()));
          List<Integer> lista = new ArrayList<>();
          for(int i = ano_actual; i >=1900 ; i--)
          {
                 lista.add(i);
          }
          
          return lista;
    }
    
    public static String findDiaSemana(Date data)
    {
        if(data.toString().contains("Mon"))
        {
            return "segunda-feira";
        }
        else if(data.toString().contains("Tue"))
        {
            return "terça-feira"; 
        }
        else if(data.toString().contains("Wed"))
        {
             return "quarta-feira"; 
        }
        else if(data.toString().contains("Thu"))
        {
            return "quinta-feira";  
        }
        else if(data.toString().contains("Fri"))
        {
            return "sexta-feira";  
        }
        else if(data.toString().contains("Sat"))
        {
            return "sabado";  
        }
        else if(data.toString().contains("Sun"))
        {
            return "domingo";  
        }
        
        
        return "";
    }
}
