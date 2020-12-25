import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class SpartanTest2 {
@Test
    public void Sparta1(){

        Response response=get("http://52.90.77.165:8000/api/spartans");
        Response response1=get("http://52.90.77.165:8000/api/spartans/10");

        System.out.println(response.asString());
        System.out.println(response.prettyPrint());
        System.out.println(response1.prettyPrint());


    }

    @Test
    public void spartanGetOne(){

    Response response=get("http://52.90.77.165:8000/api/spartans/10");

        response.prettyPrint();

    }
}
