package br.com.fiap.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecaControllerTest {
    @Test
    public void testGetEndpointStatusOk() {

        // URL da API
        String url = "fiap-cmc-api-dev-a0cfbcc0e4epexhb.eastus2-01.azurewebsites.net/api/seca/listar";

        // Realiza a requisição GET com o token no cabeçalho Authorization
        Response response = RestAssured.given().get(url);

        //espiadinha
        System.out.println(response.body().peek());

        // Verifica se o código de status HTTP retornado é 200
        assertEquals(200, response.getStatusCode(), "O código HTTP não é 200");

    }
}
