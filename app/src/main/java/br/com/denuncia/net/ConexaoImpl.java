package br.com.denuncia.net;

import static java.util.Objects.nonNull;
import static br.com.denuncia.utils.contantes.Constantes.EMPTY;
import static br.com.denuncia.utils.contantes.Constantes.MODEL_OPEN_AI;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import br.com.denuncia.dto.ChatCompletionRequestDTO;
import br.com.denuncia.dto.MessageDTO;
import br.com.denuncia.exception.ErroRequisicaoException;
import br.com.denuncia.net.interfaces.Conexao;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ConexaoImpl<T extends Serializable> implements Conexao<T> {

    private static final String API_KEY = "<API_KEY>";
    private static ConexaoImpl instance = null;
    private static final String TIMEOUT_CONEXAO = "20";
    private static final String TIMEOUT_LEITURA = "20";

    private final OkHttpClient client;
    private final String timeoutConexao;
    private final String timeoutLeitura;

    private static final MediaType MEDIA_TYPE_DEFAULT = MediaType.get("application/json; charset=utf-8");

    public static ConexaoImpl getInstance() {
        if (instance == null) {
            instance = new ConexaoImpl();
        }
        return instance;
    }

    private ConexaoImpl() {
        this.timeoutConexao = TIMEOUT_CONEXAO;
        this.timeoutLeitura = TIMEOUT_LEITURA;
        this.client = obterHttpClient();
    }

    public static boolean possuiConexaoAtiva(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        return nonNull(networkInfo) && networkInfo.isConnected();
    }

    @Override
    public void enviarRegistros(String url, String servico, String token, T dado) throws IOException {

    }

    @Override
    public String obterRegistros(String url, String servico, String token) throws IOException {
        return EMPTY;
    }

    @Override
    public String enviarPergunta(String url, String servico, String pergunta) throws IOException {
        ChatCompletionRequestDTO requestDTO = getChatCompletionRequestDTO(pergunta);

        String json = new Gson().toJson(requestDTO);
        RequestBody body = RequestBody.Companion.create(json, MEDIA_TYPE_DEFAULT);

        Request request = new Request.Builder()
                .url(url + servico)
                .addHeader("Authorization", "Bearer " + API_KEY)
                .addHeader("Content-Type", "application/json")
                .post(body)
                .build();

        Response response = client.newCall(request).execute();
        switch (response.code()) {
            case 200:
            case 201:
                return response.body().string();
            default:
                throw new ErroRequisicaoException(response.body().string());
        }
    }

    private static ChatCompletionRequestDTO getChatCompletionRequestDTO(String pergunta) {
        ChatCompletionRequestDTO requestDTO = new ChatCompletionRequestDTO();
        requestDTO.setModel(MODEL_OPEN_AI);

        MessageDTO messageSystem = new MessageDTO();
        messageSystem.setRole("system");
        messageSystem.setContent("Você é um Assistente para Atendimentos de Disque Denúncia contra Homicídio.");

        MessageDTO messageUser = new MessageDTO();
        messageUser.setRole("user");
        messageUser.setContent(pergunta);

        requestDTO.setMessages(List.of(messageSystem, messageUser));
        return requestDTO;
    }

    private OkHttpClient obterHttpClient() {
        return new OkHttpClient.Builder()
                .readTimeout(Integer.parseInt(timeoutLeitura), TimeUnit.SECONDS)
                .connectTimeout(Integer.parseInt(timeoutConexao), TimeUnit.SECONDS)
                .build();
    }
}
