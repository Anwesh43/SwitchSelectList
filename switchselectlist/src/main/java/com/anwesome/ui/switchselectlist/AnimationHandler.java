package com.anwesome.ui.switchselectlist;

import android.animation.ValueAnimator;

/**
 * Created by anweshmishra on 01/05/17.
 */
public class AnimationHandler implements ValueAnimator.AnimatorUpdateListener {
    private ValueAnimator startAnim = ValueAnimator.ofFloat(0,1),endAnim = ValueAnimator.ofFloat(1,0);
    {{
        startAnim.setDuration(500);
        startAnim.addUpdateListener(this);
        endAnim.setDuration(500);
        endAnim.addUpdateListener(this);
    }}
    public void onAnimationUpdate(ValueAnimator valueAnimator) {

    }
}
