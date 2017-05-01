package com.anwesome.ui.switchselectlist;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;

/**
 * Created by anweshmishra on 01/05/17.
 */
public class AnimationHandler extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
    private ValueAnimator startAnim = ValueAnimator.ofFloat(0,1),endAnim = ValueAnimator.ofFloat(1,0);
    {{
        startAnim.setDuration(500);
        startAnim.addUpdateListener(this);
        startAnim.addListener(this);
        endAnim.setDuration(500);
        endAnim.addUpdateListener(this);
        endAnim.addListener(this);
    }}
    private SwitchSelectView mSwitchView;
    public AnimationHandler(SwitchSelectView mSwitchView) {
        this.mSwitchView = mSwitchView;
    }
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float factor = (float)valueAnimator.getAnimatedValue();
        mSwitchView.update(factor);
    }
    public void start() {
        startAnim.start();
    }
    public void end() {
        endAnim.start();
    }
    public void onAnimationEnd(Animator animator) {
        mSwitchView.onSwitchAnimEnded();
    }
}
