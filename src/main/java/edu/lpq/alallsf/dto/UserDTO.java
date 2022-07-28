package edu.lpq.alallsf.dto;

import java.time.LocalDate;

public class UserDTO {
    private Long id;
    private String name;
    private LocalDate birthDate;

    public UserDTO(Long id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "UserDTO [birthDate=" + birthDate + ", id=" + id + ", name=" + name + "]";
    }


    
    
    
}
