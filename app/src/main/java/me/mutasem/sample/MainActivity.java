package me.mutasem.sample;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import me.mutasem.slidetoanswer.SwipeToAnswerView;

public class MainActivity extends AppCompatActivity {
    SwipeToAnswerView answer, decline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        answer = findViewById(R.id.StA);
        answer.setSlideListner(new SwipeToAnswerView.SlideListner() {
            @Override
            public void onSlideCompleted() {
                Toast.makeText(MainActivity.this, "Slide completed", Toast.LENGTH_SHORT).show();
            }
        });
        decline = findViewById(R.id.StA2);
        decline.setSlideListner(new SwipeToAnswerView.SlideListner() {
            @Override
            public void onSlideCompleted() {
                Toast.makeText(MainActivity.this, "Reverse completed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
