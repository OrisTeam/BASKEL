/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Utils.DataBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hpp
 */
public class ServiceStatistique {
    private Connection con;
    private Statement ste;
    public ServiceStatistique (){
         con = DataBase.getInstance().getConnection();
    }
   public float getStatVente(float min ,float max ) throws SQLException { 
    ste=con.createStatement();
    ResultSet rs1=ste.executeQuery("select prix from annonce_vente ") ;
    float px1 = 0 ;
     while (rs1.next()) { 
      float prix =rs1.getFloat("prix") ;
      px1+=prix ;
     }
    ResultSet rs=ste.executeQuery("select prix from annonce_vente WHERE `annonce_vente`.`prix`>='"+min+"' AND `annonce_vente`.`prix`<='"+max+"'  ") ;
    float px = 0 ;
    while (rs.next()) { 
      float prix =rs.getFloat("prix") ;
      px+=prix ;
     }
    float pourcentage = (px/px1) * 100 ;
        
    return pourcentage ;      
    }
    public float getStatLHeure(float min ,float max ) throws SQLException { 
    ste=con.createStatement();
    ResultSet rs1=ste.executeQuery("select * from annonce_location ") ;
    float px1 = 0 ;
     while (rs1.next()) { 
      float prix =rs1.getFloat("prix_heure") ;
      px1+=prix ;
     }
     
    ResultSet rs=ste.executeQuery("select prix_heure from annonce_location WHERE `annonce_location`.`prix_heure`>='"+min+"' AND `annonce_location`.`prix_heure`<='"+max+"'  ") ;
    float px = 0 ;
    while (rs.next()) { 
      float prix =rs.getFloat("prix_heure") ;
      px+=prix ;
     }
    float pourcentage = (px/px1) * 100 ;
     
        
    return pourcentage ;      
    }
      public float getStatLJour(float min ,float max ) throws SQLException { 
    ste=con.createStatement();
    ResultSet rs1=ste.executeQuery("select * from annonce_location ") ;
    float px1 = 0 ;
     while (rs1.next()) { 
      float prix =rs1.getFloat("prix_jour") ;
      px1+=prix ;
     }
     
    ResultSet rs=ste.executeQuery("select prix_jour from annonce_location WHERE `annonce_location`.`prix_jour`>='"+min+"' AND `annonce_location`.`prix_jour`<='"+max+"'  ") ;
    float px = 0 ;
    while (rs.next()) { 
      float prix =rs.getFloat("prix_jour") ;
      px+=prix ;
     }
    float pourcentage = (px/px1) * 100 ;
     
        
    return pourcentage ;      
    }
    
    
    
    
}
