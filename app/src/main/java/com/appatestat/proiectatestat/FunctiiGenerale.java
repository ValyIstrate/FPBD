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

public class FunctiiGenerale extends AppCompatActivity {

    private ScrollView scrollView;
    private final TextView[] toFragText = new TextView[4];
    private final TextView[] titleText = new TextView[4];
    private Integer[] codeViewIds = {R.id.cod_f_gen1,R.id.cod_f_gen2,R.id.cod_f_gen3,R.id.cod_f_gen4};
    private Integer[] codeArray = {R.string.cod_f_gen1,R.string.cod_f_gen2,R.string.cod_f_gen3,R.string.cod_f_gen4};
    private CodeView codeView[] = new CodeView[codeViewIds.length];
    private SharedPreferences sharedPreferences;
    private Theme[] themes = {Theme.ATELIER_CAVE_LIGHT, Theme.ANDROIDSTUDIO};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_functii_generale);

        Init();
    }

    private void Init(){
        scrollView = findViewById(R.id.scv_f_gen);
        toFragText[0] = findViewById(R.id.cnt_f_gen1); titleText[0] = findViewById(R.id.title_f_gen1);
        toFragText[1] = findViewById(R.id.cnt_f_gen2); titleText[1] = findViewById(R.id.title_f_gen2);
        toFragText[2] = findViewById(R.id.cnt_f_gen3); titleText[2] = findViewById(R.id.title_f_gen3);
        toFragText[3] = findViewById(R.id.cnt_f_gen4); titleText[3] = findViewById(R.id.title_f_gen4);

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
        for(int i = 0; i < 4; ++i){
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