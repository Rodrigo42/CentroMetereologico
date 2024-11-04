package services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.SensorTerremotoModel;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

import static io.restassured.RestAssured.given;

public class SensorTerremotoService {

    final SensorTerremotoModel sensorTerremotoModel = new SensorTerremotoModel();
    public final Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();
    public Response response;
    String baseUrl = "https://fiap-cmc-api-dev-a0cfbcc0e4epexhb.eastus2-01.azurewebsites.net/";

    public void setFieldsDelivery(String field, String value) {
        switch (field) {
            case "sismico" -> sensorTerremotoModel.setSismico(Long.parseLong(value));
            case "data" -> sensorTerremotoModel.setData(value);
            default -> throw new IllegalStateException("Unexpected feld" + field);
        }
    }

    public void createDelivery(String endPoint) {
        String url = baseUrl + endPoint;
        String bodyToSend = gson.toJson(sensorTerremotoModel);
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

    String schemasPath = "src/test/resources/schemas/";
    JSONObject jsonSchema;
    private final ObjectMapper mapper = new ObjectMapper();

    private JSONObject loadJsonFromFile(String filePath) throws IOException, JSONException {
        try (InputStream inputStream = Files.newInputStream(Paths.get(filePath))) {
            // Converte o InputStream para String
            String content = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            JSONTokener tokener = new JSONTokener(content);
            return new JSONObject(tokener);
        }
    }

    public void setContract(String contract) throws IOException, JSONException {
        switch (contract) {
            case "contrato-terremoto" -> jsonSchema = loadJsonFromFile(schemasPath + "contrato-terremoto.json");
            default -> throw new IllegalStateException("Unexpected contract" + contract);
        }
    }

    public Set<ValidationMessage> validateResponseAgainstSchema() throws IOException, JSONException {
        JSONObject jsonResponse = new JSONObject(response.getBody().asString());
        JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V4);
        JsonSchema schema = schemaFactory.getSchema(jsonSchema.toString());
        JsonNode jsonResponseNode = mapper.readTree(jsonResponse.toString());
        Set<ValidationMessage> schemaValidationErrors = schema.validate(jsonResponseNode);
        return schemaValidationErrors;
    }
}
