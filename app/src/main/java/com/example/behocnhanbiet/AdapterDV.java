package com.example.behocnhanbiet;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AdapterDV extends ArrayAdapter<DongVat> {
    ArrayList<DongVat> arrayList = new ArrayList<DongVat>();
    Activity context;
    int layout ;

    public AdapterDV(Context context, int resource, ArrayList<DongVat> objects) {
        super(context, resource, objects);
        this.context = (Activity) context;
        arrayList = objects;
        layout = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(layout, null);
        Bitmap b= BitmapFactory.decodeByteArray(arrayList.get(position).getImgdv(),0,arrayList.get(position).getImgdv().length);
        TextView tv1=(TextView)view.findViewById(R.id.textmadv) ;
        TextView txtItem2 = (TextView) view.findViewById(R.id.textdocdv);
        ImageView img =(ImageView)view.findViewById(R.id.anhdv);

        DongVat ob = arrayList.get(position);
//        tv1.setText(ob.id);
        txtItem2.setText(ob.namedv);
        img.setImageBitmap(b);


        return view;
    }
// thêm cái này vào adapter để lấy ra item ,lấy ra các thuộc tính có trong adapter

    @Nullable
    @Override
    public DongVat getItem(int position) {
        return super.getItem(position);
    }
}