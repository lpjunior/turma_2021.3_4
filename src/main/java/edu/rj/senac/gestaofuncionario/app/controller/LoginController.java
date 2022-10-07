package edu.rj.senac.gestaofuncionario.app.controller;

import edu.rj.senac.gestaofuncionario.config.JwtTokenUtil;
import edu.rj.senac.gestaofuncionario.domain.dto.JwtRequest;
import edu.rj.senac.gestaofuncionario.domain.dto.JwtResponse;
import edu.rj.senac.gestaofuncionario.domain.model.Login;
import edu.rj.senac.gestaofuncionario.service.JwtUserDetailsService;
import edu.rj.senac.gestaofuncionario.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping(path = "auth")
@Tag(name = "Autenticação Controller", description = "Controladora que gere o login de login")
public class LoginController {

    private final LoginService loginService;

    private final JwtTokenUtil jwtTokenUtil;

    private final AuthenticationManager authenticationManager;

    private final JwtUserDetailsService userDetailsService;

    public LoginController(LoginService loginService,
                           JwtTokenUtil jwtTokenUtil,
                           AuthenticationManager authenticationManager,
                           JwtUserDetailsService userDetailsService) {
        this.loginService = loginService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Cadastra um login", responses = {@ApiResponse(description = "Sucesso ao cadastrar", responseCode = "201", content = @Content)})
    ResponseEntity<Login> save(@RequestBody Login login) {
        return new ResponseEntity<>(loginService.save(login), CREATED);
    }

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Efetua o login de um login", responses = {@ApiResponse(description = "Sucesso ao efetuar o login", responseCode = "200", content = @Content)})
    ResponseEntity<Login> login(@RequestBody Login login) {
        return new ResponseEntity<>(loginService.login(login), OK);
    }

    @GetMapping(value = "/logoff/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Desconecta um login pelo ID", responses = {@ApiResponse(description = "Sucesso ao efetuar o logoff", responseCode = "204")})
    ResponseEntity<?> findById(@PathVariable UUID id) {
        loginService.logoff(id);
        return new ResponseEntity<>(NO_CONTENT);
    }

    @PatchMapping(value = "/active/{id}")
    @Operation(summary = "atualiza um funcionário", responses = {@ApiResponse(description = "Sucesso ao atualizar", responseCode = "204")})
    ResponseEntity<?> active(@PathVariable UUID id) {
        loginService.active(id);
        return new ResponseEntity<>(NO_CONTENT);
    }

    @PatchMapping(value = "/disable/{id}")
    @Operation(summary = "atualiza um funcionário", responses = {@ApiResponse(description = "Sucesso ao atualizar", responseCode = "204")})
    ResponseEntity<?> disable(@PathVariable UUID id) {
        loginService.disable(id);
        return new ResponseEntity<>(NO_CONTENT);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Exclui um login pelo ID", responses = {@ApiResponse(description = "Sucesso ao apagar", responseCode = "204")})
    ResponseEntity<?> deleteById(@PathVariable UUID id) {
        loginService.deleteById(id);
        return new ResponseEntity<>(NO_CONTENT);
    }

    /* ------------------------------------------------------- */
    @PostMapping(value = "/authenticate", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Efetua o login de um login", responses = {@ApiResponse(description = "Sucesso ao efetuar o login", responseCode = "200", content = @Content)})
    ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest autentication) throws Exception {
        authenticate(autentication.getUsername(), autentication.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(autentication.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(JwtResponse.builder().jwtToken(token).build());
    }

    private void authenticate(String username, String password) throws  Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException de) {
            throw  new Exception("USER_DISABLED", de);
        } catch (BadCredentialsException bce) {
            throw  new Exception("INVALID_CREDENTIALS", bce);
        }
    }
}
