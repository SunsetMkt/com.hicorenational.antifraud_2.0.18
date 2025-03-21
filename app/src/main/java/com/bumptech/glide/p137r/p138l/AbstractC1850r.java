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
import androidx.annotation.CallSuper;
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

/* compiled from: ViewTarget.java */
@Deprecated
/* renamed from: com.bumptech.glide.r.l.r */
/* loaded from: classes.dex */
public abstract class AbstractC1850r<T extends View, Z> extends AbstractC1834b<Z> {

    /* renamed from: g */
    private static final String f5419g = "ViewTarget";

    /* renamed from: h */
    private static boolean f5420h;

    /* renamed from: i */
    private static int f5421i = C1574R.id.glide_custom_view_target_tag;

    /* renamed from: b */
    protected final T f5422b;

    /* renamed from: c */
    private final b f5423c;

    /* renamed from: d */
    @Nullable
    private View.OnAttachStateChangeListener f5424d;

    /* renamed from: e */
    private boolean f5425e;

    /* renamed from: f */
    private boolean f5426f;

    /* compiled from: ViewTarget.java */
    /* renamed from: com.bumptech.glide.r.l.r$a */
    class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            AbstractC1850r.this.m4920e();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            AbstractC1850r.this.m4919d();
        }
    }

    public AbstractC1850r(@NonNull T t) {
        this.f5422b = (T) C1876j.m4985a(t);
        this.f5423c = new b(t);
    }

    @Nullable
    /* renamed from: g */
    private Object m4915g() {
        return this.f5422b.getTag(f5421i);
    }

    /* renamed from: h */
    private void m4916h() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f5424d;
        if (onAttachStateChangeListener == null || this.f5426f) {
            return;
        }
        this.f5422b.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f5426f = true;
    }

    /* renamed from: i */
    private void m4917i() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f5424d;
        if (onAttachStateChangeListener == null || !this.f5426f) {
            return;
        }
        this.f5422b.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f5426f = false;
    }

    @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
    @CallSuper
    /* renamed from: a */
    public void mo3708a(@NonNull InterfaceC1847o interfaceC1847o) {
        this.f5423c.m4932b(interfaceC1847o);
    }

    @Override // com.bumptech.glide.p137r.p138l.AbstractC1834b, com.bumptech.glide.p137r.p138l.InterfaceC1848p
    @CallSuper
    /* renamed from: b */
    public void mo3710b(@Nullable Drawable drawable) {
        super.mo3710b(drawable);
        m4916h();
    }

    @NonNull
    /* renamed from: c */
    public final AbstractC1850r<T, Z> m4918c() {
        if (this.f5424d != null) {
            return this;
        }
        this.f5424d = new a();
        m4916h();
        return this;
    }

    /* renamed from: d */
    void m4919d() {
        InterfaceC1825d mo3705a = mo3705a();
        if (mo3705a != null) {
            this.f5425e = true;
            mo3705a.clear();
            this.f5425e = false;
        }
    }

    /* renamed from: e */
    void m4920e() {
        InterfaceC1825d mo3705a = mo3705a();
        if (mo3705a == null || !mo3705a.mo4808b()) {
            return;
        }
        mo3705a.mo4809c();
    }

    @NonNull
    /* renamed from: f */
    public final AbstractC1850r<T, Z> m4921f() {
        this.f5423c.f5432c = true;
        return this;
    }

    @NonNull
    public T getView() {
        return this.f5422b;
    }

    public String toString() {
        return "Target for: " + this.f5422b;
    }

    /* compiled from: ViewTarget.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.r.l.r$b */
    static final class b {

        /* renamed from: e */
        private static final int f5428e = 0;

        /* renamed from: f */
        @Nullable
        @VisibleForTesting
        static Integer f5429f;

        /* renamed from: a */
        private final View f5430a;

        /* renamed from: b */
        private final List<InterfaceC1847o> f5431b = new ArrayList();

        /* renamed from: c */
        boolean f5432c;

        /* renamed from: d */
        @Nullable
        private a f5433d;

        /* compiled from: ViewTarget.java */
        /* renamed from: com.bumptech.glide.r.l.r$b$a */
        private static final class a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a */
            private final WeakReference<b> f5434a;

            a(@NonNull b bVar) {
                this.f5434a = new WeakReference<>(bVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable(AbstractC1850r.f5419g, 2)) {
                    String str = "OnGlobalLayoutListener called attachStateListener=" + this;
                }
                b bVar = this.f5434a.get();
                if (bVar == null) {
                    return true;
                }
                bVar.m4929a();
                return true;
            }
        }

        b(@NonNull View view) {
            this.f5430a = view;
        }

        /* renamed from: a */
        private static int m4923a(@NonNull Context context) {
            if (f5429f == null) {
                Display defaultDisplay = ((WindowManager) C1876j.m4985a((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f5429f = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f5429f.intValue();
        }

        /* renamed from: a */
        private boolean m4924a(int i2) {
            return i2 > 0 || i2 == Integer.MIN_VALUE;
        }

        /* renamed from: b */
        private void m4926b(int i2, int i3) {
            Iterator it = new ArrayList(this.f5431b).iterator();
            while (it.hasNext()) {
                ((InterfaceC1847o) it.next()).mo4867a(i2, i3);
            }
        }

        /* renamed from: c */
        private int m4927c() {
            int paddingTop = this.f5430a.getPaddingTop() + this.f5430a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f5430a.getLayoutParams();
            return m4922a(this.f5430a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        /* renamed from: d */
        private int m4928d() {
            int paddingLeft = this.f5430a.getPaddingLeft() + this.f5430a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f5430a.getLayoutParams();
            return m4922a(this.f5430a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        /* renamed from: b */
        void m4932b(@NonNull InterfaceC1847o interfaceC1847o) {
            this.f5431b.remove(interfaceC1847o);
        }

        /* renamed from: b */
        void m4931b() {
            ViewTreeObserver viewTreeObserver = this.f5430a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f5433d);
            }
            this.f5433d = null;
            this.f5431b.clear();
        }

        /* renamed from: a */
        void m4929a() {
            if (this.f5431b.isEmpty()) {
                return;
            }
            int m4928d = m4928d();
            int m4927c = m4927c();
            if (m4925a(m4928d, m4927c)) {
                m4926b(m4928d, m4927c);
                m4931b();
            }
        }

        /* renamed from: a */
        void m4930a(@NonNull InterfaceC1847o interfaceC1847o) {
            int m4928d = m4928d();
            int m4927c = m4927c();
            if (m4925a(m4928d, m4927c)) {
                interfaceC1847o.mo4867a(m4928d, m4927c);
                return;
            }
            if (!this.f5431b.contains(interfaceC1847o)) {
                this.f5431b.add(interfaceC1847o);
            }
            if (this.f5433d == null) {
                ViewTreeObserver viewTreeObserver = this.f5430a.getViewTreeObserver();
                this.f5433d = new a(this);
                viewTreeObserver.addOnPreDrawListener(this.f5433d);
            }
        }

        /* renamed from: a */
        private boolean m4925a(int i2, int i3) {
            return m4924a(i2) && m4924a(i3);
        }

        /* renamed from: a */
        private int m4922a(int i2, int i3, int i4) {
            int i5 = i3 - i4;
            if (i5 > 0) {
                return i5;
            }
            if (this.f5432c && this.f5430a.isLayoutRequested()) {
                return 0;
            }
            int i6 = i2 - i4;
            if (i6 > 0) {
                return i6;
            }
            if (this.f5430a.isLayoutRequested() || i3 != -2) {
                return 0;
            }
            Log.isLoggable(AbstractC1850r.f5419g, 4);
            return m4923a(this.f5430a.getContext());
        }
    }

    @Override // com.bumptech.glide.p137r.p138l.AbstractC1834b, com.bumptech.glide.p137r.p138l.InterfaceC1848p
    /* renamed from: a */
    public void mo3707a(@Nullable InterfaceC1825d interfaceC1825d) {
        m4914a((Object) interfaceC1825d);
    }

    @Override // com.bumptech.glide.p137r.p138l.AbstractC1834b, com.bumptech.glide.p137r.p138l.InterfaceC1848p
    @Nullable
    /* renamed from: a */
    public InterfaceC1825d mo3705a() {
        Object m4915g = m4915g();
        if (m4915g == null) {
            return null;
        }
        if (m4915g instanceof InterfaceC1825d) {
            return (InterfaceC1825d) m4915g;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
    @CallSuper
    /* renamed from: b */
    public void mo3711b(@NonNull InterfaceC1847o interfaceC1847o) {
        this.f5423c.m4930a(interfaceC1847o);
    }

    @Deprecated
    public AbstractC1850r(@NonNull T t, boolean z) {
        this(t);
        if (z) {
            m4921f();
        }
    }

    @Override // com.bumptech.glide.p137r.p138l.AbstractC1834b, com.bumptech.glide.p137r.p138l.InterfaceC1848p
    @CallSuper
    /* renamed from: c */
    public void mo3712c(@Nullable Drawable drawable) {
        super.mo3712c(drawable);
        this.f5423c.m4931b();
        if (this.f5425e) {
            return;
        }
        m4917i();
    }

    /* renamed from: a */
    private void m4914a(@Nullable Object obj) {
        f5420h = true;
        this.f5422b.setTag(f5421i, obj);
    }

    @Deprecated
    /* renamed from: a */
    public static void m4913a(int i2) {
        if (!f5420h) {
            f5421i = i2;
            return;
        }
        throw new IllegalArgumentException("You cannot set the tag id more than once or change the tag id after the first request has been made");
    }
}
