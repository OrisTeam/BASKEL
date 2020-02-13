/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//pour tester avec un user
package Model;

import java.util.Date;




/**
 *
 * @author MohamedBouzid ***
 */
public class UserTest {
    private int user_id ;
    private String nom ;
    private String prenom ;

    
     public UserTest(int user_id, String nom, String prenom) {
        this.user_id = user_id;
        this.nom = nom;
        this.prenom = prenom;
       
    }

    public int getUser_id() {
        return user_id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

   

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

   

    @Override
    public String toString() {
        return "UserTest{" + "user_id=" + user_id + ", nom=" + nom + ", prenom=" + prenom + '}';
    }
    

   
    
    
    
    
}
