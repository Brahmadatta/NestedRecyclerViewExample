package com.example.nestedrecyclerviewexample.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nestedrecyclerviewexample.R;
import com.example.nestedrecyclerviewexample.model.Product;

import java.util.List;


public class NewItemsRecyclerAdapter extends RecyclerView.Adapter<NewItemsRecyclerAdapter.NewItemsRecyclerViewHolder> {

    List<Product> mProductList;

    public NewItemsRecyclerAdapter(List<Product> productList) {
        mProductList = productList;
    }

    @NonNull
    @Override
    public NewItemsRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_items_row_layout,parent,false);
        return new NewItemsRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewItemsRecyclerViewHolder holder, int position) {

        Product product = mProductList.get(position);
        holder.product_item_name.setText(product.product_name);
        holder.new_item_icon.setImageResource(product.product_image);
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }

    public class NewItemsRecyclerViewHolder extends RecyclerView.ViewHolder{

        TextView product_item_name;
        ImageView new_item_icon;

        public NewItemsRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            product_item_name = itemView.findViewById(R.id.product_item_name);
            new_item_icon = itemView.findViewById(R.id.new_item_icon);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), ""+product_item_name.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


}
