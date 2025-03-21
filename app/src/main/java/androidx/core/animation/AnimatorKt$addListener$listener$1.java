package androidx.core.animation;

import android.animation.Animator;
import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Animator.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\n"}, m23546d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "core-ktx_release"}, m23547k = 1, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class AnimatorKt$addListener$listener$1 implements Animator.AnimatorListener {
    final /* synthetic */ InterfaceC5506l $onCancel;
    final /* synthetic */ InterfaceC5506l $onEnd;
    final /* synthetic */ InterfaceC5506l $onRepeat;
    final /* synthetic */ InterfaceC5506l $onStart;

    public AnimatorKt$addListener$listener$1(InterfaceC5506l interfaceC5506l, InterfaceC5506l interfaceC5506l2, InterfaceC5506l interfaceC5506l3, InterfaceC5506l interfaceC5506l4) {
        this.$onRepeat = interfaceC5506l;
        this.$onEnd = interfaceC5506l2;
        this.$onCancel = interfaceC5506l3;
        this.$onStart = interfaceC5506l4;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(@InterfaceC5816d Animator animator) {
        C5544i0.m22546f(animator, "animator");
        this.$onCancel.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(@InterfaceC5816d Animator animator) {
        C5544i0.m22546f(animator, "animator");
        this.$onEnd.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(@InterfaceC5816d Animator animator) {
        C5544i0.m22546f(animator, "animator");
        this.$onRepeat.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(@InterfaceC5816d Animator animator) {
        C5544i0.m22546f(animator, "animator");
        this.$onStart.invoke(animator);
    }
}
