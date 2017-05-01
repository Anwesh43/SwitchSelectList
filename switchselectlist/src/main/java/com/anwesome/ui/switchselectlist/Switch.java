package com.anwesome.ui.switchselectlist;

import android.graphics.*;
import android.view.MotionEvent;

/**
 * Created by anweshmishra on 01/05/17.
 */
public class Switch {
    private SwitchCircle switchCircle;
    private float x,y,w,h;
    private SwitchTouchHandler switchTouchHandler;
    public void setDimensions(float x,float y,float w,float h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        switchCircle = new SwitchCircle();
        switchTouchHandler = new SwitchTouchHandler();
    }
    public void update(float factor) {
        switchCircle.fill(factor);
    }
    public boolean on() {
        return switchCircle.isFilled();
    }
    public boolean off() {
        return switchCircle.isUnFilled();
    }
    public void draw(Canvas canvas, Paint paint) {
        canvas.save();
        canvas.translate(x,y);
        paint.setColor(Color.parseColor("#BDBDBD"));
        canvas.drawRoundRect(new RectF(0,0,w,h),w/5,w/5,paint);

        paint.setColor(Color.parseColor("#3D5AFE"));
        canvas.save();
        Path path = new Path();
        path.addRect(new RectF(0,0,switchCircle.cx,h), Path.Direction.CCW);
        canvas.clipPath(path);
        canvas.drawRoundRect(new RectF(0,0,w,h),w/5,w/5,paint);
        canvas.restore();
        switchCircle.draw(canvas,paint);
        canvas.restore();
    }
    public boolean handleTouch(MotionEvent event) {
        float x = event.getX() - this.x, y = event.getY() -this.y;
        switchTouchHandler.handleTouch(event,x,y);
        return true;
    }
    public class SwitchCircle {
        private float cx,cy,r;
        public SwitchCircle() {
            this.cx = 0;
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
        public void fill(float factor) {
            cx = (w-r)*factor;
        }
        public boolean isFilled() {
            return cx>=w-r;
        }
        public boolean isUnFilled() {
            return cx<=r;
        }
    }
    private OnTapHandler onTapHandler;
    public void setOnTapHandler(OnTapHandler onTapHandler) {
        this.onTapHandler = onTapHandler;
    }
    public interface OnTapHandler {
        void onFill();
        void onUnFill();
    }
    private class SwitchTouchHandler {
        public void handleTouch(MotionEvent event,float x,float y) {
            if(event.getAction() == MotionEvent.ACTION_DOWN && switchCircle.handleTouchDown(x,y) && onTapHandler!=null) {
                if(switchCircle.isFilled()) {
                    onTapHandler.onUnFill();
                }
                else if(switchCircle.isUnFilled()){
                    onTapHandler.onFill();
                }
            }
        }
    }
}
