package com.anwesome.ui.switchselectlist;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.view.Display;
import android.view.ViewGroup;
import android.widget.ScrollView;

/**
 * Created by anweshmishra on 01/05/17.
 */
public class SwitchSelectList  {
    private boolean isShown = false;
    private ScrollView scrollView;
    private SwitchSelectLayout switchSelectLayout;
    private Activity activity;
    private int w,h;
    public SwitchSelectList(Activity activity) {
        this.activity = activity;
        initDimension();
        initViews();
    }
    public void initViews() {
        switchSelectLayout = new SwitchSelectLayout(activity,w,h);
        scrollView = new ScrollView(activity);
        scrollView.addView(switchSelectLayout,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }
    public void initDimension() {
        DisplayManager displayManager = (DisplayManager)activity.getSystemService(Context.DISPLAY_SERVICE);
        Display display = displayManager.getDisplay(0);
        if(display != null) {
            Point size = new Point();
            display.getRealSize(size);
            w = size.x;
            h = size.y;
        }
    }
    public void addOption(String option,OnSelectionChangeListener onSelectionChangeListener) {
        if(!isShown) {
            switchSelectLayout.addOption(option, onSelectionChangeListener);
        }
    }
    public void show() {
        if(!isShown) {
            activity.setContentView(scrollView);
            isShown = true;
        }
    }
}
