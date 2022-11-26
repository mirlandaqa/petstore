package modulos.animal;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.sound.sampled.Port;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

@DisplayName("Testes de API Rest do modulo A")
public class AnimalTest {

    @Test
    @DisplayName("Retornar lista de inventário de animais de estimação")
    public void testValidarListaDePets(){
        //Configurando os dados da API Rest da petstoreAPI
        baseURI = "https://petstore.swagger.io/";
        basePath = "/v2";

        given()
                .when()
                    .get("/store/inventory")
                .then()
                    .statusCode(200);
    }

    @Test
    @DisplayName("Adicionar novo pet na loja")
    public void testValidarCadastroDePet(){

        baseURI = "https://petstore.swagger.io/";
        basePath = "/v2";

        given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": 17,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 1,\n" +
                        "    \"name\": \"raça\"\n" +
                        "  },\n" +
                        "  \"name\": \"Anita\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"available\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .when()
                    .post("/pet")
                .then()
                    .statusCode(200);
    }
}
