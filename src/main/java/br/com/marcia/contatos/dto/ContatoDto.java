package br.com.marcia.contatos.dto;

import jakarta.validation.constraints.*;

public class ContatoDto {

    private Long id;

    @Min(value = 0,message = "Tipo de contato deve ser 0 para telefeone ou 1 para celular")
    @Max(value = 1,message = "Tipo de contato deve ser 0 para telefeone ou 1 para celular")
    private Integer tipoContato;

    @NotBlank(message = "O contato é requerido")
    @NotNull(message = "O contato é requerido")
    private String contato;

    @Min(value = 1,message = "O id da pessoa é requerido")
    private Long pessoaId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(Integer tipoContato) {
        this.tipoContato = tipoContato;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }
}
