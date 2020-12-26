import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.MatcherAssert.*;

import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;


public class SpartanRestAssure {

    @BeforeAll
    public static void setup() {

        baseURI = "http://52.90.77.165:8000";
        basePath = "/api";


    }


    @Test
    public void SpartanOneGet() {

        Response response = get("/spartans/13").prettyPeek();
        String Stringresponse1 = get("/spartans/13").prettyPrint();
        String Stringresponse2 = get("/spartans/13").asString();
        System.out.println("Stringresponse2 = " + Stringresponse2);

        System.out.println("name " + response.path("name"));
        System.out.println("Id " + response.path("id"));
        System.out.println("Gender " + response.path("gender"));
        System.out.println("Phone " + response.path("phone"));

        assertThat(response.path("id"), is(13));
        assertThat(response.path("name"), is("Jaimie"));

        assertThat(response.contentType(), is("application/json;charset=UTF-8"));
        assertThat(response.statusCode(), is(200));

    }

    @Test
    public void SpartanTest3() {


        given().
                log().all().
                pathParam("id", 13).
                accept(ContentType.JSON).
                contentType(ContentType.JSON).
             when().
                get("spartans/{id}").prettyPeek().
             then().
                statusCode(200).
                contentType(ContentType.JSON).
                body("id", is(13));

    }

    @Test
    public void spartanSearh() {
        Response response = given().
                log().all().
                queryParam("gender", "Male").
                accept(ContentType.JSON).
                contentType(ContentType.JSON).
             when().
                get("/spartans/search").prettyPeek().
             then().
                statusCode(200).
                contentType(ContentType.JSON).extract().response();
        // body("",not(containsString("Male"))).extract().response();

        List<String> spartan = response.path("content.gender");
        System.out.println("Size"+spartan.size());
        System.out.println("spartan = " + spartan);
        assertThat(spartan, not(hasItem("Female")));
        assertThat(spartan, hasSize(54));

    }
}


