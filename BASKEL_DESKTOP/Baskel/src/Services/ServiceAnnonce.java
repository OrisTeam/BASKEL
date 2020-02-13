package Services;


import Model.Annonce;
import Model.UserTest;
import Utils.DataBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hpp
 */
public class ServiceAnnonce {
    private Connection con;
    private Statement ste;
    
    public ServiceAnnonce (){
         con = DataBase.getInstance().getConnection();
    }
    //avec a.type tjrs = 1
    public void ajouter(Annonce a) throws SQLException  {
        UserTest u =new UserTest (1, "mohamed", "exmple") ; // à enlever 
        ste = con.createStatement();
        Date d1 = new Date();
        String requeteInsert = "INSERT INTO `annonces` (`ann_id`, `description`, `num_tel`, `date`,`gouvernorat`,`delegation`,`address`,`photo`,`signals`,`user_id`,`type`) VALUES (NULL, '" + a.getDescription() + "', '" + a.getNum_tel() + "', '" + new java.sql.Timestamp(d1.getTime()) + "', '" + a.getGouvernorat() + "', '" + a.getDelegation() + "', '" + a.getAddress() + "', '" + a.getPhoto() + "', '0', '" +u.getUser_id() + "', '" +a.getType()+ "');";
        ste.executeUpdate(requeteInsert);
    }
  
    public boolean delete(Annonce a) throws SQLException {
        ste = con.createStatement() ; 
        String requeteDelete =" DELETE FROM `annonces` WHERE `annonces`.`ann_id` ='"+a.getAnn_id() +"'" ;
        if (ste.executeUpdate(requeteDelete)==0)
            return false ;
        else
        return true ;        
    }
     public boolean update(Annonce a) throws SQLException {
        ste = con.createStatement() ; 
        String requeteUpdate = "UPDATE `annonces`  SET `description` = '"+a.getDescription()+"', `num_tel` = '"+a.getNum_tel()+"', `date` = '"+new java.sql.Timestamp(a.getDate().getTime())+"', `gouvernorat` = '"+a.getGouvernorat()+"', `delegation` = ' "+a.getDelegation()+"', `address` = '"+a.getAddress()+"', `photo` = '"+a.getPhoto()+"' WHERE `annonces`.`ann_id` = '"+a.getAnn_id()+"';  "  ; 
        if (ste.executeUpdate(requeteUpdate)==0)
            return false ;
        else
        return true ;
    }
    public List<Annonce> readAll() throws SQLException {
        List<Annonce> arr=new ArrayList<>();
        ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select * from annonces WHERE `annonces`.`type`=1 ORDER BY date ");
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
               Annonce a=new Annonce(id,description,num_tel,date,gouvernerat,Delegation,Address,photo,Signals,type);
               arr.add(a);
            }
        return arr;
    }
    public UserTest  name_person(Annonce a ) throws SQLException {
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
    public List<Annonce> filter(String Gouvernorat ,String Delegation) throws SQLException {
        List<Annonce> arr=new ArrayList<>();
        String sql ;
        if (Gouvernorat==null){
              sql ="select * from annonces WHERE  `annonces`.`type`=1 " ;
        }
        else{
             if(Delegation == null)           
           sql ="select * from annonces WHERE  `annonces`.`type`=1 AND `annonces`.`gouvernorat`='"+ Gouvernorat +"' " ;
             else
                  sql ="select * from annonces WHERE  `annonces`.`type`=1 AND `annonces`.`gouvernorat`='"+ Gouvernorat +"' AND `annonces`.`delegation`= '"+ Delegation +"'  " ;
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
               Annonce a=new Annonce(id,description,num_tel,date,gouvernera,Delegatio,Address,photo,Signals,type);
               arr.add(a);
            }
        return arr;
    }
     public Annonce  find_annonce (int id) throws SQLException {
        String sql  = "SELECT *  FROM `annonces`  WHERE `annonces`.`type`= 1 AND `annonces`.`ann_id` ='"+id+"'" ;
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
        Annonce ann=new Annonce(ida,description,num_tel,date,gouvernera,Delegatio,Address,photo,Signals,type);
        return ann ;
        
     }
        public boolean  find_annonce_bool (int id) throws SQLException {
        String sql  = "SELECT * FROM `annonces`  WHERE `annonces`.`type`=1 AND `annonces`.`ann_id` ='"+id+"'" ;
        ste=con.createStatement(); 
        ResultSet rs= ste.executeQuery(sql);
        if (rs.absolute(1))
            return true ;
        else
        return false ;
   
     } 
}

