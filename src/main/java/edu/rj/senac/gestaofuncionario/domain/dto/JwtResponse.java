package edu.rj.senac.gestaofuncionario.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@Builder
public class JwtResponse implements Serializable {
    private final String jwtToken;
}
