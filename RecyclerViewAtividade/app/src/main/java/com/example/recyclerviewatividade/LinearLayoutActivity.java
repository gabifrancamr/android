package com.example.recyclerviewatividade;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import adapter.ProdutoAdapter;
import models.Produto;

public class LinearLayoutActivity extends AppCompatActivity {
    RecyclerView recyclerViewProdutosLL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_linear_layout);

        Bundle extras = getIntent().getExtras();
        List<Produto> produtos = (List<Produto>) getIntent().getSerializableExtra("listaProdutos");

        recyclerViewProdutosLL = findViewById(R.id.recycleViewProdutoLL);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewProdutosLL.setLayoutManager(layoutManager);

        ProdutoAdapter produtoAdapter = new ProdutoAdapter(produtos);
        recyclerViewProdutosLL.setAdapter(produtoAdapter);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void mudarParaLHorizontal() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,  RecyclerView.HORIZONTAL, false);
        recyclerViewProdutosLL.setLayoutManager(layoutManager);
    }

    public void mudarParaLVertical() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerViewProdutosLL.setLayoutManager(layoutManager);
    }

    public void mudarParaGrid(View view) {
        finish();
    }
}