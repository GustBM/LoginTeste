package com.example.loginteste;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.SharedPreferences;
import android.widget.Toast;

import java.io.IOException;
import java.util.Objects;

import okhttp3.*;

public class MainActivity extends AppCompatActivity {

    private EditText inputUsername, inputPassword;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inputUsername = findViewById(R.id.input_username);
        inputPassword = findViewById(R.id.input_password);
        Button btnLogin = findViewById(R.id.btn_login);

        sharedPreferences = getSharedPreferences("AppPrefs", MODE_PRIVATE);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = inputUsername.getText().toString();
                String password = inputPassword.getText().toString();
                login(username, password);
            }
        });
    }

    private void login(String username, String password) {
        OkHttpClient client = new OkHttpClient();

        RequestBody formBody = new FormBody.Builder()
                .add("username", "moura.placas")
                .add("password", "moura2525")
                .build();

        Request request = new Request.Builder()
                .url("http://es.eva.inf.br/eva/mobileWS/login")
                .post(formBody)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();

        System.out.println("asdf request " + request);

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                System.out.println("asdf" + e.toString());
                // runOnUiThread(() -> Toast.makeText(MainActivity.this, "Erro no Login. Verifique os dados e tente novamente.", Toast.LENGTH_SHORT).show());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if(response.isSuccessful()) {
                    String responseData = Objects.requireNonNull(response.body()).string();
                    System.out.println("asdf responseData" + responseData);
                }
            }
        });
    }
}
