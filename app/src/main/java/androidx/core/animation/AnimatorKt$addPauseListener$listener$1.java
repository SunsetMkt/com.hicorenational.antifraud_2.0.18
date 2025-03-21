package androidx.core.animation;

import android.animation.Animator;
import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Animator.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, m23546d2 = {"androidx/core/animation/AnimatorKt$addPauseListener$listener$1", "Landroid/animation/Animator$AnimatorPauseListener;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "onAnimationPause", "", "animator", "Landroid/animation/Animator;", "onAnimationResume", "core-ktx_release"}, m23547k = 1, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class AnimatorKt$addPauseListener$listener$1 implements Animator.AnimatorPauseListener {
    final /* synthetic */ InterfaceC5506l $onPause;
    final /* synthetic */ InterfaceC5506l $onResume;

    public AnimatorKt$addPauseListener$listener$1(InterfaceC5506l interfaceC5506l, InterfaceC5506l interfaceC5506l2) {
        this.$onPause = interfaceC5506l;
        this.$onResume = interfaceC5506l2;
    }

    @Override // android.animation.Animator.AnimatorPauseListener
    public void onAnimationPause(@InterfaceC5816d Animator animator) {
        C5544i0.m22546f(animator, "animator");
        this.$onPause.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorPauseListener
    public void onAnimationResume(@InterfaceC5816d Animator animator) {
        C5544i0.m22546f(animator, "animator");
        this.$onResume.invoke(animator);
    }
}
