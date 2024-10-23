package adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewatividade.R;

public class ProdutoHolder extends RecyclerView.ViewHolder {
    public TextView nome;
    public TextView preco;
    public ImageView imagem;
    public ProdutoHolder(@NonNull View itemView) {
        super(itemView);
        nome = (TextView) itemView.findViewById(R.id.textViewNome);
        preco = (TextView) itemView.findViewById(R.id.textViewPreco);
        imagem = (ImageView) itemView.findViewById(R.id.imageView);
    }
}
