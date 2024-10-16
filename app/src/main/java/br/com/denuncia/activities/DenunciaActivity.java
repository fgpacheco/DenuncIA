package br.com.denuncia.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import br.com.denuncia.R;
import br.com.denuncia.activities.interfaces.DenunciaActivityContract;
import br.com.denuncia.net.ConexaoImpl;
import br.com.denuncia.net.tasks.OpenAiTask;

public class DenunciaActivity extends AppCompatActivity
        implements DenunciaActivityContract {

    private EditText edtDescricaoCrime;
    private EditText edtRespostaOpenAi;
    private Button btnValidarCrime;
    private Button btnEnviarNotificacaoCrime;
    private TextView txtCamera;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denuncia);

        bindViews();
        edtRespostaOpenAi.setVisibility(View.GONE);
        btnEnviarNotificacaoCrime.setVisibility(View.GONE);
        txtCamera.setOnClickListener(__ -> mostrarMensagem("Em desenvolvimento."));
        btnValidarCrime.setOnClickListener(__ -> validarDescricaoCrime());
        btnEnviarNotificacaoCrime.setOnClickListener(__ -> mostrarMensagem("Webservice em desenvolvimento."));

    }

    public void validarDescricaoCrime() {
        if (ConexaoImpl.possuiConexaoAtiva(this)) {
            edtRespostaOpenAi.setVisibility(View.GONE);
            btnEnviarNotificacaoCrime.setVisibility(View.GONE);
            String descricaoCrime = edtDescricaoCrime.getText().toString();

            OpenAiTask openAiTask = new OpenAiTask(this);
            openAiTask.execute(descricaoCrime);

        } else {
            mostrarMensagem("Dispositivo sem Internet.");
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent it = new Intent(this, SelecaoCrimesActivity.class);
        startActivity(it);
        this.finish();
    }

    @Override
    public void iniciarActivity() {

    }

    @Override
    public void mostrarRespostaOpenAi(String resposta) {
        edtRespostaOpenAi.setVisibility(View.VISIBLE);
        btnEnviarNotificacaoCrime.setVisibility(View.VISIBLE);
        edtRespostaOpenAi.setText(resposta);
    }

    @Override
    public void exibirProgresso(boolean mostrar) {
        progressBar.setVisibility(mostrar ? View.VISIBLE : View.GONE);
    }

    @Override
    public void mostrarMensagem(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void bindViews() {
        edtDescricaoCrime = findViewById(R.id.edtDescricaoCrime);
        edtRespostaOpenAi = findViewById(R.id.edtRespostaOpenAi);
        btnValidarCrime = findViewById(R.id.btnValidarCrime);
        btnEnviarNotificacaoCrime = findViewById(R.id.btnEnviarNotificacaoCrime);
        txtCamera = findViewById(R.id.txtCamera);
        progressBar = findViewById(R.id.progressBarBuscaOpenAi);
    }

    @Override
    public Context getContext() {
        return this;
    }


}