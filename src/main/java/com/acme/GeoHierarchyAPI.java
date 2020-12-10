package com.acme;

import java.util.List;
import javax.inject.Inject;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

@GraphQLApi
public class GeoHierarchyAPI {

@Inject
GeoHierarchyService service;

@Query
public GeoHierarchy getOneGeo(int Id){
    return service.getOneGeo(Id);
}

@Query
public List<GeoHierarchy> getAllGeo(){
    return service.getAllGeo();
}

@Query
public List<String> getAllWojewodztwo(){
    return service.getAllWojewodztwo();
}

@Query
public List<String> getAllPowiat(String Wojewodztwo){
    return service.getAllPowiat(Wojewodztwo);
}

@Query
public List<String> getAllGmina(String Wojewodztwo, String Powiat){
    return service.getAllGmina(Wojewodztwo,Powiat);
}

@Query
public List<String> getAllMiejscowosc(String Wojewodztwo, String Powiat, String Gmina){
    return service.getAllMiejscowosc(Wojewodztwo,Powiat,Gmina);
}

}
