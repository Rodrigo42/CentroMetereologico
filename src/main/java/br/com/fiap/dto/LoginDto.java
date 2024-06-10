package br.com.fiap.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginDto (
        @NotBlank(message = "O email é obrigatorio.")
        @Email(message = "Formato do email invalido.")
        String email,
        @NotBlank(message = "Senha é obrigatoria.")
        @Size(min = 6, max = 20, message = "Senha deve conter entre 6 e 20 caracteres.")
        String senha)
{

}
