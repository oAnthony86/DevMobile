package com.example.times.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.times.R;
import com.example.times.model.Times;

import java.util.List;

@SuppressLint("ViewHolder")
public class TimeListAdapter extends BaseAdapter {
    private final List<Times> times;
    private final Activity activity;

    public TimeListAdapter(List<Times> times, Activity activity) {
        this.times = times;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return times.size();
    }

    @Override
    public Object getItem(int position) {
        return times.get(position);
    }

    @Override
    public long getItemId(int position) {
        return times.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = activity.getLayoutInflater().inflate(R.layout.cardview_time, null);

        Times time = times.get(position);

        TextView name = (TextView) view.findViewById(R.id.cardview_time_name);
        TextView country = (TextView) view.findViewById(R.id.cardview_time_country);

        name.setText(time.getName());
        country.setText(time.getCountry());

        return view;
    }
}
