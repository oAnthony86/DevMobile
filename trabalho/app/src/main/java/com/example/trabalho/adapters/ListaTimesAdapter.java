package com.example.trabalho.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.trabalho.R;
import com.example.trabalho.model.Times;

import java.util.List;

@SuppressLint("ViewHolder")
public class ListaTimesAdapter extends BaseAdapter {
    private final List<Times> times;
    private final Activity activity;

    public ListaTimesAdapter(Activity activity, List<Times> times) {
        this.activity = activity;
        this.times = times;
    }

    public long getItemId(int posicao) {
        return times.get(posicao).getId();
    }

    public Object getItem(int posicao) {
        return times.get(posicao);
    }

    public int getCount() {
        return times.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = activity.getLayoutInflater().inflate(R.layout.item, null);

        if (position % 2 == 0) {
            view.setBackgroundColor(activity.getResources().
                    getColor(R.color.linha_par));
        }

        Times times = times.get(position);

        TextView descricao = (TextView) view.findViewById(R.id.descricao);
        TextView sigla = (TextView) view.findViewById(R.id.sigla);

        descricao.setText(times.getDescricao());
        sigla.setText(times.getSigla());

        return view;
    }
}

