import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;

public class Test_delete {

    @Test
    public void test_1_put(){

         when().
             delete("https://reqres.in/api/users/2").
         then().
             statusCode(204).
             log().all();

    }
}
