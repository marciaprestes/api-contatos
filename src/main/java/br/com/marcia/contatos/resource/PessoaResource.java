package br.com.marcia.contatos.resource;

import br.com.marcia.contatos.dto.MalaDiretaRecord;
import br.com.marcia.contatos.dto.PessoaDto;
import br.com.marcia.contatos.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaResource {

    @Autowired
    private PessoaService pessoaService;

    @Operation(summary = "Cria uma Pessoa")
    @PostMapping
    public ResponseEntity<PessoaDto> save(@RequestBody @Valid PessoaDto pessoaDto){
        return ResponseEntity.ok(pessoaService.save(pessoaDto));
    }

    @Operation(summary = "Lista todas as Pessoas")
    @GetMapping
    public ResponseEntity<List<PessoaDto>> findAll(){
        return ResponseEntity.ok(pessoaService.findAll());
    }

    @Operation(summary = "Atualiza uma Pessoa")
    @PutMapping("/{id}")
    public ResponseEntity<PessoaDto> update(@RequestBody @Valid PessoaDto pessoaDto,@PathVariable Long id){
        return ResponseEntity.ok(pessoaService.update(pessoaDto,id));
    }

    @Operation(summary = "Busca Pessoa pelo Id")
    @GetMapping("/{id}")
    public ResponseEntity<PessoaDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(pessoaService.findById(id));
    }

    @Operation(summary = "Apagar Pessoa pelo Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pessoaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Dados de uma pessoa por ID para mala direta")
    @GetMapping("/maladireta/{id}")
    ResponseEntity<MalaDiretaRecord> findMalaDiretaByPessoaId(@PathVariable Long id){
        return ResponseEntity.ok(pessoaService.findMalaDiretaByPessoaId(id));
    }

}
