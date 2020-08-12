package com.example.nestedrecyclerviewexample.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nestedrecyclerviewexample.R;
import com.example.nestedrecyclerviewexample.model.Product;

import java.util.List;

public class CircularRecyclerViewAdapter extends RecyclerView.Adapter<CircularRecyclerViewAdapter.CircularViewHolder>{

    List<Product> mProductList;

    public CircularRecyclerViewAdapter(List<Product> productList) {
        mProductList = productList;
    }

    @NonNull
    @Override
    public CircularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.circular_item_row,parent,false);
        return new CircularViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CircularViewHolder holder, int position) {

        Product product = mProductList.get(position);
        //holder.product_item_name.setText(product.product_name);
        holder.product_item_image.setImageResource(product.product_image);
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }

    public class CircularViewHolder extends RecyclerView.ViewHolder{

        TextView product_item_name;
        ImageView product_item_image;

        public CircularViewHolder(@NonNull View itemView) {
            super(itemView);

            product_item_name = itemView.findViewById(R.id.product_item_name);
            product_item_image = itemView.findViewById(R.id.product_item_image);
        }
    }
}
