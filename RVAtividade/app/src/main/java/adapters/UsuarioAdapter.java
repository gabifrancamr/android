package adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewapp.R;

import java.util.List;

import models.Produto;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioHolder> {
    private final List<Produto> produtos;

    public UsuarioAdapter(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @NonNull
    @Override
    public UsuarioHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UsuarioHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioHolder holder, int position) {
        holder.nome.setText(produtos.get(position).getNome());
        holder.preco.setText(String.valueOf(produtos.get(position).getPreco()));
        //holder.preco.setText(produtos.get(position).getPreco());
        holder.imagem.setImageResource(R.drawable.ic_launcher_background);
    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }
}
