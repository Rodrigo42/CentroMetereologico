package services;

import br.com.fiap.model.SensorQualidadeAr;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.SensorChuvaModel;
import model.SensorQualidadeArModel;

import static io.restassured.RestAssured.given;

public class SensorQualidadeDoArService {

    final SensorQualidadeArModel sensorQualidadeAr = new SensorQualidadeArModel();
    public final Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();
    public Response response;
    String baseUrl = "https://fiap-cmc-api-dev-a0cfbcc0e4epexhb.eastus2-01.azurewebsites.net/";

    public void setFieldsDelivery(String field, String value) {
        switch (field) {
            case "ar" -> sensorQualidadeAr.setAr(Long.parseLong(value));
            case "data" -> sensorQualidadeAr.setData(value);
            default -> throw new IllegalStateException("Unexpected feld" + field);
        }
    }

    public void createDelivery(String endPoint) {
        String url = baseUrl + endPoint;
        String bodyToSend = gson.toJson(sensorQualidadeAr);
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


}
