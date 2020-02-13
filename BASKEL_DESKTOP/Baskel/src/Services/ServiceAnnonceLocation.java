/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Model.Annonce;
import Model.Annonce_location;
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
 * @author MohamedBouzid *** 
 */
public class ServiceAnnonceLocation extends ServiceAnnonce {
    private Connection con;
    private Statement ste;
    public ServiceAnnonceLocation (){
        con = DataBase.getInstance().getConnection();
    }
    public void ajouter(Annonce_location a) throws SQLException  {
        super.ajouter(a);
        ste = con.createStatement();
        String sql = "SELECT MAX(ann_id) FROM `annonces` " ;
        ResultSet rs= ste.executeQuery(sql);
        rs.absolute(1);
        int id=rs.getInt(1);
       
        String requeteInsert = "INSERT INTO `annonce_location`(`dispo`,`prix_heure`,`prix_jour`,`ann_id`) VALUES ('"+a.getDispo()+"','"+a.getPrix_heure()+"','"+a.getPrix_jour()+"','"+id+"')" ;
        ste.executeUpdate(requeteInsert);
    }
     public boolean delete(Annonce_location a) throws SQLException {
        return super.delete(a) ;
    }
        public boolean update(Annonce_location a) throws SQLException {
        ste = con.createStatement() ; 
        String requeteUpdate = "UPDATE `annonce_location`  SET `dispo` = '"+a.getDispo()+"',`prix_heure` = '"+a.getPrix_heure()+"' ,`prix_jour` = '"+a.getPrix_jour()+"'"  ; 
        if (ste.executeUpdate(requeteUpdate)!=0 && super.update(a)==true)
            return true ;
        else
        return false ;
    }
        //affiche que les ann dispo
    public List<Annonce_location> readAllLocation() throws SQLException {
        List<Annonce_location> arr=new ArrayList<>();
        ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select * from `annonces`,`annonce_location` WHERE `annonces`.`type`=3 AND `annonces`.`ann_id` =`Annonce_location`.`ann_id` AND `annonce_location`.`dispo`=1 ORDER BY date ");
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
               int dispo =rs.getInt("dispo") ;
               float prix_heure =rs.getFloat("prix_heure") ;
               float prix_jour =rs.getFloat("prix_jour") ;
                 
               Annonce_location a=new Annonce_location(dispo,  prix_heure,prix_jour,id, description,  num_tel,  date, gouvernerat, Delegation,Address,  photo, Signals, type);
               arr.add(a);
                }
        return arr;
    }
    //rechercher un ann a partir id 
     public  Annonce_location getALid(Annonce_location a) throws SQLException{
         
        String sql = "select * from `annonces`,`annonce_location` WHERE `annonces`.`type`=3 AND `annonces`.`ann_id` ='"+a.getAnn_id()+"' " ;
        ResultSet rs=ste.executeQuery(sql) ;
        rs.absolute(1);
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
               int dispo =rs.getInt("dispo") ;
               float prix_heure =rs.getFloat("prix_heure") ;
               float prix_jour =rs.getFloat("prix_jour") ;
               Annonce_location an=new Annonce_location (dispo,  prix_heure,prix_jour,id, description,  num_tel,  date, gouvernerat, Delegation,Address,  photo, Signals, type);
        return an ;    
     }
     public UserTest  name_person(Annonce_location a ) throws SQLException {
        String sql  = "SELECT `user_id`  FROM `annonces`  WHERE  `annonces`.`ann_id` ='"+ a.getAnn_id()+"'" ;
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
     //filtre selon prix heure
     public List<Annonce> filterH(String Gouvernorat ,String Delegation,int structure ) throws SQLException {
        List<Annonce> arr=new ArrayList<>();
        String sql ;
        if (structure==1){
            if (Gouvernorat==null){
                sql =  "select * from `annonces`,`annonce_location` WHERE `annonces`.`type`=3 AND `annonces`.`ann_id` =`annonce_location`.`ann_id` ORDER BY prix_heure " ;
            }
        else{
            if(Delegation == null) 
             sql =   "select * from `annonces`,`annonce_location` WHERE `annonces`.`type`=3 AND `annonces`.`ann_id` =`annonce_location`.`ann_id` AND `annonces`.`gouvernorat`='"+ Gouvernorat +"' ORDER BY prix_heure " ;
             else
             sql =   "select * from `annonces`,`annonce_location` WHERE `annonces`.`type`=3 AND `annonces`.`ann_id` =`annonce_location`.`ann_id` AND `annonces`.`gouvernorat`='"+ Gouvernorat +"'  AND `annonces`.`delegation`= '"+ Delegation +"' ORDER BY prix_heure" ;
             } 
         }
        else{
        if (Gouvernorat==null){
            sql =  "select * from `annonces`,`annonce_location` WHERE `annonces`.`type`=3 AND `annonces`.`ann_id` =`annonce_location`.`ann_id` ORDER BY prix_heure DESC " ;
            }
        else{
            if(Delegation == null) 
            sql =   "select * from `annonces`,`annonce_location` WHERE `annonces`.`type`=3 AND `annonces`.`ann_id` =`annonce_location`.`ann_id` AND `annonces`.`gouvernorat`='"+ Gouvernorat +"' ORDER BY prix_heure DESC " ;
            else
            sql =   "select * from `annonces`,`annonce_location` WHERE `annonces`.`type`=3 AND `annonces`.`ann_id` =`annonce_location`.`ann_id` AND `annonces`.`gouvernorat`='"+ Gouvernorat +"'  AND `annonces`.`delegation`= '"+ Delegation +"' ORDER BY prix_heure DESC " ;
            } 
        }
        ResultSet rs=ste.executeQuery(sql);
        while (rs.next()) {                
               int id=rs.getInt(1);
               String description=rs.getString("description"); 
               int num_tel=rs.getInt(3);
               Date date=rs.getDate(4);
               String gouvernerat = rs.getString(5) ;
               String delegation  = rs.getString(6);
               String Address = rs.getString(7) ;
               String photo = rs.getString(8) ;
               int Signals = rs.getInt(9) ;
               int type = rs.getInt(10) ;
               int dispo =rs.getInt("dispo") ;
               float prix_heure =rs.getFloat("prix_heure") ;
               float prix_jour =rs.getFloat("prix_jour") ;
               Annonce_location a=new Annonce_location(dispo,  prix_heure,prix_jour,id, description,  num_tel,  date, gouvernerat, delegation,Address,  photo, Signals, type);
               arr.add(a);
            }
        return arr;
        }


     //filtre selon prix jours
     public List<Annonce> filterJ(String Gouvernorat ,String Delegation,int structure ) throws SQLException {
        List<Annonce> arr=new ArrayList<>();
        String sql ;
        if (structure==1){
            if (Gouvernorat==null){
                sql =  "select * from `annonces`,`annonce_location` WHERE `annonces`.`type`=3 AND `annonces`.`ann_id` =`annonce_location`.`ann_id` ORDER BY prix_jour " ;
            }
        else{
            if(Delegation == null) 
             sql =   "select * from `annonces`,`annonce_location` WHERE `annonces`.`type`=3 AND `annonces`.`ann_id` =`annonce_location`.`ann_id` AND `annonces`.`gouvernorat`='"+ Gouvernorat +"' ORDER BY prix_jour " ;
             else
             sql =   "select * from `annonces`,`annonce_location` WHERE `annonces`.`type`=3 AND `annonces`.`ann_id` =`annonce_location`.`ann_id` AND `annonces`.`gouvernorat`='"+ Gouvernorat +"'  AND `annonces`.`delegation`= '"+ Delegation +"' ORDER BY prix_jour" ;
             } 
         }
        else{
        if (Gouvernorat==null){
            sql =  "select * from `annonces`,`annonce_location` WHERE `annonces`.`type`=3 AND `annonces`.`ann_id` =`annonce_location`.`ann_id` ORDER BY prix_jour DESC " ;
            }
        else{
            if(Delegation == null) 
            sql =   "select * from `annonces`,`annonce_location` WHERE `annonces`.`type`=3 AND `annonces`.`ann_id` =`annonce_location`.`ann_id` AND `annonces`.`gouvernorat`='"+ Gouvernorat +"' ORDER BY prix_jour DESC " ;
            else
            sql =   "select * from `annonces`,`annonce_location` WHERE `annonces`.`type`=3 AND `annonces`.`ann_id` =`annonce_location`.`ann_id` AND `annonces`.`gouvernorat`='"+ Gouvernorat +"'  AND `annonces`.`delegation`= '"+ Delegation +"' ORDER BY prix_jour DESC " ;
            } 
        }
        ResultSet rs=ste.executeQuery(sql);
        while (rs.next()) {                
               int id=rs.getInt(1);
               String description=rs.getString("description"); 
               int num_tel=rs.getInt(3);
               Date date=rs.getDate(4);
               String gouvernerat = rs.getString(5) ;
               String delegation  = rs.getString(6);
               String Address = rs.getString(7) ;
               String photo = rs.getString(8) ;
               int Signals = rs.getInt(9) ;
               int type = rs.getInt(10) ;
               int dispo =rs.getInt("dispo") ;
               float prix_heure =rs.getFloat("prix_heure") ;
               float prix_jour =rs.getFloat("prix_jour") ;
               Annonce_location a=new Annonce_location(dispo,  prix_heure,prix_jour,id, description,  num_tel,  date, gouvernerat, delegation,Address,  photo, Signals, type);
               arr.add(a);
            }
        return arr;
        }
       public boolean  find_annonce_bool (int id) throws SQLException {
        String sql = "select * from `annonces`,`annonce_location` WHERE `annonces`.`type`=3 AND `annonces`.`ann_id` ='"+id+"' " ;
        ste=con.createStatement(); 
        ResultSet rs= ste.executeQuery(sql);
        if (rs.absolute(1))
            return true ;
        else
            return false ;
   
     } 

     





}

        
        
    
         
    
     
    

