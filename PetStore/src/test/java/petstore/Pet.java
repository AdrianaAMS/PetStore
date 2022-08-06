package petstore;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class Pet {
    String uri = "http://petstore.swagger.io/v2"; // endereço da entidade Pet

    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    //Incluir - create - Post
    @Test
    public void incluirPet() throws IOException {
        String jsonBody = lerJson("db/pet1.json");

        // sintax Gherkin
       given()
               .contentType("application/json")
               .log().all() // request
               .body(jsonBody)

       .when()
               .post(uri)
       .then()
               .log().all() // response
               .statusCode(301)
       ;

    }

}
