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
public class Annonce_vente extends Annonce {
    private float prix ;

    public Annonce_vente(int ann_id) {
        super(ann_id);
    }

    public Annonce_vente(String description, int num_tel,String Gouvernorat, String Delegation,String address,String photo ,float prix,int type) {
      super( description,  num_tel, Gouvernorat,  Delegation,address, photo,type) ;
        this.prix=prix ;
    }

    public Annonce_vente(float prix, int ann_id, String description, int num_tel, Date date, String gouvernorat, String delegation, String address, String photo, int signals,int type) {
        super(ann_id, description, num_tel, date, gouvernorat, delegation, address, photo, signals,type);
        this.prix = prix;
    }
    

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
   
    @Override
    public String toString() {
        return super.toString()+ "Annonce_vente{" + "prix=" + prix + '}';
    }
}
