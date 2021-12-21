package com.sportivnayavictorina.sportsquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView exit_test_Quiz, txt_result_ac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        int s=0;
for(int i=0; i<QuizActivity.wer.length;i++){
    if (QuizActivity.wer!=null)
    if (QuizActivity.wer[i])s++;
}
        txt_result_ac = (TextView) findViewById(R.id.txt_result_ac);
        txt_result_ac.setText("Вы ответили на " + Integer.toString(s) + " из 10");
        exit_test_Quiz = (TextView) findViewById(R.id.exit_test_Quiz);

        exit_test_Quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent); QuizActivity.wer=QuizActivity.wer2;finish();
            }
        });
    }
    // Системная кнопка назад
    @Override
    public void onBackPressed(){
        Intent backintent = new Intent(ResultActivity.this, MainActivity.class);
        startActivity(backintent);QuizActivity.wer=QuizActivity.wer2;finish();
    }
}