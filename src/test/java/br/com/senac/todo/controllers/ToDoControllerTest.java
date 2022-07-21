package br.com.senac.todo.controllers;

import br.com.senac.todo.model.ToDo;
import br.com.senac.todo.services.ToDoService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class ToDoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private ToDoService toDoService;

    @Test
    void getAllToDos() throws Exception {
        List<ToDo> toDoList = new ArrayList<>();
        toDoList.add(new ToDo(1L, "Comer três vezes", true));
        toDoList.add(new ToDo(2L, "Dormir PELO MENOS duas vezes", true));
        Mockito.when(toDoService.findAll()).thenReturn(toDoList);

        mockMvc.perform(MockMvcRequestBuilders.get("/todos").contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", Matchers.hasSize(2))).andDo(print());
    }

    // finalizamos a cobertura de testes da nossa classe service
    // finalizamos a aula com um erro no test de getToDo para efetuar a correção minimalista na próxima aula.

    // Atividade de vocês: Resolver o problema getToDo
    // +++ implementar os testes para edit, save e delete

    @Test
    void getToDo() throws Exception {
        var toDo = new ToDo(1L, "Comer três vezes", true);
        Mockito.when(toDoService.findById(toDo.getId())).thenReturn(toDo);

        mockMvc.perform(MockMvcRequestBuilders.get("/todo/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", Matchers.hasSize(1))).andDo(print());
    }
}
