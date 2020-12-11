package com.acme;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class JednostkaService {

@PersistenceContext(name = "GeoPC")
EntityManager em;

public List<Jednostka> getAllJednostka(){
    return (List<Jednostka>)em.createQuery("SELECT j FROM Jednostka j",Jednostka.class)
            .getResultList();
}

public List<String> getSelectedJednostka(String wojString, String powString, String gmiString){
    return (List<String>)em.createQuery("SELECT j.Nazwa_jednostki FROM Jednostka j where UPPER(j.Wojewodztwo)=UPPER(:woj) and UPPER(j.Powiat)=UPPER(:pow) and UPPER(j.Gmina)=UPPER(:gmi) order by j.Miejscowosc",String.class)
            .setParameter("woj", wojString)
            .setParameter("pow", powString)
            .setParameter("gmi", gmiString)
            .getResultList();
}

}
