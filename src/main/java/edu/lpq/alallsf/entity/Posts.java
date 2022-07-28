package edu.lpq.alallsf.entity;

import javax.persistence.*;

@Entity
@Table(name="post")
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_post", nullable = false, unique=true)
    private Long id;

    @Column(name="description", length = 255)
    private String description;

    @ManyToOne
    private Users user;

    public Posts() {
    }

    public Posts(Long id, String description, Users user) {
        this.id = id;
        this.description = description;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Posts{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", user=" + user +
                '}';
    }
}
