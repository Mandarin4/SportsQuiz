package com.sportivnayavictorina.sportsquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {
    private RecyclerView recyclerViewQuestions;
    private List<Question_Model> questions = new ArrayList<>();

    static ArrayList<String> list = new ArrayList<String>();

    TextView stop_test_Quiz;
    static Boolean[] wer = new Boolean[10];
    static Boolean[] wer2 = new Boolean[10];
    String r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        r=ChoiceOfThemeActivity.str;
        ChoiceOfThemeActivity.str="";
        stop_test_Quiz = (TextView) findViewById(R.id.stop_test_Quiz);

        stop_test_Quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                startActivity(intent);
                finish();
            }
        });

        recyclerViewQuestions = findViewById(R.id.recycler_view);
        if (r.equals("tennis"))prepareQuestions();
        else prepareQuestions2();
        initQuestionsAdapter();


    }

    private void prepareQuestions( ) {
        for (int i = 0; i < 10; i++) {
            wer[i]=false;
            wer2[i]=false;

        }
        Question_Model question1 = new Question_Model();
        question1.optionA = "Калашникова Василиса";
        question1.optionB = "Элина Свитолина";
        question1.optionC = "Петрик Таисия";
        question1.optionD = "Ершова Полина";
        question1.src_image = "tennis1";
        question1.correctOption = 2;
        questions.add(question1);

        Question_Model question2 = new Question_Model();
        question2.optionA = "Цушко Лада";
        question2.optionB = "Уварова Ирина";
        question2.optionC = "Fabrice Santoro";
        question2.optionD = "Самсонова Раиса";
        question2.src_image = "tennis2";
        question2.correctOption = 3;
        questions.add(question2);

        Question_Model question3 = new Question_Model();
        question3.optionA = "Коновалов Йосып";
        question3.optionB = "Агафонов Вадим";
        question3.optionC = "Mansour Bahrami";
        question3.optionD = "Носов Андрей";
        question3.src_image = "tennis3";
        question3.correctOption = 3;
        questions.add(question3);

        Question_Model question4 = new Question_Model();
        question4.optionA = "Грабчак Фёдор";
        question4.optionB = "Бондаренко Платон";
        question4.optionC = "Виноградов Харитон";
        question4.optionD = "Андрей Медведев";
        question4.src_image = "tennis4";
        question4.correctOption = 4;
        questions.add(question4);

        Question_Model question5 = new Question_Model();
        question5.optionA = "Сергей Стаховский";
        question5.optionB = "Шаров Цезарь";
        question5.optionC = "Юдин Валерий";
        question5.optionD = "Грабчак Андрей";
        question5.src_image = "tennis5";
        question5.correctOption = 1;
        questions.add(question5);

        Question_Model question6 = new Question_Model();
        question6.optionA = "Евгений Кафельников";
        question6.optionB = "Мухин Йонас";
        question6.optionC = "Чернов Харитон";
        question6.optionD = "Несвитайло Эрик";
        question6.src_image = "tennis6";
        question6.correctOption = 1;
        questions.add(question6);

        Question_Model question7 = new Question_Model();
        question7.optionA = "Прохоров Феликс";
        question7.optionB = "Александр Недовесов";
        question7.optionC = "Погомий Геннадий";
        question7.optionD = "Тягай Пётр";
        question7.src_image = "tennis7";
        question7.correctOption = 2;
        questions.add(question7);

        Question_Model question8 = new Question_Model();
        question8.optionA = "Воробьёв Чарльзс";
        question8.optionB = "Белоусов Юлий";
        question8.optionC = "Ермаков Иосиф";
        question8.optionD = "Рафаэль Надаль";
        question8.src_image = "tennis8";
        question8.correctOption = 4;
        questions.add(question8);

        Question_Model question9 = new Question_Model();
        question9.optionA = "Симонов Йоханес";
        question9.optionB = "Федосеев Яромир";
        question9.optionC = "Андре Агасси";
        question9.optionD = "Архипов Зенон";
        question9.src_image = "tennis9";
        question9.correctOption = 3;
        questions.add(question9);

        Question_Model question10 = new Question_Model();
        question10.optionA = "Антонова Рада";
        question10.optionB = "Миронова Софья";
        question10.optionC = "Крис Эверт";
        question10.optionD = "Кулагина Божена";
        question10.src_image = "tennis10";
        question10.correctOption = 3;
        questions.add(question10);


    }

    private void prepareQuestions2( ) {
        for (int i = 0; i < 10; i++) {
            wer[i]=false;
            wer2[i]=false;

        }
        Question_Model question1 = new Question_Model();
        question1.optionA = "Рогов Юлий";
        question1.optionB = "Евгений Плющенко";
        question1.optionC = "Сирко Никита";
        question1.optionD = "Яценюк Ким";
        question1.src_image = "images1";
        question1.correctOption = 2;
        questions.add(question1);

        Question_Model question2 = new Question_Model();
        question2.optionA = "Зуева Цилла";
        question2.optionB = "Гурьева Зоя";
        question2.optionC = "Алина Загитова";
        question2.optionD = "Темченко Федосья";
        question2.src_image = "images2";
        question2.correctOption = 3;
        questions.add(question2);

        Question_Model question3 = new Question_Model();
        question3.optionA = "Фомина Устинья";
        question3.optionB = "Орехова Злата";
        question3.optionC = "Евгения Медведева";
        question3.optionD = "Фокина Юнона";
        question3.src_image = "images3";
        question3.correctOption = 3;
        questions.add(question3);

        Question_Model question4 = new Question_Model();
        question4.optionA = "Петрова Флорентина";
        question4.optionB = "Зиновьева Ксения";
        question4.optionC = "Крюкова Флорентина";
        question4.optionD = "Алёна Косторная";
        question4.src_image = "images4";
        question4.correctOption = 4;
        questions.add(question4);

        Question_Model question5 = new Question_Model();
        question5.optionA = "Елизавета Туктамышева";
        question5.optionB = "Трофимова Розалина";
        question5.optionC = "Повалий Кристина";
        question5.optionD = "Веселова Искра";
        question5.src_image = "images5";
        question5.correctOption = 1;
        questions.add(question5);

        Question_Model question6 = new Question_Model();
        question6.optionA = "Этери Тутберидзе";
        question6.optionB = "Мухин Йонас";
        question6.optionC = "Чернов Харитон";
        question6.optionD = "Несвитайло Эрик";
        question6.src_image = "images6";
        question6.correctOption = 1;
        questions.add(question6);

        Question_Model question7 = new Question_Model();
        question7.optionA = "Комарова Елизавета";
        question7.optionB = "Елизавета Нугуманова";
        question7.optionC = "Батейко Йосифа";
        question7.optionD = "Мельникова Устинья";
        question7.src_image = "images7";
        question7.correctOption = 2;
        questions.add(question7);

        Question_Model question8 = new Question_Model();
        question8.optionA = "Веселов Цицерон";
        question8.optionB = "Кулибаба Пётр";
        question8.optionC = "Носов Йозеф";
        question8.optionD = "Михаил Коляда";
        question8.src_image = "images8";
        question8.correctOption = 4;
        questions.add(question8);

        Question_Model question9 = new Question_Model();
        question9.optionA = "Пасичник Ива";
        question9.optionB = "Погомий Камиль";
        question9.optionC = "Никита Кацалапов";
        question9.optionD = "Савин Лукиллиан";
        question9.src_image = "images9";
        question9.correctOption = 3;
        questions.add(question9);

        Question_Model question10 = new Question_Model();
        question10.optionA = "Котовский Стефан";
        question10.optionB = "Павленко Тит";
        question10.optionC = "Дмитрий Алиев";
        question10.optionD = "Лановой Юрий";
        question10.src_image = "images10";
        question10.correctOption = 3;
        questions.add(question10);


    }

    private void initQuestionsAdapter() {
        recyclerViewQuestions.setLayoutManager(new LinearLayoutManager(this));
        QuestionAdapter questionAdapter = new QuestionAdapter(this, questions);
        recyclerViewQuestions.setAdapter(questionAdapter);
    }
    // Системная кнопка назад
    @Override
    public void onBackPressed(){
        Intent backintent = new Intent(QuizActivity.this, MainActivity.class);
        startActivity(backintent);wer=wer2;finish();
    }

}
