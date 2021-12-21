package com.sportivnayavictorina.sportsquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class ChoiceOfThemeActivity extends AppCompatActivity {
    TextView id_theme_tennis,id_theme_figure_sk;
    static String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_of_theme);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        id_theme_tennis = (TextView) findViewById(R.id.id_theme_tennis);

        id_theme_tennis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = "tennis";
                Intent intent = new Intent(ChoiceOfThemeActivity.this, QuizActivity.class);
                startActivity(intent); QuizActivity.wer=QuizActivity.wer2;finish();
            }
        });
        id_theme_figure_sk = (TextView) findViewById(R.id.id_theme_figure_sk);

        id_theme_figure_sk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = "figure_sk";
                Intent intent = new Intent(ChoiceOfThemeActivity.this, QuizActivity.class);
                startActivity(intent); QuizActivity.wer=QuizActivity.wer2;finish();
            }
        });
    }
    // Системная кнопка назад
    @Override
    public void onBackPressed(){
        Intent backintent = new Intent(ChoiceOfThemeActivity.this, MainActivity.class);
        startActivity(backintent);str = "";QuizActivity.wer=QuizActivity.wer2;finish();
    }
}