/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Cityinfo;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Christian
 * Christian used a lot of time, trying to get the server up and running, so we
 * didn't have too uch time to make tests. The only test we made checked if the 
 * CityInfo database list was empty, from the FactoryFacade.
 * We haven't tested our REST API.
 */
public class FactoryTest {
    
    private EntityManagerFactory emf;
    private Factory f;
    private String PU = "pu";
    
    public FactoryTest() {
        f = new Factory();
    }
    
    @BeforeClass 
    public static void setUpClass() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3306;
        RestAssured.basePath = "/CourseAssignment1";
        RestAssured.defaultParser = Parser.JSON;
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.out.println("SetUp");
        emf = Persistence.createEntityManagerFactory(PU);
        f.addEntityManagerFactory(emf);
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testGetCityInfo() {
        System.out.println("getCityInfo");
        Factory factory = new Factory();
        factory.addEntityManagerFactory(emf);
        List<Cityinfo> result = factory.getCityInfo();
        System.out.println(result);
        assertTrue(!result.isEmpty());
    }    
}
