package br.com.fiap.cmc;

import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QualidadeArControllerTest {
    @Test
    public void testGetLocalEndpointReturns200() throws Exception {
        // Cria o cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        // Endereço da API local
        String uri = "http://localhost:8080/api/qldar";

        // Cria a requisição GET
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();

        // Envia a requisição e obtém a resposta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Verifica se o código de status HTTP retornado é 200
        assertEquals(200, response.statusCode(), "O código HTTP não é 200");
    }
}
