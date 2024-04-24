package com.gcms.dns.Service;


import com.gcms.dns.Dto.LoginDto;
import com.gcms.dns.Dto.LoginResponse;
import com.gcms.dns.Dto.UsuarioDto;
import com.gcms.dns.Usuario;
import com.gcms.dns.UsuarioRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.Optional;
/**
 * Servicio para operaciones relacionadas con usuarios.
 * Implementa la interfaz IUsuarioService y proporciona métodos para agregar y autenticar usuarios.
 */
@Slf4j
@Service
public class UsuarioOperation implements IUsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public ResponseEntity<Object> agregarUsuarios(UsuarioDto request) {
        try {
            Optional<Usuario> u = usuarioRepository.findByEmail(request.getEmail());

            if (u.isEmpty()) {
                usuarioRepository.save(Usuario.builder().userId(request.getUserId()).name(request.getName())
                        .email(request.getEmail()).phone(request.getPhone()).address(request.getAddress()).
                        lastName(request.getLastName()).password(this.passwordEncoder.encode(request.getPassword()))
                        .identificationNumber(request.getIdentificationNumber()).build());

                return new ResponseEntity<>(request, HttpStatus.CREATED);


            } else {

                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public LoginResponse LoginUsuarios(LoginDto loginDto) {
        String msg = StringUtils.EMPTY;
        Optional<Usuario> usuario1 = usuarioRepository.findByEmail(loginDto.getEmail());
        if (usuario1.isPresent()) {
            String password = loginDto.getPassword();
            String encodedPassword = usuario1.get().getPassword();
            if (passwordEncoder.matches(password, encodedPassword)) {
                Optional<Usuario> usuario = usuarioRepository.findOneByEmailAndPassword(loginDto.getEmail(), encodedPassword);
                if (usuario.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("Password Not Match", false);
            }
        } else {
            return new LoginResponse("Email not exists", false);
        }
    }
}