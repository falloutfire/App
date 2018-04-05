package com.example.igor.whowantwillbemillioner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);
        TextView textView = findViewById(R.id.CountTrueQuestion);
        Intent intent = getIntent();
        textView.setText("Правильные ответы:"+ intent.getIntExtra("index", 0));
    }

    public void onClickCloseTour(View view) {

        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
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
