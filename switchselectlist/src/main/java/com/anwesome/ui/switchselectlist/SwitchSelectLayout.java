package com.anwesome.ui.switchselectlist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by anweshmishra on 01/05/17.
 */
public class SwitchSelectLayout extends ViewGroup {
    private int deviceW,deviceH;
    public SwitchSelectLayout(Context context,int deviceW,int deviceH) {
        super(context);
        this.deviceH = deviceH;
        this.deviceW = deviceW;
    }
    public void addOption(String option,OnSelectionChangeListener onSelectionChangeListener) {
        SwitchSelectView switchSelectView = new SwitchSelectView(getContext(),option);
        switchSelectView.setOnSelectionChangeListener(onSelectionChangeListener);
        addView(switchSelectView,new LayoutParams(deviceW,deviceH/5));
        requestLayout();
    }
    public void onMeasure(int wspec,int hspec) {
        int maxH = 0;
        for(int i=0;i<getChildCount();i++) {
            View child = getChildAt(i);
            measureChild(child,wspec,hspec);
            maxH += (child.getMeasuredHeight()*11)/10;
        }
        setMeasuredDimension(deviceW,Math.max(deviceH,maxH));
    }
    public void onLayout(boolean reloaded,int a,int b,int w,int h) {
        int y = 0;
        for(int i=0;i<getChildCount();i++) {
            View child = getChildAt(i);
            child.layout(0,y,deviceW,y+child.getMeasuredHeight());
            y+=(child.getMeasuredHeight()*11)/10;
        }
    }
}
