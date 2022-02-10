package com.example.shop;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.shop.adapter.CategoryAdapter;
import com.example.shop.adapter.DiscontinuedProductsAdapter;
import com.example.shop.model.Category;
import com.example.shop.model.DiscontinuedProducts;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView discountRecyclerView, categoryRecyclerView;
    DiscontinuedProductsAdapter discontinuedProductsAdapter;
    List<DiscontinuedProducts> discontinuedProductsList;

    CategoryAdapter categoryAdapter;
    List<Category> categoryList;

    ImageView allCategory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ojo revisar la siguiente linea en descontinuedrecycler
        discountRecyclerView = findViewById(R.id.discontinuedRecycler);
        categoryRecyclerView=findViewById(R.id.categoryRecycler);
        allCategory=findViewById(R.id.allCategoryImage);


        allCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this, AllCategory.class);
                startActivity(i);
            }
        });

        discontinuedProductsList = new ArrayList<>();
        discontinuedProductsList.add( new DiscontinuedProducts(1,R.drawable.blanconike));
        discontinuedProductsList.add( new DiscontinuedProducts(2,R.drawable.camisa));
        discontinuedProductsList.add( new DiscontinuedProducts(3,R.drawable.camisa_celeste));
        discontinuedProductsList.add( new DiscontinuedProducts(4,R.drawable.blusa));
        discontinuedProductsList.add( new DiscontinuedProducts(3,R.drawable.negroazuk));


        categoryList=new ArrayList<>();
        categoryList.add( new Category(1,R.drawable.blusa));
        categoryList.add( new Category(2,R.drawable.blusa));
        categoryList.add( new Category(3,R.drawable.blusa));


        setDiscountedRecycler(discontinuedProductsList);
        setCategoryRecycler(categoryList);
    }

    public void setCategoryRecyclerView(RecyclerView categoryRecyclerView) {
        this.categoryRecyclerView = categoryRecyclerView;
    }

    private void setDiscountedRecycler(List<DiscontinuedProducts> dataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        discountRecyclerView.setLayoutManager(layoutManager);
        discontinuedProductsAdapter = new DiscontinuedProductsAdapter(this,dataList);
        discountRecyclerView.setAdapter(discontinuedProductsAdapter);
    }


    private void setCategoryRecycler(List<Category> categoryDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        categoryRecyclerView.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(this,categoryDataList);
        categoryRecyclerView.setAdapter(categoryAdapter);
    }
}