package br.com.denuncia.activities.interfaces;

public interface TaskViewContract extends BaseView {

    void mostrarMensagem(String msg);

    void mostrarRespostaOpenAi(String resposta);

    void exibirProgresso(boolean mostrar);
}
