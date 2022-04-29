package com.example.sayurin.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.example.sayurin.Array.ArraySaveOrder;
import com.example.sayurin.Model.OrderModels;
import com.example.sayurin.R;


public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    private static final String ORDER_KEY = "order";
    //atribut list data dari model yg akan ditampilkan
    private Context context;
    private List<OrderModels> items;

    ArraySaveOrder orderArray;

    CartAdapter cartAdapter;

    //Sebuah listener yang telah didefinisikan sebelumnya.
//    private ItemClickListener listener;

    public OrderAdapter(Context context, List<OrderModels> items) {
        this.context = context;
        this.items = items;
        this.orderArray = new ArraySaveOrder(this.items.size());
//        this.listener = listener;
        cartAdapter = new CartAdapter();
    }


    @NonNull
    @Override
    public OrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.list_order, parent, false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Bundle bundle = new Bundle();
        bundle.getParcelable(ORDER_KEY);

        final OrderModels item = items.get(position);
        holder.imGetData.setImageResource(item.getgImg());
        holder.titleGetData.setText(item.getgTitle());
        holder.hargaGetData.setText(String.valueOf(item.getgHarga()));
        holder.rpGetData.setText("Rp. ");
        holder.orderDet.setText(String.valueOf(orderArray.orderSave[position]));
        holder.descGet.setText(item.getgDesc());

        holder.incOrdered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderArray.orderSave[position] += 1;
                holder.orderDet.setText(String.valueOf(orderArray.orderSave[position]));
            }
        });
        holder.decOrdered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderArray.orderSave[position] -= 1;
                if (orderArray.orderSave[position] < 0) {
                    orderArray.orderSave[position] = 0;
                }
                holder.orderDet.setText(String.valueOf(orderArray.orderSave[position]));
            }
        });

        holder.orderedOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (orderArray.orderSave[position] != 0) {
                    Toast.makeText(context, "OrderSucces", Toast.LENGTH_SHORT).show();

                    item.setJumlahPesan(Integer.parseInt(holder.orderDet.getText().toString()));
                    cartAdapter.addCart(item, context);
                } else{
                    Toast.makeText(context, "Order minimal 1 item", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return (items != null ) ? items.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleGetData, hargaGetData, rpGetData, descGet, orderDet;
        public ImageView imGetData;
        public Button incOrdered, decOrdered, orderedOkay;
//        ItemClickListener itemClickListener;

        public ViewHolder(View itemView) {
            super(itemView);
            titleGetData = itemView.findViewById(R.id.titleGet);
            hargaGetData = itemView.findViewById(R.id.hargaGet);
            imGetData = itemView.findViewById(R.id.imageGet);
            rpGetData = itemView.findViewById(R.id.rpGet);
            incOrdered = itemView.findViewById(R.id.btnPlus);
            decOrdered = itemView.findViewById(R.id.btnMinus);
            orderDet = itemView.findViewById(R.id.textGet);
            descGet = itemView.findViewById(R.id.descGet);
            orderedOkay = itemView.findViewById(R.id.btnOrder);
//            itemView.setOnClickListener(this);
        }

//        @Override
//        public void onClick(View view) {
//            this.itemClickListener.onItemClick(view, getLayoutPosition());
//        }
//
//        public void setItemClickListener(ItemClickListener ic) {
//            this.itemClickListener = ic;
//        }
//    }

    }
}
