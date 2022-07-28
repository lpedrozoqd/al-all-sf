package edu.lpq.alallsf.utils.lombokTester.ej1;

public class Person6Tester {
    public static void main(String[] args) {

        Person6 p;
        Person6.Person6Builder builder = Person6.builder();
        builder.id(1);
        builder.name("Leonel");
        builder.lastName("Pedrozo");
        builder.age(43);
        p = builder.build();

        System.out.println(p.toString());



    }

}
