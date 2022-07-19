package br.com.senac.todo.services;

import br.com.senac.todo.model.ToDo;
import br.com.senac.todo.repositories.ToDoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ToDoServiceTest {

    private ToDoRepository toDoRepository;

    // caso de teste - buscar todos os ToDos

    // finalizamos a aula com o nosso caso de teste(controller) funcionando e nosso caso de teste(service) com falha
    // na próxima aula vamos fazer a alteração minimalista corrigir a DI

    public ToDoServiceTest(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @AfterEach
    void tearDown() {
        toDoRepository.deleteAll();
    }

    @Test
    void findAll() {
        var toDo = new ToDo("Dormir 8h por dia", true);
        toDoRepository.save(toDo);

        var toDoService = new ToDoService(toDoRepository);
        List<ToDo> toDoList = toDoService.findAll();
        var lastToDo = toDoList.get(toDoList.size() - 1); // n-1

        Assertions.assertEquals(toDo.getDescription(), lastToDo.getDescription());
        Assertions.assertEquals(toDo.isCompleted(), lastToDo.isCompleted());
        Assertions.assertEquals(toDo.getId(), lastToDo.getId());
    }
}
