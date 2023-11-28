package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


public void onCloseButtonClick(View view){
    String[] mIngredients = {"Томаты", "Курица", "Шампиньоны", "Маслины"};
    final boolean[] mSelectedIngredients = {false, false, false, false};
    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
    builder.setTitle("Выберите");
    builder.setIcon(R.drawable.close);
    builder.setCancelable(false);

    builder.setMultiChoiceItems(mIngredients, null, new DialogInterface.OnMultiChoiceClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
            mSelectedIngredients[which]=isChecked;
        }
    });
    builder.setPositiveButton("OK",
            new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {finish();}
                });
    builder.setNegativeButton("Отмена",
            new DialogInterface.OnClickListener(){
        public void onClick(DialogInterface dialog, int id) {dialog.cancel();}
                });
    AlertDialog alert = builder.create();
    alert.show();
    }

}

