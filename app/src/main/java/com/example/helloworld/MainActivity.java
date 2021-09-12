package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Product> listProduct = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // B1: Data source
        initData();

        // B2: Adapter
        ProductAdapter adapter = new ProductAdapter(this, listProduct);

        // B3: Layout Manager
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        // B4: RecyclerView
        RecyclerView rvProduct = findViewById(R.id.rvProduct);
        rvProduct.setLayoutManager(layoutManager);
        rvProduct.setAdapter(adapter);
    }

    private void initData() {
       listProduct.add(new Product("Product 1", "500.000", R.drawable.p1));
       listProduct.add(new Product("Product 2", "600.000", R.drawable.p2));
       listProduct.add(new Product("Product 3", "700.000", R.drawable.p3));
       listProduct.add(new Product("Product 4", "800.000", R.drawable.p4));
       listProduct.add(new Product("Product 5", "900.000", R.drawable.p5));
       listProduct.add(new Product("Product 6", "500.000", R.drawable.p6));
    }
}