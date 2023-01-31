import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_GET {


    /***   get all API contain   **/
    @Test
    void test_get01(){
        //Response response = RestAssured.get("https://reqres.in/api/users?page=2");

        /** this with===> import static io.restassured.RestAssured.*; ***/
        Response response = get("https://reqres.in/api/users?page=2");

        System.out.println(response.asString());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());


        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    /*  ****   get all API detail  ****  */
    @Test
    void test_get02(){
        given()
                .get("https://reqres.in/api/users?page=2")
        .then()
                .statusCode(200)  /*  ****   check status  ****  */
                .body("data.id[1 ]", equalTo(8))   /** verify items to string **/
                .body("data.first_name", hasItems("Michael", "Lindsay"))       /** verify items to string **/
                .log().all()  /*  ****   get all API detail  ****  */
                ;

    }

}
