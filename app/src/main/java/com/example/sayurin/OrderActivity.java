package com.example.sayurin;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.example.sayurin.Adapter.OrderAdapter;
import com.example.sayurin.Model.OrderModels;
import com.example.sayurin.Model.Session;

public class OrderActivity extends AppCompatActivity {
    private Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        session = new Session(this);
        //logika untuk mengatur apabila telah ada session maka tidak diperlukan untuk melakukan login
        if (!session.isLoggedIn()) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }

        RecyclerView recyclerView = findViewById(R.id.rv_order);
        List<OrderModels> order = new ArrayList<>();
        OrderModels or = new OrderModels(R.drawable.bayam,30000 ,"Bayam Hijau","250 gram/ikat");
        order.add(or);
        or = new OrderModels(R.drawable.buncis,5000 ,"Buncis","500 gram/pack");
        order.add(or);
        or = new OrderModels(R.drawable.wortel,60000 ,"Wortel","/kg");
        order.add(or);
        or = new OrderModels(R.drawable.kol,50000 ,"Kubis","450 gram/pcs");
        order.add(or);
        or = new OrderModels(R.drawable.tomat,70000 ,"Tomat ","500 gram/pack");
        order.add(or);
        or = new OrderModels(R.drawable.selada,90000 ,"Selada Hijau","350 gram/pack ");
        order.add(or);
        or = new OrderModels(R.drawable.kangkung,20000 ,"Kangkung","/ikat ");
        order.add(or);
        or = new OrderModels(R.drawable.timun,100000,"Timun ","/kg");
        order.add(or);

        OrderAdapter adapter = new OrderAdapter(this, order);
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

    }

    public void handleHome (View view){
        Intent intent = new Intent(OrderActivity.this, MainActivity.class);
        startActivity(intent);

    }

    public void handleMenu (View view){
        Intent intent = new Intent(OrderActivity.this, OrderActivity.class);
        startActivity(intent);

    }

    public void handleCart (View view){
        Intent intent = new Intent(OrderActivity.this, CartActivity.class);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (@NonNull MenuItem item){
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_logout) {
            session.logout();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        return false;
    }
}
