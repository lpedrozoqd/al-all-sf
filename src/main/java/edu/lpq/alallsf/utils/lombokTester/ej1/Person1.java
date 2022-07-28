package edu.lpq.alallsf.utils.lombokTester.ej1;

import lombok.Getter;
import lombok.Setter;

/*
* Aquí aplica getter/setter a todos los atributos
* sin excepción
* */
@Setter
@Getter
public class Person1 {
    private int id;
    private String name;
    private String lastName;
    private int age;
}
