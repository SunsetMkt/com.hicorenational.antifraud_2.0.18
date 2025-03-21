package androidx.core.transition;

import android.transition.Transition;
import androidx.annotation.RequiresApi;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import p286h.C5715y1;
import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Transition.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\u001aÆ\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022#\b\u0006\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u001a2\u0010\r\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u001a2\u0010\u000f\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u001a2\u0010\u0010\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u001a2\u0010\u0011\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u001a2\u0010\u0012\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b¨\u0006\u0013"}, m23546d2 = {"addListener", "Landroid/transition/Transition$TransitionListener;", "Landroid/transition/Transition;", "onEnd", "Lkotlin/Function1;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "transition", "", "onStart", "onCancel", "onResume", "onPause", "doOnCancel", "action", "doOnEnd", "doOnPause", "doOnResume", "doOnStart", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class TransitionKt {
    @RequiresApi(19)
    @InterfaceC5816d
    public static final Transition.TransitionListener addListener(@InterfaceC5816d Transition transition, @InterfaceC5816d InterfaceC5506l<? super Transition, C5715y1> interfaceC5506l, @InterfaceC5816d InterfaceC5506l<? super Transition, C5715y1> interfaceC5506l2, @InterfaceC5816d InterfaceC5506l<? super Transition, C5715y1> interfaceC5506l3, @InterfaceC5816d InterfaceC5506l<? super Transition, C5715y1> interfaceC5506l4, @InterfaceC5816d InterfaceC5506l<? super Transition, C5715y1> interfaceC5506l5) {
        C5544i0.m22546f(transition, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "onEnd");
        C5544i0.m22546f(interfaceC5506l2, "onStart");
        C5544i0.m22546f(interfaceC5506l3, "onCancel");
        C5544i0.m22546f(interfaceC5506l4, "onResume");
        C5544i0.m22546f(interfaceC5506l5, "onPause");
        TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(interfaceC5506l, interfaceC5506l4, interfaceC5506l5, interfaceC5506l3, interfaceC5506l2);
        transition.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    @RequiresApi(19)
    @InterfaceC5816d
    public static /* bridge */ /* synthetic */ Transition.TransitionListener addListener$default(Transition transition, InterfaceC5506l interfaceC5506l, InterfaceC5506l interfaceC5506l2, InterfaceC5506l interfaceC5506l3, InterfaceC5506l interfaceC5506l4, InterfaceC5506l interfaceC5506l5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            interfaceC5506l = TransitionKt$addListener$1.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            interfaceC5506l2 = TransitionKt$addListener$2.INSTANCE;
        }
        InterfaceC5506l interfaceC5506l6 = interfaceC5506l2;
        if ((i2 & 4) != 0) {
            interfaceC5506l3 = TransitionKt$addListener$3.INSTANCE;
        }
        InterfaceC5506l interfaceC5506l7 = interfaceC5506l3;
        if ((i2 & 8) != 0) {
            interfaceC5506l4 = TransitionKt$addListener$4.INSTANCE;
        }
        if ((i2 & 16) != 0) {
            interfaceC5506l5 = TransitionKt$addListener$5.INSTANCE;
        }
        C5544i0.m22546f(transition, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "onEnd");
        C5544i0.m22546f(interfaceC5506l6, "onStart");
        C5544i0.m22546f(interfaceC5506l7, "onCancel");
        C5544i0.m22546f(interfaceC5506l4, "onResume");
        C5544i0.m22546f(interfaceC5506l5, "onPause");
        TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(interfaceC5506l, interfaceC5506l4, interfaceC5506l5, interfaceC5506l7, interfaceC5506l6);
        transition.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    @RequiresApi(19)
    @InterfaceC5816d
    public static final Transition.TransitionListener doOnCancel(@InterfaceC5816d Transition transition, @InterfaceC5816d final InterfaceC5506l<? super Transition, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(transition, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnCancel$$inlined$addListener$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@InterfaceC5816d Transition transition2) {
                C5544i0.m22546f(transition2, "transition");
                InterfaceC5506l.this.invoke(transition2);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@InterfaceC5816d Transition transition2) {
                C5544i0.m22546f(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@InterfaceC5816d Transition transition2) {
                C5544i0.m22546f(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@InterfaceC5816d Transition transition2) {
                C5544i0.m22546f(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@InterfaceC5816d Transition transition2) {
                C5544i0.m22546f(transition2, "transition");
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }

    @RequiresApi(19)
    @InterfaceC5816d
    public static final Transition.TransitionListener doOnEnd(@InterfaceC5816d Transition transition, @InterfaceC5816d final InterfaceC5506l<? super Transition, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(transition, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnEnd$$inlined$addListener$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@InterfaceC5816d Transition transition2) {
                C5544i0.m22546f(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@InterfaceC5816d Transition transition2) {
                C5544i0.m22546f(transition2, "transition");
                InterfaceC5506l.this.invoke(transition2);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@InterfaceC5816d Transition transition2) {
                C5544i0.m22546f(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@InterfaceC5816d Transition transition2) {
                C5544i0.m22546f(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@InterfaceC5816d Transition transition2) {
                C5544i0.m22546f(transition2, "transition");
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }

    @RequiresApi(19)
    @InterfaceC5816d
    public static final Transition.TransitionListener doOnPause(@InterfaceC5816d Transition transition, @InterfaceC5816d final InterfaceC5506l<? super Transition, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(transition, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnPause$$inlined$addListener$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@InterfaceC5816d Transition transition2) {
                C5544i0.m22546f(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@InterfaceC5816d Transition transition2) {
                C5544i0.m22546f(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@InterfaceC5816d Transition transition2) {
                C5544i0.m22546f(transition2, "transition");
                InterfaceC5506l.this.invoke(transition2);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@InterfaceC5816d Transition transition2) {
                C5544i0.m22546f(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@InterfaceC5816d Transition transition2) {
                C5544i0.m22546f(transition2, "transition");
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }

    @RequiresApi(19)
    @InterfaceC5816d
    public static final Transition.TransitionListener doOnResume(@InterfaceC5816d Transition transition, @InterfaceC5816d final InterfaceC5506l<? super Transition, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(transition, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnResume$$inlined$addListener$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@InterfaceC5816d Transition transition2) {
                C5544i0.m22546f(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@InterfaceC5816d Transition transition2) {
                C5544i0.m22546f(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@InterfaceC5816d Transition transition2) {
                C5544i0.m22546f(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@InterfaceC5816d Transition transition2) {
                C5544i0.m22546f(transition2, "transition");
                InterfaceC5506l.this.invoke(transition2);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@InterfaceC5816d Transition transition2) {
                C5544i0.m22546f(transition2, "transition");
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }

    @RequiresApi(19)
    @InterfaceC5816d
    public static final Transition.TransitionListener doOnStart(@InterfaceC5816d Transition transition, @InterfaceC5816d final InterfaceC5506l<? super Transition, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(transition, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnStart$$inlined$addListener$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@InterfaceC5816d Transition transition2) {
                C5544i0.m22546f(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@InterfaceC5816d Transition transition2) {
                C5544i0.m22546f(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@InterfaceC5816d Transition transition2) {
                C5544i0.m22546f(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@InterfaceC5816d Transition transition2) {
                C5544i0.m22546f(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@InterfaceC5816d Transition transition2) {
                C5544i0.m22546f(transition2, "transition");
                InterfaceC5506l.this.invoke(transition2);
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }
}
