import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Simulate_Local_APIs {

    //@Test
    public void test_get(){

        baseURI = "http://localhost:3000" ;
        given().
            param("name", "type1").
            get("/subjects").
        then().
            statusCode(200).
            log().all();
    }

    @Test
    public void test_post(){

        JSONObject req = new JSONObject();
        req.put("firstname", "fifth");
        req.put("lstname","person");
        req.put("subjectId",2);

        baseURI = "http://localhost:3000" ;

        given().
                //header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(req.toJSONString()).
            when().
                post("/users").
            then().
                statusCode(201).
                log().all();
    }


    //@Test
    public void test_patch(){

        JSONObject req = new JSONObject();

        req.put("lstname","new person");

        baseURI = "http://localhost:3000" ;

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(req.toJSONString()).
                when().
                patch("/users/5").
                then().
                statusCode(200).
                log().all();
    }

    //@Test
    public void test_put(){

        JSONObject req = new JSONObject();
        req.put("firstname", "first one");
        req.put("lstname","1st person");
        req.put("subjectId",2);

        baseURI = "http://localhost:3000" ;

        given().
                //header("Content-Type", "application/json").
                        contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(req.toJSONString()).
                when().
                put("/users/1").
                then().
                statusCode(200).
                log().all();
    }

    //@Test
    public void test_delete(){

        baseURI = "http://localhost:3000" ;

        when().
            delete("/users/2").
        then().
            statusCode(200);
    }
}
