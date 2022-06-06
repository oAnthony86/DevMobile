package com.example.trabalho.helpers;

import android.widget.EditText;

import com.example.trabalho.R;
import com.example.trabalho.activities.FormularioTimesActivity;
import com.example.trabalho.model.Times;

public class FormularioTimesHelper {
    private EditText descricao;
    private EditText sigla;
    private Times registro;

    public FormularioTimesHelper(FormularioTimesActivity activity) {

        descricao = (EditText) activity.findViewById(R.id.descricao);
        sigla = (EditText) activity.findViewById(R.id.sigla);

        registro = new Times();
    }

    public Times pegaDoFormulario() {

        registro.setDescricao(descricao.getEditableText().toString());
        registro.setSigla(sigla.getEditableText().toString());

        return registro;
    }

    public void colocaNoFormulario(Times pRegistro) {
        this.registro = pRegistro;

        descricao.setText(pRegistro.getDescricao());
        sigla.setText(pRegistro.getSigla());
    }


}

