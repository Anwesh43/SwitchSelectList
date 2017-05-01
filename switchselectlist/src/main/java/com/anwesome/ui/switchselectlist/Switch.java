package com.anwesome.ui.switchselectlist;

import android.graphics.*;
import android.view.MotionEvent;

/**
 * Created by anweshmishra on 01/05/17.
 */
public class Switch {
    private SwitchCircle switchCircle;
    private float x,y,w,h;

    public void setDimensions(float x,float y,float w,float h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        switchCircle = new SwitchCircle();
    }
    public void draw(Canvas canvas, Paint paint) {
        canvas.save();
        canvas.translate(x,y);
        paint.setColor(Color.parseColor("#BDBDBD"));
        canvas.drawRoundRect(new RectF(0,0,w,h),w/10,w/10,paint);
        canvas.restore();
    }
    public boolean handleTouch(MotionEvent event) {
        float x = event.getX() - this.x, y = event.getY() -this.y;
        return true;
    }
    private class SwitchCircle {
        private float cx,cy,r;
        public SwitchCircle() {
            this.cx = h/2;
            this.cy = h/2;
            this.r = h/2+h/10;
        }
        public void draw(Canvas canvas,Paint paint) {
            paint.setColor(Color.parseColor("#E0E0E0"));
            canvas.drawCircle(cx,cy,r,paint);
        }
        public boolean handleTouchDown(float x,float y) {
            return x>=cx-r && x<=cx+r && y>=cy-r && y<=cy+r;
        }
        public void handleTouchMove(float x,float y) {
            if(x>=r && x<=w-r) {
                cx = x;
                if(x<r) {
                    x = r;
                }
                if(x>w-r) {
                    x = w-r;
                }
            }
        }

    }
}
