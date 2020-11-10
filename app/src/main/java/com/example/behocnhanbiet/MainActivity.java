package com.example.behocnhanbiet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phatnhac();
        ImageButton imgbt = (ImageButton) findViewById(R.id.btnhoaqua);
        ImageButton imghk = (ImageButton) findViewById(R.id.btnhinhkhoi);
        ImageButton imgdv = (ImageButton) findViewById(R.id.btndongvat);
        ImageButton imgbkt = (ImageButton) findViewById(R.id.btnbekiemtra);

        imgbt.setOnClickListener(this);
        imghk.setOnClickListener(this);
        imgdv.setOnClickListener(this);
        imgbkt.setOnClickListener(this);

    }
    public void amthanh(int nhac) {
        mediaPlayer = MediaPlayer.create(this, nhac);
        mediaPlayer.start();
    }
    public void phatnhac(){
        amthanh(R.raw.nhacnen);


    }
    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.btnhoaqua:
                i = new Intent(this, NbHoaQua.class);
                startActivity(i);
                break;

            case R.id.btnhinhkhoi:
                i = new Intent(this, NbHinhKhoi.class);
                startActivity(i);
                break;

            case R.id.btndongvat:
                i = new Intent(this, NbDongVat.class);
                startActivity(i);
                break;
            case R.id.btnbekiemtra:
                i = new Intent(this, BeKiemTra.class);
                startActivity(i);
                break;
        }
    }
}



