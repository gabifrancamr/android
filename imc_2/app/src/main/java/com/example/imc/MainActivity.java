package com.example.imc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void calcularImc(View view) {
        // TextView resultado = findViewById(R.id.resultado);

        EditText text_altura = findViewById(R.id.altura);
        Double altura = Double.parseDouble(text_altura.getText().toString());

        EditText text_peso = findViewById(R.id.peso);
        Double peso = Double.parseDouble(text_peso.getText().toString());

        Double imc = peso / (altura * altura);

        // resultado.setText("O IMC é igual a: " + imc);

        Intent intent = new Intent(this, ResultadoImcActivity.class);
        intent.putExtra("imc", imc);

        startActivity(intent);
    }
}