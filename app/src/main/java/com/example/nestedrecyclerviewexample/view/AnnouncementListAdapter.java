package com.example.nestedrecyclerviewexample.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.viewpager.widget.PagerAdapter;

import com.example.nestedrecyclerviewexample.R;
import com.example.nestedrecyclerviewexample.model.Product;

import java.util.List;


public class AnnouncementListAdapter extends PagerAdapter {

    List<Product> mProductList;

    private Context mContext;

    LayoutInflater mLayoutInflater;

    public AnnouncementListAdapter(Context context, List<Product> productList) {
        mContext = context;
        this.mProductList = productList;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View itemView = mLayoutInflater.inflate(R.layout.viewpager_type_item_row, container, false);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.viewpager_image);
        imageView.setImageResource(mProductList.get(position).product_image);
        container.addView(itemView);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), ""+mProductList.get(position).getProduct_name(), Toast.LENGTH_SHORT).show();
            }
        });

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return mProductList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


}


/*
*
* public class AnnouncementListAdapter extends RecyclerView.Adapter<AnnouncementListAdapter.AnnouncementListViewHolder> {

    List<Product> mProductList;

    public AnnouncementListAdapter(List<Product> productList) {
        mProductList = productList;
    }

    @NonNull
    @Override
    public AnnouncementListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewpager_type_item_row,parent,false);
        return new AnnouncementListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnnouncementListViewHolder holder, int position) {

        Product product = mProductList.get(position);
        holder.viewpager_image.setImageResource(product.product_image);
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }

    public class AnnouncementListViewHolder extends RecyclerView.ViewHolder{

        ImageView viewpager_image;

        public AnnouncementListViewHolder(@NonNull View itemView) {
            super(itemView);

            viewpager_image = itemView.findViewById(R.id.viewpager_image);
        }
    }


}
*
* */
