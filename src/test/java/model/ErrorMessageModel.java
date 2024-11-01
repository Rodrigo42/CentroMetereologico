package br.com.fiap.test.model;
import com.google.gson.annotations.Expose;
import lombok.Data;


@Data
public class ErrorMessageModel {
    @Expose
    private String message;
}