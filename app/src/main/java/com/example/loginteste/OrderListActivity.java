package com.example.loginteste;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginteste.data.events.PhotosCapturedEvent;
import com.example.loginteste.data.model.Order;
import com.example.loginteste.data.model.OrderResponse;
import com.example.loginteste.data.adapters.RCAdapter;
import com.example.loginteste.data.model.User;
import com.example.loginteste.data.network.NetworkUtils;
import com.example.loginteste.data.utils.SessionManager;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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
    RCAdapter rcAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);

        recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        User user = SessionManager.getUser(this);

        fetchOrders(user.getLojaId(), recyclerView);

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        recyclerView.setAdapter(rcAdapter);

    }

    private void fetchOrders(String shopId, RecyclerView recyclerView) {
        OkHttpClient client = new OkHttpClient();
        Request request = NetworkUtils.getGetRequest("getAtendimentosApp?lojaId=" + shopId + "&version=2.84");

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(() -> Toast.makeText(OrderListActivity.this, "Erro ao Buscar Atendimentos!", Toast.LENGTH_SHORT).show());
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

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onPhotosCapturedEvent(@NonNull PhotosCapturedEvent event) {
        Bitmap photoPath1 = event.getPhoto1Path();
        Bitmap photoPath2 = event.getPhoto2Path();
        // Toast.makeText(this, "Fotos capturadas: " + photoPath1 + ", " + photoPath2, Toast.LENGTH_LONG).show();
        System.out.println("asdf Fotos capturadas: " + photoPath1.toString() + ", " + photoPath2.toString());
    }
}

