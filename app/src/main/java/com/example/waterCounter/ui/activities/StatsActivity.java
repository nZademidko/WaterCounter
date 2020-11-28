package com.example.waterCounter.ui.activities;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.waterCounter.ui.Adapters.MyRecyclerViewAdapter;
import com.example.waterCounter.R;
import com.example.waterCounter.mvp.presenters.StatsPresenter;
import com.example.waterCounter.mvp.views.StatsView;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class StatsActivity extends MvpAppCompatActivity implements StatsView, View.OnClickListener {


    RecyclerView recyclerView;
    String dateArr[], countArr[];
    SharedPreferences spDays;
    Button btnExit;

    @InjectPresenter
    StatsPresenter statsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        spDays = getSharedPreferences(MainActivity.DAYS, MODE_PRIVATE);
        dateArr = new String[]{spDays.getString(MainActivity.DAY_FIFTH_DATE, "-"), spDays.getString(MainActivity.DAY_FOURTH_DATE, "-"),
                spDays.getString(MainActivity.DAY_THIRD_DATE, "-"), spDays.getString(MainActivity.DAY_SECOND_DATE, "-"),
                spDays.getString(MainActivity.DAY_FIRST_DATE, "-")};

        countArr = new String[]{spDays.getInt(MainActivity.DAY_FIFTH, 0) + "", spDays.getInt(MainActivity.DAY_FOURTH, 0) + "",
                spDays.getInt(MainActivity.DAY_THIRD, 0) + "", spDays.getInt(MainActivity.DAY_SECOND, 0) + "",
                spDays.getInt(MainActivity.DAY_FIRST, 0) + ""};

        recyclerView = findViewById(R.id.recyclerView);
        btnExit = findViewById(R.id.btnExitStats);
        btnExit.setOnClickListener(this);


        MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(this, dateArr, countArr);
        recyclerView.setAdapter(myRecyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateTo() {

    }

    @Override
    public void onClick(View view) {
        onBackPressed();
    }
}