package rest;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import static io.restassured.RestAssured.given;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PersonIntegrationTest {
    
    public PersonIntegrationTest() {
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
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void serverIsRunning() {
        System.out.println("serverIsRunning");
        
        given().
        when().get().
        then().statusCode(200);
    }
    
}
