package com.appatestat.proiectatestat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import br.tiagohm.codeview.CodeView;
import br.tiagohm.codeview.Language;
import br.tiagohm.codeview.Theme;

public class FunctiiData extends AppCompatActivity {

    private ScrollView scrollView;
    private final TextView[] toFragText = new TextView[7];
    private final TextView[] titleText = new TextView[7];
    private Integer[] codeViewIds = {R.id.cod_f_data1,R.id.cod_f_data2,R.id.cod_f_data3,R.id.cod_f_data4,R.id.cod_f_data5,R.id.cod_f_data6,R.id.cod_f_data7};
    private Integer[] codeArray = {R.string.cod_f_data1,R.string.cod_f_data2,R.string.cod_f_data3,R.string.cod_f_data4,R.string.cod_f_data5,R.string.cod_f_data6,R.string.cod_f_data7};
    private CodeView codeView[] = new CodeView[codeViewIds.length];
    private SharedPreferences sharedPreferences;
    private Theme[] themes = {Theme.ATELIER_CAVE_LIGHT, Theme.ANDROIDSTUDIO};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_functii_data);

        Init();
    }

    private void Init(){
        scrollView = findViewById(R.id.scv_f_data);
        toFragText[0] = findViewById(R.id.cnt_f_data1); titleText[0] = findViewById(R.id.title_f_data1);
        toFragText[1] = findViewById(R.id.cnt_f_data2); titleText[1] = findViewById(R.id.title_f_data2);
        toFragText[2] = findViewById(R.id.cnt_f_data3); titleText[2] = findViewById(R.id.title_f_data3);
        toFragText[3] = findViewById(R.id.cnt_f_data4); titleText[3] = findViewById(R.id.title_f_data4);
        toFragText[4] = findViewById(R.id.cnt_f_data5); titleText[4] = findViewById(R.id.title_f_data5);
        toFragText[5] = findViewById(R.id.cnt_f_data6); titleText[5] = findViewById(R.id.title_f_data6);
        toFragText[6] = findViewById(R.id.cnt_f_data7); titleText[6] = findViewById(R.id.title_f_data7);

        sharedPreferences = getSharedPreferences("percs", MODE_PRIVATE);
        int themeIndex = sharedPreferences.getBoolean("theme", true) ? 1 : 0;

        for(int i = 0; i < codeView.length; ++i){
            codeView[i] = findViewById(codeViewIds[i]);
            codeView[i].setTheme(themes[themeIndex])
                    .setCode(getString(codeArray[i]))
                    .setLanguage(Language.SQL)
                    .setShowLineNumber(true)
                    .setStartLineNumber(1)
                    .apply();
        }

        hyperLink();
    }

    private void hyperLink(){
        for(int i = 0; i < 7; ++i){
            final int q = i;
            titleText[i].setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    scrollView.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.scrollTo(0,toFragText[q].getTop());
                        }
                    },10);
                }
            });
        }
    }

    public void goUp(View view){
        scrollView.postDelayed(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(ScrollView.FOCUS_UP);
            }
        },10);
    }

}