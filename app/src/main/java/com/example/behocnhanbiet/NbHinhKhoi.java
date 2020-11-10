package com.example.behocnhanbiet;

import android.database.Cursor;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class NbHinhKhoi extends AppCompatActivity {
    DatabaseHandler db = new DatabaseHandler(this);
    TextView dochk;
    ArrayList<HinhKhoi> arrList = null;
    ArrayAdapter<HinhKhoi> adap = null;
    TextToSpeech textToSpeech;
    HinhKhoi ob = new HinhKhoi();
    int i;
    private ListView lv;
    HinhKhoi item;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listhinhkhoi);
        try {
            db.copyDB2SDCard();
        } catch (IOException e) {
            e.printStackTrace();
        }
        anhxa();
        LoadQuestion();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                item = (HinhKhoi) lv.getItemAtPosition(position);
                textToSpeech=new TextToSpeech(NbHinhKhoi.this, new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int i) {
                        if (i != TextToSpeech.ERROR) {
                           // textToSpeech.setLanguage(Locale.US);
                            textToSpeech.setLanguage(new Locale("vi"));
                        } else {
                            Toast.makeText(NbHinhKhoi.this, "Errol", Toast.LENGTH_LONG).show();
                        }
                        if (item != null) {
                            textToSpeech.speak(item.getTenHK(), TextToSpeech.QUEUE_FLUSH, null);

                        }

                    }
                });

            }
        });

    }
    public void anhxa(){
        lv=(ListView) findViewById(R.id.listviewhk);

    }

    public void LoadQuestion() { // đây là hiện lên listview
        arrList = new ArrayList<HinhKhoi>();
        HinhKhoi row;
        Cursor c = db.getCursor("select * from tbHinhKhoi");
        c.moveToFirst();
        while (!c.isAfterLast()) {
            row = new HinhKhoi();
            row.id= c.getInt(0);
            row.tenHK= c.getString(1);
            row.imghk=c.getBlob(2);
            arrList.add(row);
            c.moveToNext();
        }
        adap = new AdapterHK(this, R.layout.item_hinhkhoi, arrList);
        lv.setAdapter(adap);
        adap.notifyDataSetChanged();
        registerForContextMenu(lv);
        c.close();
    }


}

