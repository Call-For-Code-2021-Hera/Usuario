package br.com.amaro.usuaio.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UsuarioDTO {

    @JsonProperty("clienteId")
    private String clienteId;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("endereco")
    private String endereco;

    @JsonProperty("telefone")
    private String telefone;

    @JsonProperty("nuCpfCnpj")
    private String nuCpfCnpj;

    @JsonProperty("tipo")
    private String tipo;

}
