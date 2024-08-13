package br.com.marcia.contatos.exception;

public class ContatoNaoEncontradoException extends RuntimeException{

    public ContatoNaoEncontradoException(String message){
        super(message);
    }

}
