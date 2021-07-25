package br.com.amaro.usuaio.controller.util;

import br.com.amaro.usuaio.controller.dto.UsuarioDTO;
import br.com.amaro.usuaio.repository.entity.UsuarioEntity;

public class UsuarioMapper {
    public static UsuarioDTO entityToDto(UsuarioEntity usuarioEntity){
        return UsuarioDTO.builder()
                .clienteId(usuarioEntity.getClienteId())
                .nome(usuarioEntity.getNome())
                .endereco(usuarioEntity.getEndereco())
                .telefone(usuarioEntity.getTelefone())
                .nuCpfCnpj(usuarioEntity.getNuCpfCnpj())
                .tipo(usuarioEntity.getTipo())
                .latitude(usuarioEntity.getLatitude())
                .longitude(usuarioEntity.getLongitude())
                .build();
    }
    public static UsuarioEntity dtoToEntity(UsuarioDTO usuarioDTO){
        return UsuarioEntity.builder()
                .clienteId(usuarioDTO.getClienteId())
                .nome(usuarioDTO.getNome())
                .endereco(usuarioDTO.getEndereco())
                .telefone(usuarioDTO.getTelefone())
                .nuCpfCnpj(usuarioDTO.getNuCpfCnpj())
                .tipo(usuarioDTO.getTipo())
                .latitude(usuarioDTO.getLatitude())
                .longitude(usuarioDTO.getLongitude())
                .build();
    }
}
