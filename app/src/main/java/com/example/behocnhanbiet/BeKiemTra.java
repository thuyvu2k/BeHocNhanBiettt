package com.example.behocnhanbiet;

import android.app.Dialog;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.security.acl.AclNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class BeKiemTra extends AppCompatActivity {
    listch recent_q;
    DatabaseHandler db = new DatabaseHandler(this);
    ArrayList<listch> listCauHoi = new ArrayList<>();
    private TextView tvCauHoi;
    ImageButton DaA, DaB, DaC, DaD;
    int Dapandung, i;
    MediaPlayer mediaPlayer;
    TextToSpeech textToSpeech;
    Dialog dialog;
    int luotchoi=2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cauhoi3);

        AnhXa();
        LoadQuestion();
        ViewQuestion(i++);

    }

    public void AnhXa() {
        DaA = (ImageButton) findViewById(R.id.daa);
        DaB = (ImageButton) findViewById(R.id.dab);
        DaC = (ImageButton) findViewById(R.id.dac);
        DaD = (ImageButton) findViewById(R.id.dad);
        tvCauHoi = (TextView) findViewById(R.id.txtCauHoi);
    }

    public void LoadQuestion() {

        listCauHoi = new ArrayList<>();
        String sql = "select * from tbCauHoi ";
        Cursor c = db.getCursor(sql);
        if (c.moveToFirst()) {
            do {
                listch ch = new listch();
                ch.setId(c.getInt(0));
                ch.setNoidung(c.getString(1));
                ch.setImgdaa(c.getBlob(2));
                ch.setImgdab(c.getBlob(3));
                ch.setImgdac(c.getBlob(4));
                ch.setImgdad(c.getBlob(5));
                ch.setDapan(c.getInt(6));
                listCauHoi.add(ch);
            } while (c.moveToNext());
        }

    }

    public listch randomQ(ArrayList<listch> questions) {
        listch q;
        Random rd = new Random();
        if (questions.size() > 0) {
            int cs = rd.nextInt(questions.size());
            q = questions.get(cs);
            questions.remove(cs);
            return q;
        }
        return null;
    }

    public void ViewQuestion(int i) {


        Doc();
        tvCauHoi.setText(listCauHoi.get(i).getNoidung());
        Bitmap a = BitmapFactory.decodeByteArray(listCauHoi.get(i).getImgdaa(), 0, listCauHoi.get(i).getImgdaa().length);
        DaA.setImageBitmap(a);
        DaA.setEnabled(true);

        Bitmap b = BitmapFactory.decodeByteArray(listCauHoi.get(i).getImgdab(), 0, listCauHoi.get(i).getImgdab().length);
        DaB.setImageBitmap(b);
        DaB.setEnabled(true);

        Bitmap c = BitmapFactory.decodeByteArray(listCauHoi.get(i).getImgdac(), 0, listCauHoi.get(i).getImgdac().length);
        DaC.setImageBitmap(c);
        DaC.setEnabled(true);
        Bitmap d = BitmapFactory.decodeByteArray(listCauHoi.get(i).getImgdad(), 0, listCauHoi.get(i).getImgdad().length);
        DaD.setImageBitmap(d);
        DaD.setEnabled(true);
        switch (listCauHoi.get(i).getDapan()) {
            case 1:
                Dapandung = R.id.daa;
                break;
            case 2:
                Dapandung = R.id.dab;
                break;
            case 3:
                Dapandung = R.id.dac;
                break;
            case 4:
                Dapandung = R.id.dad;
                break;
        }//day la dung sai

}
    public void animnButon(ImageButton btn) {
        Animation animationButton = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.nhay);
        btn.startAnimation(animationButton);
    }
    public void amthanh(int nhac) {
        mediaPlayer = MediaPlayer.create(this, nhac);
        mediaPlayer.start();
    }
    public void Ketthuc() {
        dialog = new Dialog(this, android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar_MinWidth);
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View view = layoutInflater.inflate(R.layout.activity_ketthuc, null);
        TextView tvFinish = (TextView) view.findViewById(R.id.ketthuc);
        amthanh(R.raw.ketthuc);
        Button btnFinish = (Button) view.findViewById(R.id.btnFinish);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                dialog.dismiss();
            }
        });
        dialog.setCancelable(false);
        dialog.setContentView(view);
        dialog.show();
    }
    public void OnClick(View v) {
        switch (v.getId()) {

            case R.id.daa:
                if (R.id.daa != Dapandung) {

                    if(luotchoi>0){
                        luotchoi = luotchoi - 1;
                    }
                    else if(luotchoi==0){
                        Ketthuc();
                    }

                    amthanh(R.raw.thuacuoc);
                } else {
                    animnButon(DaA);
                    amthanh(R.raw.traloidung);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ViewQuestion(i++);
                        }
                    }, 2500);
                }
                break;
            case R.id.dab:
                if (R.id.dab != Dapandung) {

                    if(luotchoi>0){
                        luotchoi = luotchoi - 1;
                        }
                    else if(luotchoi==0){
                        Ketthuc();
                    }

                    amthanh(R.raw.thuacuoc);
                } else {
                    animnButon(DaB);
                    amthanh(R.raw.traloidung);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ViewQuestion(i++);
                        }
                    }, 2500);
                }
                break;

            case R.id.dac:
                if (R.id.dac != Dapandung) {

                    if(luotchoi>0){
                        luotchoi = luotchoi - 1;
                    }
                    else if(luotchoi==0){
                        Ketthuc();
                    }

                    amthanh(R.raw.thuacuoc);
                } else {
                    animnButon(DaC);
                    amthanh(R.raw.traloidung);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ViewQuestion(i++);
                        }
                    }, 2500);
                }
                break;
            case R.id.dad:
                if (R.id.dad != Dapandung) {

                    if(luotchoi>0){
                        luotchoi = luotchoi - 1;
                    }
                    else if(luotchoi==0){
                        Ketthuc();
                    }

                    amthanh(R.raw.thuacuoc);
                } else {
                    animnButon(DaD);
                    amthanh(R.raw.traloidung);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ViewQuestion(i++);
                        }
                    }, 2500);
                }
                break;
        }
    }
    public void Doc() {
        textToSpeech = new TextToSpeech(BeKiemTra.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.ROOT);
                } else {
                    Toast.makeText(BeKiemTra.this, "Errol", Toast.LENGTH_LONG).show();
                }
                if (tvCauHoi != null) {
                    textToSpeech.speak(tvCauHoi.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
                }

            }
        });
    }


}
