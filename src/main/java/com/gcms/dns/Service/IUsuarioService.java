package com.gcms.dns.Service;

import com.gcms.dns.Dto.LoginDto;
import com.gcms.dns.Dto.LoginResponse;
import com.gcms.dns.Dto.UsuarioDto;
import org.springframework.http.ResponseEntity;

public interface IUsuarioService {

    ResponseEntity<Object> agregarUsuarios(UsuarioDto usuarioDTO);

    LoginResponse LoginUsuarios(LoginDto loginDto);
}
