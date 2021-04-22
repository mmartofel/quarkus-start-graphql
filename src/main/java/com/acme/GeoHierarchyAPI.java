package com.acme;

import java.util.List;
import javax.inject.Inject;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;
import org.jboss.logging.Logger;


@GraphQLApi
public class GeoHierarchyAPI {

    private static final Logger LOG = Logger.getLogger(GeoHierarchyAPI.class);

@Inject
GeoHierarchyService service;

@Query
public GeoHierarchy getOneGeo(int Id){
    LOG.info("Single geo location requested");
    return service.getOneGeo(Id);
}

@Query
public List<GeoHierarchy> getAllGeo(){
    LOG.info("ALL! geo locations requested");
    return service.getAllGeo();
}

@Query
public List<String> getAllWojewodztwo(){
    LOG.info("List of WOJEWODZTWO requested");
    return service.getAllWojewodztwo();
}

@Query
public List<String> getAllPowiat(String Wojewodztwo){
    LOG.info("List of POWIAT requested");
    return service.getAllPowiat(Wojewodztwo);
}

@Query
public List<String> getAllGmina(String Wojewodztwo, String Powiat){
    LOG.info("List of GMINA requested");
    return service.getAllGmina(Wojewodztwo,Powiat);
}

@Query
public List<String> getAllMiejscowosc(String Wojewodztwo, String Powiat, String Gmina){
    LOG.info("List of MIEJSCOWOSC requested");
    return service.getAllMiejscowosc(Wojewodztwo,Powiat,Gmina);
}

}
