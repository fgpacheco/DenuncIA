package br.com.denuncia.net.tasks;

import static br.com.denuncia.utils.contantes.Constantes.EMPTY;

import android.os.AsyncTask;

import com.google.gson.Gson;

import br.com.denuncia.activities.interfaces.TaskViewContract;
import br.com.denuncia.dto.ChatCompletionResponseDTO;
import br.com.denuncia.net.ConexaoImpl;
import br.com.denuncia.net.interfaces.Conexao;

public class OpenAiTask extends AsyncTask<String, Void, String> {

    private final Conexao conexao;
    private final TaskViewContract view;

    public OpenAiTask(TaskViewContract view) {
        this.conexao = ConexaoImpl.getInstance();
        this.view = view;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        view.exibirProgresso(true);
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            return ConexaoImpl.getInstance().enviarPergunta(
                    "https://api.openai.com",
                    "/v1/chat/completions",
                    strings[0]);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return EMPTY;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (s.isEmpty()) {
            view.mostrarMensagem("Erro ao receber resposta da OpenAI");
            return;
        }

        ChatCompletionResponseDTO chatCompletionResponseDTO = new Gson().fromJson(s, ChatCompletionResponseDTO.class);
        String respostaOpenAi = chatCompletionResponseDTO
                .getChoices()
                .get(0)
                .getMessage()
                .getContent();

        view.mostrarRespostaOpenAi(respostaOpenAi);
        view.exibirProgresso(false);
    }
}
