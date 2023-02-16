import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;

import static io.restassured.RestAssured.*;

public class Delete_DataDriven_In_Class extends DataForTests{

   /* @DataProvider(name = "Data")
    public Object[][] DataForDelete(){
       // return new Iterator<Object[]>{6, 7, 8, 9};
        return new Object[][]{
                {6},
                {9}
        };
    }*/

    @Test(dataProvider = "DataForDelete")
    public void test_delete( int userid){

        baseURI = "http://localhost:3000" ;

        when().
                delete("/users/"+userid ).
                then().
                statusCode(200);
    }

}

