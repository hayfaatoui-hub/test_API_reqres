import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

public class Delete_ByTestngXmlFile{

    @Parameters({"userID"})
    @Test
    public void test_delete(@Optional("0") int userid ){

        baseURI = "http://localhost:3000" ;
        System.out.println("value of iduser: "+userid);
        when().
                delete("/users/"+userid ).
                then().
                statusCode(200);
    }

}

