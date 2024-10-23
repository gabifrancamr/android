package adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewatividade.R;

import java.util.List;

import models.Produto;

public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoHolder> {
    private final List<Produto> produtos;

    public ProdutoAdapter(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @NonNull
    @Override
    public ProdutoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProdutoHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProdutoHolder holder, int position) {
        holder.nome.setText(produtos.get(position).getNome());
        holder.preco.setText(produtos.get(position).getPreco());
        holder.imagem.setImageResource(R.drawable.ic_launcher_background);
    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }
}
