package com.example.recyclerview;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.recyclerview.Restaurante.*;
import com.example.recyclerview.databinding.FragmentItemBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Restaurante}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyRestauranteRecyclerViewAdapter extends RecyclerView.Adapter<MyRestauranteRecyclerViewAdapter.ViewHolder> {
    private Context ctx;
    private final List<Restaurante> mValues;

    public MyRestauranteRecyclerViewAdapter(Context context, List<Restaurante> items) {
        ctx = context;
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.textViewNombre.setText(holder.mItem.getNombre());
        holder.textViewDireccionRestaurante.setText(holder.mItem.getDirección());
        holder.ratingBar.setRating(holder.mItem.getValoracion());
        Glide.with(ctx)
                .load(holder.mItem.getUrlPhoto())
                .centerCrop()
                .into(holder.imageViewPhoto);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView textViewNombre;
        public final TextView textViewDireccionRestaurante;
        public final ImageView imageViewPhoto;
        public final RatingBar ratingBar;
        public Restaurante mItem;

        public ViewHolder(FragmentItemBinding binding) {
            super(binding.getRoot());
            textViewNombre = binding.textViewNombre ;
            textViewDireccionRestaurante = binding.textViewDireccionRestaurante;
            imageViewPhoto = itemView.findViewById(R.id.imageViewPhoto);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            //mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + textViewNombre .getText() + "'";
        }
    }
}