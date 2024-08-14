package br.com.marcia.contatos.dto;

import org.hibernate.validator.constraints.Length;

public class PessoaDto {

    private Long id;

    @Length(min = 3, max = 100, message = "O nome deve ter no mínimo 3 e no máximo 100 caracteres")
    private String nome;

    @Length(min = 3, max = 100, message = "O endereco deve ter no mínimo 3 e no máximo 100 caracteres")
    private String endereco;

    @Length(min = 9, max = 9, message = "O CEP deve estar no formato 12345-123")
    private String cep;

    @Length(min = 3, max = 100, message = "A cidade deve ter no mínimo 3 e no máximo 100 caracteres")
    private String cidade;

    @Length(min = 2, max = 2, message = "UF deve ter 2 caracteres")
    private String uf;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
