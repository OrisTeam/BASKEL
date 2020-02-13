/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author MohamedBouzid *** 
 */
public class Annonce_location extends Annonce {
   private int dispo ;
   private float prix_heure ;
   private float prix_jour ;

    public Annonce_location( String description, int num_tel,String Gouvernorat, String Delegation,String address ,int dispo,String photo,float prix_heure,float prix_jour,int type) {
          super( description,  num_tel, Gouvernorat,  Delegation,address, photo,type);
        this.dispo = dispo ;
        this.prix_heure = prix_heure ; 
        this.prix_jour=prix_jour ;
        
    }

    public Annonce_location(int ann_id) {
        super(ann_id);
    }

    public Annonce_location(int dispo, float prix_heure, float prix_jour, int ann_id, String description, int num_tel, Date date, String gouvernorat, String delegation, String address, String photo, int signals,int type) {
        super(ann_id, description, num_tel, date, gouvernorat, delegation, address, photo, signals,type);
        this.dispo = dispo;
        this.prix_heure = prix_heure;
        this.prix_jour = prix_jour;
    }
    

    public int getDispo() {
        return dispo;
    }

    public float getPrix_heure() {
        return prix_heure;
    }

    public float getPrix_jour() {
        return prix_jour;
    }

    public void setDispo(int dispo) {
        this.dispo = dispo;
    }

    public void setPrix_heure(float prix_heure) {
        this.prix_heure = prix_heure;
    }

    public void setPrix_jour(float prix_jour) {
        this.prix_jour = prix_jour;
    }

    @Override
    public String toString() {
        return "Annonce_location{" + "dispo=" + dispo + ", prix_heure=" + prix_heure + ", prix_jour=" + prix_jour + '}';
    }
}
