package com.example.temperatura;

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

    public void converter(View view) {
        EditText temperaturaCelsius = findViewById(R.id.celsius);
        String temperaturaCelsiusString = temperaturaCelsius.getText().toString();
        Double temperaturaCelsiusDouble = Double.parseDouble(temperaturaCelsiusString);

        Double farenheit = (temperaturaCelsiusDouble * 1.8) + 32;

        TextView resultado = findViewById(R.id.resultado);
        resultado.setText("A temperatura em farenheit é: " + farenheit);
    }
}