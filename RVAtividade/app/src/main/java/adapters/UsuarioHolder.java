package adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.recyclerviewapp.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UsuarioHolder extends RecyclerView.ViewHolder {
    public TextView nome;
    public TextView preco;
    public ImageView imagem;
    public UsuarioHolder(@NonNull View itemView) {
        super(itemView);
        nome = (TextView) itemView.findViewById(R.id.textViewNome);
        preco = (TextView) itemView.findViewById(R.id.textViewProfissao);
        imagem = (ImageView) itemView.findViewById(R.id.imageView);
    }
}
