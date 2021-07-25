package br.com.amaro.usuaio.controller;

import br.com.amaro.usuaio.controller.dto.UsuarioDTO;
import br.com.amaro.usuaio.controller.util.UsuarioMapper;
import br.com.amaro.usuaio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.UUID;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/{clienteId}")
    public ResponseEntity<?> consultaCliente(@PathVariable(value = "clienteId")String clienteId){
        try{
            if(usuarioRepository.existsByClienteId(clienteId)){
                return ResponseEntity.ok().body(usuarioRepository.findByClienteId(clienteId));
            } else{
                return ResponseEntity.status(404).body("Usuário não encontrado!");
            }
        }catch (Exception e){
            return ResponseEntity.status(400).body("Parâmetros inválidos");
        }
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastraCliente(@RequestBody UsuarioDTO usuarioDTO){
        try{
            if(usuarioRepository.existsByNuCpfCnpj(usuarioDTO.getNuCpfCnpj())){
                return ResponseEntity.status(400).body("Cliente já cadastrado!");
            } else{
                usuarioDTO.setClienteId(UUID.randomUUID().toString());
                return ResponseEntity.status(201).body(UsuarioMapper.entityToDto(usuarioRepository.save(UsuarioMapper.dtoToEntity(usuarioDTO))));
            }
        }catch (Exception e){
            return ResponseEntity.status(400).body("Parâmetros inválidos");
        }
    }

    @PatchMapping("/{clienteId}")
    public ResponseEntity<?> atualizaCliente(@PathVariable(value = "clienteId")String clienteId,
                                             @RequestBody UsuarioDTO usuarioDTO){
        try{
            usuarioDTO.setClienteId(clienteId);
            if(usuarioRepository.existsByClienteId(usuarioDTO.getClienteId())){
                return ResponseEntity.ok().body(UsuarioMapper.entityToDto(usuarioRepository.save(UsuarioMapper.dtoToEntity(usuarioDTO))));
            } else{
                return ResponseEntity.status(400).body("Usuário não encontrado!");
            }
        }catch (Exception e){
            return ResponseEntity.status(400).body("Parâmetros inválidos");
        }
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<?> deletaCliente(@PathVariable(value = "clienteId") String clienteId){
        try{
            if(usuarioRepository.existsByClienteId(clienteId)){
                usuarioRepository.delete(usuarioRepository.findByClienteId(clienteId));
                return ResponseEntity.ok().body("Usuário excluido com sucesso");
            } else{
                return ResponseEntity.status(400).body("Usuário não encontrado!");
            }
        }catch (Exception e){
            return ResponseEntity.status(400).body("Parâmetros inválidos");
        }
    }
}
