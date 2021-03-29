package com.appmob.klast.user;

import android.location.Location;

import com.appmob.klast.Personne;

public class Employe extends Personne {
    public Employe(String nom, String prenom, String numeroTel, Location local) {
        super(nom, prenom, numeroTel, local);
    }
}
