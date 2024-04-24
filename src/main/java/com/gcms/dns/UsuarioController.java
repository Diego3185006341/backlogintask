package com.gcms.dns;

import com.gcms.dns.Dto.LoginDto;
import com.gcms.dns.Dto.LoginResponse;
import com.gcms.dns.Dto.UsuarioDto;
import com.gcms.dns.Service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class UsuarioController {


    public static UsuarioRepository usuarioRepository;

    @Autowired
    IUsuarioService iUsuarioService;


    @PostMapping(path = "/save")
    public ResponseEntity<Object> saveRegistroTienda(@RequestBody UsuarioDto usuarioDTO) {

        return iUsuarioService.agregarUsuarios(usuarioDTO);


    }
    @PostMapping(path = "/login")
    public ResponseEntity<?> LoginTienda(@RequestBody LoginDto loginDto) {

        LoginResponse loginMessage= iUsuarioService.LoginUsuarios(loginDto);
        return ResponseEntity.ok(loginMessage);


    }
}