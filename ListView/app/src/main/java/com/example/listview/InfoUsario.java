package com.example.listview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

import models.Usuario;

public class InfoUsario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_info_usario);

        Bundle extras = getIntent().getExtras();
        int posicao = extras.getInt("posicaoUsuario");

        TextView resultado = findViewById(R.id.resultado);

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("LucasAlmeida93", "Desenvolvedor Android", "Desenvolvedor Android com 5 anos de experiência."));
        usuarios.add(new Usuario("AnaTechGuru", "Engenheira de Software", "Especialista em IA."));
        usuarios.add(new Usuario("JoaoDevMaster", "Full-stack Developer", "Foco em Java e Kotlin."));
        usuarios.add(new Usuario("MarinaCoder21", "Desenvolvedora Mobile", "Entusiasta de design UX/UI."));
        usuarios.add(new Usuario("PedroGamerPro", "Criador de Jogos", "Desenvolvedor de software e criador de jogos."));

        Usuario usuario = usuarios.get(posicao);

        resultado.setText(
                "Nome: " + usuario.nome + "\n" + "Profissão: " + usuario.profissao + "\n" + "Descrição: " + usuario.descricao
        );

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}