package com.example.imc;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultadoImcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resultado_imc);
        
        Bundle extras = getIntent().getExtras();
        Double imc = extras.getDouble("imc");

        TextView resultadoImc = findViewById(R.id.valorImc);

        if(imc < 18.5) {
            resultadoImc.setText("IMC: " + imc + " abaixo do peso");
        } else if(imc >= 18.5 && imc < 24.9 ) {
            resultadoImc.setText("IMC: " + imc + " peso normal");
        } else if(imc >= 25 && imc <= 29.9 ) {
            resultadoImc.setText("IMC: " + imc + " sobrepeso");
        } else {
            resultadoImc.setText("IMC: " + imc + " obesidade");
        }

        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void fechar(View view) {
        finish();
    }
}