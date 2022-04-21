package com.example.calculadoraanthony;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView result;
    String finalResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.imprimeResultado);

        Button btn0 = findViewById(R.id.valor_0);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.append("0");
            }
        });

        Button btn1 = findViewById(R.id.valor_1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.append("1");
            }
        });

        Button btn2 = findViewById(R.id.valor_2);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.append("2");
            }
        });

        Button btn3 = findViewById(R.id.valor_3);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.append("3");
            }
        });

        Button btn4 = findViewById(R.id.valor_4);

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.append("4");
            }
        });

        Button btn5 = findViewById(R.id.valor_5);

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.append("5");
            }
        });

        Button btn6 = findViewById(R.id.valor_6);

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.append("6");
            }
        });

        Button btn7 = findViewById(R.id.valor_7);

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.append("7");
            }
        });

        Button btn8 = findViewById(R.id.valor_8);

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.append("8");
            }
        });

        Button btn9 = findViewById(R.id.valor_9);

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.append("9");
            }
        });

        Button virgula = findViewById(R.id.virgula);

        virgula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.append(",");
            }
        });

        Button soma = findViewById(R.id.soma);

        soma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.append("+");
            }
        });

        Button subtrai = findViewById(R.id.subtrai);

        subtrai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.append("-");
            }
        });

        Button multiplica = findViewById(R.id.multiplica);

        multiplica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.append("X");
            }
        });

        Button divide = findViewById(R.id.divide);

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.append("/");
            }
        });

        Button porcentagem = findViewById(R.id.porcentagem);

        porcentagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.append("%");
            }
        });

        Button igual = findViewById(R.id.igual);

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(finalResult);
            }
        });

        Button reseta = findViewById(R.id.reseta);

        reseta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText("");
            }
        });
    }
}