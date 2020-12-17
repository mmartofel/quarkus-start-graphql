package com.acme;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class JednostkaService {

@PersistenceContext(name = "GeoPC")
EntityManager em;

public Jednostka getJednostka(int Id){
    return em.find(Jednostka.class, Id);
}

public List<Jednostka> getAllJednostka(){
    return (List<Jednostka>)em.createQuery("SELECT j FROM Jednostka j",Jednostka.class)
            .getResultList();
}

public List<Jednostka> getSelectedJednostka(String wojString, String powString, String gmiString){
    return (List<Jednostka>)em.createQuery("SELECT j FROM Jednostka j where UPPER(j.Wojewodztwo)=UPPER(:woj) and UPPER(j.Powiat)=UPPER(:pow) and UPPER(j.Gmina)=UPPER(:gmi) order by j.Miejscowosc",Jednostka.class)
            .setParameter("woj", wojString)
            .setParameter("pow", powString)
            .setParameter("gmi", gmiString)
            .getResultList();
}

}
