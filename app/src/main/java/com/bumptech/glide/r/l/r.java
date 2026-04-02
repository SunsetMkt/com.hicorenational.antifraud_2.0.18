package com.bumptech.glide.r.l;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ViewTarget.java */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class r<T extends View, Z> extends com.bumptech.glide.r.l.b<Z> {

    /* JADX INFO: renamed from: g */
    private static final String f3523g = "ViewTarget";

    /* JADX INFO: renamed from: h */
    private static boolean f3524h;

    /* JADX INFO: renamed from: i */
    private static int f3525i = R.id.glide_custom_view_target_tag;

    /* JADX INFO: renamed from: b */
    protected final T f3526b;

    /* JADX INFO: renamed from: c */
    private final b f3527c;

    /* JADX INFO: renamed from: d */
    @Nullable
    private View.OnAttachStateChangeListener f3528d;

    /* JADX INFO: renamed from: e */
    private boolean f3529e;

    /* JADX INFO: renamed from: f */
    private boolean f3530f;

    /* JADX INFO: compiled from: ViewTarget.java */
    class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            r.this.e();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            r.this.d();
        }
    }

    public r(@NonNull T t) {
        this.f3526b = (T) com.bumptech.glide.util.j.a(t);
        this.f3527c = new b(t);
    }

    @Nullable
    private Object g() {
        return this.f3526b.getTag(f3525i);
    }

    private void h() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f3528d;
        if (onAttachStateChangeListener == null || this.f3530f) {
            return;
        }
        this.f3526b.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f3530f = true;
    }

    private void i() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f3528d;
        if (onAttachStateChangeListener == null || !this.f3530f) {
            return;
        }
        this.f3526b.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f3530f = false;
    }

    @Override // com.bumptech.glide.r.l.p
    @CallSuper
    public void a(@NonNull o oVar) {
        this.f3527c.b(oVar);
    }

    @Override // com.bumptech.glide.r.l.b, com.bumptech.glide.r.l.p
    @CallSuper
    public void b(@Nullable Drawable drawable) {
        super.b(drawable);
        h();
    }

    @NonNull
    public final r<T, Z> c() {
        if (this.f3528d != null) {
            return this;
        }
        this.f3528d = new a();
        h();
        return this;
    }

    void d() {
        com.bumptech.glide.r.d dVarA = a();
        if (dVarA != null) {
            this.f3529e = true;
            dVarA.clear();
            this.f3529e = false;
        }
    }

    void e() {
        com.bumptech.glide.r.d dVarA = a();
        if (dVarA == null || !dVarA.b()) {
            return;
        }
        dVarA.c();
    }

    @NonNull
    public final r<T, Z> f() {
        this.f3527c.f3534c = true;
        return this;
    }

    @NonNull
    public T getView() {
        return this.f3526b;
    }

    public String toString() {
        return "Target for: " + this.f3526b;
    }

    /* JADX INFO: compiled from: ViewTarget.java */
    @VisibleForTesting
    static final class b {

        /* JADX INFO: renamed from: e */
        private static final int f3531e = 0;

        /* JADX INFO: renamed from: f */
        @Nullable
        @VisibleForTesting
        static Integer f3532f;
        private final View a;

        /* JADX INFO: renamed from: b */
        private final List<o> f3533b = new ArrayList();

        /* JADX INFO: renamed from: c */
        boolean f3534c;

        /* JADX INFO: renamed from: d */
        @Nullable
        private a f3535d;

        /* JADX INFO: compiled from: ViewTarget.java */
        private static final class a implements ViewTreeObserver.OnPreDrawListener {
            private final WeakReference<b> a;

            a(@NonNull b bVar) {
                this.a = new WeakReference<>(bVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable(r.f3523g, 2)) {
                    String str = "OnGlobalLayoutListener called attachStateListener=" + this;
                }
                b bVar = this.a.get();
                if (bVar == null) {
                    return true;
                }
                bVar.a();
                return true;
            }
        }

        b(@NonNull View view) {
            this.a = view;
        }

        private static int a(@NonNull Context context) {
            if (f3532f == null) {
                Display defaultDisplay = ((WindowManager) com.bumptech.glide.util.j.a((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f3532f = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f3532f.intValue();
        }

        private boolean a(int i2) {
            return i2 > 0 || i2 == Integer.MIN_VALUE;
        }

        private void b(int i2, int i3) {
            Iterator it = new ArrayList(this.f3533b).iterator();
            while (it.hasNext()) {
                ((o) it.next()).a(i2, i3);
            }
        }

        private int c() {
            int paddingTop = this.a.getPaddingTop() + this.a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            return a(this.a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        private int d() {
            int paddingLeft = this.a.getPaddingLeft() + this.a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            return a(this.a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        void b(@NonNull o oVar) {
            this.f3533b.remove(oVar);
        }

        void b() {
            ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f3535d);
            }
            this.f3535d = null;
            this.f3533b.clear();
        }

        void a() {
            if (this.f3533b.isEmpty()) {
                return;
            }
            int iD = d();
            int iC = c();
            if (a(iD, iC)) {
                b(iD, iC);
                b();
            }
        }

        void a(@NonNull o oVar) {
            int iD = d();
            int iC = c();
            if (a(iD, iC)) {
                oVar.a(iD, iC);
                return;
            }
            if (!this.f3533b.contains(oVar)) {
                this.f3533b.add(oVar);
            }
            if (this.f3535d == null) {
                ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
                this.f3535d = new a(this);
                viewTreeObserver.addOnPreDrawListener(this.f3535d);
            }
        }

        private boolean a(int i2, int i3) {
            return a(i2) && a(i3);
        }

        private int a(int i2, int i3, int i4) {
            int i5 = i3 - i4;
            if (i5 > 0) {
                return i5;
            }
            if (this.f3534c && this.a.isLayoutRequested()) {
                return 0;
            }
            int i6 = i2 - i4;
            if (i6 > 0) {
                return i6;
            }
            if (this.a.isLayoutRequested() || i3 != -2) {
                return 0;
            }
            Log.isLoggable(r.f3523g, 4);
            return a(this.a.getContext());
        }
    }

    @Override // com.bumptech.glide.r.l.b, com.bumptech.glide.r.l.p
    public void a(@Nullable com.bumptech.glide.r.d dVar) {
        a((Object) dVar);
    }

    @Override // com.bumptech.glide.r.l.b, com.bumptech.glide.r.l.p
    @Nullable
    public com.bumptech.glide.r.d a() {
        Object objG = g();
        if (objG == null) {
            return null;
        }
        if (objG instanceof com.bumptech.glide.r.d) {
            return (com.bumptech.glide.r.d) objG;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    @Override // com.bumptech.glide.r.l.p
    @CallSuper
    public void b(@NonNull o oVar) {
        this.f3527c.a(oVar);
    }

    @Deprecated
    public r(@NonNull T t, boolean z) {
        this(t);
        if (z) {
            f();
        }
    }

    @Override // com.bumptech.glide.r.l.b, com.bumptech.glide.r.l.p
    @CallSuper
    public void c(@Nullable Drawable drawable) {
        super.c(drawable);
        this.f3527c.b();
        if (this.f3529e) {
            return;
        }
        i();
    }

    private void a(@Nullable Object obj) {
        f3524h = true;
        this.f3526b.setTag(f3525i, obj);
    }

    @Deprecated
    public static void a(int i2) {
        if (!f3524h) {
            f3525i = i2;
            return;
        }
        throw new IllegalArgumentException("You cannot set the tag id more than once or change the tag id after the first request has been made");
    }
}
