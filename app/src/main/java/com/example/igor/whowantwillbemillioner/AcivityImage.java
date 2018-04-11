package com.example.igor.whowantwillbemillioner;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.igor.whowantwillbemillioner.Entites.Question;

import java.util.ArrayList;

public class AcivityImage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acivity_image);
        Button btn1 = (Button) findViewById(R.id.btn1);
        btn1.setText(Question.getQuestions().get(13).getAnswer()[2]);
        Button btn2 = (Button) findViewById(R.id.btn2);
        btn2.setText(Question.getQuestions().get(13).getAnswer()[3]);
        Button btn3 = (Button) findViewById(R.id.btn3);
        btn3.setText(Question.getQuestions().get(13).getAnswer()[0]);
        Button btn4 = (Button) findViewById(R.id.btn4);
        btn4.setText(Question.getQuestions().get(13).getAnswer()[1]);
        TextView txt1 = (TextView) findViewById(R.id.txt1);
        txt1.setText(Question.getQuestions().get(13).getQuestionText());
        ImageView imagev=(ImageView) findViewById(R.id.image);
        imagev.setImageResource(R.drawable.ansmargarita);
}
    public void onStartClick(View v) {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.buttonalpha);
        v.startAnimation(anim);
        Button button = (Button) v;
        String getAnswer = Question.getQuestions().get(13).getAnswer()[Question.getQuestions().get(13).getTrueAnswer()];
        if (button.getText().toString().equals(getAnswer)) {
            Intent intent = new Intent(this, TrueActivity.class);
            button.setBackgroundResource(R.drawable.trueanswer);
            startActivity(intent);
            overridePendingTransition(R.anim.animstart, R.anim.myanim);
            finish();
        }

        else {
            button.setBackgroundResource(R.drawable.falseanswer);
            Intent intent = new Intent(this, LoseActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.animstart, R.anim.myanim);
            finish();
        }
    }}