package br.com.marcia.contatos.exception;

public class PessoaNaoEncontradaException extends RuntimeException{

    public PessoaNaoEncontradaException(String message){
        super(message);
    }
}
