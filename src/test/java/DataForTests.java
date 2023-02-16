import org.testng.annotations.DataProvider;

public class DataForTests {

    @DataProvider(name = "DataForDelete")
    public Object[][] DataForDelete(){
        // return new Iterator<Object[]>{6, 7, 8, 9};
        return new Object[][]{{7}};
    }
    @DataProvider(name = "DataForPost")
    public Object [][] dataForPost(){

        return new Object[][]{
                {"Agha","Agha",1},
                {"Bacha","Bacha",2}
        };


    }
}
