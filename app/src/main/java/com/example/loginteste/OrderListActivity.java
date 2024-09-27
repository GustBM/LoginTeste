package com.example.loginteste;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginteste.data.model.Order;
import com.example.loginteste.data.model.OrderResponse;
import com.example.loginteste.data.model.RCAdapter;
import com.example.loginteste.data.model.User;
import com.example.loginteste.data.utils.NetworkUtils;
import com.example.loginteste.data.utils.SessionManager;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OrderListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    //ArrayList<Order> orderArrayList;
    RCAdapter rcAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);

        recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        //orderArrayList = new ArrayList<>();

        //rcAdapter = new RCAdapter(this, orderArrayList);
        //recyclerView.setAdapter(rcAdapter);

        User user = SessionManager.getUser(this);

        fetchOrders(user.getLojaId(), recyclerView);

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        recyclerView.setAdapter(rcAdapter);

        /*fetchOrders(user.getLojaId()).thenAccept(orders -> {
            orderArrayList.addAll(orders);
            rcAdapter.notifyDataSetChanged();
        }).exceptionally(e -> {
            System.err.println("Error fetching orders: " + e.getMessage());
            return null;
        });*/


    }

    private void fetchOrders(String shopId, RecyclerView recyclerView) {
        OkHttpClient client = new OkHttpClient();
        Request request = NetworkUtils.getGetRequest("getAtendimentosApp?lojaId=" + shopId + "&version=2.84");

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // Handle failure
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String responseData = response.body().string();
                    Gson gson = new Gson();
                    List<Order> orderArrayList = gson.fromJson(responseData, OrderResponse.class).getAtendimentos();
                    rcAdapter = new RCAdapter(OrderListActivity.this, orderArrayList);
                    recyclerView.setAdapter(rcAdapter);
                }
            }
        });
    }

    /*private List<Order> fetchOrders(String shopId) {
        OkHttpClient client = new OkHttpClient();
        // CompletableFuture<List<Order>> future = new CompletableFuture<>();
        Request request = NetworkUtils.getGetRequest("getAtendimentosApp?lojaId=" + shopId + "&version=2.84");

        try (Response response = client.newCall(request).execute()) {
            Gson gson = new Gson();
            String responseData = response.body().string();
            List<Order> response = gson.fromJson(responseData, OrderResponse.class).getAtendimentos();
            return response;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /*client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                future.completeExceptionally(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    Gson gson = new Gson();
                    String responseData = response.body().string();

                    List<Order> orderList = gson.fromJson(responseData, OrderResponse.class).getAtendimentos();
                    future.complete(orderList);

                } else {
                    future.completeExceptionally(new IOException("Failed to fetch orders"));
                }
            }
        });

        // return future;
    }*/
}

