package br.com.alura.screenmatch.excecao;

public class ErroDeConversaoDeAnoException extends RuntimeException {
    private String mensagem;

    public ErroDeConversaoDeAnoException(String msg) {
        this.mensagem = msg;
    }

    public String getMessage() {
        return this.mensagem;
    }
}
