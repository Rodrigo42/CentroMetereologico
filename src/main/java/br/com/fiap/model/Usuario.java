package br.com.fiap.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tbl_usuarios")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SQ_USUARIOS"
    )
    @SequenceGenerator(
            name= "SQ_USUARIOS",
            sequenceName = "SQ_USUARIOS",
            allocationSize = 1
    )
    @Column(name= "usuario_id")

    private Long usuarioId;
    private String nome;
    private String email;
    private String senha;
    @Enumerated(EnumType.STRING)
    private UsuarioRole role;

    public Usuario() {
    }

    public Usuario(Long usuarioId, String nome, String email, String senha) {
        this.usuarioId = usuarioId;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }


    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public UsuarioRole getRole() {
        return role;
    }

    public void setRole(UsuarioRole role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(usuarioId, usuario.usuarioId) && Objects.equals(nome, usuario.nome) && Objects.equals(email, usuario.email) && Objects.equals(senha, usuario.senha);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UsuarioRole.ADMIN){
            return List.of(
                    new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_USER")
            );
        } else {
            return  List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
