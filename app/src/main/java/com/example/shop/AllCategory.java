package com.example.shop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.shop.adapter.AllCategoryAdapter;
import com.example.shop.model.AllCategoryModel;

import java.util.ArrayList;
import java.util.List;

public class AllCategory extends AppCompatActivity {
    RecyclerView AllCategoryRecycler;
    AllCategoryAdapter allCategoryAdapter;
    List<AllCategoryModel> allcategoryModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_category);
        AllCategoryRecycler = findViewById(R.id.all_Category);

        allcategoryModelList=new ArrayList<>();
        allcategoryModelList.add( new AllCategoryModel(1,R.drawable.blusa));
        allcategoryModelList.add( new AllCategoryModel(2,R.drawable.blusa));
        allcategoryModelList.add( new AllCategoryModel(3,R.drawable.blusa));



        setCategoryRecycler(allcategoryModelList);
    }

    private void setCategoryRecycler(List<AllCategoryModel> allCategoryModelList) {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        AllCategoryRecycler.setLayoutManager(layoutManager);
        allCategoryAdapter = new AllCategoryAdapter(this,allCategoryModelList);
        AllCategoryRecycler.setAdapter(allCategoryAdapter);
    }
}