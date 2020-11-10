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

public class NbHoaQua extends AppCompatActivity {
    DatabaseHandler db = new DatabaseHandler(this);
    ArrayList<HoaQua> arrList = null;
    ArrayAdapter<HoaQua> adap = null;
    HoaQua ob = new HoaQua();
    int i;
    TextToSpeech textToSpeech;
    private ListView lv;
    HoaQua item;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listhoaqua);
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
                item = (HoaQua) lv.getItemAtPosition(position);
                textToSpeech=new TextToSpeech(NbHoaQua.this, new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int i) {
                        if (i != TextToSpeech.ERROR) {
                           // textToSpeech.setLanguage(Locale.US);
                            textToSpeech.setLanguage(new Locale("vi"));
                        } else {
                            Toast.makeText(NbHoaQua.this, "Errol", Toast.LENGTH_LONG).show();
                        }
                        if (item != null) {
                            textToSpeech.speak(item.getName(), TextToSpeech.QUEUE_FLUSH, null);
                        }

                    }
                });

            }
        });

    }

    public void anhxa() {
        lv = (ListView) findViewById(R.id.listview1);

    }

    public void LoadQuestion() { // đây là hiện lên listview
        arrList = new ArrayList<HoaQua>();
        HoaQua row;
        //Cursor c = db.getCursor("select * from tbHoaQua");
        Cursor c = db.getCursor("select * from tbHoaQua order by tenHQ ASC");
        c.moveToFirst();
        while (!c.isAfterLast()) {
            row = new HoaQua();
            row.id = c.getInt(0);
            row.name = c.getString(1);
            row.img = c.getBlob(2);
            arrList.add(row);
            c.moveToNext();
        }
        adap = new AdapterHQ(this, R.layout.item_hoaqua, arrList);
        lv.setAdapter(adap);
        adap.notifyDataSetChanged();
        registerForContextMenu(lv);
        c.close();
    }


}

