package com.example.igor.whowantwillbemillioner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.igor.whowantwillbemillioner.Entites.Question;

import java.util.ArrayList;
import java.util.Collections;

public class AcivityImage extends AppCompatActivity {
    int index;
    ArrayList<Integer> numbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acivity_image);
        index = getIntent().getIntExtra("index", 0);
        numbers = getIntent().getIntegerArrayListExtra("Numbers");
        ArrayList<Integer> answers = new ArrayList<>();
        answers.add(0);
        answers.add(1);
        answers.add(2);
        answers.add(3);
        Collections.shuffle(answers);
        Button btn1 = (Button) findViewById(R.id.btn1);
        btn1.setText(Question.getQuestions().get(numbers.get(index)).getAnswer()[answers.indexOf(0)]);
        Button btn2 = (Button) findViewById(R.id.btn2);
        btn2.setText(Question.getQuestions().get(numbers.get(index)).getAnswer()[answers.indexOf(1)]);
        Button btn3 = (Button) findViewById(R.id.btn3);
        btn3.setText(Question.getQuestions().get(numbers.get(index)).getAnswer()[answers.indexOf(2)]);
        Button btn4 = (Button) findViewById(R.id.btn4);
        btn4.setText(Question.getQuestions().get(numbers.get(index)).getAnswer()[answers.indexOf(3)]);
        TextView txt1 = (TextView) findViewById(R.id.txt1);
        txt1.setText(Question.getQuestions().get(numbers.get(index)).getQuestionText());
        ImageView imagev = (ImageView) findViewById(R.id.image);
        imagev.setImageResource(Question.getQuestions().get(numbers.get(index)).getIdphoto());
    }

    public void onStartClick(View v) {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.buttonalpha);
        v.startAnimation(anim);
        Button button = (Button) v;
        String getAnswer = Question.getQuestions().get(numbers.get(index)).getAnswer()[Question.getQuestions().get(numbers.get(index)).getTrueAnswer()];

        if (button.getText().toString().equals(getAnswer) && index == 10) {
            Intent intent = new Intent(this, VinAcivite.class);
            button.setBackgroundResource(R.drawable.trueanswer);
            startActivity(intent);
            overridePendingTransition(R.anim.animstart, R.anim.myanim);
            finish();

        } else if (button.getText().toString().equals(getAnswer)) {
            Intent intent = new Intent(this, TrueActivity.class);
            button.setBackgroundResource(R.drawable.trueanswer);
            intent.putExtra("Numbers", numbers);
            intent.putExtra("index", index);
            startActivity(intent);
            overridePendingTransition(R.anim.animstart, R.anim.myanim);
            finish();
        } else {
            button.setBackgroundResource(R.drawable.falseanswer);
            Intent intent = new Intent(this, LoseActivity.class);
            intent.putExtra("index", index);
            startActivity(intent);
            overridePendingTransition(R.anim.animstart, R.anim.myanim);
            finish();
        }
    }
}