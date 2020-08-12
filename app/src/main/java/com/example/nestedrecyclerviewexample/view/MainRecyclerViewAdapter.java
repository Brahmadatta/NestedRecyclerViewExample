package com.example.nestedrecyclerviewexample.view;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.nestedrecyclerviewexample.R;
import com.example.nestedrecyclerviewexample.model.Product;
import com.example.nestedrecyclerviewexample.model.Section;
import com.example.nestedrecyclerviewexample.utils.ViewPagerCustomDuration;
import com.google.android.material.tabs.TabLayout;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder> {

    List<Section> mSectionList;

    private static final int ANNOUNCEMENT_LIST_ITEMS = 0;
    private static final int CIRCULAR_LIST_ITEMS = 1;

    private static final int RECTANGULAR_SHOP_LIST_ITEMS = 2;

    private static final int NEW_ITEMS_ITEM_VIEW = 3;

    private static final int IMAGE_GROCERY_SHOP = 4;

    private static final int GRID_ITEM_LIST_VIEW = 5;
    private static final int FLASH_SALE_ITEM_LIST_VIEW = 5;
    public Context mContext;

    public MainRecyclerViewAdapter(List<Section> sectionList, Context context) {
        mSectionList = sectionList;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.section_row, parent, false);
        return new ViewHolder(view);

//        View view;
//
//        switch (viewType)
//        {
//
//            case 0:
//
//                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewpager_type_item_row,parent,false);
//                break;
//
//
//            case 1:
//                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.section_row,parent,false);
//                break;
//
//            case 2:
//                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false);
//
//                break;
//
//
//            case 3:
//
//                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_items_row_layout,parent,false);
//                break;
//
//        }

    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        Section section = mSectionList.get(position);

        final List<Product> sectionList = section.getProduct_items();


        switch (position) {

            case 0:
                final int[] page = {0};
                holder.product_heading.setText(section.product_name);
                holder.viewpager_layout.setVisibility(View.VISIBLE);
                holder.product_child_recyclerView.setVisibility(View.GONE);
                holder.image_view_shop.setVisibility(View.GONE);
                AnnouncementListAdapter announcement_RecyclerViewAdapter = new AnnouncementListAdapter(holder.itemView.getContext(),sectionList);
                holder.viewpager.setAdapter(announcement_RecyclerViewAdapter);
                holder.viewpager.setScrollDurationFactor(5);
                holder.image_view_shop.setVisibility(View.GONE);
                holder.see_all_layout.setVisibility(View.GONE);
                //holder.include_layout.setVisibility(View.GONE);

                // adding bottom dots
                //addBottomDots(0,sectionList.size(),holder.layoutDots);

                holder.tab_layout.setupWithViewPager(holder.viewpager, true);

                //To Enable automatic scrolling

                final int[] currentPage = {0};

                holder.viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                        currentPage[0] = position;
                    }

                    @Override
                    public void onPageSelected(int position) {

                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                });


                final Handler handler = new Handler();
                final Runnable update = new Runnable() {
                    @Override
                    public void run() {
                        if (currentPage[0] == sectionList.size()){
                            currentPage[0] = 0;
                        }
                        holder.viewpager.setCurrentItem(currentPage[0]++,true);
                    }
                };



                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        handler.post(update);
                    }
                },1000,2000);


                break;

            case 1:

                holder.product_heading.setText(section.product_name);
                holder.product_child_recyclerView.setHasFixedSize(true);
                CircularRecyclerViewAdapter circular_RecyclerViewAdapter = new CircularRecyclerViewAdapter(sectionList);
                holder.product_child_recyclerView.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
                holder.product_child_recyclerView.setAdapter(circular_RecyclerViewAdapter);
                holder.image_view_shop.setVisibility(View.GONE);
                holder.viewpager.setVisibility(View.GONE);
                holder.viewpager_layout.setVisibility(View.GONE);
                holder.see_all_layout.setVisibility(View.GONE);
                //holder.include_layout.setVisibility(View.GONE);

                break;

            case 2:

                holder.product_heading.setText(section.product_name);
                holder.product_child_recyclerView.setHasFixedSize(true);
                ChildRecyclerViewAdapter childRecyclerViewAdapter = new ChildRecyclerViewAdapter(sectionList);
                holder.product_child_recyclerView.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
                holder.product_child_recyclerView.setAdapter(childRecyclerViewAdapter);
                holder.image_view_shop.setVisibility(View.GONE);
                //holder.include_layout.setVisibility(View.GONE);
                holder.viewpager_layout.setVisibility(View.GONE);
                holder.viewpager.setVisibility(View.GONE);
                holder.see_all_layout.setVisibility(View.GONE);

                break;

            case 3:

                holder.product_heading.setText(section.product_name);
                holder.product_child_recyclerView.setHasFixedSize(true);
                NewItemsRecyclerAdapter new_items_adapter = new NewItemsRecyclerAdapter(sectionList);
                holder.product_child_recyclerView.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
                holder.product_child_recyclerView.setAdapter(new_items_adapter);
                holder.image_view_shop.setVisibility(View.GONE);
                holder.see_all_layout.setVisibility(View.VISIBLE);
                //holder.include_layout.setVisibility(View.GONE);

                break;

            case 4:


                holder.product_heading.setVisibility(View.GONE);
                holder.image_view_shop.setVisibility(View.VISIBLE);
                holder.viewpager_image.setImageResource(section.getProduct_items().get(0).product_image);
                holder.product_child_recyclerView.setVisibility(View.GONE);
                holder.viewpager.setVisibility(View.GONE);
                holder.viewpager_layout.setVisibility(View.GONE);
                holder.see_all_layout.setVisibility(View.GONE);
                //holder.include_layout.setVisibility(View.GONE);

                break;

            case 5:

                holder.product_heading.setVisibility(View.GONE);
                GridItemListAdapter grid_items_adapter = new GridItemListAdapter(sectionList);
                holder.product_child_recyclerView.setLayoutManager(new GridLayoutManager(holder.itemView.getContext(), 3));
                holder.product_child_recyclerView.setAdapter(grid_items_adapter);
                holder.image_view_shop.setVisibility(View.GONE);
                holder.viewpager.setVisibility(View.GONE);
                holder.viewpager_layout.setVisibility(View.GONE);
                holder.see_all_layout.setVisibility(View.GONE);
                ////holder.include_layout.setVisibility(View.GONE);

                break;


            case 6:
                holder.product_heading.setText(section.product_name);
                holder.product_child_recyclerView.setHasFixedSize(true);
                CircularRecyclerViewAdapter circular_Recycler_ViewAdapter = new CircularRecyclerViewAdapter(sectionList);
                holder.product_child_recyclerView.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
                holder.product_child_recyclerView.setAdapter(circular_Recycler_ViewAdapter);
                holder.image_view_shop.setVisibility(View.GONE);
                holder.viewpager.setVisibility(View.GONE);
                holder.viewpager_layout.setVisibility(View.GONE);
                holder.see_all_layout.setVisibility(View.VISIBLE);
                //holder.include_layout.setVisibility(View.GONE);
                break;

//            case 7:
//
//                holder.product_heading.setVisibility(View.GONE);
//                holder.product_child_recyclerView.setVisibility(View.GONE);
//                holder.image_view_shop.setVisibility(View.GONE);
//                holder.viewpager.setVisibility(View.GONE);
//                holder.include_layout.setVisibility(View.VISIBLE);
//
//                break;


        }


    }

    @Override
    public int getItemCount() {
        return mSectionList.size();
    }

    @Override
    public int getItemViewType(int position) {

        if (position == 0) {
            return ANNOUNCEMENT_LIST_ITEMS;
        } else if (position == 1) {
            return CIRCULAR_LIST_ITEMS;
        } else if (position == 2) {
            return RECTANGULAR_SHOP_LIST_ITEMS;
        } else if (position == 3) {
            return NEW_ITEMS_ITEM_VIEW;
        } else if (position == 4) {
            return IMAGE_GROCERY_SHOP;
        } else if (position == 5) {
            return GRID_ITEM_LIST_VIEW;
        } else if (position == 6) {
            return CIRCULAR_LIST_ITEMS;
        }else {
            return FLASH_SALE_ITEM_LIST_VIEW;
        }

    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        RecyclerView product_child_recyclerView;
        TextView product_heading;
        ImageView viewpager_image;
        ViewPagerCustomDuration viewpager;
        CardView image_view_shop;
        LinearLayout see_all_layout,viewpager_layout;
        private LinearLayout layoutDots;
        TabLayout tab_layout;
        //LinearLayout include_layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            product_heading = itemView.findViewById(R.id.product_heading);
            product_child_recyclerView = itemView.findViewById(R.id.product_child_recyclerView);
            viewpager_image = itemView.findViewById(R.id.viewpager_image);
            image_view_shop = itemView.findViewById(R.id.image_view_shop);
            viewpager = itemView.findViewById(R.id.viewpager);
            viewpager_layout = itemView.findViewById(R.id.viewpager_layout);
            see_all_layout = itemView.findViewById(R.id.see_all_layout);
            tab_layout = itemView.findViewById(R.id.tab_layout);
            //include_layout = itemView.findViewById(R.id.include_layout);
        }
    }

}
