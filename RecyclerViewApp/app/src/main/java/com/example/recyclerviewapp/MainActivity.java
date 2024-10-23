package com.example.recyclerviewapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import adapters.UsuarioAdapter;
import models.Usuario;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewUsuarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        List<Usuario> listUsuarios = new ArrayList<>();
        listUsuarios.add(new Usuario("Alexandre", "Desenvolvedor de Software"));
        listUsuarios.add(new Usuario("Bruna", "Engenheira Civil"));
        listUsuarios.add(new Usuario("Joana", "Dentista"));

        UsuarioAdapter usuarioAdapter = new UsuarioAdapter(listUsuarios);

        recyclerViewUsuarios = findViewById(R.id.recycleViewUsuarios);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerViewUsuarios.setLayoutManager(layoutManager);
        recyclerViewUsuarios.setAdapter(usuarioAdapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}