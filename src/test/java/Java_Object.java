import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pojo.Spartan;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class Java_Object {

    @BeforeAll
    public static void setup(){

        RestAssured.baseURI="http://107.20.53.61";
        RestAssured.port=8000;
        RestAssured.basePath="/api";

    }

    @Test
    public void desirilization(){

      Response response=  given()
                                .log().all()
                                .contentType(ContentType.JSON)
                                .pathParam("id", 15).
                      when()
                                .get("/spartans/{id}").prettyPeek();


        String nameSpartan15 =response.path("name");
        JsonPath jpSpartan15=response.jsonPath();

        System.out.println("nameSpartan15 = " + nameSpartan15);

        Map<String,Object> Spartan15Map = response.body().as(Map.class);
        Map<String,Object> jpSpartan15Map= jpSpartan15.getMap("");


        System.out.println("Spartan15Map = " + Spartan15Map);
        System.out.println("jpSpartan15Map = " + jpSpartan15Map);


    }
    @Test
    public void listSpartans(){

        Response response=  given()
                                .log().all()
                                .contentType(ContentType.JSON).
                             when()
                                .get("/spartans").prettyPeek();


        JsonPath jsResponse =response.jsonPath();

        List<Map<String,Object>> SpartanList =jsResponse.getList("");

        System.out.println("SpartanList = " + SpartanList);

        String spartan17name =SpartanList.get(16).get("name").toString();

        System.out.println("spartan17name = " + spartan17name);





    }

    @Test
    public void spartnaPojo(){

        Response response=  given()
                                .log().all()
                                .contentType(ContentType.JSON)
                                .pathParam("id", 15).
                                        when()
                                .get("/spartans/{id}").prettyPeek();

        JsonPath jsSpartan15=response.jsonPath();

        Spartan spartan15Obj=jsSpartan15.getObject("", Spartan.class);

        System.out.println("spartan15Obj = " + spartan15Obj);



    }



}
