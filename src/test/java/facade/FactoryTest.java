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
 */
public class FactoryTest {
    
    private EntityManagerFactory emf;
    private Factory f;
    private String PU = "PU_DERBY";
    
    public FactoryTest() {
        f = new Factory();
    }
    
    @BeforeClass 
    public static void setUpClass() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
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
    
    

    /**
     * Test of addEntityManagerFactory method, of class Factory.
     *//*
    @Test
    public void testAddEntityManagerFactory() {
        System.out.println("addEntityManagerFactory");
        EntityManagerFactory emf = null;
        Factory instance = new Factory();
        instance.addEntityManagerFactory(emf);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEntityManager method, of class Factory.
     *//*
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        Factory instance = new Factory();
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCityInfo method, of class Factory.
     */
    @Test
    public void testGetCityInfo() {
        System.out.println("getCityInfo");
        Factory factory = new Factory();
        factory.addEntityManagerFactory(emf);
        List<Cityinfo> result = factory.getCityInfo();
        System.out.println(result);
        assertTrue(result.isEmpty());
    }

    /**
     * Test of getPersonInfo method, of class Factory.
     *//*
    @Test
    public void testGetPersonInfo() {
        System.out.println("getPersonInfo");
        Factory instance = new Factory();
        String expResult = "";
        String result = instance.getPersonInfo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPersonContactInfo method, of class Factory.
     *//*
    @Test
    public void testGetPersonContactInfo() {
        System.out.println("getPersonContactInfo");
        Factory instance = new Factory();
        String expResult = "";
        String result = instance.getPersonContactInfo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPersonInfoId method, of class Factory.
     *//*
    @Test
    public void testGetPersonInfoId() {
        System.out.println("getPersonInfoId");
        Long id = null;
        Factory instance = new Factory();
        String expResult = "";
        String result = instance.getPersonInfoId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
