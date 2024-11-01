package br.com.fiap.test.services;

import br.com.fiap.model.SensorQualidadeAgua;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import br.com.fiap.test.model.SensorQualidadeDaAguaModel;

import static io.restassured.RestAssured.given;

public class SensorQualidadeDaAguaService {

    final SensorQualidadeDaAguaModel sensorQualidadeAgua = new SensorQualidadeDaAguaModel();

    public final Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();
    public Response response;
    String baseUrl = "https://fiap-cmc-api-dev-a0cfbcc0e4epexhb.eastus2-01.azurewebsites.net/";

    public void setFieldsDelivery(String field, String value) {
        switch (field) {
            case "agua" -> sensorQualidadeAgua.setAgua(Long.parseLong(value));
            case "data" -> sensorQualidadeAgua.setData(value);
            default -> throw new IllegalStateException("Unexpected feld" + field);
        }
    }

    public void createDelivery(String endPoint) {
        String url = baseUrl + endPoint;
        String bodyToSend = gson.toJson(sensorQualidadeAgua);
        response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(bodyToSend)
                .when()
                .post(url)
                .then()
                .extract()
                .response();
    }

    String idDelivery;
    public void retrieveIdDelivery() {
        idDelivery = String.valueOf(gson.fromJson(response.jsonPath().prettify(), SensorQualidadeAgua.class).getId());
    }

    public void deleteDelivery(String endPoint) {
        String url = String.format("%s%s/%s", baseUrl, endPoint, idDelivery);
        response = given()
                .accept(ContentType.JSON)
                .when()
                .delete(url)
                .then()
                .extract()
                .response();
    }
}
