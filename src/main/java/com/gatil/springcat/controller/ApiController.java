package com.gatil.springcat.controller;

import com.gatil.springcat.entidades.Gato;
import com.gatil.springcat.repository.GatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {

    @Autowired //injeta o repositorio na classe para utilizar os metodos jpa
    GatoRepository gatoRepository;



    @GetMapping("/miar")
    public String miau() {
        String miado = "MEOOOOOOOOOOOW";
        return miado; //rota teste criando um miado
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Gato> cadastrarGato(@RequestBody Gato gato){
        gatoRepository.save(gato); //salva no banco de dados

        return new ResponseEntity<Gato>(HttpStatus.ACCEPTED);  //segunda rota criada, rota de cadastro no banco
    }

    @GetMapping("/mostrar")
    public List<Gato> listarGato(){
        return gatoRepository.findAll(); //terceira rota, rota para mostrar os gatos cadastrados
    }
}
