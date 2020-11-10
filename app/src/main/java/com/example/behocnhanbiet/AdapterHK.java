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

public class AdapterHK extends ArrayAdapter<HinhKhoi> {
    ArrayList<HinhKhoi> arrayList = new ArrayList<HinhKhoi>();
    Activity context;
    int layout ;

    public AdapterHK(Context context, int resource, ArrayList<HinhKhoi> objects) {
        super(context, resource, objects);
        this.context = (Activity) context;
        arrayList = objects;
        layout = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(layout, null);
        Bitmap b= BitmapFactory.decodeByteArray(arrayList.get(position).getImghk(),0,arrayList.get(position).getImghk().length);
        TextView tv1=(TextView)view.findViewById(R.id.textmahk) ;
        TextView txtItem2 = (TextView) view.findViewById(R.id.textdochk);
        ImageView img =(ImageView)view.findViewById(R.id.anhhk);

        HinhKhoi ob = arrayList.get(position);
//        tv1.setText(ob.id);
        txtItem2.setText(ob.tenHK);
        img.setImageBitmap(b);


        return view;
    }
// thêm cái này vào adapter để lấy ra item ,lấy ra các thuộc tính có trong adapter

    @Nullable
    @Override
    public HinhKhoi getItem(int position) {
        return super.getItem(position);
    }

}
