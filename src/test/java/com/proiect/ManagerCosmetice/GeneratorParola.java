package com.proiect.ManagerCosmetice;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeneratorParola {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String parolaCriptata = encoder.encode("alina");

        System.out.println("Parola ta criptată este:");
        System.out.println(parolaCriptata);
    }
}