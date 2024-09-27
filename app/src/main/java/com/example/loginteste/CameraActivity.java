package com.example.loginteste;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.loginteste.data.events.PhotosCapturedEvent;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

public class CameraActivity extends AppCompatActivity {
    private Button btnPhoto1, btnPhoto2;
    private Bitmap photoPath1, photoPath2;
    private ImageView photo1, photo2;
    private static final int REQUEST_IMAGE_CAPTURE_1 = 1;
    private static final int REQUEST_IMAGE_CAPTURE_2 = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        btnPhoto1 = findViewById(R.id.btn_photo1);
        btnPhoto2 = findViewById(R.id.btn_photo2);

        photo1 = findViewById(R.id.photo_view1);
        photo2 = findViewById(R.id.photo_view2);

        btnPhoto1.setOnClickListener(v -> openCamera(REQUEST_IMAGE_CAPTURE_1));
        btnPhoto2.setOnClickListener(v -> openCamera(REQUEST_IMAGE_CAPTURE_2));

        Button sendButton = findViewById(R.id.sendBtn);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (photoPath1 != null && photoPath2 != null) {
                    EventBus.getDefault().post(new PhotosCapturedEvent(photoPath1, photoPath2));
                    System.out.println("asdf4 " + photoPath1.toString() + " " + photoPath2.toString());
                    Intent intent = new Intent(CameraActivity.this, OrderListActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        /*OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (photoPath1 != null && photoPath2 != null) {
                    EventBus.getDefault().post(new PhotosCapturedEvent(photoPath1, photoPath2));
                    System.out.println("asdf4 " + photoPath1.toString() + " " + photoPath2.toString());
                    finish();
                } else {
                    System.out.println("asdf Capture as duas fotos antes de sair");
                }
            }
        };
        getOnBackPressedDispatcher().addCallback(this,onBackPressedCallback);*/
    }

    private void openCamera(int requestCode) {
        if (ContextCompat.checkSelfPermission(CameraActivity.this, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(CameraActivity.this, new String[] {Manifest.permission.CAMERA}, requestCode);
        }

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePictureIntent, requestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {

            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            if (requestCode == REQUEST_IMAGE_CAPTURE_1) {
                photo1.setImageBitmap(imageBitmap);
                photoPath1 = imageBitmap;
            } else if (requestCode == REQUEST_IMAGE_CAPTURE_2) {
                photo2.setImageBitmap(imageBitmap);
                photoPath2 = imageBitmap;
            }
        }
    }

    /*@Override
    public void onBackPressed() {
        super.onBackPressed();
        if (photoPath1 != null && photoPath2 != null) {
            EventBus.getDefault().post(new PhotosCapturedEvent(photoPath1, photoPath2));
            System.out.println("asdf4 " + photoPath1.toString() + " " + photoPath2.toString());
            finish();
        } else {
            System.out.println("asdf Capture as duas fotos antes de sair");
        }
    }*/
}
