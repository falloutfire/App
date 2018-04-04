package com.example.igor.whowantwillbemillioner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;

public class TrueActivity extends AppCompatActivity {
    ArrayList<Integer> check;
    int IND;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitytrue);
        IND = getIntent().getIntExtra("index", 0);
        check = getIntent().getIntegerArrayListExtra("Numbers");
    }

    public void Click(View view) {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.buttonalpha);
        view.startAnimation(anim);
        if (IND <= 10) {
            Intent intent = new Intent(this, QuestionActivity.class);
            intent.putExtra("Numbers", check);
            intent.putExtra("index", IND + 1);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
        finish();
    }
}

