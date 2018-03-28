package com.example.igor.whowantwillbemillioner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.example.igor.whowantwillbemillioner.Entites.Question;

public class MainActivity extends AppCompatActivity {
 int iD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        iD+=intent.getIntExtra("id", 0);
        Button btn1 =  (Button) findViewById(R.id.btn1);
        btn1.setText(Question.getQuestions().get(iD).getAnswer()[0]);
        Button btn2 =  (Button) findViewById(R.id.btn2);
        btn2.setText(Question.getQuestions().get(iD).getAnswer()[1]);
        Button btn3 =  (Button) findViewById(R.id.btn3);
        btn3.setText(Question.getQuestions().get(iD).getAnswer()[2]);
        Button btn4 =  (Button) findViewById(R.id.btn4);
        btn4.setText(Question.getQuestions().get(iD).getAnswer()[3]);
        TextView txt1=(TextView) findViewById(R.id.txt1);
        txt1.setText(Question.getQuestions().get(iD).getQuestionText());

}
public void onStartClick(View v) {
    Animation anim=AnimationUtils.loadAnimation(this,R.anim.myalpha);
    v.startAnimation(anim);
    switch (v.getId()) {
        case R.id.btn1:
            Button button = (Button) v;
            if (Question.getQuestions().get(iD).getAnswer()[Question.getQuestions().get(iD).getTrueAnswer()] == button.getText()) {
                button.setBackgroundResource(R.drawable.two2);
                Intent intent = new Intent(this, Main2Activity.class);
                intent.putExtra("iD",iD);
                startActivity(intent);
               finish();
            }else {
                button.setBackgroundResource(R.drawable.two);
            }
            break;
        case R.id.btn2:
            Button button2 = (Button) v;
            if (Question.getQuestions().get(iD).getAnswer()[Question.getQuestions().get(iD).getTrueAnswer()] == button2.getText()) {
                button2.setBackgroundResource(R.drawable.two2);
                Intent intent = new Intent(this, Main2Activity.class);
                intent.putExtra("iD",iD);
                startActivity(intent);
                overridePendingTransition(R.anim.myanimfinish,R.anim.myanim);

                finish();
            }else {
                button2.setBackgroundResource(R.drawable.two);

            }
            break;
        case R.id.btn3:
            Button button3 = (Button) v;
            if (Question.getQuestions().get(iD).getAnswer()[Question.getQuestions().get(iD).getTrueAnswer()] == button3.getText()) {
                button3.setBackgroundResource(R.drawable.two2);
                Intent intent = new Intent(this, Main2Activity.class);
                intent.putExtra("iD",iD);
                startActivity(intent);
                overridePendingTransition(R.anim.myanimfinish,R.anim.myanim);
                finish();
            }else {
                button3.setBackgroundResource(R.drawable.two);


            }
            break;
        case R.id.btn4:
            Button button4 = (Button) v;
            if (Question.getQuestions().get(iD).getAnswer()[Question.getQuestions().get(iD).getTrueAnswer()] == button4.getText()) {
                button4.setBackgroundResource(R.drawable.two2);
                Intent intent = new Intent(this, Main2Activity.class);
                intent.putExtra("iD",iD);
                startActivity(intent);
                overridePendingTransition(R.anim.myanimfinish,R.anim.myanim);
                finish();
                break;
            }else {
                button4.setBackgroundResource(R.drawable.two);

            }
    }
}
}