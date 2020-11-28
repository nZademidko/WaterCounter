package com.example.waterCounter.ui.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.waterCounter.R;
import com.example.waterCounter.mvp.presenters.RemovePresenter;
import com.example.waterCounter.mvp.views.RemoveView;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class RemoveActivity extends MvpAppCompatActivity implements RemoveView, View.OnClickListener {

    @InjectPresenter
    RemovePresenter removePresenter;

    Button btnRemove;
    Button btnExit;
    EditText etCountRemove;

    SharedPreferences spDays;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);

        btnRemove = findViewById(R.id.btnRemove);
        btnExit = findViewById(R.id.btnExitRemove);
        etCountRemove = findViewById(R.id.etCountRemove);

        btnRemove.setOnClickListener(this);
        btnExit.setOnClickListener(this);

        spDays = getSharedPreferences(MainActivity.DAYS, Context.MODE_PRIVATE);

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
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnRemove:
                if (etCountRemove.getText().toString().isEmpty()) {
                    showMessage("Некорректный ввод данных");
                } else {
                    int count = Integer.parseInt(etCountRemove.getText().toString());
                    removePresenter.addResult(spDays, count);
                }
                break;
            case R.id.btnExitRemove:
                navigateTo();
                break;
        }
    }

}