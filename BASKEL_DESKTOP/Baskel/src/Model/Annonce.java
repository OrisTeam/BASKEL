/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author MohamedBouzid***
 */
public class Annonce {
    private int ann_id ;
    private String description ;
    private int num_tel ;
    private Date date ;
    private String gouvernorat ;
    private String delegation ;
    String address ;
    private String photo ;
    private int signals ;
    private int type ; //1 pour echange /2 pour vente/3 pour location /4 pour accessoires 

    public Annonce(int ann_id) {
        this.ann_id = ann_id;
    }

    



    public Annonce(String description, int num_tel, String gouvernorat, String delegation, String address, String photo,int type) {
        this.description = description;
        this.num_tel = num_tel;
        this.gouvernorat = gouvernorat;
        this.delegation = delegation;
        this.address = address;
        this.photo = photo;
        this.type=type ;
    }

    public Annonce(int ann_id, String description, int num_tel, Date date, String gouvernorat, String delegation, String address, String photo, int signals,int type) {
        this.ann_id = ann_id;
        this.description = description;
        this.num_tel = num_tel;
        this.date = date;
        this.gouvernorat = gouvernorat;
        this.delegation = delegation;
        this.address = address;
        this.photo = photo;
        this.signals = signals;
        this.type=type ;
    }
    
    

    public int getAnn_id() {
        return ann_id;
    }

    public void setAnn_id(int ann_id) {
        this.ann_id = ann_id;
    }

  

    public String getDescription() {
        return description;
    }

    public int getNum_tel() {
        return num_tel;
    }

    public Date getDate() {
        return date;
    }

    public String getGouvernorat() {
        return gouvernorat;
    }

    public String getDelegation() {
        return delegation;
    }

    public void setId(int id) {
        this.ann_id = id;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNum_tel(int num_tel) {
        this.num_tel = num_tel;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setGouvernorat(String Gouvernorat) {
        this.gouvernorat = Gouvernorat;
    }

    public void setDelegation(String Delegation) {
        this.delegation = Delegation;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Annonce other = (Annonce) obj;
        if (this.ann_id != other.ann_id) {
            return false;
        }
        return true;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSignals() {
        return signals;
    }

    public void setSignals(int signals) {
        this.signals = signals;
    }

    @Override
    public String toString() {
        return "Annonce{" + "ann_id=" + ann_id + ", description=" + description + ", num_tel=" + num_tel + ", date=" + date + ", gouvernorat=" + gouvernorat + ", delegation=" + delegation + ", address=" + address + ", photo=" + photo + ", signals=" + signals + ", type=" + type + '}';
    }

    
    

    
}
