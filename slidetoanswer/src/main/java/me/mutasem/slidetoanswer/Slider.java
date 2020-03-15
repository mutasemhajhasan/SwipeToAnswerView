package me.mutasem.slidetoanswer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.appcompat.widget.AppCompatSeekBar;

public class Slider extends AppCompatSeekBar {
    public static int DEFAULT_THRESHOLD = 50;
 int threshold = DEFAULT_THRESHOLD;
   boolean reverse = false;
    SwipeToAnswerView.SlideListner slideListner;

    public Slider(Context context) {
        super(context);
    }

    public Slider(Context context, AttributeSet attrs) {
        super(context, attrs);
    }




    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (getThumb().getBounds().contains((int) event.getX(), (int) event.getY())) {
                // This fixes an issue where the parent view (e.g ScrollView) receives
                // touch events along with the SlideView
                getParent().requestDisallowInterceptTouchEvent(true);
                super.onTouchEvent(event);
            } else {
                return false;
            }
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            if (getProgress() > threshold) {
                if (slideListner != null) slideListner.onSlideCompleted();
            }

            getParent().requestDisallowInterceptTouchEvent(false);
            setProgress(0);
        } else
            super.onTouchEvent(event);

        return true;
    }




}
