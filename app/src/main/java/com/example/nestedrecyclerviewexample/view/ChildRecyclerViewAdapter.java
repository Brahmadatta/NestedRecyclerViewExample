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


public class ChildRecyclerViewAdapter extends RecyclerView.Adapter<ChildRecyclerViewAdapter.ChildRecyclerViewHolder> {

    List<Product> mProductList;

    public ChildRecyclerViewAdapter(List<Product> productList) {
        mProductList = productList;
    }

    @NonNull
    @Override
    public ChildRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false);
        return new ChildRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildRecyclerViewHolder holder, int position) {
        Product product = mProductList.get(position);

        //holder.product_item_name.setText(product.product_name);
        holder.product_image.setImageResource(product.product_image);

    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }

    public class ChildRecyclerViewHolder extends RecyclerView.ViewHolder{

        TextView product_item_name;
        ImageView product_image;


        public ChildRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            //product_item_name = itemView.findViewById(R.id.product_item_name);
            product_image = itemView.findViewById(R.id.product_shop_id);
        }
    }
}
