package androidx.core.animation;

import android.animation.Animator;
import androidx.annotation.RequiresApi;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import p286h.C5715y1;
import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Animator.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u001a¡\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022#\b\u0006\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001aW\u0010\f\u001a\u00020\r*\u00020\u00022#\b\u0006\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u001a2\u0010\u0010\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a2\u0010\u0012\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a2\u0010\u0013\u001a\u00020\r*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u001a2\u0010\u0014\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a2\u0010\u0015\u001a\u00020\r*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u001a2\u0010\u0016\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b¨\u0006\u0017"}, m23546d2 = {"addListener", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "onEnd", "Lkotlin/Function1;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "animator", "", "onStart", "onCancel", "onRepeat", "addPauseListener", "Landroid/animation/Animator$AnimatorPauseListener;", "onResume", "onPause", "doOnCancel", "action", "doOnEnd", "doOnPause", "doOnRepeat", "doOnResume", "doOnStart", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class AnimatorKt {
    @InterfaceC5816d
    public static final Animator.AnimatorListener addListener(@InterfaceC5816d Animator animator, @InterfaceC5816d InterfaceC5506l<? super Animator, C5715y1> interfaceC5506l, @InterfaceC5816d InterfaceC5506l<? super Animator, C5715y1> interfaceC5506l2, @InterfaceC5816d InterfaceC5506l<? super Animator, C5715y1> interfaceC5506l3, @InterfaceC5816d InterfaceC5506l<? super Animator, C5715y1> interfaceC5506l4) {
        C5544i0.m22546f(animator, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "onEnd");
        C5544i0.m22546f(interfaceC5506l2, "onStart");
        C5544i0.m22546f(interfaceC5506l3, "onCancel");
        C5544i0.m22546f(interfaceC5506l4, "onRepeat");
        AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(interfaceC5506l4, interfaceC5506l, interfaceC5506l3, interfaceC5506l2);
        animator.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    @InterfaceC5816d
    public static /* bridge */ /* synthetic */ Animator.AnimatorListener addListener$default(Animator animator, InterfaceC5506l interfaceC5506l, InterfaceC5506l interfaceC5506l2, InterfaceC5506l interfaceC5506l3, InterfaceC5506l interfaceC5506l4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            interfaceC5506l = AnimatorKt$addListener$1.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            interfaceC5506l2 = AnimatorKt$addListener$2.INSTANCE;
        }
        if ((i2 & 4) != 0) {
            interfaceC5506l3 = AnimatorKt$addListener$3.INSTANCE;
        }
        if ((i2 & 8) != 0) {
            interfaceC5506l4 = AnimatorKt$addListener$4.INSTANCE;
        }
        C5544i0.m22546f(animator, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "onEnd");
        C5544i0.m22546f(interfaceC5506l2, "onStart");
        C5544i0.m22546f(interfaceC5506l3, "onCancel");
        C5544i0.m22546f(interfaceC5506l4, "onRepeat");
        AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(interfaceC5506l4, interfaceC5506l, interfaceC5506l3, interfaceC5506l2);
        animator.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    @RequiresApi(19)
    @InterfaceC5816d
    public static final Animator.AnimatorPauseListener addPauseListener(@InterfaceC5816d Animator animator, @InterfaceC5816d InterfaceC5506l<? super Animator, C5715y1> interfaceC5506l, @InterfaceC5816d InterfaceC5506l<? super Animator, C5715y1> interfaceC5506l2) {
        C5544i0.m22546f(animator, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "onResume");
        C5544i0.m22546f(interfaceC5506l2, "onPause");
        AnimatorKt$addPauseListener$listener$1 animatorKt$addPauseListener$listener$1 = new AnimatorKt$addPauseListener$listener$1(interfaceC5506l2, interfaceC5506l);
        animator.addPauseListener(animatorKt$addPauseListener$listener$1);
        return animatorKt$addPauseListener$listener$1;
    }

    @RequiresApi(19)
    @InterfaceC5816d
    public static /* bridge */ /* synthetic */ Animator.AnimatorPauseListener addPauseListener$default(Animator animator, InterfaceC5506l interfaceC5506l, InterfaceC5506l interfaceC5506l2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            interfaceC5506l = AnimatorKt$addPauseListener$1.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            interfaceC5506l2 = AnimatorKt$addPauseListener$2.INSTANCE;
        }
        C5544i0.m22546f(animator, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "onResume");
        C5544i0.m22546f(interfaceC5506l2, "onPause");
        AnimatorKt$addPauseListener$listener$1 animatorKt$addPauseListener$listener$1 = new AnimatorKt$addPauseListener$listener$1(interfaceC5506l2, interfaceC5506l);
        animator.addPauseListener(animatorKt$addPauseListener$listener$1);
        return animatorKt$addPauseListener$listener$1;
    }

    @InterfaceC5816d
    public static final Animator.AnimatorListener doOnCancel(@InterfaceC5816d Animator animator, @InterfaceC5816d final InterfaceC5506l<? super Animator, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(animator, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "action");
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnCancel$$inlined$addListener$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@InterfaceC5816d Animator animator2) {
                C5544i0.m22546f(animator2, "animator");
                InterfaceC5506l.this.invoke(animator2);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@InterfaceC5816d Animator animator2) {
                C5544i0.m22546f(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@InterfaceC5816d Animator animator2) {
                C5544i0.m22546f(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@InterfaceC5816d Animator animator2) {
                C5544i0.m22546f(animator2, "animator");
            }
        };
        animator.addListener(animatorListener);
        return animatorListener;
    }

    @InterfaceC5816d
    public static final Animator.AnimatorListener doOnEnd(@InterfaceC5816d Animator animator, @InterfaceC5816d final InterfaceC5506l<? super Animator, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(animator, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "action");
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnEnd$$inlined$addListener$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@InterfaceC5816d Animator animator2) {
                C5544i0.m22546f(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@InterfaceC5816d Animator animator2) {
                C5544i0.m22546f(animator2, "animator");
                InterfaceC5506l.this.invoke(animator2);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@InterfaceC5816d Animator animator2) {
                C5544i0.m22546f(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@InterfaceC5816d Animator animator2) {
                C5544i0.m22546f(animator2, "animator");
            }
        };
        animator.addListener(animatorListener);
        return animatorListener;
    }

    @RequiresApi(19)
    @InterfaceC5816d
    public static final Animator.AnimatorPauseListener doOnPause(@InterfaceC5816d Animator animator, @InterfaceC5816d final InterfaceC5506l<? super Animator, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(animator, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "action");
        Animator.AnimatorPauseListener animatorPauseListener = new Animator.AnimatorPauseListener() { // from class: androidx.core.animation.AnimatorKt$doOnPause$$inlined$addPauseListener$1
            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationPause(@InterfaceC5816d Animator animator2) {
                C5544i0.m22546f(animator2, "animator");
                InterfaceC5506l.this.invoke(animator2);
            }

            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationResume(@InterfaceC5816d Animator animator2) {
                C5544i0.m22546f(animator2, "animator");
            }
        };
        animator.addPauseListener(animatorPauseListener);
        return animatorPauseListener;
    }

    @InterfaceC5816d
    public static final Animator.AnimatorListener doOnRepeat(@InterfaceC5816d Animator animator, @InterfaceC5816d final InterfaceC5506l<? super Animator, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(animator, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "action");
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnRepeat$$inlined$addListener$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@InterfaceC5816d Animator animator2) {
                C5544i0.m22546f(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@InterfaceC5816d Animator animator2) {
                C5544i0.m22546f(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@InterfaceC5816d Animator animator2) {
                C5544i0.m22546f(animator2, "animator");
                InterfaceC5506l.this.invoke(animator2);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@InterfaceC5816d Animator animator2) {
                C5544i0.m22546f(animator2, "animator");
            }
        };
        animator.addListener(animatorListener);
        return animatorListener;
    }

    @RequiresApi(19)
    @InterfaceC5816d
    public static final Animator.AnimatorPauseListener doOnResume(@InterfaceC5816d Animator animator, @InterfaceC5816d final InterfaceC5506l<? super Animator, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(animator, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "action");
        Animator.AnimatorPauseListener animatorPauseListener = new Animator.AnimatorPauseListener() { // from class: androidx.core.animation.AnimatorKt$doOnResume$$inlined$addPauseListener$1
            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationPause(@InterfaceC5816d Animator animator2) {
                C5544i0.m22546f(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationResume(@InterfaceC5816d Animator animator2) {
                C5544i0.m22546f(animator2, "animator");
                InterfaceC5506l.this.invoke(animator2);
            }
        };
        animator.addPauseListener(animatorPauseListener);
        return animatorPauseListener;
    }

    @InterfaceC5816d
    public static final Animator.AnimatorListener doOnStart(@InterfaceC5816d Animator animator, @InterfaceC5816d final InterfaceC5506l<? super Animator, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(animator, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "action");
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnStart$$inlined$addListener$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@InterfaceC5816d Animator animator2) {
                C5544i0.m22546f(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@InterfaceC5816d Animator animator2) {
                C5544i0.m22546f(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@InterfaceC5816d Animator animator2) {
                C5544i0.m22546f(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@InterfaceC5816d Animator animator2) {
                C5544i0.m22546f(animator2, "animator");
                InterfaceC5506l.this.invoke(animator2);
            }
        };
        animator.addListener(animatorListener);
        return animatorListener;
    }
}
