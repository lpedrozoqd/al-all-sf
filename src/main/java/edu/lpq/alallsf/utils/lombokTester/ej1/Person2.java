package edu.lpq.alallsf.utils.lombokTester.ej1;

import lombok.Getter;
/*
* En esta ocasión, sólo se declara que campo requiere
* getter, etc.
* Se le pueden agregar atributos así:
* @Getter(atributo = valor, ..., n)
* */
public class Person2 {
    @Getter
    private int id;
    private String name;
    private String lastName;
    private int age;
}
