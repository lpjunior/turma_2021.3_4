package br.com.senac.todo.controllers;

import br.com.senac.todo.model.ToDo;
import br.com.senac.todo.services.ToDoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ToDoController {

    private ToDoService service;

    public ToDoController(ToDoService service) {
        this.service = service;
    }

    @GetMapping("/todos")
    ResponseEntity<List<ToDo>> getAllTodos() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PostMapping("/todo")
    ResponseEntity<ToDo> create(@RequestBody ToDo toDo) {
        return new ResponseEntity<>(service.save(toDo), HttpStatus.CREATED);
    }
}