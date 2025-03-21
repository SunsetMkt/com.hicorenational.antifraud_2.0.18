package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.load.p118p.AbstractC1665j;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.C1799m;
import com.bumptech.glide.manager.C1800n;
import com.bumptech.glide.manager.InterfaceC1789c;
import com.bumptech.glide.manager.InterfaceC1790d;
import com.bumptech.glide.manager.InterfaceC1794h;
import com.bumptech.glide.manager.InterfaceC1795i;
import com.bumptech.glide.manager.InterfaceC1798l;
import com.bumptech.glide.p137r.AbstractC1822a;
import com.bumptech.glide.p137r.C1829h;
import com.bumptech.glide.p137r.InterfaceC1825d;
import com.bumptech.glide.p137r.InterfaceC1828g;
import com.bumptech.glide.p137r.p138l.AbstractC1838f;
import com.bumptech.glide.p137r.p138l.InterfaceC1848p;
import com.bumptech.glide.p137r.p139m.InterfaceC1856f;
import com.bumptech.glide.util.C1878l;
import java.io.File;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: RequestManager.java */
/* renamed from: com.bumptech.glide.k */
/* loaded from: classes.dex */
public class ComponentCallbacks2C1585k implements ComponentCallbacks2, InterfaceC1795i, InterfaceC1581g<C1584j<Drawable>> {

    /* renamed from: m */
    private static final C1829h f4158m = C1829h.m4836b((Class<?>) Bitmap.class).m4734M();

    /* renamed from: n */
    private static final C1829h f4159n = C1829h.m4836b((Class<?>) GifDrawable.class).m4734M();

    /* renamed from: o */
    private static final C1829h f4160o = C1829h.m4834b(AbstractC1665j.f4539c).m4747a(EnumC1582h.LOW).m4767b(true);

    /* renamed from: a */
    protected final ComponentCallbacks2C1576b f4161a;

    /* renamed from: b */
    protected final Context f4162b;

    /* renamed from: c */
    final InterfaceC1794h f4163c;

    /* renamed from: d */
    @GuardedBy("this")
    private final C1799m f4164d;

    /* renamed from: e */
    @GuardedBy("this")
    private final InterfaceC1798l f4165e;

    /* renamed from: f */
    @GuardedBy("this")
    private final C1800n f4166f;

    /* renamed from: g */
    private final Runnable f4167g;

    /* renamed from: h */
    private final Handler f4168h;

    /* renamed from: i */
    private final InterfaceC1789c f4169i;

    /* renamed from: j */
    private final CopyOnWriteArrayList<InterfaceC1828g<Object>> f4170j;

    /* renamed from: k */
    @GuardedBy("this")
    private C1829h f4171k;

    /* renamed from: l */
    private boolean f4172l;

    /* compiled from: RequestManager.java */
    /* renamed from: com.bumptech.glide.k$a */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ComponentCallbacks2C1585k componentCallbacks2C1585k = ComponentCallbacks2C1585k.this;
            componentCallbacks2C1585k.f4163c.mo4524a(componentCallbacks2C1585k);
        }
    }

    /* compiled from: RequestManager.java */
    /* renamed from: com.bumptech.glide.k$b */
    private static class b extends AbstractC1838f<View, Object> {
        b(@NonNull View view) {
            super(view);
        }

        @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
        /* renamed from: a */
        public void mo3706a(@Nullable Drawable drawable) {
        }

        @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
        /* renamed from: a */
        public void mo3709a(@NonNull Object obj, @Nullable InterfaceC1856f<? super Object> interfaceC1856f) {
        }

        @Override // com.bumptech.glide.p137r.p138l.AbstractC1838f
        /* renamed from: d */
        protected void mo3805d(@Nullable Drawable drawable) {
        }
    }

    /* compiled from: RequestManager.java */
    /* renamed from: com.bumptech.glide.k$c */
    private class c implements InterfaceC1789c.a {

        /* renamed from: a */
        @GuardedBy("RequestManager.this")
        private final C1799m f4174a;

        c(@NonNull C1799m c1799m) {
            this.f4174a = c1799m;
        }

        @Override // com.bumptech.glide.manager.InterfaceC1789c.a
        /* renamed from: a */
        public void mo3806a(boolean z) {
            if (z) {
                synchronized (ComponentCallbacks2C1585k.this) {
                    this.f4174a.m4561e();
                }
            }
        }
    }

    public ComponentCallbacks2C1585k(@NonNull ComponentCallbacks2C1576b componentCallbacks2C1576b, @NonNull InterfaceC1794h interfaceC1794h, @NonNull InterfaceC1798l interfaceC1798l, @NonNull Context context) {
        this(componentCallbacks2C1576b, interfaceC1794h, interfaceC1798l, new C1799m(), componentCallbacks2C1576b.m3661e(), context);
    }

    @NonNull
    /* renamed from: b */
    public synchronized ComponentCallbacks2C1585k m3788b(@NonNull C1829h c1829h) {
        m3792c(c1829h);
        return this;
    }

    /* renamed from: c */
    protected synchronized void m3792c(@NonNull C1829h c1829h) {
        this.f4171k = c1829h.mo26850clone().m4739a();
    }

    @NonNull
    @CheckResult
    /* renamed from: e */
    public C1584j<GifDrawable> m3794e() {
        return m3779a(GifDrawable.class).mo3763a((AbstractC1822a<?>) f4159n);
    }

    @NonNull
    @CheckResult
    /* renamed from: f */
    public C1584j<File> m3795f() {
        return m3779a(File.class).mo3763a((AbstractC1822a<?>) f4160o);
    }

    /* renamed from: g */
    List<InterfaceC1828g<Object>> m3796g() {
        return this.f4170j;
    }

    /* renamed from: h */
    synchronized C1829h m3797h() {
        return this.f4171k;
    }

    /* renamed from: i */
    public synchronized boolean m3798i() {
        return this.f4164d.m4556b();
    }

    /* renamed from: j */
    public synchronized void m3799j() {
        this.f4164d.m4558c();
    }

    /* renamed from: k */
    public synchronized void m3800k() {
        m3799j();
        Iterator<ComponentCallbacks2C1585k> it = this.f4165e.mo4509a().iterator();
        while (it.hasNext()) {
            it.next().m3799j();
        }
    }

    /* renamed from: l */
    public synchronized void m3801l() {
        this.f4164d.m4560d();
    }

    /* renamed from: m */
    public synchronized void m3802m() {
        m3801l();
        Iterator<ComponentCallbacks2C1585k> it = this.f4165e.mo4509a().iterator();
        while (it.hasNext()) {
            it.next().m3801l();
        }
    }

    /* renamed from: n */
    public synchronized void m3803n() {
        this.f4164d.m4562f();
    }

    /* renamed from: o */
    public synchronized void m3804o() {
        C1878l.m5007b();
        m3803n();
        Iterator<ComponentCallbacks2C1585k> it = this.f4165e.mo4509a().iterator();
        while (it.hasNext()) {
            it.next().m3803n();
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.bumptech.glide.manager.InterfaceC1795i
    public synchronized void onDestroy() {
        this.f4166f.onDestroy();
        Iterator<InterfaceC1848p<?>> it = this.f4166f.m4566c().iterator();
        while (it.hasNext()) {
            m3783a(it.next());
        }
        this.f4166f.m4564b();
        this.f4164d.m4554a();
        this.f4163c.mo4526b(this);
        this.f4163c.mo4526b(this.f4169i);
        this.f4168h.removeCallbacks(this.f4167g);
        this.f4161a.m3658b(this);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // com.bumptech.glide.manager.InterfaceC1795i
    public synchronized void onStart() {
        m3803n();
        this.f4166f.onStart();
    }

    @Override // com.bumptech.glide.manager.InterfaceC1795i
    public synchronized void onStop() {
        m3801l();
        this.f4166f.onStop();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        if (i2 == 60 && this.f4172l) {
            m3800k();
        }
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.f4164d + ", treeNode=" + this.f4165e + "}";
    }

    /* renamed from: d */
    private synchronized void m3778d(@NonNull C1829h c1829h) {
        this.f4171k = this.f4171k.mo3763a(c1829h);
    }

    @NonNull
    @CheckResult
    /* renamed from: b */
    public C1584j<Bitmap> m3786b() {
        return m3779a(Bitmap.class).mo3763a((AbstractC1822a<?>) f4158m);
    }

    @NonNull
    @CheckResult
    /* renamed from: c */
    public C1584j<Drawable> m3791c() {
        return m3779a(Drawable.class);
    }

    ComponentCallbacks2C1585k(ComponentCallbacks2C1576b componentCallbacks2C1576b, InterfaceC1794h interfaceC1794h, InterfaceC1798l interfaceC1798l, C1799m c1799m, InterfaceC1790d interfaceC1790d, Context context) {
        this.f4166f = new C1800n();
        this.f4167g = new a();
        this.f4168h = new Handler(Looper.getMainLooper());
        this.f4161a = componentCallbacks2C1576b;
        this.f4163c = interfaceC1794h;
        this.f4165e = interfaceC1798l;
        this.f4164d = c1799m;
        this.f4162b = context;
        this.f4169i = interfaceC1790d.mo4528a(context.getApplicationContext(), new c(c1799m));
        if (C1878l.m5010c()) {
            this.f4168h.post(this.f4167g);
        } else {
            interfaceC1794h.mo4524a(this);
        }
        interfaceC1794h.mo4524a(this.f4169i);
        this.f4170j = new CopyOnWriteArrayList<>(componentCallbacks2C1576b.m3663g().m3691b());
        m3792c(componentCallbacks2C1576b.m3663g().m3692c());
        componentCallbacks2C1576b.m3654a(this);
    }

    /* renamed from: c */
    private void m3777c(@NonNull InterfaceC1848p<?> interfaceC1848p) {
        boolean m3790b = m3790b(interfaceC1848p);
        InterfaceC1825d mo3705a = interfaceC1848p.mo3705a();
        if (m3790b || this.f4161a.m3656a(interfaceC1848p) || mo3705a == null) {
            return;
        }
        interfaceC1848p.mo3707a((InterfaceC1825d) null);
        mo3705a.clear();
    }

    @NonNull
    @CheckResult
    /* renamed from: b */
    public C1584j<File> m3787b(@Nullable Object obj) {
        return m3795f().mo3718a(obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.InterfaceC1581g
    @NonNull
    @CheckResult
    /* renamed from: d */
    public C1584j<Drawable> mo3722d(@Nullable Drawable drawable) {
        return m3791c().mo3722d(drawable);
    }

    /* renamed from: b */
    synchronized boolean m3790b(@NonNull InterfaceC1848p<?> interfaceC1848p) {
        InterfaceC1825d mo3705a = interfaceC1848p.mo3705a();
        if (mo3705a == null) {
            return true;
        }
        if (!this.f4164d.m4557b(mo3705a)) {
            return false;
        }
        this.f4166f.m4565b(interfaceC1848p);
        interfaceC1848p.mo3707a((InterfaceC1825d) null);
        return true;
    }

    @NonNull
    @CheckResult
    /* renamed from: d */
    public C1584j<File> m3793d() {
        return m3779a(File.class).mo3763a((AbstractC1822a<?>) C1829h.m4839e(true));
    }

    @NonNull
    /* renamed from: a */
    public synchronized ComponentCallbacks2C1585k m3781a(@NonNull C1829h c1829h) {
        m3778d(c1829h);
        return this;
    }

    /* renamed from: a */
    public ComponentCallbacks2C1585k m3780a(InterfaceC1828g<Object> interfaceC1828g) {
        this.f4170j.add(interfaceC1828g);
        return this;
    }

    /* renamed from: a */
    public void m3785a(boolean z) {
        this.f4172l = z;
    }

    @NonNull
    /* renamed from: b */
    <T> AbstractC1586l<?, T> m3789b(Class<T> cls) {
        return this.f4161a.m3663g().m3688a(cls);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.InterfaceC1581g
    @NonNull
    @CheckResult
    /* renamed from: a */
    public C1584j<Drawable> mo3714a(@Nullable Bitmap bitmap) {
        return m3791c().mo3714a(bitmap);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.InterfaceC1581g
    @NonNull
    @CheckResult
    /* renamed from: a */
    public C1584j<Drawable> mo3719a(@Nullable String str) {
        return m3791c().mo3719a(str);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.InterfaceC1581g
    @NonNull
    @CheckResult
    /* renamed from: a */
    public C1584j<Drawable> mo3715a(@Nullable Uri uri) {
        return m3791c().mo3715a(uri);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.InterfaceC1581g
    @NonNull
    @CheckResult
    /* renamed from: a */
    public C1584j<Drawable> mo3716a(@Nullable File file) {
        return m3791c().mo3716a(file);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.InterfaceC1581g
    @NonNull
    @CheckResult
    /* renamed from: a */
    public C1584j<Drawable> mo3717a(@Nullable @DrawableRes @RawRes Integer num) {
        return m3791c().mo3717a(num);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.InterfaceC1581g
    @CheckResult
    @Deprecated
    /* renamed from: a */
    public C1584j<Drawable> mo3720a(@Nullable URL url) {
        return m3791c().mo3720a(url);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.InterfaceC1581g
    @NonNull
    @CheckResult
    /* renamed from: a */
    public C1584j<Drawable> mo3721a(@Nullable byte[] bArr) {
        return m3791c().mo3721a(bArr);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.InterfaceC1581g
    @NonNull
    @CheckResult
    /* renamed from: a */
    public C1584j<Drawable> mo3718a(@Nullable Object obj) {
        return m3791c().mo3718a(obj);
    }

    @NonNull
    @CheckResult
    /* renamed from: a */
    public <ResourceType> C1584j<ResourceType> m3779a(@NonNull Class<ResourceType> cls) {
        return new C1584j<>(this.f4161a, this, cls, this.f4162b);
    }

    /* renamed from: a */
    public void m3782a(@NonNull View view) {
        m3783a((InterfaceC1848p<?>) new b(view));
    }

    /* renamed from: a */
    public void m3783a(@Nullable InterfaceC1848p<?> interfaceC1848p) {
        if (interfaceC1848p == null) {
            return;
        }
        m3777c(interfaceC1848p);
    }

    /* renamed from: a */
    synchronized void m3784a(@NonNull InterfaceC1848p<?> interfaceC1848p, @NonNull InterfaceC1825d interfaceC1825d) {
        this.f4166f.m4563a(interfaceC1848p);
        this.f4164d.m4559c(interfaceC1825d);
    }
}
