package br.com.marcia.contatos.resource;

import br.com.marcia.contatos.Serveve.PessoaService;
import br.com.marcia.contatos.dto.PessoaDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<PessoaDto> save(@RequestBody PessoaDto pessoaDto){
        return ResponseEntity.ok(pessoaService.save(pessoaDto));
    }

    @Operation(summary = "Lista todas as Pessoas")
    @GetMapping
    public ResponseEntity<List<PessoaDto>> findAll(){
        return ResponseEntity.ok(pessoaService.findAll());
    }

}
