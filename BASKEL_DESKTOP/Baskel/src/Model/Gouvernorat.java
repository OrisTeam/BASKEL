/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author hpp
 */
public class Gouvernorat {
   private int id_gouv ;
   private String nom_gouv ;

    public Gouvernorat(int id_gouv, String nom_gouv) {
        this.id_gouv = id_gouv;
        this.nom_gouv = nom_gouv;
    }

    public Gouvernorat(String nom_gouv) {
        this.nom_gouv = nom_gouv;
    }
    

    public int getId_gouv() {
        return id_gouv;
    }

    public String getNom_gouv() {
        return nom_gouv;
    }

    public void setId_gouv(int id_gouv) {
        this.id_gouv = id_gouv;
    }

    public void setNom_gouv(String nom_gouv) {
        this.nom_gouv = nom_gouv;
    }
    

    @Override
    public String toString() {
        return "Gouvernorat{" + "id_gouv=" + id_gouv + ", nom_gouv=" + nom_gouv + '}';
    }

   
    
    
}
