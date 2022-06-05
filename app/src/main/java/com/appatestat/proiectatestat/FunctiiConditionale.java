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

public class FunctiiConditionale extends AppCompatActivity {


    private ScrollView scrollView;
    private final TextView[] toFragText = new TextView[2];
    private final TextView[] titleText = new TextView[2];
    private Integer[] codeViewIds = {R.id.cod_f_cond1, R.id.cod_f_cond22};
    private Integer[] codeArray = {R.string.cod_f_cond1, R.string.cod_f_cond2};
    private CodeView codeView[] = new CodeView[codeViewIds.length];
    private Theme[] themes = {Theme.ATELIER_CAVE_LIGHT, Theme.ANDROIDSTUDIO};
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_functii_conditionale);

        Init();
    }

    private void Init(){
        scrollView = findViewById(R.id.scv_f_cond);
        toFragText[0] = findViewById(R.id.cnt_f_cond1); titleText[0] = findViewById(R.id.title_f_cond1);
        toFragText[1] = findViewById(R.id.cnt_f_cond2); titleText[1] = findViewById(R.id.title_f_cond2);

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
        for(int i = 0; i < 2; ++i){
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