/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import deploy.DeploymentConfiguration;
import entity.Person;
import facade.Factory;
import java.lang.ProcessBuilder.Redirect.Type;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String postPerson(String content) {
        JsonObject body = new JsonParser().parse(content).getAsJsonObject();
        int Num = 0;
        if (body.has("num")) {
            Num = body.get("num").getAsInt();
        }
        return new Gson().toJson(f.getEmployeesNum(Num));
    }

    @GET
    @Path("complete")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPers() {
        return gson.toJson(f.getPersonInfo());
    }

    @GET
    @Path("completeCompany")
    @Produces(MediaType.APPLICATION_JSON)
    public String getComp() {
        return gson.toJson(f.getAllCompany());
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersId(@PathParam("id") Long id) {
        try {
            if (f.getPersonInfoId(id).isEmpty()) {
                throw new QuoteNotFoundException("{\"code\": 404, \"message\": \"Quote with requested id: " + id + " not found\"} ");
            }
            return gson.toJson(f.getPersonInfoId(id));
        } catch (QuoteNotFoundException e) {
            return e.getMessage();
        }
    }

    @GET
    @Path("hobby/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersHobby(@PathParam("id") long id) {
        return gson.toJson(f.getPersonHobby(id));
    }

    @GET
    @Path("contact/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersIdContactInfo(@PathParam("id") Long id) {
        try {
            if (f.getPersonInfoId(id).isEmpty()) {
                throw new QuoteNotFoundException("{\"code\": 404, \"message\": \"Quote with requested id: " + id + " not found\"} ");
            }
            return gson.toJson(f.getPersonContactInfo(id));
        } catch (QuoteNotFoundException e) {
            return e.getMessage();
        }
    }

    @GET
    @Path("cityinfo")
    @Produces(MediaType.APPLICATION_JSON)
    public String getStr() {
        return gson.toJson(f.getCityInfo());
    }
}
