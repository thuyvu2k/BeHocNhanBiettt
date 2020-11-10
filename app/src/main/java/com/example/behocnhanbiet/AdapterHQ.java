package com.example.behocnhanbiet;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AdapterHQ extends ArrayAdapter<HoaQua> {
    TextToSpeech textToSpeech;
    ArrayList<HoaQua> arrayList = new ArrayList<HoaQua>();
    Activity context;
    int layout;

    public AdapterHQ(Context context, int resource, ArrayList<HoaQua> objects) {
        super(context, resource, objects);
        this.context = (Activity) context;
        arrayList = objects;
        layout = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(layout, null);
        Bitmap b = BitmapFactory.decodeByteArray(arrayList.get(position).getImg(), 0, arrayList.get(position).getImg().length);
        TextView tv1 = (TextView) view.findViewById(R.id.textma);
        TextView txtItem2 = (TextView) view.findViewById(R.id.textdoc);
        ImageView img = (ImageView) view.findViewById(R.id.anh);
        HoaQua ob = arrayList.get(position);
        txtItem2.setText(ob.name);
        img.setImageBitmap(b);


        return view;
    }

    @Nullable
    @Override
    public HoaQua getItem(int position) {
        return super.getItem(position);
    }




}