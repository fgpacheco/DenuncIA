package br.com.denuncia.net.interfaces;

import java.io.IOException;

public interface Conexao<T> {

    void enviarRegistros(String url, String servico, String token, T dado) throws IOException;

    String obterRegistros(String url, String servico, String token) throws IOException;

    String enviarPergunta(String url, String servico, String pergunta) throws IOException;

}
