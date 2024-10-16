package br.com.denuncia.presenter;

import br.com.denuncia.activities.interfaces.MainActivityContract;
import br.com.denuncia.net.tasks.OpenAiTask;
import br.com.denuncia.presenter.interfaces.MainPresenterContract;
import br.com.denuncia.utils.contantes.TelasApp;

public class MainPresenter implements MainPresenterContract {

    private final MainActivityContract view;

    public MainPresenter(MainActivityContract view) {
        this.view = view;
    }

    @Override
    public void validarEscolhaTela(TelasApp tela) {
        if (tela.equals(TelasApp.SELECIONAR_CRIME)) {
            view.iniciarActivity();
            return;
        }
        view.mostrarMensagem("Em desenvolvimento.");
    }
}
