package com.example.grocerylist;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{

    private final Context mCtx;
    private final List<Product> productList;

    public ProductAdapter(Context mCtx, List<Product> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.card_item, parent, false);
        return new ProductViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.textViewTitle.setText(product.getName());
        holder.textViewAmount.setText(String.format("%s %s", (product.getAmount()), product.getUnit()));
        holder.textViewComment.setText(product.getComment());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView  textViewTitle, textViewAmount, textViewComment;
        ImageButton imageButtonDelete, imageButtonEdit;
        public ProductViewHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewAmount = itemView.findViewById(R.id.textViewAmount);
            imageButtonDelete = itemView.findViewById(R.id.imageButtonDelete);
            imageButtonEdit = itemView.findViewById(R.id.imageButtonEdit);
            textViewComment = itemView.findViewById(R.id.textViewComment);
        }
    }
}
