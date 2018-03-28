package com.example.igor.whowantwillbemillioner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    int ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        ID=getIntent().getIntExtra("iD",0);
    }
    public void Click(View view){
        Animation anim= AnimationUtils.loadAnimation(this,R.anim.myalpha);
        view.startAnimation(anim);
        if(ID<=6) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("id", ID+1);
            startActivity(intent);
            finish();
        }
    }
}
