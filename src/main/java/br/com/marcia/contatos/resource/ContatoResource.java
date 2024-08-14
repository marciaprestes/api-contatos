package br.com.marcia.contatos.resource;

import br.com.marcia.contatos.service.ContatoService;
import br.com.marcia.contatos.dto.ContatoDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contatos")
public class ContatoResource {

    @Autowired
    private ContatoService contatoService;

    @Operation(summary = "Cria um contato")
    @PostMapping
    public ResponseEntity<ContatoDto> save(@RequestBody @Valid ContatoDto contatoDto){
        return ResponseEntity.ok(contatoService.save(contatoDto));
    }

    @Operation(summary = "Busca contato pelo Id")
    @GetMapping("/{id}")
    public ResponseEntity<ContatoDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(contatoService.findById(id));
    }

    @Operation(summary = "Atualiza um contato pelo Id")
    @PutMapping("/{id}")
    public ResponseEntity<ContatoDto> update(@RequestBody @Valid ContatoDto contatoDto,@PathVariable Long id){
        return ResponseEntity.ok(contatoService.update(contatoDto,id));
    }

    @Operation(summary = "Apagar um contato pelo Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        contatoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Lista todos os Contatos de uma Pessoa")
    @GetMapping("/pessoa/{idPessoa}")
    public ResponseEntity<List<ContatoDto>> findContatosByPessoaId(@PathVariable Long idPessoa) {
        return ResponseEntity.ok(contatoService.findContatosByPessoaId(idPessoa));
    }

}
