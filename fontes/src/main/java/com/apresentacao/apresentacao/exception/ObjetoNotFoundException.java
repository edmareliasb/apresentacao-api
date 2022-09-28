package com.apresentacao.apresentacao.exception;

public class ObjetoNotFoundException extends RuntimeException {

    private String mensagem;
    private String errorCode;

    public ObjetoNotFoundException(String errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
        this.mensagem = msg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getMensagem() {
        return mensagem;
    }
}
