/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import deploy.DeploymentConfiguration;
import facade.Factory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Hallur
 */
@Path("person")
public class TestResource {

    @Context
    private UriInfo context;
    private Factory f;
    private Gson gson;

    /**
     * Creates a new instance of TestResource
     */
    public TestResource() {
        f = new Factory();
        f.addEntityManagerFactory(Persistence.createEntityManagerFactory(DeploymentConfiguration.PU_NAME));
        gson = new Gson();
    }
    
    @GET
    @Path("complete")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPers(){
        return gson.toJson(f.getPersonInfo());
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersId(@PathParam("id") Long id){
        return gson.toJson(f.getPersonInfoId(id));
    }
    
    @GET
    @Path("cityinfo")
    @Produces(MediaType.APPLICATION_JSON)
    public String getStr() {
        return gson.toJson(f.getCityInfo());
    }
    
    @GET
    @Path("contactinfo")
    @Produces(MediaType.APPLICATION_JSON)
    public String getThis(){
        return gson.toJson(f.getPersonContactInfo());
    }
}
