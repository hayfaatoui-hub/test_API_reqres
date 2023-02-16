import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;

public class Post_DataDriven_In_Class extends  DataForTests{

   /* @DataProvider(name = "Data")
    public Object [][] dataForPost(){

        *//**********we declare data by two methods********//*

        *//**********  1st methode
        Object [][] data = new Object[2][3];

        data[0][0] = "Albert";
        data[0][1] = "Einstein";
        data[0][2] = 2;

        data[1][0] = "Albert2";
        data[1][1] = "Einstein2";
        data[1][2] = 1;

        return data;

       end (1) ********************//*

        *//************** the second method*//*
        return new Object[][]{
                {"Agha","Agha",1},
                {"Bacha","Bacha",2}
        };


    }*/

    @Test(dataProvider = "DataForPost")
    public void test_post(String firstName , String lastName, int subjectId){

        JSONObject req = new JSONObject();
        req.put("firstname", firstName);
        req.put("lstname",lastName);
        req.put("subjectId",subjectId);

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

}
