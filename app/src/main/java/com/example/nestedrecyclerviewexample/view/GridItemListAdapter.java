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


public class GridItemListAdapter extends RecyclerView.Adapter<GridItemListAdapter.GridItemListViewHolder> {

    List<Product> mProductList;

    public GridItemListAdapter(List<Product> productList) {
        mProductList = productList;
    }

    @NonNull
    @Override
    public GridItemListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item_row,parent,false);
        return new GridItemListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridItemListViewHolder holder, int position) {

        Product product = mProductList.get(position);

        holder.grocery_items.setImageResource(product.product_image);
        //holder.grocery_item_names.setText(product.product_name);
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }

    public class GridItemListViewHolder extends RecyclerView.ViewHolder{

        TextView grocery_item_names;
        ImageView grocery_items;

        public GridItemListViewHolder(@NonNull View itemView) {
            super(itemView);
            grocery_items = itemView.findViewById(R.id.grocery_items);
            grocery_item_names = itemView.findViewById(R.id.grocery_item_names);
        }
    }
}


/*public class GridItemListAdapter extends BaseAdapter {

    List<Product> mProductList;
    LayoutInflater inflater;


    private Context mContext;

    public GridItemListAdapter(List<Product> productList, Context context) {
        mProductList = productList;
        this.inflater = LayoutInflater.from(context);
        mContext = context;
    }

    @Override
    public int getCount() {
        return mProductList.size();
    }

    @Override
    public Object getItem(int i) {
        return mProductList.get(i).product_image;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        final  viewHolder holder;
        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.grid_item_row, null);
            holder=new viewHolder();
            holder.item_name= (TextView) convertView.findViewById(R.id.grocery_item_names);
            holder.item_image= (ImageView) convertView.findViewById(R.id.grocery_items);

            convertView.setTag(holder);

        }
        else

        {
            holder= (viewHolder) convertView.getTag();
        }
        holder.item_image.setImageResource(mProductList.get(i).getProduct_image());
        holder.item_name.setText(mProductList.get(i).getProduct_name());

        return convertView;


//        LinearLayout linearLayout = new LinearLayout(mContext);
//        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
//
//
//        //Creating a textview to show the title
//        TextView textView = new TextView(mContext);
//        textView.setText(mProductList.get(i).product_name);
//
//        ImageView imageView = new ImageView(mContext);
//        imageView.setImageResource(mProductList.get(i).product_image);
//
//        //Adding views to the layout
//        linearLayout.addView(textView);
//        linearLayout.addView(imageView);
//
//        return linearLayout;
    }

    class viewHolder
    {
        TextView item_name;
        ImageView item_image;
    }

}*/

