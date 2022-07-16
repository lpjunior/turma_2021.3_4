package br.com.senac.todo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ToDo {

    @Id
    private long id;
    private String description;
    private boolean completed;

    public ToDo() {

    }

    public ToDo(long id, String description, boolean completed) {
        this.id = id;
        this.description = description;
        this.completed = completed;
    }
}
