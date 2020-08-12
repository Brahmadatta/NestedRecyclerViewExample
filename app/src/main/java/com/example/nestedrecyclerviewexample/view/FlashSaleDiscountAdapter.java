package com.example.nestedrecyclerviewexample.view;

import android.content.Intent;
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

public class FlashSaleDiscountAdapter extends RecyclerView.Adapter<FlashSaleDiscountAdapter.FlashSaleDiscountViewHolder> {


    List<Product> mProductList;

    public FlashSaleDiscountAdapter(List<Product> productList) {
        mProductList = productList;
    }

    @NonNull
    @Override
    public FlashSaleDiscountViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.flash_sale_account_item_layout,parent,false);
        return new FlashSaleDiscountViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FlashSaleDiscountViewHolder holder, int position) {


        Product product = mProductList.get(position);
        holder.product_item_name.setText(product.getProduct_name());
        holder.product_item_image.setImageResource(product.getProduct_image());

    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }

    public class FlashSaleDiscountViewHolder extends RecyclerView.ViewHolder{

        ImageView product_item_image;
        TextView product_item_name;

        public FlashSaleDiscountViewHolder(@NonNull final View itemView) {
            super(itemView);

            product_item_name = itemView.findViewById(R.id.product_item_name);
            product_item_image = itemView.findViewById(R.id.product_item_image);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    view.getContext().startActivity(new Intent(itemView.getContext(),ItemDetailActivity.class));
//                }
//            });
        }
    }


}
