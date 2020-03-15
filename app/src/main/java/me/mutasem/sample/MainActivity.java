package me.mutasem.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import me.mutasem.slidetoanswer.SwipeToAnswerView;

public class MainActivity extends AppCompatActivity {
    SwipeToAnswerView answer, decline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        answer = findViewById(R.id.StA);
        answer.setSlideListner(new SwipeToAnswerView.SlideListner() {
            @Override
            public void onSlideCompleted() {
                Toast.makeText(MainActivity.this, "Slide completed", Toast.LENGTH_SHORT).show();
                decline.stopAnimation();
            }
        });
        decline = findViewById(R.id.StA2);
        decline.setSlideListner(new SwipeToAnswerView.SlideListner() {
            @Override
            public void onSlideCompleted() {
                Toast.makeText(MainActivity.this, "Reverse completed", Toast.LENGTH_SHORT).show();
                answer.stopAnimation();
            }
        });
    }
}
