package trash;

import br.com.fiap.config.security.TokenService;
import br.com.fiap.dto.LoginDto;
import br.com.fiap.dto.TokenDto;
import br.com.fiap.model.Usuario;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChuvaControllerTest {
    @Test
    public void testGetLocalEndpointReturns200() throws Exception {



        LoginDto loginDto = new LoginDto("teste@teste.com.br", "teste1234");

        UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(
                loginDto.email(),
                loginDto.senha()
        );

        Authentication auth = authenticationManager.authenticate(usernamePassword);

        String token = tokenService.gerarToken((Usuario)auth.getPrincipal());
        // Cria o cliente HTTP
        // Defina o token de autenticação




        // URL da API
        String url = "https://api.exemplo.com/endpoint";

        // Realiza a requisição GET com o token no cabeçalho Authorization
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .get(url);

        // Verifica se o código de status HTTP retornado é 200
        assertEquals(200, response.getStatusCode(), "O código HTTP não é 200");
    }
}
