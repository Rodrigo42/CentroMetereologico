package br.com.fiap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CMCApplication {
    public static void main(String[] args) {
        SpringApplication.run(CMCApplication.class, args);
        System.out.println("Ta rodando.");
    }
}

