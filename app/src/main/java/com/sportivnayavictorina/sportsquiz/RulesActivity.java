package com.sportivnayavictorina.sportsquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RulesActivity extends AppCompatActivity {
    TextView exit_test_rules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        exit_test_rules = (TextView) findViewById(R.id.exit_test_rules);

        exit_test_rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RulesActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
    // Системная кнопка назад
    @Override
    public void onBackPressed(){
        Intent backintent = new Intent(RulesActivity.this, MainActivity.class);
        startActivity(backintent);finish();
    }
}