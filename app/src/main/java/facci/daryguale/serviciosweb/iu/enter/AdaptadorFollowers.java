package facci.daryguale.serviciosweb.iu.enter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import facci.daryguale.serviciosweb.R;
import facci.daryguale.serviciosweb.rest.model.Owner;

public class AdaptadorFollowers extends RecyclerView.Adapter<AdaptadorFollowers.ViewHolderFollowers> {

    ArrayList<Owner> listaFollowers;

    public AdaptadorFollowers(ArrayList<Owner> listaFollowers) {
        this.listaFollowers = listaFollowers;
    }

    @NonNull
    @Override
    public ViewHolderFollowers onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null, false);
        return new ViewHolderFollowers(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderFollowers holder, int position) {
        holder.etiNombre.setText(listaFollowers.get(position).getCiudad());
        //holder.foto.setImageResource(listaFollowers.get(position).get);

        //Picasso.get().load(listaFollowers.get(position).getAvatarUrl()).into(holder.foto);
    }

    @Override
    public int getItemCount() {
        return listaFollowers.size();
    }

    public class ViewHolderFollowers extends RecyclerView.ViewHolder {

        TextView etiNombre;
        ImageView foto;

        public ViewHolderFollowers(View itemView) {
            super(itemView);

            etiNombre = (TextView) itemView.findViewById(R.id.textViewLista);
            foto = (ImageView) itemView.findViewById(R.id.imageViewLista);
        }
    }
}
