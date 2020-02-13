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
public class Annonce_Accessoire extends Annonce {
    float prix ;
    int nbrdispo ;

    public Annonce_Accessoire(int ann_id) {
        super(ann_id);
    }
    
    
    public Annonce_Accessoire( String description, int num_tel,  String Gouvernorat, String Delegation,String address,String photo,float prix,int nbrdispo,int type) {
        super( description,  num_tel, Gouvernorat,  Delegation,address, photo,type);
        this.prix= prix ;
        this.nbrdispo = nbrdispo ;
    }

    public Annonce_Accessoire(float prix, int nbrdispo, int ann_id, String description, int num_tel, Date date, String gouvernorat, String delegation, String address, String photo, int signals,int type) {
        super(ann_id, description, num_tel, date, gouvernorat, delegation, address, photo, signals,type);
        this.prix = prix;
        this.nbrdispo = nbrdispo;
    }
    

    public float getPrix() {
        return prix;
    }

    public int getNbrdispo() {
        return nbrdispo;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setNbrdispo(int nbrdispo) {
        this.nbrdispo = nbrdispo;
    }

    @Override
    public String toString() {
        return "Annonce_Accessoire{" + "prix=" + prix + ", nbrdispo=" + nbrdispo + '}';
    }
}
