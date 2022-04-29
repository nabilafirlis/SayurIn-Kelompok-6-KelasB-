package com.example.sayurin;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.example.sayurin.Adapter.CartAdapter;
import com.example.sayurin.Model.OrderModels;
import com.example.sayurin.Model.Session;

public class CartActivity extends AppCompatActivity {
    private Session session;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerView = findViewById(R.id.rv_cart);
        session = new Session(this);
        //logika untuk mengatur apabila telah ada session maka tidak diperlukan untuk melakukan login
        if (!session.isLoggedIn()) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
//
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(adapter);
        final List<OrderModels> cart = session.getCart();
        final CartAdapter adapter = new CartAdapter(this,cart);
        recyclerView.setAdapter(adapter);
        
        if(cart.size() == 0){
            Toast.makeText(this, "cart masih kosong kaka, gamau beli nih ?", Toast.LENGTH_SHORT).show();
        }

        final ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int index = viewHolder.getAdapterPosition();

                cart.remove(index);
//                adapter.removeCart(index);
                adapter.notifyDataSetChanged();
                adapter.removeSession(CartActivity.this);
            }
        };


        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);


    }


    public void handleHome (View view){
        Intent intent = new Intent(CartActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void handleMenu (View view){
        Intent intent = new Intent(CartActivity.this, com.example.sayurin.OrderActivity.class);
        startActivity(intent);

    }

    public void handleCart (View view){
        Intent intent = new Intent(CartActivity.this, CartActivity.class);
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
