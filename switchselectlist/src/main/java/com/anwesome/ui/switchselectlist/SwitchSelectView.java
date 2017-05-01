package com.anwesome.ui.switchselectlist;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by anweshmishra on 01/05/17.
 */
public class SwitchSelectView extends View {
    private String option;
    private int time = 0;
    private Switch mSwitch = new Switch();
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private AnimationHandler animationHandler;
    public SwitchSelectView(Context context,String option) {
        super(context);
        this.option = option;
        animationHandler = new AnimationHandler(this);
    }
    public void update(float factor) {
        mSwitch.update(factor);
        postInvalidate();
    }
    public void onDraw(Canvas canvas) {
        int w = canvas.getWidth(),h = canvas.getHeight();
        if(time == 0) {
            mSwitch.setDimensions(7*w/10,h/6,w/5,w/12);
            mSwitch.setOnTapHandler(new Switch.OnTapHandler() {
                @Override
                public void onFill() {
                    animationHandler.start();
                }

                @Override
                public void onUnFill() {
                    animationHandler.end();
                }
            });
        }
        canvas.drawColor(Color.WHITE);
        mSwitch.draw(canvas,paint);
        paint.setTextSize(h/6);
        paint.setColor(Color.parseColor("#BDBDBD"));
        canvas.drawText(option,w/6,h/4,paint);
        time++;
    }
}
