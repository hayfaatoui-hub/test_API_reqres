import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class Test_Post {

    @Test
    public void test_1_post(){

        /******** 1st methode to create body post***********/
        /*Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "Hayfa");
        map.put("job", "Tester");
        System.out.println(map);

        JSONObject request = new JSONObject(map);
        System.out.println(request);
        System.out.println(request.toJSONString());*/

        /******** 2nd methode with json.simple lib to create body post ***********/
        JSONObject request = new JSONObject();

        request.put("name", "Hayfa");
        request.put("job", "Tester");

        System.out.println(request);
        System.out.println(request.toJSONString());

        given().
            header("Content-Type", "application/json").
            contentType(ContentType.JSON).
            accept(ContentType.JSON).
            body(request.toJSONString()).
        when().
            post("https://reqres.in/api/users").
        then().
        statusCode(201);

    }


}
