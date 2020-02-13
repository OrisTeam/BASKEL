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
public class Delegation {
    private int id_deleg ;
    private String nom ;

    public Delegation(int id_deleg, String nom) {
        this.id_deleg = id_deleg;
        this.nom = nom;
    }

    public Delegation(String nom) {
        this.nom = nom;
    }
    

    public int getId_deleg() {
        return id_deleg;
    }

    public String getNom() {
        return nom;
    }

    public void setId_deleg(int id_deleg) {
        this.id_deleg = id_deleg;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Delegation{" + "id_deleg=" + id_deleg + ", nom=" + nom + '}';
    }
    
    
}
