package com.example.igor.whowantwillbemillioner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class VinAcivite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vinacivite);
    }
    public void backtomenu(View v){
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.buttonalpha);
        v.startAnimation(animation);
        Intent intent=new Intent(this,MainMenuActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.animstart,R.anim.myanim);
        finish();

    }
    @Override
    public void onBackPressed() {

        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.animstart,R.anim.myanim);
        finish();
    }
}
