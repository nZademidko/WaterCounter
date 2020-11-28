package com.example.waterCounter.ui.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.waterCounter.R;
import com.example.waterCounter.mvp.presenters.AddPresenter;
import com.example.waterCounter.mvp.views.AddView;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class AddActivity extends MvpAppCompatActivity implements AddView, View.OnClickListener {

    @InjectPresenter
    AddPresenter addPresenter;

    Button btnAdd;
    Button btnExit;
    EditText etCount;

    SharedPreferences spDays;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        btnAdd = findViewById(R.id.btnAdd);
        btnExit = findViewById(R.id.btnExitAdd);
        etCount = findViewById(R.id.etCount);

        btnAdd.setOnClickListener(this);
        btnExit.setOnClickListener(this);

        spDays = getSharedPreferences(MainActivity.DAYS, Context.MODE_PRIVATE);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnAdd:
                if(etCount.getText().toString().isEmpty()){
                    showMessage("Некорректный ввод данных");
                } else{
                    int count = Integer.parseInt(etCount.getText().toString());
                    addPresenter.addResult(spDays,count);
                }
                break;
            case R.id.btnExitAdd:
                navigateTo();
                break;

        }
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateTo() {

        onBackPressed();
    }
}