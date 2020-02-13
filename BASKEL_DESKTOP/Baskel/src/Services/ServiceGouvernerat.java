/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;


import Model.Delegation;
import Model.Gouvernorat;
import Utils.DataBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hpp
 */
public class ServiceGouvernerat {
    private Connection con;
    private Statement ste;
    public ServiceGouvernerat  (){
        con = DataBase.getInstance().getConnection();
    }
    public List<Gouvernorat> readAll() throws SQLException {
        List<Gouvernorat> arr=new ArrayList<>();
        ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select * from gouvernorat  ");
        while (rs.next()) {                
               int id_gouv=rs.getInt(1);
               String nom_gouv=rs.getString(2); 
               
               Gouvernorat g=new Gouvernorat(id_gouv , nom_gouv) ;
               arr.add(g);
            }
        return arr;
    }
    public List<Delegation> readAll(Gouvernorat g) throws SQLException {
        List<Delegation> arr=new ArrayList<>();
        ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select * from Delegation WHERE `delegation`.`id_gouv`='"+g.getId_gouv()+"'   ");
        while (rs.next()) {                
               int id_gouv=rs.getInt(1);
               String nom_deleg=rs.getString(2); 
               
               Delegation d=new Delegation(id_gouv , nom_deleg) ;
               arr.add(d);
            }
        return arr;
    }
    
    
}
