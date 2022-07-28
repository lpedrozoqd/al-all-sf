package edu.lpq.alallsf.utils.lombokTester.ej1;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

/*
* Si tenemos alguna propiedad de tipo final,
* es necesario añadirlo.
* Con @ToSting es generar el típico toString();
* Para excluir propiedades en toString, se usa;
* @ToString(exclude = {"id"})
* */
@RequiredArgsConstructor
@ToString(exclude = {"id"})
public class Person4 {
    private int id;
    private String name;
    private String lastName;
    private int age;
}
