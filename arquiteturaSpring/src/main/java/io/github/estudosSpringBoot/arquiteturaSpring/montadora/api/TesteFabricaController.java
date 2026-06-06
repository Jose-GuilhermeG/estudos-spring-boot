package io.github.estudosSpringBoot.arquiteturaSpring.montadora.api;

import io.github.estudosSpringBoot.arquiteturaSpring.montadora.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("car")
public class TesteFabricaController {

    @Autowired
    @Qualifier("motorEletrico")
    private Motor motor;

    @PostMapping
    public CarroStatus ligarCarro(@RequestBody Chave chave){
        Carro carro = new HondaHRV(motor);
        return carro.darIgnicao(chave);
    }
}
