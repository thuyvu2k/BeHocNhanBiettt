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

public class NbDongVat extends AppCompatActivity {
    DatabaseHandler db = new DatabaseHandler(this);
    ArrayList<DongVat> arrList = null;
    ArrayAdapter<DongVat> adap = null;
    DongVat ob = new DongVat();
    TextToSpeech textToSpeech;
    int i;
    TextView ten;
    private ListView lv;
    DongVat item;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listdongvat);
        try {
            db.copyDB2SDCard();
        } catch (IOException e) {
            e.printStackTrace();
        }
        anhxa();
        LoadQuestion();
// ấn vào lisview thì nó đọc
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                item = (DongVat) lv.getItemAtPosition(position);
                textToSpeech=new TextToSpeech(NbDongVat.this, new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int i) {
                        if (i != TextToSpeech.ERROR) {
                           // textToSpeech.setLanguage(Locale.US);
                            textToSpeech.setLanguage(new Locale("vi"));

                        } else {
                            Toast.makeText(NbDongVat.this, "Errol", Toast.LENGTH_LONG).show();
                        }
                        if (item != null) {
                            textToSpeech.speak(item.getNamedv(), TextToSpeech.QUEUE_FLUSH, null);
                        }

                    }
                });

            }
        });
    }

    public void anhxa() {
        lv = (ListView) findViewById(R.id.listviewdv);
        ten = (TextView) findViewById(R.id.textdocdv);
    }

    public void LoadQuestion() {
//        Doc();
        arrList = new ArrayList<DongVat>();
        DongVat row;
       // Cursor c = db.getCursor("select * from tbDongVat");
        Cursor c = db.getCursor("select * from tbDongVat");
        c.moveToFirst();
        while (!c.isAfterLast()) {
            row = new DongVat();
            row.id = c.getInt(0);
            row.namedv = c.getString(1);
            row.imgdv = c.getBlob(2);
            arrList.add(row);
            c.moveToNext();
        }
        adap = new AdapterDV(this, R.layout.item_dongvat, arrList);
        lv.setAdapter(adap);
        adap.notifyDataSetChanged();
        registerForContextMenu(lv);
        c.close();
    }
}

