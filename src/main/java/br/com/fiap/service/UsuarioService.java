package br.com.fiap.service;


import br.com.fiap.dto.UsuarioCadastroDto;
import br.com.fiap.dto.UsuarioExibicaoDto;
import br.com.fiap.model.Usuario;
import br.com.fiap.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioExibicaoDto gravarUsuario(UsuarioCadastroDto usuarioCadastroDto){

        String senhaCriptografada = new BCryptPasswordEncoder().encode(usuarioCadastroDto.senha());

        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioCadastroDto, usuario);
        usuario.setSenha(senhaCriptografada);
        return new UsuarioExibicaoDto(usuarioRepository.save(usuario));
    }

    public Page<Usuario> listarUsuarios(Pageable paginacao){
        return usuarioRepository.findAll(paginacao);
    }

    public Usuario atualizarUsuario(Usuario usuario){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuario.getUsuarioId());

        if(usuarioOptional.isPresent()){
            return usuarioRepository.save(usuario);
        }else {
            throw new RuntimeException("Usuario não encontrado.");
        }
    }

    public void excluirUsuario(Usuario usuario){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuario.getUsuarioId());

        if(usuarioOptional.isPresent()){
            usuarioRepository.delete(usuario);
        }else {
            throw new RuntimeException("Usuario não encontrado.");
        }
    }

}
