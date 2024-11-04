package steps;

import com.networknt.schema.ValidationMessage;
import io.cucumber.java.pt.*;
import model.ErrorMessageModel;
import org.json.JSONException;
import org.junit.Assert;
import services.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class MyStepdefs {
    SensorChuvaService sensorChuvaService = new SensorChuvaService();
    SensorQualidadeDaAguaService sensorQualidadeDaAguaService = new SensorQualidadeDaAguaService();
    SensorSecaService sensorSecaService = new SensorSecaService();
    SensorTerremotoService sensorTerremotoService = new SensorTerremotoService();
    SensorQualidadeDoArService sensorQualidadeDoArService = new SensorQualidadeDoArService();

    //Chuva
    @Dado("que eu tenha o seguinte dado para registrar")
    public void queEuTenhaOSeguinteDadoParaRegistrar(List<Map<String, String>> rows) {
        for (Map<String, String> columns : rows) {
            sensorChuvaService.setFieldsDelivery(columns.get("campo"), columns.get("valor"));
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
    //Qualidade da agua
    @Dado("que eu tenha o seguinte dado de sensor qualidade da agua  para registrar")
    public void queEuTenhaOSeguinteDadoDeSensorQualidadeDaAguaParaRegistrar(List<Map<String, String>> rows) {
        for (Map<String, String> columns : rows) {
            sensorQualidadeDaAguaService.setFieldsDelivery(columns.get("campo"), columns.get("valor"));
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

    //Umidade
    @Dado("que eu tenha o seguinte dado de sensor de umidade para registrar")
    public void queEuTenhaOSeguinteDadoDeSensorDeUmidadeParaRegistrar(List<Map<String, String>> rows) {
        for (Map<String, String> columns : rows) {
            sensorSecaService.setFieldsDelivery(columns.get("campo"), columns.get("valor"));
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

    //Terremoto
    @Dado("que eu tenha o seguinte dado do sensor de terremoto")
    public void queEuTenhaOSeguinteDadoDoSensorDeTerremoto(List<Map<String, String>> rows) {
        for (Map<String, String> columns : rows) {
            sensorTerremotoService.setFieldsDelivery(columns.get("campo"), columns.get("valor"));
        }
    }

    @Quando("eu enviar a requisição para o endpoint de terremoto {string} de registro")
    public void euEnviarARequisiçãoParaOEndpointDeTerremotoDeRegistro(String endpoint) {
        sensorTerremotoService.createDelivery(endpoint);
    }

    @Entao("O status code de resposta do terremoto deve ser {int}")
    public void oStatusCodeDeRespostaDoTerremotoDeveSer(int statusCode) {
        Assert.assertEquals(statusCode, sensorTerremotoService.response.statusCode());
    }

    @E("que o arquivo de contrato esperado é o {string}")
    public void queOArquivoDeContratoEsperadoÉO(String contrato) throws JSONException, IOException {
        sensorTerremotoService.setContract(contrato);
    }

    @Então("a resposta da requisição deve estar em conformidade com o contrato selecionado")
    public void aRespostaDaRequisiçãoDeveEstarEmConformidadeComOContratoSelecionado() throws JSONException, IOException {
        Set<ValidationMessage> validateResponse = sensorTerremotoService.validateResponseAgainstSchema();
        Assert.assertTrue("O contrato é inválido. Erros: " + validateResponse, validateResponse.isEmpty());
    }


    //Qualidade do Ar
    @Dado("que eu tenha o seguinte dado do sensor de Qualidade do Ar")
    public void queEuTenhaOSeguinteDadoDoSensorDeQualidadeDoAr(List<Map<String, String>> rows) {
        for (Map<String, String> columns : rows) {
            sensorQualidadeDoArService.setFieldsDelivery(columns.get("campo"), columns.get("valor"));
        }
    }

    @Quando("eu enviar a requisição para o endpoint de Qualidade do Ar {string} de registro")
    public void euEnviarARequisiçãoParaOEndpointDeQualidadeDoArDeRegistro(String endpoint) {
        sensorQualidadeDoArService.createDelivery(endpoint);
    }

    @Entao("o status code de resposta de qualidade do ar deve ser o {int}")
    public void oStatusCodeDeRespostaDeQualidadeDoArDeveSerO(int statusCode) {
        Assert.assertEquals(statusCode, sensorQualidadeDoArService.response.statusCode());
    }



}
