package io.github.estudosSpringBoot.arquiteturaSpring.todos;

import jakarta.persistence.*;

@Entity
@Table(name = "to_do")
public class ToDoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;
    private Boolean is_ready;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIs_ready() {
        return is_ready;
    }

    public void setIs_ready(Boolean is_ready) {
        this.is_ready = is_ready;
    }
}
