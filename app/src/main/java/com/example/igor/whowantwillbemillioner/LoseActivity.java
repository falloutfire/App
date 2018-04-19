package com.example.igor.whowantwillbemillioner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class LoseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);
        TextView textView = findViewById(R.id.CountTrueQuestion);
        Intent intent = getIntent();
        textView.setText("Правильные ответы:" + intent.getIntExtra("index", 0));
    }

    public void onClickCloseTour(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.buttonalpha);
        view.startAnimation(animation);
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.animstart, R.anim.myanim);
        finish();

    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
        finish();
    }
}