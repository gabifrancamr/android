package adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewapp.R;

import java.util.List;

import models.Usuario;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioHolder> {
    private final List<Usuario> usuarios;

    public UsuarioAdapter(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @NonNull
    @Override
    public UsuarioHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UsuarioHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioHolder holder, int position) {
        holder.nome.setText(usuarios.get(position).getNome());
        holder.profissao.setText(usuarios.get(position).getProfissao());
        holder.imagem.setImageResource(R.drawable.ic_launcher_background);
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }
}
