package com.appatestat.proiectatestat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private boolean isChecked;
    private SharedPreferences sharedPreferences;
    private ImageView themeSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Init();
    }

    private void Init() {
        sharedPreferences = getSharedPreferences("percs", MODE_PRIVATE);
        themeSwitch = findViewById(R.id.btn_ldmode);
        getThemeData();
    }

    private void getThemeData() {
        if(sharedPreferences.getBoolean("theme", true)){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            themeSwitch.setImageResource(R.drawable.luna);
            isChecked = false;
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            themeSwitch.setImageResource(R.drawable.soare);
            isChecked = true;
        }
    }

    public void changeTheme(View v){
        if(isChecked){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            sharedPreferences.edit().putBoolean("theme", true).apply();
            themeSwitch.setImageResource(R.drawable.luna);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            sharedPreferences.edit().putBoolean("theme", false).apply();
            themeSwitch.setImageResource(R.drawable.soare);
        }

        isChecked = !isChecked;
    }

    public void btn1(View v){
        Intent intent = new Intent(MainActivity.this, IntroActivity.class);
        startActivity(intent);
    }

    public void btn2(View v){
        Intent intent = new Intent (MainActivity.this, FunctiiNumerice.class);
        startActivity(intent);
    }

    public void btn3(View v){
        Intent intent = new Intent(MainActivity.this, FunctiiData.class);
        startActivity(intent);
    }

    public void btn4(View v){
        Intent intent = new Intent(MainActivity.this, FunctiiConversie.class);
        startActivity(intent);
    }

    public void btn5(View v){
        Intent intent = new Intent(MainActivity.this, FunctiiGenerale.class);
        startActivity(intent);
    }

    public void btn6(View v){
        Intent intent = new Intent(MainActivity.this, FunctiiGrup.class);
        startActivity(intent);
    }

    public void btn7(View v){
        Intent intent = new Intent(MainActivity.this, FunctiiConditionale.class);
        startActivity(intent);
    }

}