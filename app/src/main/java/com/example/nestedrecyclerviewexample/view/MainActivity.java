package com.example.nestedrecyclerviewexample.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.nestedrecyclerviewexample.R;
import com.example.nestedrecyclerviewexample.model.Product;
import com.example.nestedrecyclerviewexample.model.Section;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;

    List<Section> mSectionList = new ArrayList<>();

    @BindView(R.id.sales_item_image)
    ImageView sales_item_image;

    @BindView(R.id.shop_recyclerView)
    RecyclerView shop_recyclerView;

    String flash_sale_product_Name[] = {

            "Nested RecyclerView Example",
            "Nested RecyclerView Example",
            "Nested RecyclerView Example",
            "Nested RecyclerView Example",
            "Nested RecyclerView Example",
            "Nested RecyclerView Example",
            "Nested RecyclerView Example",
            "Nested RecyclerView Example",
            "Nested RecyclerView Example",
            "Nested RecyclerView Example",
            "Nested RecyclerView Example",
            "Nested RecyclerView Example"

    };


    int flash_sales_images[] = {

            R.mipmap.ic_launcher_round,
            R.mipmap.ic_launcher_round,
            R.mipmap.ic_launcher_round,
            R.mipmap.ic_launcher_round,
            R.mipmap.ic_launcher_round,
            R.mipmap.ic_launcher_round,
            R.mipmap.ic_launcher_round,
            R.mipmap.ic_launcher_round,
            R.mipmap.ic_launcher_round,
            R.mipmap.ic_launcher_round,
            R.mipmap.ic_launcher_round,
            R.mipmap.ic_launcher_round
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        initData();


        MainRecyclerViewAdapter mainRecyclerViewAdapter = new MainRecyclerViewAdapter(mSectionList,this);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mainRecyclerViewAdapter);

        ArrayList<Product> recordsDataLists = prepareData();

        FlashSaleDiscountAdapter main_RecyclerViewAdapter = new FlashSaleDiscountAdapter(recordsDataLists);
        shop_recyclerView.setHasFixedSize(true);
        shop_recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        shop_recyclerView.setAdapter(main_RecyclerViewAdapter);
    }

    private ArrayList<Product> prepareData() {
        ArrayList<Product> theImage = new ArrayList<>();
        for (int i = 0; i < flash_sales_images.length ; i++){
            Product createList = new Product(flash_sale_product_Name[i],flash_sales_images[i]);
            createList.setProduct_name(flash_sale_product_Name[i]);
            createList.setProduct_image(flash_sales_images[i]);
            theImage.add(createList);
        }
        return theImage;
    }

    private void initData(){

        String sectionOneName = "Example";
        List<Product> sectionOneItems = new ArrayList<>();

        sectionOneItems.add(new Product("Example",R.mipmap.ic_launcher));
        sectionOneItems.add(new Product("Example",R.mipmap.ic_launcher));
        sectionOneItems.add(new Product("Example",R.mipmap.ic_launcher));
        sectionOneItems.add(new Product("Example",R.mipmap.ic_launcher));
        sectionOneItems.add(new Product("Example",R.mipmap.ic_launcher));
        sectionOneItems.add(new Product("Example",R.mipmap.ic_launcher));
        sectionOneItems.add(new Product("Example",R.mipmap.ic_launcher));
        sectionOneItems.add(new Product("Example",R.mipmap.ic_launcher));
        sectionOneItems.add(new Product("Example",R.mipmap.ic_launcher));
        sectionOneItems.add(new Product("Example",R.mipmap.ic_launcher));
        sectionOneItems.add(new Product("Example",R.mipmap.ic_launcher));
        sectionOneItems.add(new Product("Example",R.mipmap.ic_launcher));
        sectionOneItems.add(new Product("Example",R.mipmap.ic_launcher));


        String sectionTwoName = "Example";
        List<Product> sectionTwoItems = new ArrayList<>();

        sectionTwoItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionTwoItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionTwoItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionTwoItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionTwoItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionTwoItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionTwoItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionTwoItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionTwoItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionTwoItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionTwoItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionTwoItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionTwoItems.add(new Product("Example",R.mipmap.ic_launcher_round));


        String sectionThreeName = "Example";
        List<Product> sectionThreeItems = new ArrayList<>();

        sectionThreeItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionThreeItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionThreeItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionThreeItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionThreeItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionThreeItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionThreeItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionThreeItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionThreeItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionThreeItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionThreeItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionThreeItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionThreeItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionThreeItems.add(new Product("Example",R.mipmap.ic_launcher_round));


        String sectionFourName = "Example";
        List<Product> sectionFourItems = new ArrayList<>();

        sectionFourItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionFourItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionFourItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionFourItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionFourItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionFourItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionFourItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionFourItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionFourItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionFourItems.add(new Product("Example",R.mipmap.ic_launcher_round));


        String sectionFiveName = "";
        List<Product> sectionFiveItems = new ArrayList<>();

        sectionFiveItems.add(new Product("Example",R.mipmap.ic_launcher));



        String sectionSixName = "Example";
        List<Product> sectionSixItems = new ArrayList<>();

        sectionSixItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionSixItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionSixItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionSixItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionSixItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionSixItems.add(new Product("Example",R.mipmap.ic_launcher_round));

        String sectionSevenName = "Example";

        List<Product> sectionSevenItems = new ArrayList<>();

        sectionSevenItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionSevenItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionSevenItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionSevenItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionSevenItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionSevenItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionSevenItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionSevenItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionSevenItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionSevenItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionSevenItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionSevenItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionSevenItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionSevenItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionSevenItems.add(new Product("Example",R.mipmap.ic_launcher_round));
        sectionSevenItems.add(new Product("Example",R.mipmap.ic_launcher_round));






        mSectionList.add(new Section(sectionOneName,sectionOneItems));
        mSectionList.add(new Section(sectionTwoName,sectionTwoItems));
        mSectionList.add(new Section(sectionThreeName,sectionThreeItems));
        mSectionList.add(new Section(sectionFourName,sectionFourItems));
        mSectionList.add(new Section(sectionFiveName,sectionFiveItems));
        mSectionList.add(new Section(sectionSixName,sectionSixItems));
        mSectionList.add(new Section(sectionSevenName,sectionSevenItems));

    }
}