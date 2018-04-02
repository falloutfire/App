package com.example.igor.whowantwillbemillioner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.example.igor.whowantwillbemillioner.Entites.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class QuestionActivity extends AppCompatActivity {
 int iD;
 int index;
 ArrayList<Integer>numbers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityquestion);
        Intent intent=getIntent();
        if(intent.getIntegerArrayListExtra("Questions")==null){
            index+=getIntent().getIntExtra("index2",0);
            numbers=getIntent().getIntegerArrayListExtra("Numbers");
            iD=numbers.indexOf(index);
        }else{
        numbers=intent.getIntegerArrayListExtra("Questions");
        iD=numbers.indexOf(index);
        }
     ArrayList<Integer>answers=new ArrayList<>();
        answers.add(0);
        answers.add(1);
        answers.add(2);
        answers.add(3);
        Collections.shuffle(answers);
        Button btn1 =  (Button) findViewById(R.id.btn1);
        btn1.setText(Question.getQuestions().get(iD).getAnswer()[answers.indexOf(0)]);
        Button btn2 =  (Button) findViewById(R.id.btn2);
        btn2.setText(Question.getQuestions().get(iD).getAnswer()[answers.indexOf(2)]);//здесь индексы можно было сделать по порядку все равно все ответы
        //были бы рандомными и разными, но мне чего-то так захотелось
        Button btn3 =  (Button) findViewById(R.id.btn3);
        btn3.setText(Question.getQuestions().get(iD).getAnswer()[answers.indexOf(3)]);
        Button btn4 =  (Button) findViewById(R.id.btn4);
        btn4.setText(Question.getQuestions().get(iD).getAnswer()[answers.indexOf(1)]);
        TextView txt1=(TextView) findViewById(R.id.txt1);
        txt1.setText(Question.getQuestions().get(iD).getQuestionText());

}
public void onStartClick(View v) {
    Animation anim = AnimationUtils.loadAnimation(this, R.anim.buttonalpha);
    v.startAnimation(anim);
    Intent intent=new Intent(this,TrueActivity.class);
    intent.putExtra("NumbersQ",numbers);
    intent.putExtra("indexnow",index);
    Button button = (Button) v;
    String getAnswer = Question.getQuestions().get(iD).getAnswer()[Question.getQuestions().get(iD).getTrueAnswer()];
    if (button.getText().toString().equals(getAnswer)) {
        button.setBackgroundResource(R.drawable.trueanswer);
        startActivity(intent);
        overridePendingTransition(R.anim.animstart, R.anim.myanim);
        finish();
    } else {
        button.setBackgroundResource(R.drawable.falseanswer);
    }
}}
