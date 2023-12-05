package com.example.grocerylist;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class ListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProductAdapter productAdapter = new ProductAdapter(this, productList);
    static List<Product> productList = new ArrayList<>();
    ImageButton menuButton;
    ImageButton deleteButton;
    ImageButton addButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = findViewById(R.id.recyclerView);
        menuButton = findViewById(R.id.menuButton);
        deleteButton = findViewById(R.id.deleteButton);
        addButton = findViewById(R.id.addButton);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(productAdapter);
        productAdapter.setOnItemClickListener(position -> {
            productList.remove(position);
            productAdapter.notifyItemRemoved(position);
        });

        Product product = (Product) getIntent().getSerializableExtra("product");
        if (product != null){
            productList.add(product);
            productAdapter.notifyItemInserted(productList.size() - 1);
        }

        menuButton.setOnClickListener(view -> {
            Intent intent = new Intent(ListActivity.this, MainActivity.class);
            this.startActivity(intent);
        });

        deleteButton.setOnClickListener(view -> {
            int count = productList.size();
            productList.clear();
            productAdapter.notifyItemRangeRemoved(0, count);
        });


        addButton.setOnClickListener(view -> {
            Intent intent = new Intent(ListActivity.this, AddActivity.class);
            this.startActivity(intent);
        });


        recyclerView.setAdapter(productAdapter);
    }
}
