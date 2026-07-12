package com.example.demo.controller;

import com.example.demo.domain.usuario.dto.DadosAutenticacaoDto;
import com.example.demo.domain.usuario.model.Usuario;
import com.example.demo.infra.security.GerarToken;
import com.example.demo.infra.security.dto.DadosTokenJwtDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {



    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private GerarToken tokenService;

    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacaoDto dados){
        var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var autenticationtoken = manager.authenticate(token);
        var tokenJwt = tokenService.getToken((Usuario)autenticationtoken.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJwtDto(tokenJwt));
    }

}
