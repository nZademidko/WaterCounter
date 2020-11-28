package com.example.waterCounter.mvp.presenters;

import android.content.SharedPreferences;
import android.view.View;

import com.example.waterCounter.R;
import com.example.waterCounter.ui.activities.AddActivity;
import com.example.waterCounter.ui.activities.MainActivity;
import com.example.waterCounter.ui.activities.RemoveActivity;
import com.example.waterCounter.ui.activities.StatsActivity;
import com.example.waterCounter.mvp.views.MainView;


import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {


    public void getButtonId(View view) {

        switch (view.getId()) {
            case R.id.btnAddActivity:
                getViewState().navigateTo(AddActivity.class);
                break;
            case R.id.btnRemove:
                getViewState().navigateTo(RemoveActivity.class);
                break;
            case R.id.btnStats:
                getViewState().navigateTo(StatsActivity.class);
                break;
        }
    }

    public void changeDay(SharedPreferences shDays, String currDay){

        SharedPreferences.Editor editor = shDays.edit();

        editor.putString(MainActivity.DAY_FIFTH_DATE,shDays.getString(MainActivity.DAY_FOURTH_DATE,"-"));
        editor.putInt(MainActivity.DAY_FIFTH, shDays.getInt(MainActivity.DAY_FOURTH, 0));

        editor.putString(MainActivity.DAY_FOURTH_DATE,shDays.getString(MainActivity.DAY_THIRD_DATE,"-"));
        editor.putInt(MainActivity.DAY_FOURTH, shDays.getInt(MainActivity.DAY_THIRD, 0));

        editor.putString(MainActivity.DAY_THIRD_DATE,shDays.getString(MainActivity.DAY_SECOND_DATE,"-"));
        editor.putInt(MainActivity.DAY_THIRD, shDays.getInt(MainActivity.DAY_SECOND, 0));

        editor.putString(MainActivity.DAY_SECOND_DATE,shDays.getString(MainActivity.DAY_FIRST_DATE,"-"));
        editor.putInt(MainActivity.DAY_SECOND, shDays.getInt(MainActivity.DAY_FIRST, 0));

        editor.putString(MainActivity.DAY_FIRST_DATE,currDay);
        editor.putInt(MainActivity.DAY_FIRST, 0);

        editor.apply();
    }
}
