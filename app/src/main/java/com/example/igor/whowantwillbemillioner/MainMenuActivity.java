package com.example.igor.whowantwillbemillioner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.igor.whowantwillbemillioner.Entites.Question;

import java.util.ArrayList;
import java.util.Collections;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

    }

    public void onClickExit(View view) {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.buttonalpha);
        view.startAnimation(anim);
        finish();
        System.exit(0);
    }

    public void onClickStart(View view) {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.buttonalpha);
        view.startAnimation(anim);
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < Question.getQuestions().size(); i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);

        for (int i:numbers){
            Log.e("Array", String.valueOf(i));
        }
        Intent intent = new Intent(this, QuestionActivity.class);
        intent.putExtra("Questions", numbers);
        startActivity(intent);
        overridePendingTransition(R.anim.animstart, R.anim.myanim);
        finish();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        moveTaskToBack(true);
        System.exit(0);
        finish();
    }
}
