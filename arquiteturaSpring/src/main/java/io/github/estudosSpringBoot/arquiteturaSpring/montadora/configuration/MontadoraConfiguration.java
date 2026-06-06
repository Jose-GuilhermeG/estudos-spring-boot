package io.github.estudosSpringBoot.arquiteturaSpring.montadora.configuration;

import io.github.estudosSpringBoot.arquiteturaSpring.montadora.Motor;
import io.github.estudosSpringBoot.arquiteturaSpring.montadora.TipoMotor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MontadoraConfiguration {

    @Bean
    public Motor motor(){
        Motor motor = new Motor();
        motor.setCavalos(120);
        motor.setCilindro(4);
        motor.setModelo("XPTO-0");
        motor.setLitragem(2.0);
        motor.setTipo(TipoMotor.ASPIRADO);
        return  motor;
    }
}
