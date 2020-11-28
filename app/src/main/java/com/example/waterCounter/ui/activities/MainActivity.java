package com.example.waterCounter.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.example.waterCounter.R;
import com.example.waterCounter.mvp.presenters.MainPresenter;
import com.example.waterCounter.mvp.views.MainView;

import org.joda.time.DateTime;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class MainActivity extends MvpAppCompatActivity implements MainView, View.OnClickListener {

    @InjectPresenter
    MainPresenter mainPresenter;


    SharedPreferences spDays;

    Button btnAddActivity;
    Button btnRemoveActivity;
    Button btnStatsActivity;
    TextView tvCountL;

    final public static String DAYS = "DAYS";
    final public static String DAY_FIRST = "DAY_FIRST";
    final public static String DAY_SECOND = "DAY_SECOND";
    final public static String DAY_THIRD = "DAY_THIRD";
    final public static String DAY_FOURTH = "DAY_FOURTH";
    final public static String DAY_FIFTH = "DAY_FIFTH";

    final public static String DAY_FIRST_DATE = "DAY_FIRST_DATE";
    final public static String DAY_SECOND_DATE = "DAY_SECOND_DATE";
    final public static String DAY_THIRD_DATE = "DAY_THIRD_DATE";
    final public static String DAY_FOURTH_DATE = "DAY_FOURTH_DATE";
    final public static String DAY_FIFTH_DATE = "DAY_FIFTH_DATE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvCountL = findViewById(R.id.tvCountL);

        btnAddActivity = findViewById(R.id.btnAddActivity);
        btnRemoveActivity = findViewById(R.id.btnRemove);
        btnStatsActivity = findViewById(R.id.btnStats);

        btnAddActivity.setOnClickListener(this);
        btnRemoveActivity.setOnClickListener(this);
        btnStatsActivity.setOnClickListener(this);
        spDays = getSharedPreferences(DAYS,Context.MODE_PRIVATE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DateTime now = DateTime.now();
       // showMessage(now.toLocalDate().toString());

        if(!now.toLocalDate().toString().equals(spDays.getString(DAY_FIRST_DATE, "-"))){

            mainPresenter.changeDay(spDays,now.toLocalDate().toString());
        }

        if(spDays.contains(DAY_FIRST)) {
            String s = spDays.getInt(DAY_FIRST, -1)+"";
            tvCountL.setText(s);
        }
        else tvCountL.setText("0");


    }

    @Override
    protected void onPause() {
        super.onPause();
    }


    @Override
    public void onClick(View view) {
        mainPresenter.getButtonId(view);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateTo() {
        onBackPressed();
    }

    @Override
    public void navigateTo(Class<?> l) {
        startActivity(new Intent(MainActivity.this, l));
    }
}