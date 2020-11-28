package com.example.waterCounter.mvp.presenters;

import android.content.SharedPreferences;

import com.example.waterCounter.ui.activities.MainActivity;
import com.example.waterCounter.mvp.views.AddView;

import moxy.InjectViewState;
import moxy.MvpPresenter;


@InjectViewState
public class AddPresenter extends MvpPresenter<AddView> {




    public void addResult(SharedPreferences spDays, int res){

        int count = spDays.getInt(MainActivity.DAY_FIRST,0);
        SharedPreferences.Editor editor = spDays.edit();
        editor.putInt(MainActivity.DAY_FIRST,count+res);
        editor.apply();
        getViewState().navigateTo();
    }
}
