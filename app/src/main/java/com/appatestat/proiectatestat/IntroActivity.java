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

public class IntroActivity extends AppCompatActivity {

private ScrollView scrollView;
private final TextView[] toFragText = new TextView[6];
private final TextView[] titleText = new TextView[6];
private Integer[] codeViewIds = {R.id.secv_simpla_cod, R.id.secv_where_cod, R.id.secv_orderby_cod,R.id.secv_groupby_cod, R.id.secv_having_cod};
private Integer[] codeArray = {R.string.cod_secv_simpla, R.string.cod_secv_where, R.string.cod_secv_orderby, R.string.cod_secv_groupby, R.string.cod_secv_having};
private CodeView codeView[] = new CodeView[codeViewIds.length];
private Theme[] themes = {Theme.ATELIER_CAVE_LIGHT, Theme.ANDROIDSTUDIO};
private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        Init();
    }

    private void Init(){
        scrollView = findViewById(R.id.scvIntro);
        toFragText[0] = findViewById(R.id.cnt0); titleText[0] = findViewById(R.id.cpName0);
        toFragText[1] = findViewById(R.id.cnt1); titleText[1] = findViewById(R.id.cpName1);
        toFragText[2] = findViewById(R.id.cnt2); titleText[2] = findViewById(R.id.cpName2);
        toFragText[3] = findViewById(R.id.cnt3); titleText[3] = findViewById(R.id.cpName3);
        toFragText[4] = findViewById(R.id.cnt4); titleText[4] = findViewById(R.id.cpName4);
        toFragText[5] = findViewById(R.id.cnt5); titleText[5] = findViewById(R.id.cpName5);

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
        for(int i = 0; i < 6; ++i){
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