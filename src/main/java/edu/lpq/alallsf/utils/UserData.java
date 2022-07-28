package edu.lpq.alallsf.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

/**
 * ConstructorBinding = usado para que se pueda inyectar como
 * dependencia
 * ConfigurationProperties = se determina el prefijo que podrá usar
 * desde el archivo de propiedades
 *
 * Finalmente esta clase hay que configurarla como dependencia
 * */
@ConstructorBinding
@ConfigurationProperties(prefix = "user")
public class UserData {
    private String email;
    private String password;
    private int age;

    public UserData(String email, String password, int age) {
        this.email = email;
        this.password = password;
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
