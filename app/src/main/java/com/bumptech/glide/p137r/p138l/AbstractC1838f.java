package com.bumptech.glide.p137r.p138l;

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
import com.bumptech.glide.C1574R;
import com.bumptech.glide.p137r.InterfaceC1825d;
import com.bumptech.glide.util.C1876j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: CustomViewTarget.java */
/* renamed from: com.bumptech.glide.r.l.f */
/* loaded from: classes.dex */
public abstract class AbstractC1838f<T extends View, Z> implements InterfaceC1848p<Z> {

    /* renamed from: f */
    private static final String f5382f = "CustomViewTarget";

    /* renamed from: g */
    @IdRes
    private static final int f5383g = C1574R.id.glide_custom_view_target_tag;

    /* renamed from: a */
    private final b f5384a;

    /* renamed from: b */
    protected final T f5385b;

    /* renamed from: c */
    @Nullable
    private View.OnAttachStateChangeListener f5386c;

    /* renamed from: d */
    private boolean f5387d;

    /* renamed from: e */
    private boolean f5388e;

    /* compiled from: CustomViewTarget.java */
    /* renamed from: com.bumptech.glide.r.l.f$a */
    class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            AbstractC1838f.this.m4886e();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            AbstractC1838f.this.m4885d();
        }
    }

    public AbstractC1838f(@NonNull T t) {
        this.f5385b = (T) C1876j.m4985a(t);
        this.f5384a = new b(t);
    }

    @Nullable
    /* renamed from: g */
    private Object m4879g() {
        return this.f5385b.getTag(f5383g);
    }

    /* renamed from: h */
    private void m4880h() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f5386c;
        if (onAttachStateChangeListener == null || this.f5388e) {
            return;
        }
        this.f5385b.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f5388e = true;
    }

    /* renamed from: i */
    private void m4881i() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f5386c;
        if (onAttachStateChangeListener == null || !this.f5388e) {
            return;
        }
        this.f5385b.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f5388e = false;
    }

    @Deprecated
    /* renamed from: a */
    public final AbstractC1838f<T, Z> m4882a(@IdRes int i2) {
        return this;
    }

    @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
    /* renamed from: a */
    public final void mo3708a(@NonNull InterfaceC1847o interfaceC1847o) {
        this.f5384a.m4899b(interfaceC1847o);
    }

    @NonNull
    /* renamed from: b */
    public final AbstractC1838f<T, Z> m4883b() {
        if (this.f5386c != null) {
            return this;
        }
        this.f5386c = new a();
        m4880h();
        return this;
    }

    @NonNull
    /* renamed from: c */
    public final T m4884c() {
        return this.f5385b;
    }

    /* renamed from: d */
    final void m4885d() {
        InterfaceC1825d mo3705a = mo3705a();
        if (mo3705a != null) {
            this.f5387d = true;
            mo3705a.clear();
            this.f5387d = false;
        }
    }

    /* renamed from: d */
    protected abstract void mo3805d(@Nullable Drawable drawable);

    /* renamed from: e */
    final void m4886e() {
        InterfaceC1825d mo3705a = mo3705a();
        if (mo3705a == null || !mo3705a.mo4808b()) {
            return;
        }
        mo3705a.mo4809c();
    }

    /* renamed from: e */
    protected void m4887e(@Nullable Drawable drawable) {
    }

    @NonNull
    /* renamed from: f */
    public final AbstractC1838f<T, Z> m4888f() {
        this.f5384a.f5394c = true;
        return this;
    }

    @Override // com.bumptech.glide.manager.InterfaceC1795i
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.InterfaceC1795i
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.InterfaceC1795i
    public void onStop() {
    }

    public String toString() {
        return "Target for: " + this.f5385b;
    }

    /* compiled from: CustomViewTarget.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.r.l.f$b */
    static final class b {

        /* renamed from: e */
        private static final int f5390e = 0;

        /* renamed from: f */
        @Nullable
        @VisibleForTesting
        static Integer f5391f;

        /* renamed from: a */
        private final View f5392a;

        /* renamed from: b */
        private final List<InterfaceC1847o> f5393b = new ArrayList();

        /* renamed from: c */
        boolean f5394c;

        /* renamed from: d */
        @Nullable
        private a f5395d;

        /* compiled from: CustomViewTarget.java */
        /* renamed from: com.bumptech.glide.r.l.f$b$a */
        private static final class a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a */
            private final WeakReference<b> f5396a;

            a(@NonNull b bVar) {
                this.f5396a = new WeakReference<>(bVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable(AbstractC1838f.f5382f, 2)) {
                    String str = "OnGlobalLayoutListener called attachStateListener=" + this;
                }
                b bVar = this.f5396a.get();
                if (bVar == null) {
                    return true;
                }
                bVar.m4896a();
                return true;
            }
        }

        b(@NonNull View view) {
            this.f5392a = view;
        }

        /* renamed from: a */
        private static int m4890a(@NonNull Context context) {
            if (f5391f == null) {
                Display defaultDisplay = ((WindowManager) C1876j.m4985a((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f5391f = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f5391f.intValue();
        }

        /* renamed from: a */
        private boolean m4891a(int i2) {
            return i2 > 0 || i2 == Integer.MIN_VALUE;
        }

        /* renamed from: b */
        private void m4893b(int i2, int i3) {
            Iterator it = new ArrayList(this.f5393b).iterator();
            while (it.hasNext()) {
                ((InterfaceC1847o) it.next()).mo4867a(i2, i3);
            }
        }

        /* renamed from: c */
        private int m4894c() {
            int paddingTop = this.f5392a.getPaddingTop() + this.f5392a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f5392a.getLayoutParams();
            return m4889a(this.f5392a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        /* renamed from: d */
        private int m4895d() {
            int paddingLeft = this.f5392a.getPaddingLeft() + this.f5392a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f5392a.getLayoutParams();
            return m4889a(this.f5392a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        /* renamed from: b */
        void m4899b(@NonNull InterfaceC1847o interfaceC1847o) {
            this.f5393b.remove(interfaceC1847o);
        }

        /* renamed from: b */
        void m4898b() {
            ViewTreeObserver viewTreeObserver = this.f5392a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f5395d);
            }
            this.f5395d = null;
            this.f5393b.clear();
        }

        /* renamed from: a */
        void m4896a() {
            if (this.f5393b.isEmpty()) {
                return;
            }
            int m4895d = m4895d();
            int m4894c = m4894c();
            if (m4892a(m4895d, m4894c)) {
                m4893b(m4895d, m4894c);
                m4898b();
            }
        }

        /* renamed from: a */
        void m4897a(@NonNull InterfaceC1847o interfaceC1847o) {
            int m4895d = m4895d();
            int m4894c = m4894c();
            if (m4892a(m4895d, m4894c)) {
                interfaceC1847o.mo4867a(m4895d, m4894c);
                return;
            }
            if (!this.f5393b.contains(interfaceC1847o)) {
                this.f5393b.add(interfaceC1847o);
            }
            if (this.f5395d == null) {
                ViewTreeObserver viewTreeObserver = this.f5392a.getViewTreeObserver();
                this.f5395d = new a(this);
                viewTreeObserver.addOnPreDrawListener(this.f5395d);
            }
        }

        /* renamed from: a */
        private boolean m4892a(int i2, int i3) {
            return m4891a(i2) && m4891a(i3);
        }

        /* renamed from: a */
        private int m4889a(int i2, int i3, int i4) {
            int i5 = i3 - i4;
            if (i5 > 0) {
                return i5;
            }
            if (this.f5394c && this.f5392a.isLayoutRequested()) {
                return 0;
            }
            int i6 = i2 - i4;
            if (i6 > 0) {
                return i6;
            }
            if (this.f5392a.isLayoutRequested() || i3 != -2) {
                return 0;
            }
            Log.isLoggable(AbstractC1838f.f5382f, 4);
            return m4890a(this.f5392a.getContext());
        }
    }

    @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
    /* renamed from: a */
    public final void mo3707a(@Nullable InterfaceC1825d interfaceC1825d) {
        m4878a((Object) interfaceC1825d);
    }

    @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
    /* renamed from: c */
    public final void mo3712c(@Nullable Drawable drawable) {
        this.f5384a.m4898b();
        mo3805d(drawable);
        if (this.f5387d) {
            return;
        }
        m4881i();
    }

    @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
    @Nullable
    /* renamed from: a */
    public final InterfaceC1825d mo3705a() {
        Object m4879g = m4879g();
        if (m4879g == null) {
            return null;
        }
        if (m4879g instanceof InterfaceC1825d) {
            return (InterfaceC1825d) m4879g;
        }
        throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
    }

    @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
    /* renamed from: b */
    public final void mo3711b(@NonNull InterfaceC1847o interfaceC1847o) {
        this.f5384a.m4897a(interfaceC1847o);
    }

    @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
    /* renamed from: b */
    public final void mo3710b(@Nullable Drawable drawable) {
        m4880h();
        m4887e(drawable);
    }

    /* renamed from: a */
    private void m4878a(@Nullable Object obj) {
        this.f5385b.setTag(f5383g, obj);
    }
}
