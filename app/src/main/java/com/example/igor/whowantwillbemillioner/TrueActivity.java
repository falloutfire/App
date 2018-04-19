package com.example.igor.whowantwillbemillioner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.igor.whowantwillbemillioner.Entites.Question;

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
        TextView textView = (TextView) findViewById(R.id.trueAns);
        TextView textView1 = (TextView) findViewById(R.id.Description);
        if (IND >= 9) {
            float dp = this.getResources().getDisplayMetrics().density;
            int margin = 100;
            int Margin = (int) dp * margin;
            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            param.setMargins(0, Margin, 0, 0);
            textView.setLayoutParams(param);
            textView.setText(R.string.vin);
            textView1.setText("");
            Button button = (Button) findViewById(R.id.btn0);
            button.setText("вернутся в меню");
        } else {
            String description = Question.getQuestions().get(check.get(IND)).getDescription();
            textView1.setText(description);

        }
    }

    public void Click(View view) {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.buttonalpha);
        view.startAnimation(anim);
        if (IND >= 9) {
            Intent intent = new Intent(this, MainMenuActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.animstart, R.anim.myanim);
            finish();
        } else if (Question.getQuestions().get(check.get(IND + 1)).getIdphoto() != 0) {
            Intent intent = new Intent(this, AcivityImage.class);
            intent.putExtra("Numbers", check);
            intent.putExtra("index", IND + 1);
            startActivity(intent);
            finish();
        } else {
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

