package com.example.aula;

import android.os.Bundle;

import android.view.View;
import android.widget.Toast;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

//    private TextView messageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Encontrar o TextView pelo ID e armazenar na variável
//        messageTextView = findViewById(R.id.message);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Método que será chamado quando o botão for clicado
    public void sortear(View view) {
        Random random = new Random();
        int numeroSorteado = random.nextInt(11);
        TextView resultado = findViewById(R.id.resultado);

        if(numeroSorteado % 2 == 0) {
            resultado.setText("O número encontrado é par\n Resultado: " + numeroSorteado);
        } else {
            resultado.setText("O número encontrado é ímpar\n Resultado: " + numeroSorteado);
        }

        // Definir a mensagem no TextView quando o botão for clicado
        // messageTextView.setText("Botão clicado");
    }

}