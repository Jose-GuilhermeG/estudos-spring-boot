package io.github.estudosSpringBoot.arquiteturaSpring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ExemploValue {

    @Value("${app.config.variable}")
    private String variable;

    public void showVariable(){
        System.out.println(variable);
    }
}
