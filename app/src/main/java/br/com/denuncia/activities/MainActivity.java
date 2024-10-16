package br.com.denuncia.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import br.com.denuncia.R;
import br.com.denuncia.activities.interfaces.MainActivityContract;
import br.com.denuncia.presenter.MainPresenter;
import br.com.denuncia.presenter.interfaces.MainPresenterContract;
import br.com.denuncia.utils.contantes.TelasApp;

public class MainActivity extends AppCompatActivity implements MainActivityContract {

    private Button btnDenunciarCrime;
    private Button btnVerificarDenuncias;
    private MainPresenterContract presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();

        presenter = new MainPresenter(this);

        btnDenunciarCrime.setOnClickListener(__ -> presenter.validarEscolhaTela(TelasApp.SELECIONAR_CRIME));
        btnVerificarDenuncias.setOnClickListener(__ -> presenter.validarEscolhaTela(TelasApp.ACOMPANHAR_CRIME));
    }

    @Override
    public void iniciarActivity() {
        Intent it = new Intent(this, SelecaoCrimesActivity.class);
        startActivity(it);
        this.finish();
    }

    @Override
    public void mostrarMensagem(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void mostrarRespostaOpenAi(String resposta) {

    }

    @Override
    public void exibirProgresso(boolean mostrar) {

    }

    @Override
    public void bindViews() {
        btnDenunciarCrime = findViewById(R.id.btnDenunciar);
        btnVerificarDenuncias = findViewById(R.id.btnVerificarDenuncias);
    }

    @Override
    public Context getContext() {
        return this;
    }
}