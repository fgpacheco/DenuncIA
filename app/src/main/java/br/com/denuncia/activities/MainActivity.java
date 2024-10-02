package br.com.denuncia.activities;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import br.com.denuncia.R;
import br.com.denuncia.activities.interfaces.MainContract;

public class MainActivity extends AppCompatActivity implements MainContract {

    private Button btnDenunciarCrime;
    private Button btnVerificarDenuncias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();

        btnDenunciarCrime.setOnClickListener(v -> mostrarMensagem("Em desenvolvimento."));
        btnVerificarDenuncias.setOnClickListener(v -> mostrarMensagem("Em desenvolvimento."));
    }

    @Override
    public void iniciarActivity() {

    }

    @Override
    public void mostrarMensagem(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
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