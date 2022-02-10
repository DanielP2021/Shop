package com.example.shop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shop.R;
import com.example.shop.model.DiscontinuedProducts;

import java.util.List;

public class DiscontinuedProductsAdapter extends RecyclerView.Adapter<DiscontinuedProductsAdapter.DiscontinuedProductViewHolder> {

    Context context;
    List<DiscontinuedProducts> discontinuedProductsList;

    public DiscontinuedProductsAdapter(Context context, List<DiscontinuedProducts> discontinuedProductsList) {
        this.context =context;
        this.discontinuedProductsList=discontinuedProductsList;
    }

    @NonNull
    @Override
    public DiscontinuedProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.discontinued_row_items, parent, false);
        return new DiscontinuedProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiscontinuedProductViewHolder holder, int position) {
        holder.discontinuedImageView.setImageResource((discontinuedProductsList.get(position).getImageurl()));

    }

    @Override
    public int getItemCount() {
        return discontinuedProductsList.size();

    }


    public static class DiscontinuedProductViewHolder extends RecyclerView.ViewHolder{

        ImageView discontinuedImageView;
        public DiscontinuedProductViewHolder(@NonNull View itemView) {

            super(itemView);
            discontinuedImageView=itemView.findViewById(R.id.categoryImage);
        }

    }

}
