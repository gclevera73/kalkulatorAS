package com.example.kalkulatorv1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button button;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.simple_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSimpleCalc();
            }
        });

        button = (Button) findViewById(R.id.advanced_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAdvancedCalc();
            }
        });

        button = (Button) findViewById(R.id.about_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAbout();
            }
        });

        button = (Button) findViewById(R.id.exit_btn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
                System.exit(0);
            }
        });
    }



    public void openAbout(){
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }

    public void openSimpleCalc(){
        Intent intent = new Intent(this, SimpleCalc.class);
        startActivity(intent);
    }

    public void openAdvancedCalc(){
        Intent intent = new Intent(this, AdvancedCalc.class);
        startActivity(intent);
    }


}
