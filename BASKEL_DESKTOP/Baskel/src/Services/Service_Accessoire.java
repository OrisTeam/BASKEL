/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Model.Annonce;
import Model.Annonce_Accessoire;
import Model.Annonce_vente;
import Model.UserTest;
import Utils.DataBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author hpp
 */
public class Service_Accessoire extends ServiceAnnonce {
    private Connection con;
    private Statement ste;
    
    public Service_Accessoire (){
         con = DataBase.getInstance().getConnection();
    }
    public void ajouter(Annonce_Accessoire a) throws SQLException {
        super.ajouter(a);
        ste = con.createStatement();
        String sql = "SELECT MAX(ann_id) FROM `annonces` " ;
        ResultSet rs= ste.executeQuery(sql);
        rs.absolute(1);
        int id=rs.getInt(1);
        String requeteInsert = "INSERT INTO `annonce_accessoire`(`prix`,`nbrdispo`,`ann_id`) VALUES ('"+a.getPrix()+"','"+a.getNbrdispo()+"','"+id+"')" ;
        ste.executeUpdate(requeteInsert);
    }
     public boolean delete(Annonce_Accessoire a) throws SQLException {
       return super.delete(a) ;
    }
     public boolean update(Annonce_Accessoire a) throws SQLException {
        ste = con.createStatement() ; 
        String requeteUpdate = "UPDATE `annonce_accessoire`  SET `prix` = '"+a.getPrix()+"',`nbrdispo`='"+a.getNbrdispo()+"' "  ; 
        if (ste.executeUpdate(requeteUpdate)!=0 && super.update(a)==true)
            return true ;
        else
        return false ;
    }
      public List<Annonce_Accessoire> readAllAcc() throws SQLException {
        List<Annonce_Accessoire> arr=new ArrayList<>();
        ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select * from `annonces`,`annonce_accessoire` WHERE `annonces`.`type`=4 AND `annonces`.`ann_id` =`annonce_accessoire`.`ann_id` ORDER BY date ");
        while (rs.next()) {                
               int id=rs.getInt(1);
               String description=rs.getString("description"); 
               int num_tel=rs.getInt(3);
               Date date=rs.getDate(4);
               String gouvernerat = rs.getString(5) ;
               String Delegation  = rs.getString(6);
               String Address = rs.getString(7) ;
               String photo = rs.getString(8) ;
               int Signals = rs.getInt(9) ;
               int type = rs.getInt(10) ;
               float prix =rs.getFloat("prix") ;
               int nbrdispo = rs.getInt("nbrdispo") ;
               
                       
               Annonce_Accessoire a=new Annonce_Accessoire(prix,  nbrdispo,  id,  description, num_tel,  date,  gouvernerat, Delegation, Address, photo,  Signals, type);
               arr.add(a);
                }
        return arr;
    }
      public UserTest  name_person(Annonce_Accessoire a ) throws SQLException {
        String sql  = "SELECT `user_id`  FROM `annonces`  WHERE  `annonces`.`ann_id` ='"+a.getAnn_id()+"'" ;
        ste=con.createStatement(); 
        ResultSet rs= ste.executeQuery(sql);
        rs.absolute(1);
        int id=rs.getInt(1);   
        String sql1  = "SELECT *  FROM `user` WHERE `user`.`user_id` ='"+id+"'" ;
        ste=con.createStatement(); 
        ResultSet rs1= ste.executeQuery(sql1);
        rs1.absolute(1);
        int id_user=rs1.getInt(1);
        String nom= rs1.getString(2) ;
        String prenom = rs1.getString(3) ;
        UserTest u =new UserTest(id_user, nom, prenom) ;
        return u ;
    }
       //structure 1 prix croissant 2 décr
       public List<Annonce_Accessoire> filterA(String Gouvernorat ,String Delegation,int structure ) throws SQLException {
        List<Annonce_Accessoire> arr=new ArrayList<>();
        String sql ;
        if (structure==1){
        if (Gouvernorat==null){
          
              sql =  "select * from `annonces`,`annonce_accessoire` WHERE `annonces`.`type`=4 AND `annonces`.`ann_id` =`annonce_accessoire`.`ann_id` ORDER BY prix " ;
        }
        else{
             if(Delegation == null) 
             sql =   "select * from `annonces`,`annonce_accessoire` WHERE `annonces`.`type`=4 AND `annonces`.`ann_id` =`annonce_accessoire`.`ann_id` AND `annonces`.`gouvernorat`='"+ Gouvernorat +"' ORDER BY prix " ;
             else
             sql =   "select * from `annonces`,`annonce_accessoire` WHERE `annonces`.`type`=4 AND `annonces`.`ann_id` =`annonce_accessoire`.`ann_id` AND `annonces`.`gouvernorat`='"+ Gouvernorat +"'  AND `annonces`.`delegation`= '"+ Delegation +"' ORDER BY prix " ;
        } 
        }
         else{
        if (Gouvernorat==null){
          
              sql =  "select * from `annonces`,`annonce_accessoire` WHERE `annonces`.`type`=4 AND `annonces`.`ann_id` =`annonce_accessoire`.`ann_id` ORDER BY prix DESC " ;
        }
        else{
             if(Delegation == null) 
             sql =   "select * from `annonces`,`annonce_accessoire` WHERE `annonces`.`type`=4 AND `annonces`.`ann_id` =`annonce_accessoire`.`ann_id` AND `annonces`.`gouvernorat`='"+ Gouvernorat +"' ORDER BY prix DESC " ;
             else
             sql =   "select * from `annonces`,`annonce_accessoire` WHERE `annonces`.`type`=4 AND `annonces`.`ann_id` =`annonce_accessoire`.`ann_id` AND `annonces`.`gouvernorat`='"+ Gouvernorat +"'  AND `annonces`.`delegation`= '"+ Delegation +"' ORDER BY prix DESC " ;
        } 
        }
        
        ste=con.createStatement();      
        ResultSet rs=ste.executeQuery(sql);
        while (rs.next()) {                
               int id=rs.getInt(1);
               String description=rs.getString("description"); 
               int num_tel=rs.getInt(3);
               Date date=rs.getDate(4);
               String gouvernera = rs.getString(5) ;
               String Delegatio  = rs.getString(6);
               String Address = rs.getString(7) ;
               String photo = rs.getString(8) ;
               int Signals = rs.getInt(9) ; 
               int type =rs.getInt(10) ;
               float prix =rs.getFloat("prix") ;
               int nbrdispo = rs.getInt("nbrdispo") ;
               Annonce_Accessoire a=new Annonce_Accessoire(prix,  nbrdispo,  id,  description, num_tel,  date,  gouvernera, Delegatio, Address, photo,  Signals, type);
               arr.add(a);
            }
        return arr;
    }
       public Annonce_Accessoire  find_annonceAccessoire(int id) throws SQLException {
        String sql = "select * from `annonces`,`annonce_accessoire` WHERE `annonces`.`type`=4 AND `annonces`.`ann_id` =`annonce_accessoire`.`ann_id` AND `annonces`.`ann_id`='"+id+"'  " ;
        ste=con.createStatement(); 
        ResultSet rs= ste.executeQuery(sql);
        rs.absolute(1);
        int ida=rs.getInt(1);
        String description=rs.getString("description"); 
        int num_tel=rs.getInt(3);
        Date date=rs.getDate(4);
        String gouvernera = rs.getString(5) ;
        String Delegatio  = rs.getString(6);
        String Address = rs.getString(7) ;
        String photo = rs.getString(8) ;
        int Signals = rs.getInt(9) ;
        int type = rs.getInt(10) ;
        float prix =rs.getFloat("prix") ;
        int nbrdispo = rs.getInt("nbrdispo") ;
        Annonce_Accessoire a=new Annonce_Accessoire(prix,  nbrdispo,  id,  description, num_tel,  date,  gouvernera, Delegatio, Address, photo,  Signals, type);
        return a;
    }
       public boolean  find_annonceLoc_bool (int id) throws SQLException {
        String sql = "select * from `annonces`,`annonce_accessoire` WHERE `annonces`.`type`=4 AND `annonces`.`ann_id` =`annonce_accessoire`.`ann_id` AND `annonces`.`ann_id`='"+id+"'  " ;
        ste=con.createStatement(); 
        ResultSet rs= ste.executeQuery(sql);
        if (rs.absolute(1))
            return true ;
        else
            return false ;
   
     } 
       
     
    
}
