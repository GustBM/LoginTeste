package com.example.loginteste.data.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginteste.R;

import java.util.List;

public class RCAdapter extends RecyclerView.Adapter<RCAdapter.RCViewHolder> {

    Context context;
    List<Order> modelArrayList;

    public RCAdapter(Context context, List<Order> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @NonNull
    @Override
    public RCViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.order_card, parent, false);
        return new RCViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RCViewHolder holder, int position) {
        Order order = modelArrayList.get(position);
        holder.store_card_title.setText(order.getPlaca());
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public static class RCViewHolder extends RecyclerView.ViewHolder {
        TextView store_card_title;

        public RCViewHolder(@NonNull View itemView) {
            super(itemView);

            store_card_title = itemView.findViewById(R.id.store_card_title);
        }
    }
}
