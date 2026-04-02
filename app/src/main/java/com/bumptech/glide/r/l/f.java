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
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: CustomViewTarget.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class f<T extends View, Z> implements p<Z> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f3493f = "CustomViewTarget";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @IdRes
    private static final int f3494g = R.id.glide_custom_view_target_tag;
    private final b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final T f3495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private View.OnAttachStateChangeListener f3496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3497d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f3498e;

    /* JADX INFO: compiled from: CustomViewTarget.java */
    class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            f.this.e();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            f.this.d();
        }
    }

    public f(@NonNull T t) {
        this.f3495b = (T) com.bumptech.glide.util.j.a(t);
        this.a = new b(t);
    }

    @Nullable
    private Object g() {
        return this.f3495b.getTag(f3494g);
    }

    private void h() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f3496c;
        if (onAttachStateChangeListener == null || this.f3498e) {
            return;
        }
        this.f3495b.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f3498e = true;
    }

    private void i() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f3496c;
        if (onAttachStateChangeListener == null || !this.f3498e) {
            return;
        }
        this.f3495b.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f3498e = false;
    }

    @Deprecated
    public final f<T, Z> a(@IdRes int i2) {
        return this;
    }

    @Override // com.bumptech.glide.r.l.p
    public final void a(@NonNull o oVar) {
        this.a.b(oVar);
    }

    @NonNull
    public final f<T, Z> b() {
        if (this.f3496c != null) {
            return this;
        }
        this.f3496c = new a();
        h();
        return this;
    }

    @NonNull
    public final T c() {
        return this.f3495b;
    }

    final void d() {
        com.bumptech.glide.r.d dVarA = a();
        if (dVarA != null) {
            this.f3497d = true;
            dVarA.clear();
            this.f3497d = false;
        }
    }

    protected abstract void d(@Nullable Drawable drawable);

    final void e() {
        com.bumptech.glide.r.d dVarA = a();
        if (dVarA == null || !dVarA.b()) {
            return;
        }
        dVarA.c();
    }

    protected void e(@Nullable Drawable drawable) {
    }

    @NonNull
    public final f<T, Z> f() {
        this.a.f3502c = true;
        return this;
    }

    @Override // com.bumptech.glide.manager.i
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.i
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.i
    public void onStop() {
    }

    public String toString() {
        return "Target for: " + this.f3495b;
    }

    /* JADX INFO: compiled from: CustomViewTarget.java */
    @VisibleForTesting
    static final class b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final int f3499e = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        @VisibleForTesting
        static Integer f3500f;
        private final View a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<o> f3501b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f3502c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        private a f3503d;

        /* JADX INFO: compiled from: CustomViewTarget.java */
        private static final class a implements ViewTreeObserver.OnPreDrawListener {
            private final WeakReference<b> a;

            a(@NonNull b bVar) {
                this.a = new WeakReference<>(bVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable(f.f3493f, 2)) {
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
            if (f3500f == null) {
                Display defaultDisplay = ((WindowManager) com.bumptech.glide.util.j.a((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f3500f = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f3500f.intValue();
        }

        private boolean a(int i2) {
            return i2 > 0 || i2 == Integer.MIN_VALUE;
        }

        private void b(int i2, int i3) {
            Iterator it = new ArrayList(this.f3501b).iterator();
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
            this.f3501b.remove(oVar);
        }

        void b() {
            ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f3503d);
            }
            this.f3503d = null;
            this.f3501b.clear();
        }

        void a() {
            if (this.f3501b.isEmpty()) {
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
            if (!this.f3501b.contains(oVar)) {
                this.f3501b.add(oVar);
            }
            if (this.f3503d == null) {
                ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
                this.f3503d = new a(this);
                viewTreeObserver.addOnPreDrawListener(this.f3503d);
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
            if (this.f3502c && this.a.isLayoutRequested()) {
                return 0;
            }
            int i6 = i2 - i4;
            if (i6 > 0) {
                return i6;
            }
            if (this.a.isLayoutRequested() || i3 != -2) {
                return 0;
            }
            Log.isLoggable(f.f3493f, 4);
            return a(this.a.getContext());
        }
    }

    @Override // com.bumptech.glide.r.l.p
    public final void a(@Nullable com.bumptech.glide.r.d dVar) {
        a((Object) dVar);
    }

    @Override // com.bumptech.glide.r.l.p
    public final void c(@Nullable Drawable drawable) {
        this.a.b();
        d(drawable);
        if (this.f3497d) {
            return;
        }
        i();
    }

    @Override // com.bumptech.glide.r.l.p
    @Nullable
    public final com.bumptech.glide.r.d a() {
        Object objG = g();
        if (objG == null) {
            return null;
        }
        if (objG instanceof com.bumptech.glide.r.d) {
            return (com.bumptech.glide.r.d) objG;
        }
        throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
    }

    @Override // com.bumptech.glide.r.l.p
    public final void b(@NonNull o oVar) {
        this.a.a(oVar);
    }

    @Override // com.bumptech.glide.r.l.p
    public final void b(@Nullable Drawable drawable) {
        h();
        e(drawable);
    }

    private void a(@Nullable Object obj) {
        this.f3495b.setTag(f3494g, obj);
    }
}
