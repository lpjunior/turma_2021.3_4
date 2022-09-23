package edu.rj.senac.gestaofuncionario.app.controller;

import edu.rj.senac.gestaofuncionario.domain.model.Funcionario;
import edu.rj.senac.gestaofuncionario.service.FuncionarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping(path = "rh")
@Tag(name = "Funcionario RH Controller", description = "Controladora que gere o cadastro de funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping(value = "/funcionario", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Cadastra um funcionário", responses = {@ApiResponse(description = "Sucesso ao cadastrar", responseCode = "201", content = @Content)})
    ResponseEntity<Funcionario> save(@RequestBody Funcionario funcionario) {
        return new ResponseEntity<>(funcionarioService.save(funcionario), CREATED);
    }

    @GetMapping(value = "/funcionario", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Lista funcionários", responses = {@ApiResponse(description = "Sucesso ao listar os funcionários", responseCode = "200", content = @Content)})
    ResponseEntity<List<Funcionario>> findAll() {
        return new ResponseEntity<>(funcionarioService.findAll(), OK);
    }

    @GetMapping(value = "/funcionario/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Localiza um funcionários pelo ID", responses = {@ApiResponse(description = "Sucesso ao consultar o funcionário", responseCode = "200", content = @Content)})
    ResponseEntity<Funcionario> findById(@PathVariable UUID id) {
        return new ResponseEntity<>(funcionarioService.findById(id), OK);
    }

    @PutMapping(value = "/funcionario", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "atualiza um funcionário", responses = {@ApiResponse(description = "Sucesso ao atualizar", responseCode = "201", content = @Content)})
    ResponseEntity<?> update(@RequestBody Funcionario funcionario) {
        funcionarioService.save(funcionario);
        return new ResponseEntity<>(NO_CONTENT);
    }

    @PatchMapping(value = "/funcionario", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "atualiza um funcionário", responses = {@ApiResponse(description = "Sucesso ao atualizar", responseCode = "201", content = @Content)})
    ResponseEntity<?> updateEmail(@Parameter String email) {
        //funcionarioService.save(email);
        return new ResponseEntity<>(NO_CONTENT);
    }

    @DeleteMapping(value = "/funcionario/{id}")
    @Operation(summary = "Exclui um funcionários pelo ID", responses = {@ApiResponse(description = "Sucesso ao apagar o funcionário", responseCode = "204")})
    ResponseEntity<?> deleteById(@PathVariable UUID id) {
        funcionarioService.deleteById(id);
        return new ResponseEntity<>(NO_CONTENT);
    }
}