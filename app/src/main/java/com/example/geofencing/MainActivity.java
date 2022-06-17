package com.example.geofencing;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String naslov;
    String radij;
    int s;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("Alarm", Context.MODE_PRIVATE);
        naslov = sp.getString("naslov", "");
        radij = sp.getString("radij", "");
        s = sp.getInt("true", 0);

        LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
        if(s != 0) {
            final LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            final TextView textView = new TextView(this);
            textView.setLayoutParams(lparams);
            textView.setBackground(getDrawable(R.drawable.round_edge));
            textView.setTextSize(25);
            textView.setText("    " + naslov + "\n" + "    " + radij + "m");
            ll.addView(textView);

            final LinearLayout.LayoutParams lparams1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            lparams1.setMargins(-150,22,0,0);
            final Switch stikalo = new Switch(this);
            stikalo.setLayoutParams(lparams1);
            stikalo.setChecked(true);
            ll.addView(stikalo);
        }
    }


    public void dodaj(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}

