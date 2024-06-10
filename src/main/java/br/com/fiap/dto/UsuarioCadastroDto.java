package br.com.fiap.dto;

import br.com.fiap.model.UsuarioRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioCadastroDto (
        Long usuarioId,
        @NotBlank(message = "Nome do usuário é obrigatório.")
        String nome,
        @NotBlank(message = "Email é obrigatório.")
        @Email(message = "email invalido.")
        String email,
        @NotBlank(message = "Senha é obrigatório.")
        @Size(min = 6, max = 20, message = "Senha deve conter de 6 a 20 caracteres.")
        String senha,
        UsuarioRole role
) {
}
