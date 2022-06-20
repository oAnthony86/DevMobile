package com.example.times.helpers;

import android.widget.EditText;

import com.example.times.R;
import com.example.times.activities.TimeFormActivity;
import com.example.times.model.Times;

public class TimeFormHelper {

    private final EditText name;
    private final EditText country;
    private Times time;

    public TimeFormHelper(TimeFormActivity activity){

        name = (EditText) activity.findViewById(R.id.cadastro_time_input_title);
        country = (EditText) activity.findViewById(R.id.cadastro_time_input_comment);

        time = new Times();
    }

    public Times getFromForm() {

        time.setName(name.getEditableText().toString());
        time.setCountry(country.getEditableText().toString());

        return time;
    }

    public void setOnForm(Times time) {
        this.time = time;

        name.setText(time.getName());
        country.setText(time.getCountry());
    }
}
