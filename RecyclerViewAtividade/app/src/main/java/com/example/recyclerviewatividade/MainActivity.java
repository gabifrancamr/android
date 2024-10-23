package com.example.recyclerviewatividade;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import adapter.ProdutoAdapter;
import models.Produto;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewProdutos;
    private List<Produto> listProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        listProdutos = new ArrayList<>();
        listProdutos.add(new Produto("Chocolate", "R$ 15.00"));
        listProdutos.add(new Produto("Perfume", "R$ 800.00"));
        listProdutos.add(new Produto("Chocolate", "R$ 15.00"));
        listProdutos.add(new Produto("Perfume", "R$ 800.00"));
        listProdutos.add(new Produto("Chocolate", "R$ 15.00"));
        listProdutos.add(new Produto("Perfume", "R$ 800.00"));


        ProdutoAdapter produtoAdapter = new ProdutoAdapter(listProdutos);

        recyclerViewProdutos = findViewById(R.id.recycleViewProdutos);

        //LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);

        recyclerViewProdutos.setLayoutManager(layoutManager);
        recyclerViewProdutos.setAdapter(produtoAdapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void mudarParaHorizontal() {
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2, RecyclerView.HORIZONTAL, false);
        recyclerViewProdutos.setLayoutManager(layoutManager);
    }

    public void mudarParaVertical() {
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2, RecyclerView.VERTICAL, false);
        recyclerViewProdutos.setLayoutManager(layoutManager);
    }

    public void mudarParaLinearLayout(View view) {
        Intent intent = new Intent(this, LinearLayoutActivity.class);
        intent.putExtra("listaProdutos", (Serializable) listProdutos);
        startActivity(intent);
    }
}