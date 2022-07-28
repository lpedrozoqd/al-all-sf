package edu.lpq.alallsf.utils.lombokTester.ej1;

/*
*
* */

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/*
* Con @AllArgsConstructor estoy confirmando
* tener constructor con todos los campos.
* Con @NoArgsConstructor es un constructor vacío
* */
@AllArgsConstructor
@NoArgsConstructor
public class Person3 {
    private int id;
    private String name;
    private String lastName;
    private int age;
}
