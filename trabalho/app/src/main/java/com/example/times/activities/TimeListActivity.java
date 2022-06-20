package com.example.times.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.times.R;
import com.example.times.adapters.TimeListAdapter;
import com.example.times.dao.TimesDAO;
import com.example.times.model.Times;

import java.util.List;

public class TimeListActivity extends Activity {

    private ListView timeList;
    protected Times timeSelected;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_list);

        TextView addNewElementButton = findViewById(R.id.addButton);

        addNewElementButton.setOnClickListener(v -> {
            Intent intent = new Intent(TimeListActivity.this, TimeFormActivity.class);
            startActivity(intent);
        });

        timeList = findViewById(R.id.activity_time_list_time_list);
        registerForContextMenu(timeList);
        timeList.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(TimeListActivity.this, TimeFormActivity.class);

            Times timeSelected = (Times) timeList.getItemAtPosition(position);

            intent.putExtra("timeSelected", timeSelected);
            startActivity(intent);
        });

        timeList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> adapter, View view,
                                           int posicao, long id) {

                timeSelected = (Times) adapter.getItemAtPosition(posicao);

                return false;
            }
        });
    }

    @Override
    protected void onResume() {
        this.loadTimesList();
        super.onResume();
    }

    private void loadTimesList() {
        List<Times> list;
        TimesDAO timesDAO = new TimesDAO(this);
        list = timesDAO.getList();
        timesDAO.close();

        TimeListAdapter adapter = new TimeListAdapter(list, this);

        timeList.setAdapter(adapter);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {

        MenuItem editar = menu.add("Editar");
        editar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent(TimeListActivity.this, TimeFormActivity.class);

                intent.putExtra("timeSelected", timeSelected);
                startActivity(intent);
                return false;
            }
        });

        MenuItem deletar = menu.add("Deletar");
        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                delete();
                loadTimesList();
                return false;
            }
        });

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    public void delete() {
        TimesDAO timesDAO = new TimesDAO(this);
        timesDAO.delete(timeSelected);
        timesDAO.close();

        loadTimesList();
    }
}
