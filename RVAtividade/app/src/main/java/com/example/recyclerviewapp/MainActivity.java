package com.example.recyclerviewapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import adapters.UsuarioAdapter;
import models.Produto;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewUsuarios;
    List<Produto> listProdutos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        listProdutos = new ArrayList<>();
        listProdutos.add(new Produto("Bolsa", 199.99));
        listProdutos.add(new Produto("Blusa", 99.99));
        listProdutos.add(new Produto("Gloss", 9.99));

        UsuarioAdapter usuarioAdapter = new UsuarioAdapter(listProdutos);

        recyclerViewUsuarios = findViewById(R.id.recycleViewUsuarios);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        // GridLayoutManager layoutManager = new GridLayoutManager(this, 2);

        recyclerViewUsuarios.setLayoutManager(layoutManager);
        recyclerViewUsuarios.setAdapter(usuarioAdapter);

        Button horizontalBtn = findViewById(R.id.horizontal);
        Button verticalBtn = findViewById(R.id.vertical);
        Button gridBtn = findViewById(R.id.grid);
        Button linearBtn = findViewById(R.id.linear);

        horizontalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.HORIZONTAL, false);
                recyclerViewUsuarios.setLayoutManager(layoutManager);
            }
        });

        verticalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
                recyclerViewUsuarios.setLayoutManager(layoutManager);
            }
        });

        gridBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GridLayoutManager layoutManager = new GridLayoutManager(MainActivity.this, 2, RecyclerView.HORIZONTAL, false);
                recyclerViewUsuarios.setLayoutManager(layoutManager);
            }
        });

        linearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
                recyclerViewUsuarios.setLayoutManager(layoutManager);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}