package com.example.recyclerviewapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import adapters.ProdutoAdapter;
import models.Produto;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recycleViewProdutos;
    List<Produto> listProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        listProdutos = new ArrayList<>();
        listProdutos.add(new Produto("Chocolate", 123.4));
        listProdutos.add(new Produto("Perfume", 6564.6));
        listProdutos.add(new Produto("Blush", 86.5));

        ProdutoAdapter produtoAdapter = new ProdutoAdapter(listProdutos);

        recycleViewProdutos = findViewById(R.id.recycleViewProdutos);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, RecyclerView.HORIZONTAL);
        recycleViewProdutos.addItemDecoration(dividerItemDecoration);

        recycleViewProdutos.setLayoutManager(layoutManager);
        recycleViewProdutos.setAdapter(produtoAdapter);

        Button adicionarBtn = findViewById(R.id.adicionarBtn);
        Button removerBtn = findViewById(R.id.removerBtn);

        adicionarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editTextNome = findViewById(R.id.editTextNome);

                String nome = editTextNome.getText().toString();

                EditText editTextPreco = findViewById(R.id.editTextPreco);

                Double preco = Double.parseDouble(editTextPreco.getText().toString());

                Produto produto = new Produto(nome, preco);
                produtoAdapter.adicionarItem(produto);


            }
        });

        removerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                produtoAdapter.removerItem();
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

}