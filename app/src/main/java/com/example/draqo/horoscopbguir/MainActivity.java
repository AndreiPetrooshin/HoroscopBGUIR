package com.example.draqo.horoscopbguir;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public static TextView oven;
    public static TextView telec;
    public static TextView blizneci;
    public static TextView rak;
    public static TextView lev;
    public static TextView deva;
    public static TextView vesi;
    public static TextView scorpion;
    public static TextView strelec;
    public static TextView kozerog;
    public static TextView vodolei;
    public static TextView ribi;
    public static TextView textToday;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oven = (TextView) findViewById(R.id.ovenText);
        telec = (TextView) findViewById(R.id.telecText);
        blizneci = (TextView) findViewById(R.id.blizneciText);
        rak = (TextView) findViewById(R.id.rakText);
        lev = (TextView) findViewById(R.id.levText);
        deva = (TextView) findViewById(R.id.devaText);
        vesi = (TextView) findViewById(R.id.vesiText);
        scorpion = (TextView) findViewById(R.id.scorpionText);
        strelec = (TextView) findViewById(R.id.sctrelecText);
        kozerog = (TextView) findViewById(R.id.kozerogText);
        vodolei = (TextView) findViewById(R.id.vodoleiText);
        ribi = (TextView) findViewById(R.id.ribiText);
        textToday = (TextView) findViewById(R.id.textToday);

        LoaderActivity loaderActivity = new LoaderActivity();
        loaderActivity.execute();


    }
}
