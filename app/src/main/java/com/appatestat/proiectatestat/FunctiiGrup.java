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

public class FunctiiGrup extends AppCompatActivity {

    private ScrollView scrollView;
    private final TextView[] toFragText = new TextView[8];
    private final TextView[] titleText = new TextView[8];
    private Integer[] codeViewIds = {R.id.cod_imp_f_grup,R.id.cod_f_grup1,R.id.cod_f_grup2,R.id.cod_f_grup3,R.id.cod_f_grup4,R.id.cod_f_grup5,R.id.cod_f_grup6,R.id.cod_f_grup7};
    private Integer[] codeArray = {R.string.sintax_f_grup,R.string.cod_f_grup1,R.string.cod_f_grup2,R.string.cod_f_grup3,R.string.cod_f_grup4,R.string.cod_f_grup5,R.string.cod_f_grup6,R.string.cod_f_grup7};
    private CodeView codeView[] = new CodeView[codeViewIds.length];
    private SharedPreferences sharedPreferences;
    private Theme[] themes = {Theme.ATELIER_CAVE_LIGHT, Theme.ANDROIDSTUDIO};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_functii_grup);

        Init();
    }

    private void Init(){
        scrollView = findViewById(R.id.scv_f_grup);
        toFragText[0] = findViewById(R.id.cnt_f_grup_imp); titleText[0] = findViewById(R.id.title_f_grup_imp);
        toFragText[1] = findViewById(R.id.cnt_f_grup1); titleText[1] = findViewById(R.id.title_f_grup1);
        toFragText[2] = findViewById(R.id.cnt_f_grup2); titleText[2] = findViewById(R.id.title_f_grup2);
        toFragText[3] = findViewById(R.id.cnt_f_grup3); titleText[3] = findViewById(R.id.title_f_grup3);
        toFragText[4] = findViewById(R.id.cnt_f_grup4); titleText[4] = findViewById(R.id.title_f_grup4);
        toFragText[5] = findViewById(R.id.cnt_f_grup5); titleText[5] = findViewById(R.id.title_f_grup5);
        toFragText[6] = findViewById(R.id.cnt_f_grup6); titleText[6] = findViewById(R.id.title_f_grup6);
        toFragText[7] = findViewById(R.id.cnt_f_grup7); titleText[7] = findViewById(R.id.title_f_grup7);

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
        for(int i = 0; i < 8; ++i){
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