package com.acme;

import java.util.List;
import javax.inject.Inject;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

@GraphQLApi
public class JednostkaAPI {

@Inject
JednostkaService service;

@Query
public List<Jednostka> getAllJednostka(){
    return service.getAllJednostka();
}

@Query
public Jednostka getJednostka(Long id){
    return service.getJednostka(id);
}

@Query
public List<Jednostka> getSelectedJednostka(String w, String p, String g){
    return service.getSelectedJednostka(w, p, g);
}

}
