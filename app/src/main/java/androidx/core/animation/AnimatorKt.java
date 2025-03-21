package androidx.core.animation;

import android.animation.Animator;
import androidx.annotation.RequiresApi;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import h.q2.s.l;
import h.q2.t.i0;
import h.y;
import h.y1;
import i.c.a.d;

/* compiled from: Animator.kt */
@y(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u001a¡\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022#\b\u0006\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001aW\u0010\f\u001a\u00020\r*\u00020\u00022#\b\u0006\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u001a2\u0010\u0010\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a2\u0010\u0012\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a2\u0010\u0013\u001a\u00020\r*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u001a2\u0010\u0014\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a2\u0010\u0015\u001a\u00020\r*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u001a2\u0010\u0016\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b¨\u0006\u0017"}, d2 = {"addListener", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "onEnd", "Lkotlin/Function1;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "animator", "", "onStart", "onCancel", "onRepeat", "addPauseListener", "Landroid/animation/Animator$AnimatorPauseListener;", "onResume", "onPause", "doOnCancel", "action", "doOnEnd", "doOnPause", "doOnRepeat", "doOnResume", "doOnStart", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class AnimatorKt {
    @d
    public static final Animator.AnimatorListener addListener(@d Animator animator, @d l<? super Animator, y1> lVar, @d l<? super Animator, y1> lVar2, @d l<? super Animator, y1> lVar3, @d l<? super Animator, y1> lVar4) {
        i0.f(animator, "$receiver");
        i0.f(lVar, "onEnd");
        i0.f(lVar2, "onStart");
        i0.f(lVar3, "onCancel");
        i0.f(lVar4, "onRepeat");
        AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(lVar4, lVar, lVar3, lVar2);
        animator.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    @d
    public static /* bridge */ /* synthetic */ Animator.AnimatorListener addListener$default(Animator animator, l lVar, l lVar2, l lVar3, l lVar4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            lVar = AnimatorKt$addListener$1.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            lVar2 = AnimatorKt$addListener$2.INSTANCE;
        }
        if ((i2 & 4) != 0) {
            lVar3 = AnimatorKt$addListener$3.INSTANCE;
        }
        if ((i2 & 8) != 0) {
            lVar4 = AnimatorKt$addListener$4.INSTANCE;
        }
        i0.f(animator, "$receiver");
        i0.f(lVar, "onEnd");
        i0.f(lVar2, "onStart");
        i0.f(lVar3, "onCancel");
        i0.f(lVar4, "onRepeat");
        AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(lVar4, lVar, lVar3, lVar2);
        animator.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    @RequiresApi(19)
    @d
    public static final Animator.AnimatorPauseListener addPauseListener(@d Animator animator, @d l<? super Animator, y1> lVar, @d l<? super Animator, y1> lVar2) {
        i0.f(animator, "$receiver");
        i0.f(lVar, "onResume");
        i0.f(lVar2, "onPause");
        AnimatorKt$addPauseListener$listener$1 animatorKt$addPauseListener$listener$1 = new AnimatorKt$addPauseListener$listener$1(lVar2, lVar);
        animator.addPauseListener(animatorKt$addPauseListener$listener$1);
        return animatorKt$addPauseListener$listener$1;
    }

    @RequiresApi(19)
    @d
    public static /* bridge */ /* synthetic */ Animator.AnimatorPauseListener addPauseListener$default(Animator animator, l lVar, l lVar2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            lVar = AnimatorKt$addPauseListener$1.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            lVar2 = AnimatorKt$addPauseListener$2.INSTANCE;
        }
        i0.f(animator, "$receiver");
        i0.f(lVar, "onResume");
        i0.f(lVar2, "onPause");
        AnimatorKt$addPauseListener$listener$1 animatorKt$addPauseListener$listener$1 = new AnimatorKt$addPauseListener$listener$1(lVar2, lVar);
        animator.addPauseListener(animatorKt$addPauseListener$listener$1);
        return animatorKt$addPauseListener$listener$1;
    }

    @d
    public static final Animator.AnimatorListener doOnCancel(@d Animator animator, @d final l<? super Animator, y1> lVar) {
        i0.f(animator, "$receiver");
        i0.f(lVar, "action");
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnCancel$$inlined$addListener$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@d Animator animator2) {
                i0.f(animator2, "animator");
                l.this.invoke(animator2);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@d Animator animator2) {
                i0.f(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@d Animator animator2) {
                i0.f(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@d Animator animator2) {
                i0.f(animator2, "animator");
            }
        };
        animator.addListener(animatorListener);
        return animatorListener;
    }

    @d
    public static final Animator.AnimatorListener doOnEnd(@d Animator animator, @d final l<? super Animator, y1> lVar) {
        i0.f(animator, "$receiver");
        i0.f(lVar, "action");
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnEnd$$inlined$addListener$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@d Animator animator2) {
                i0.f(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@d Animator animator2) {
                i0.f(animator2, "animator");
                l.this.invoke(animator2);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@d Animator animator2) {
                i0.f(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@d Animator animator2) {
                i0.f(animator2, "animator");
            }
        };
        animator.addListener(animatorListener);
        return animatorListener;
    }

    @RequiresApi(19)
    @d
    public static final Animator.AnimatorPauseListener doOnPause(@d Animator animator, @d final l<? super Animator, y1> lVar) {
        i0.f(animator, "$receiver");
        i0.f(lVar, "action");
        Animator.AnimatorPauseListener animatorPauseListener = new Animator.AnimatorPauseListener() { // from class: androidx.core.animation.AnimatorKt$doOnPause$$inlined$addPauseListener$1
            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationPause(@d Animator animator2) {
                i0.f(animator2, "animator");
                l.this.invoke(animator2);
            }

            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationResume(@d Animator animator2) {
                i0.f(animator2, "animator");
            }
        };
        animator.addPauseListener(animatorPauseListener);
        return animatorPauseListener;
    }

    @d
    public static final Animator.AnimatorListener doOnRepeat(@d Animator animator, @d final l<? super Animator, y1> lVar) {
        i0.f(animator, "$receiver");
        i0.f(lVar, "action");
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnRepeat$$inlined$addListener$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@d Animator animator2) {
                i0.f(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@d Animator animator2) {
                i0.f(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@d Animator animator2) {
                i0.f(animator2, "animator");
                l.this.invoke(animator2);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@d Animator animator2) {
                i0.f(animator2, "animator");
            }
        };
        animator.addListener(animatorListener);
        return animatorListener;
    }

    @RequiresApi(19)
    @d
    public static final Animator.AnimatorPauseListener doOnResume(@d Animator animator, @d final l<? super Animator, y1> lVar) {
        i0.f(animator, "$receiver");
        i0.f(lVar, "action");
        Animator.AnimatorPauseListener animatorPauseListener = new Animator.AnimatorPauseListener() { // from class: androidx.core.animation.AnimatorKt$doOnResume$$inlined$addPauseListener$1
            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationPause(@d Animator animator2) {
                i0.f(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationResume(@d Animator animator2) {
                i0.f(animator2, "animator");
                l.this.invoke(animator2);
            }
        };
        animator.addPauseListener(animatorPauseListener);
        return animatorPauseListener;
    }

    @d
    public static final Animator.AnimatorListener doOnStart(@d Animator animator, @d final l<? super Animator, y1> lVar) {
        i0.f(animator, "$receiver");
        i0.f(lVar, "action");
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnStart$$inlined$addListener$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@d Animator animator2) {
                i0.f(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@d Animator animator2) {
                i0.f(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@d Animator animator2) {
                i0.f(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@d Animator animator2) {
                i0.f(animator2, "animator");
                l.this.invoke(animator2);
            }
        };
        animator.addListener(animatorListener);
        return animatorListener;
    }
}
