package com.example.loginteste.data.events;

import android.graphics.Bitmap;

public class PhotosCapturedEvent {
    private Bitmap photoPath1;
    private Bitmap photoPath2;

    public PhotosCapturedEvent(Bitmap photo1Path, Bitmap photo2Path) {
        this.photoPath1 = photo1Path;
        this.photoPath2 = photo2Path;
    }

    public Bitmap getPhoto1Path() {
        return photoPath1;
    }

    public Bitmap getPhoto2Path() {
        return photoPath2;
    }
}