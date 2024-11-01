package steps;

import com.networknt.schema.ValidationMessage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.ErrorMessageModel;
import model.SensorChuvaModel;
import org.junit.Assert;
import services.SensorChuvaService;
import services.SensorQualidadeDaAguaService;
import services.SensorSecaService;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ChuvaStepdefs {
    SensorChuvaService sensorChuvaService = new SensorChuvaService();
    SensorQualidadeDaAguaService sensorQualidadeDaAguaService = new SensorQualidadeDaAguaService();
    SensorSecaService sensorSecaService = new SensorSecaService();

    @Dado("que eu tenha o seguinte dado para registrar")
    public void queEuTenhaOSeguinteDadoParaRegistrar(List<Map<String, String>> rows) {
        for(Map<String, String> columns : rows) {
            sensorChuvaService.setFieldsDelivery(columns.get("campo"),  columns.get("valor"));
        }
    }

    @Quando("eu enviar a requisição para o endpoint {string} de cadastro")
    public void euEnviarARequisiçãoParaOEndpointDeCadastro(String endpoint) {
        sensorChuvaService.createDelivery(endpoint);
    }

    @Entao("O status code de resposta da chuva deve ser {int}")
    public void oStatusCodeDeRespostaDaChuvaDeveSer(int statusCode) {
        Assert.assertEquals(statusCode, sensorChuvaService.response.statusCode());
    }

    @E("o corpo de resposta de erro da api de chuva deve retornar a mensagem {string}")
    public void oCorpoDeRespostaDeErroDaApiDeChuvaDeveRetornarAMensagem(String message) {
        ErrorMessageModel errorMessageModel = sensorChuvaService.gson.fromJson(
                sensorChuvaService.response.jsonPath().prettify(), ErrorMessageModel.class);
        Assert.assertEquals(message, errorMessageModel.getMessage());
    }

    @Dado("que eu tenha o seguinte dado de sensor qualidade da agua  para registrar")
    public void queEuTenhaOSeguinteDadoDeSensorQualidadeDaAguaParaRegistrar(List<Map<String, String>> rows) {
        for(Map<String, String> columns : rows) {
            sensorQualidadeDaAguaService.setFieldsDelivery(columns.get("campo"),  columns.get("valor"));
        }
    }

    @Quando("eu enviar a requisição para o endpoint de qualidade da agua {string} de cadastro")
    public void euEnviarARequisiçãoParaOEndpointDeQualidadeDaAguaDeCadastro(String endpoint) {
        sensorQualidadeDaAguaService.createDelivery(endpoint);
    }

    @Entao("O status code de resposta da qualidade da agua deve ser {int}")
    public void oStatusCodeDeRespostaDaQualidadeDaAguaDeveSer(int statusCode) {
        Assert.assertEquals(statusCode, sensorQualidadeDaAguaService.response.statusCode());
    }

    @E("o corpo de resposta de erro da api deve retornar a mensagem {string}")
    public void oCorpoDeRespostaDeErroDaApiDeveRetornarAMensagem(String message) {
        ErrorMessageModel errorMessageModel = sensorQualidadeDaAguaService.gson.fromJson(
                sensorQualidadeDaAguaService.response.jsonPath().prettify(), ErrorMessageModel.class);
        Assert.assertEquals(message, errorMessageModel.getMessage());
    }

    @Dado("que eu tenha o seguinte dado de sensor de umidade para registrar")
    public void queEuTenhaOSeguinteDadoDeSensorDeUmidadeParaRegistrar(List<Map<String, String>> rows) {
        for(Map<String, String> columns : rows) {
            sensorSecaService.setFieldsDelivery(columns.get("campo"),  columns.get("valor"));
        }
    }

    @Quando("eu enviar a requisição para o endpoint de umidade {string} de cadastro")
    public void euEnviarARequisiçãoParaOEndpointDeUmidadeDeCadastro(String endpoint) {
        sensorSecaService.createDelivery(endpoint);
    }

    @Entao("O status code de resposta deve ser {int}")
    public void oStatusCodeDeRespostaDeveSer(int statusCode) {
        Assert.assertEquals(statusCode, sensorSecaService.response.statusCode());
    }

    @E("o corpo de resposta de erro da api de seca deve retornar a mensagem {string}")
    public void oCorpoDeRespostaDeErroDaApiDeSecaDeveRetornarAMensagem(String message) {
        ErrorMessageModel errorMessageModel = sensorSecaService.gson.fromJson(
                sensorSecaService.response.jsonPath().prettify(), ErrorMessageModel.class);
        Assert.assertEquals(message, errorMessageModel.getMessage());
    }

    /*//Exclusão chuva
    @Dado("que eu recupere o ID da entrega criada no contexto")
    public void queEuRecupereOIDDaEntregaCriadaNoContexto() {
        sensorChuvaService.retrieveIdDelivery();
    }

    @Quando("eu enviar a requisição para o endpoint {string} de exclusão")
    public void euEnviarARequisiçãoParaOEndpointDeExclusão(String endpoint) {
        sensorChuvaService.deleteDelivery(endpoint);
    }

    @Entao("o status code de resposta deve ser o {int}")
    public void oStatusCodeDeRespostaDeveSerO(int statusCode) {
        Assert.assertEquals(statusCode, sensorChuvaService.response.statusCode());
    }*/



}
