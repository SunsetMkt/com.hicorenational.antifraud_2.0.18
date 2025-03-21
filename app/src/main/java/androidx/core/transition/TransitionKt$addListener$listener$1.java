package androidx.core.transition;

import android.transition.Transition;
import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Transition.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u000b"}, m23546d2 = {"androidx/core/transition/TransitionKt$addListener$listener$1", "Landroid/transition/Transition$TransitionListener;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "onTransitionCancel", "", "transition", "Landroid/transition/Transition;", "onTransitionEnd", "onTransitionPause", "onTransitionResume", "onTransitionStart", "core-ktx_release"}, m23547k = 1, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class TransitionKt$addListener$listener$1 implements Transition.TransitionListener {
    final /* synthetic */ InterfaceC5506l $onCancel;
    final /* synthetic */ InterfaceC5506l $onEnd;
    final /* synthetic */ InterfaceC5506l $onPause;
    final /* synthetic */ InterfaceC5506l $onResume;
    final /* synthetic */ InterfaceC5506l $onStart;

    public TransitionKt$addListener$listener$1(InterfaceC5506l interfaceC5506l, InterfaceC5506l interfaceC5506l2, InterfaceC5506l interfaceC5506l3, InterfaceC5506l interfaceC5506l4, InterfaceC5506l interfaceC5506l5) {
        this.$onEnd = interfaceC5506l;
        this.$onResume = interfaceC5506l2;
        this.$onPause = interfaceC5506l3;
        this.$onCancel = interfaceC5506l4;
        this.$onStart = interfaceC5506l5;
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionCancel(@InterfaceC5816d Transition transition) {
        C5544i0.m22546f(transition, "transition");
        this.$onCancel.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionEnd(@InterfaceC5816d Transition transition) {
        C5544i0.m22546f(transition, "transition");
        this.$onEnd.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionPause(@InterfaceC5816d Transition transition) {
        C5544i0.m22546f(transition, "transition");
        this.$onPause.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionResume(@InterfaceC5816d Transition transition) {
        C5544i0.m22546f(transition, "transition");
        this.$onResume.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionStart(@InterfaceC5816d Transition transition) {
        C5544i0.m22546f(transition, "transition");
        this.$onStart.invoke(transition);
    }
}
