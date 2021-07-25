package br.com.amaro.usuaio.repository;

import br.com.amaro.usuaio.repository.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity,String> {
    boolean existsByClienteId(String clienteId);
    boolean existsByNuCpfCnpj(String nuCpfCnpj);
    UsuarioEntity findByClienteId(String clienteId);
}
