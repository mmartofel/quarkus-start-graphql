package com.acme;

import java.util.List;
import javax.inject.Inject;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;
import org.jboss.logging.Logger;

@GraphQLApi
public class JednostkaAPI {

    private static final Logger LOG = Logger.getLogger(GeoHierarchyAPI.class);

@Inject
JednostkaService service;

@Query
public List<Jednostka> getAllJednostka(){
    LOG.info("List of all JEDNOSTKA requested");
    return service.getAllJednostka();
}

@Query
public Jednostka getJednostka(int Id){
    LOG.info("Single JEDNOSTKA requested");
    return service.getJednostka(Id);
}

@Query
public List<Jednostka> getSelectedJednostka(String w, String p, String g){
    LOG.info("List of JEDNOSTKA at the area requested");
    return service.getSelectedJednostka(w, p, g);
}

}
