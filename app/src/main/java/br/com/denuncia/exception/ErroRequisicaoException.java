package br.com.denuncia.exception;

public class ErroRequisicaoException extends RuntimeException {

    private static final long serialVersionUID = 4413992101571781883L;

    public ErroRequisicaoException() {
    }

    public ErroRequisicaoException(String message) {
        super(message);
    }
}
