package br.com.marcia.contatos.service;

import br.com.marcia.contatos.dto.ContatoDto;
import br.com.marcia.contatos.exception.ContatoNaoEncontradoException;
import br.com.marcia.contatos.exception.PessoaNaoEncontradaException;
import br.com.marcia.contatos.model.Contato;
import br.com.marcia.contatos.model.Pessoa;
import br.com.marcia.contatos.repository.ContatoRepository;
import br.com.marcia.contatos.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public ContatoDto save(ContatoDto contatoDto){
        Contato contatoModel = new Contato();
        Pessoa pessoaModel = pessoaRepository.findById(contatoDto.getPessoaId()).orElseThrow(() -> new PessoaNaoEncontradaException("Pessoa Não Encontrada"));
        contatoModel.setTipoContato(contatoDto.getTipoContato());
        contatoModel.setContato(contatoDto.getContato());
        contatoModel.setPessoa(pessoaModel);
        contatoRepository.save(contatoModel);
        contatoDto.setId(contatoModel.getId());
        return  contatoDto;
    }

    public ContatoDto findById(Long id){
        Contato contatoModel = contatoRepository.findById(id).orElseThrow( () -> new ContatoNaoEncontradoException("Contato Não Encontrado"));
        ContatoDto contatoDto = new ContatoDto();

        contatoDto.setId(contatoModel.getId());
        contatoDto.setTipoContato(contatoModel.getTipoContato());
        contatoDto.setContato(contatoModel.getContato());
        contatoDto.setPessoaId(contatoModel.getPessoa().getId());
        return contatoDto;
    }

    public ContatoDto update(ContatoDto contatoDto, Long id) {
        Contato contatoModel = contatoRepository.findById(id).orElseThrow( () -> new ContatoNaoEncontradoException("Contato Não Encontrado"));
        Pessoa pessoaModel = pessoaRepository.findById(contatoDto.getPessoaId()).orElseThrow(() -> new PessoaNaoEncontradaException("Pessoa Não Encontrada"));
        contatoModel.setTipoContato(contatoDto.getTipoContato());
        contatoModel.setContato(contatoDto.getContato());
        contatoModel.setPessoa(pessoaModel);
        contatoRepository.save(contatoModel);
        return contatoDto;
    }

    public void delete(Long id){
        contatoRepository.deleteById(id);
    }

    public List<ContatoDto> findContatosByPessoaId(Long pessoaId){
       Pessoa pessoaModel = pessoaRepository.findById(pessoaId).orElseThrow(() -> new PessoaNaoEncontradaException("Pessoa Não Encontrada"));

       return pessoaModel.getContatos().stream()
                .map(contatoModel -> {
            ContatoDto contatoDto = new ContatoDto();
            contatoDto.setId(contatoModel.getId());
            contatoDto.setTipoContato(contatoModel.getTipoContato());
            contatoDto.setContato(contatoModel.getContato());
            contatoDto.setPessoaId(contatoModel.getPessoa().getId());
            return contatoDto;
        }).toList();
    }


    
}
