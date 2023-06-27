package com.example.planetas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomBaseAdapter extends BaseAdapter {

    Context context;
    String listPlanets[];
    int listImages[];
    LayoutInflater inflater;

    public CustomBaseAdapter(Context ctx, String [] planetList, int [] imagenes){
        this.context=ctx;
        this.listPlanets=planetList;
        this.listImages=imagenes;
        inflater=LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return listPlanets.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.activity_custom_list_view, null);
        TextView textView = (TextView) view.findViewById(R.id.textView);
        ImageView planetImagen = (ImageView) view.findViewById(R.id.ImagenIcon);
        textView.setText(listPlanets[i]);
        planetImagen.setImageResource(listImages[i]);
        return view;
    }
}
