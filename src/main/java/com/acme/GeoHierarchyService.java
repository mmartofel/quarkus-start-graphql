package com.acme;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class GeoHierarchyService {
    
@PersistenceContext(name = "GeoPC")
EntityManager em;

public List<GeoHierarchy> getAllGeo(){
    return (List<GeoHierarchy>)em.createQuery("SELECT g FROM GeoHierarchy g",GeoHierarchy.class)
            .getResultList();
}

public List<String> getAllWojewodztwo(){
    return (List<String>)em.createQuery("SELECT DISTINCT g.Wojewodztwo FROM GeoHierarchy g order by g.Wojewodztwo",String.class)
            .getResultList();
}

public List<String> getAllPowiat(String wojString){
    return (List<String>)em.createQuery("SELECT DISTINCT g.Powiat FROM GeoHierarchy g where Wojewodztwo=:woj order by g.Powiat",String.class)
    .setParameter("woj", wojString)
    .getResultList();
}

public List<String> getAllGmina(String wojString, String powString){
    return (List<String>)em.createQuery("SELECT DISTINCT g.Gmina FROM GeoHierarchy g where Wojewodztwo=:woj and Powiat=:pow order by g.Gmina",String.class)
    .setParameter("woj", wojString)
    .setParameter("pow", powString)
    .getResultList();
}

public List<String> getAllMiejscowosc(String wojString, String powString, String gmiString){
    return (List<String>)em.createQuery("SELECT DISTINCT g.Miejscowosc FROM GeoHierarchy g where Wojewodztwo=:woj and Powiat=:pow and g.Gmina=:gmi order by g.Miejscowosc",String.class)
    .setParameter("woj", wojString)
    .setParameter("pow", powString)
    .setParameter("gmi", gmiString)
    .getResultList();
}

public GeoHierarchy getOneGeo(int Id) {
    return em.find(GeoHierarchy.class, Id);
}

}
