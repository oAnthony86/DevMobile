package com.example.times.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.times.R;
import com.example.times.dao.TimesDAO;
import com.example.times.helpers.TimeFormHelper;
import com.example.times.model.Times;

public class TimeFormActivity extends Activity {

    private TimeFormHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_time_form);

        Intent intent = getIntent();
        final Times timeToAlter = (Times) intent.getSerializableExtra("timeSelected");

        this.helper = new TimeFormHelper(this);

        Button botao = (Button) findViewById(R.id.cadastro_time_cadastro_btn);

        if (timeToAlter != null) {
            TextView pageTitle = (TextView) findViewById(R.id.cadastro_time_page_title);

            // Page config change
            pageTitle.setText("Alterar");
            botao.setText("Alterar");

            // Set info to edit
            helper.setOnForm(timeToAlter);
        }

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Times time = helper.getFromForm();

                TimesDAO timesDAO = new TimesDAO(TimeFormActivity.this);

                if(timeToAlter == null){
                    timesDAO.insert(time);
                } else {
                    time.setId(timeToAlter.getId());
                    timesDAO.alter(time);
                }

                timesDAO.close();

                finish();
            }
        });
    }
}
