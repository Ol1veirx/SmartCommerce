package com.github_ol1veirx.smartcommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SmartCommerceApplication{

    //@Autowired
    //private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SmartCommerceApplication.class, args);
    }
    //Serve para salvar a senha criptografada
    //System.out.println("ENCODE" + passwordEncoder.encode("123456"));

    //Na hora do login verificar se a senha digitada é a mesma do banco de dados criptografada
    //boolean resul = passwordEncoder.matches("123456", "$2a$10$/64y17g0NU0nf8hQuccbqOzFYDhTalh9udTEjQzzED.Z7F766XtFy");
    //System.out.println(resul);
}
