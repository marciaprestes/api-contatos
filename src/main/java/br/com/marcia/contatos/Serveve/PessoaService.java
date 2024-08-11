package br.com.marcia.contatos.Serveve;

import br.com.marcia.contatos.dto.PessoaDto;
import br.com.marcia.contatos.exception.PessoaNaoEncontradaException;
import br.com.marcia.contatos.model.Pessoa;
import br.com.marcia.contatos.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaDto save(PessoaDto pessoaDto){
        Pessoa pessoaModel = new Pessoa();
        pessoaModel.setNome(pessoaDto.getNome());
        pessoaModel.setCep(pessoaDto.getCep());
        pessoaModel.setCidade(pessoaDto.getCidade());
        pessoaModel.setEndereco(pessoaDto.getEndereco());
        pessoaModel.setUf(pessoaDto.getUf());
        pessoaRepository.save(pessoaModel);
        pessoaDto.setId(pessoaModel.getId());
        return pessoaDto;
    }

    public List<PessoaDto> findAll(){
        return pessoaRepository.findAll().stream().map(pessoa -> {
            PessoaDto pessoaDto = new PessoaDto();
            pessoaDto.setNome(pessoa.getNome());
            pessoaDto.setCep(pessoa.getCep());
            pessoaDto.setCidade(pessoa.getCidade());
            pessoaDto.setEndereco(pessoa.getEndereco());
            pessoaDto.setUf(pessoa.getUf());
            pessoaDto.setId(pessoa.getId());
            return pessoaDto;
        }).toList();
    }

    public PessoaDto findById(Long id){
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNaoEncontradaException("Pessoa não encontrada"));
        PessoaDto pessoaDto = new PessoaDto();
        pessoaDto.setId(pessoa.getId());
        pessoaDto.setNome(pessoa.getNome());
        pessoaDto.setEndereco(pessoa.getEndereco());
        pessoaDto.setCep(pessoa.getCep());
        pessoaDto.setCidade(pessoa.getCidade());
        pessoaDto.setUf(pessoa.getUf());
        return pessoaDto;
    }

    public PessoaDto update(PessoaDto pessoaDto, Long id) {
        Pessoa pessoaModel = pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNaoEncontradaException("Pessoa não encontrada"));
        pessoaModel.setNome(pessoaDto.getNome());
        pessoaModel.setEndereco(pessoaDto.getEndereco());
        pessoaModel.setCep(pessoaDto.getCep());
        pessoaModel.setCidade(pessoaDto.getCidade());
        pessoaModel.setUf(pessoaDto.getUf());
        pessoaRepository.save(pessoaModel);
        return pessoaDto;
    }

    public void delete(Long id){
        pessoaRepository.deleteById(id);
    }

}
