package com.example.trabalho.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import com.example.trabalho.R;
import com.example.trabalho.dao.TimesDAO;
import com.example.trabalho.model.Times;
import com.example.trabalho.helpers.FormularioTimesHelper;

import java.io.File;

public class FormularioTimesActivity extends Activity {

    private FormularioTimesHelper helper;
    private String localArquivoFoto;
    private static final int TIRA_FOTO = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.times_activity_formulario);

        Intent intent = getIntent();
        final Times registroParaSerAlterado = (Times) intent.getSerializableExtra("timesSelecionado");

        this.helper = new FormularioTimesHelper(this);

        Button botao = (Button) findViewById(R.id.botao);

        if (registroParaSerAlterado != null) {
            botao.setText("Alterar");
            helper.colocaNoFormulario(registroParaSerAlterado);
        }

        botao.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Times registro = helper.pegaDoFormulario();

                TimesDAO dao = new TimesDAO(FormularioTimesActivity.this);

                if (registroParaSerAlterado == null) {
                    dao.insere(registro);
                } else {
                    registro.setId(registroParaSerAlterado.getId());
                    dao.altera(registro);
                }

                dao.close();

                finish();
            }
        });


    }
}

