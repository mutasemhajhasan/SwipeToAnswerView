package me.mutasem.slidetoanswer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;

public class SwipeToAnswerView extends RelativeLayout {
    Slider slider;
    ImageView arrow;

    private SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            setBackground(ContextCompat.getDrawable(getContext(), R.drawable.sa_view_bg));
            try {
                arrow.clearAnimation();
                arrow.setVisibility(GONE);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    public SwipeToAnswerView(Context context) {
        super(context);
    }

    public SwipeToAnswerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public SwipeToAnswerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SwipeToAnswerView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    void init(Context context, AttributeSet attrs) {
        inflate(getContext(), R.layout.swipe_to_answer_view, this);
        slider = findViewById(R.id.slider);
        arrow = findViewById(R.id.arrow);
        Animation bounceAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.anim_bounce);
        bounceAnimation.setRepeatCount(Animation.INFINITE);
        arrow.startAnimation(bounceAnimation);
        slider.setOnSeekBarChangeListener(seekBarChangeListener);
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.SwipeToAnswerView,
                0, 0);
        try {
            slider.threshold = a.getInt(R.styleable.SwipeToAnswerView_threshold, Slider.DEFAULT_THRESHOLD);
            slider.reverse = a.getBoolean(R.styleable.SwipeToAnswerView_reverse, false);
//            boolean vertical = a.getBoolean(R.styleable.SlideView_vertical, false);
            setBackground(ContextCompat.getDrawable(context, R.drawable.sa_view_bg));
            slider.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
            int icon = a.getResourceId(R.styleable.SwipeToAnswerView_icon, R.drawable.ic_answer);
//            slider.setThumbOffset(64);
            LayerDrawable drawable = (LayerDrawable) slider.getThumb();

            drawable.setDrawableByLayerId(R.id.thumb_ic, ContextCompat.getDrawable(context, icon));
            if (slider.reverse) {
                setRotationY(180);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            a.recycle();
        }
    }

    public void stopAnimation() {
        arrow.clearAnimation();
        arrow.setVisibility(GONE);
    }

    public void setSlideListner(SlideListner slideListner) {
        slider.slideListner = slideListner;
    }

    public interface SlideListner {
        void onSlideCompleted();
    }
}
