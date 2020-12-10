package com.acme;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "geohierarchy")
@Entity
public class GeoHierarchy {

@Id
public int Id;    
@Column(length = 30, unique = false)
public String Wojewodztwo;
@Column(length = 30, unique = false)
public String Powiat;
@Column(length = 30, unique = false)
public String Gmina;
@Column(length = 30, unique = false)
public String Miejscowosc;

    public GeoHierarchy() {
    }

    public GeoHierarchy(String Wojewodztwo, String Powiat, String Gmina, String Miejscowosc) {
        this.Wojewodztwo = Wojewodztwo;
        this.Powiat = Powiat;
        this.Gmina = Gmina;
        this.Miejscowosc = Miejscowosc;
    }

    public String getWojewodztwo() {
        return this.Wojewodztwo;
    }

    public void setWojewodztwo(String Wojewodztwo) {
        this.Wojewodztwo = Wojewodztwo;
    }

    public String getPowiat() {
        return this.Powiat;
    }

    public void setPowiat(String Powiat) {
        this.Powiat = Powiat;
    }

    public String getGmina() {
        return this.Gmina;
    }

    public void setGmina(String Gmina) {
        this.Gmina = Gmina;
    }

    public String getMiejscowosc() {
        return this.Miejscowosc;
    }

    public void setMiejscowosc(String Miejscowosc) {
        this.Miejscowosc = Miejscowosc;
    }

    public GeoHierarchy Wojewodztwo(String Wojewodztwo) {
        this.Wojewodztwo = Wojewodztwo;
        return this;
    }

    public GeoHierarchy Powiat(String Powiat) {
        this.Powiat = Powiat;
        return this;
    }

    public GeoHierarchy Gmina(String Gmina) {
        this.Gmina = Gmina;
        return this;
    }

    public GeoHierarchy Miejscowosc(String Miejscowosc) {
        this.Miejscowosc = Miejscowosc;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof GeoHierarchy)) {
            return false;
        }
        GeoHierarchy geoHierarchy = (GeoHierarchy) o;
        return Objects.equals(Wojewodztwo, geoHierarchy.Wojewodztwo) && Objects.equals(Powiat, geoHierarchy.Powiat) && Objects.equals(Gmina, geoHierarchy.Gmina) && Objects.equals(Miejscowosc, geoHierarchy.Miejscowosc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Wojewodztwo, Powiat, Gmina, Miejscowosc);
    }

    @Override
    public String toString() {
        return "{" +
            " Wojewodztwo='" + getWojewodztwo() + "'" +
            ", Powiat='" + getPowiat() + "'" +
            ", Gmina='" + getGmina() + "'" +
            ", Miejscowosc='" + getMiejscowosc() + "'" +
            "}";
    }

}
