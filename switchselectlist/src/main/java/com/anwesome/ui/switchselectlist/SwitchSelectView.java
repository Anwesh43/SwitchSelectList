package com.anwesome.ui.switchselectlist;

import android.content.Context;
import android.view.View;

/**
 * Created by anweshmishra on 01/05/17.
 */
public class SwitchSelectView extends View {
    private String option;
    private int time = 0;
    private Switch mSwitch = new Switch();
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
}
