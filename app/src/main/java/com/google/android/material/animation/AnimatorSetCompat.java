package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import androidx.annotation.RestrictTo;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class AnimatorSetCompat {
    public static void playTogether(AnimatorSet animatorSet, List<Animator> list) {
        int size = list.size();
        long j2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Animator animator = list.get(i2);
            j2 = Math.max(j2, animator.getStartDelay() + animator.getDuration());
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 0);
        ofInt.setDuration(j2);
        list.add(0, ofInt);
        animatorSet.playTogether(list);
    }
}
