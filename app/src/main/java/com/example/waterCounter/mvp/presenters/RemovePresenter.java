package com.example.waterCounter.mvp.presenters;

import android.content.SharedPreferences;

import moxy.InjectViewState;
import moxy.MvpPresenter;

import com.example.waterCounter.ui.activities.MainActivity;
import com.example.waterCounter.mvp.views.RemoveView;


@InjectViewState
public class RemovePresenter extends MvpPresenter<RemoveView> {

    public void addResult(SharedPreferences spDays, int res) {

        int count = spDays.getInt(MainActivity.DAY_FIRST, 0);
        if (count - res < 0) {
            getViewState().showMessage("Некоррекнтые ввод данных");
        } else {
            SharedPreferences.Editor editor = spDays.edit();
            editor.putInt(MainActivity.DAY_FIRST, count - res);
            editor.apply();
            getViewState().navigateTo();
        }
    }
}
