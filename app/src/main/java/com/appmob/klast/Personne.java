package com.appmob.klast;

import android.location.Location;

import androidx.annotation.Nullable;

public abstract class Personne {
    private String nom;
    private String prenom;
    @Nullable private String numeroTel;
    private Location local;

    public Personne(String nom, String prenom, String numeroTel, Location local) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroTel = numeroTel;
        this.local = local;
    }

    public Location getLocal() {
        return local;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public String getNom() {
        return nom;
    }
}
