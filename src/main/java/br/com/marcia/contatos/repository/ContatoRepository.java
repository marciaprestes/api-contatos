package br.com.marcia.contatos.repository;

import br.com.marcia.contatos.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

    List<Contato> findAllByPessoaId(Long pessoaId);

}
