package br.com.denuncia.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import br.com.denuncia.R;
import br.com.denuncia.activities.interfaces.SelecaoCrimesActivityContract;

public class SelecaoCrimesActivity extends AppCompatActivity implements SelecaoCrimesActivityContract {

    private Button btnHomicidio;
    private Button btnRoubo;
    private Button btnFeminicidio;
    private Button btnLatrocinio;
    private Button btnIncedioOnibus;
    private Button btnAmbiental;
    private Button btnVandalismo;
    private Button btnEstupro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecao_crimes);
//        requireNonNull(getSupportActionBar()).setTitle("Selecione um crime");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bindViews();

        btnHomicidio.setOnClickListener(__ -> iniciarActivity(DenunciaActivity.class));
        btnRoubo.setOnClickListener(__ -> mostrarMensagem("Em desenvolvimento."));
        btnFeminicidio.setOnClickListener(__ -> mostrarMensagem("Em desenvolvimento."));
        btnLatrocinio.setOnClickListener(__ -> mostrarMensagem("Em desenvolvimento."));
        btnIncedioOnibus.setOnClickListener(__ -> mostrarMensagem("Em desenvolvimento."));
        btnAmbiental.setOnClickListener(__ -> mostrarMensagem("Em desenvolvimento."));
        btnVandalismo.setOnClickListener(__ -> mostrarMensagem("Em desenvolvimento."));
        btnEstupro.setOnClickListener(__ -> mostrarMensagem("Em desenvolvimento."));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
        this.finish();
    }

    @Override
    public void iniciarActivity() {

    }

    @Override
    public void iniciarActivity(Class Activity) {
        Intent it = new Intent(this, Activity);
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
        btnAmbiental = findViewById(R.id.btnAmbiental);
        btnEstupro = findViewById(R.id.btnEstupro);
        btnFeminicidio = findViewById(R.id.btnFeminicidio);
        btnHomicidio = findViewById(R.id.btnHomicidio);
        btnLatrocinio = findViewById(R.id.btnLatrocinio);
        btnIncedioOnibus = findViewById(R.id.btnIncedioOnibus);
        btnRoubo = findViewById(R.id.btnRoubo);
        btnVandalismo = findViewById(R.id.btnVandalismo);
    }

    @Override
    public Context getContext() {
        return this;
    }
}