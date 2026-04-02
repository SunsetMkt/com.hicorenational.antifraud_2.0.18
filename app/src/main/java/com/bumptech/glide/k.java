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
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.c;
import com.bumptech.glide.manager.m;
import com.bumptech.glide.manager.n;
import com.bumptech.glide.r.l.p;
import java.io.File;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: RequestManager.java */
/* JADX INFO: loaded from: classes.dex */
public class k implements ComponentCallbacks2, com.bumptech.glide.manager.i, g<j<Drawable>> {

    /* JADX INFO: renamed from: m */
    private static final com.bumptech.glide.r.h f2698m = com.bumptech.glide.r.h.b((Class<?>) Bitmap.class).M();

    /* JADX INFO: renamed from: n */
    private static final com.bumptech.glide.r.h f2699n = com.bumptech.glide.r.h.b((Class<?>) GifDrawable.class).M();
    private static final com.bumptech.glide.r.h o = com.bumptech.glide.r.h.b(com.bumptech.glide.load.p.j.f2962c).a(h.LOW).b(true);
    protected final com.bumptech.glide.b a;

    /* JADX INFO: renamed from: b */
    protected final Context f2700b;

    /* JADX INFO: renamed from: c */
    final com.bumptech.glide.manager.h f2701c;

    /* JADX INFO: renamed from: d */
    @GuardedBy("this")
    private final m f2702d;

    /* JADX INFO: renamed from: e */
    @GuardedBy("this")
    private final com.bumptech.glide.manager.l f2703e;

    /* JADX INFO: renamed from: f */
    @GuardedBy("this")
    private final n f2704f;

    /* JADX INFO: renamed from: g */
    private final Runnable f2705g;

    /* JADX INFO: renamed from: h */
    private final Handler f2706h;

    /* JADX INFO: renamed from: i */
    private final com.bumptech.glide.manager.c f2707i;

    /* JADX INFO: renamed from: j */
    private final CopyOnWriteArrayList<com.bumptech.glide.r.g<Object>> f2708j;

    /* JADX INFO: renamed from: k */
    @GuardedBy("this")
    private com.bumptech.glide.r.h f2709k;

    /* JADX INFO: renamed from: l */
    private boolean f2710l;

    /* JADX INFO: compiled from: RequestManager.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k kVar = k.this;
            kVar.f2701c.a(kVar);
        }
    }

    /* JADX INFO: compiled from: RequestManager.java */
    private static class b extends com.bumptech.glide.r.l.f<View, Object> {
        b(@NonNull View view) {
            super(view);
        }

        @Override // com.bumptech.glide.r.l.p
        public void a(@Nullable Drawable drawable) {
        }

        @Override // com.bumptech.glide.r.l.p
        public void a(@NonNull Object obj, @Nullable com.bumptech.glide.r.m.f<? super Object> fVar) {
        }

        @Override // com.bumptech.glide.r.l.f
        protected void d(@Nullable Drawable drawable) {
        }
    }

    /* JADX INFO: compiled from: RequestManager.java */
    private class c implements c.a {

        @GuardedBy("RequestManager.this")
        private final m a;

        c(@NonNull m mVar) {
            this.a = mVar;
        }

        @Override // com.bumptech.glide.manager.c.a
        public void a(boolean z) {
            if (z) {
                synchronized (k.this) {
                    this.a.e();
                }
            }
        }
    }

    public k(@NonNull com.bumptech.glide.b bVar, @NonNull com.bumptech.glide.manager.h hVar, @NonNull com.bumptech.glide.manager.l lVar, @NonNull Context context) {
        this(bVar, hVar, lVar, new m(), bVar.e(), context);
    }

    @NonNull
    public synchronized k b(@NonNull com.bumptech.glide.r.h hVar) {
        c(hVar);
        return this;
    }

    protected synchronized void c(@NonNull com.bumptech.glide.r.h hVar) {
        this.f2709k = hVar.mo34clone().a();
    }

    @NonNull
    @CheckResult
    public j<GifDrawable> e() {
        return a(GifDrawable.class).a((com.bumptech.glide.r.a<?>) f2699n);
    }

    @NonNull
    @CheckResult
    public j<File> f() {
        return a(File.class).a((com.bumptech.glide.r.a<?>) o);
    }

    List<com.bumptech.glide.r.g<Object>> g() {
        return this.f2708j;
    }

    synchronized com.bumptech.glide.r.h h() {
        return this.f2709k;
    }

    public synchronized boolean i() {
        return this.f2702d.b();
    }

    public synchronized void j() {
        this.f2702d.c();
    }

    public synchronized void k() {
        j();
        Iterator<k> it = this.f2703e.a().iterator();
        while (it.hasNext()) {
            it.next().j();
        }
    }

    public synchronized void l() {
        this.f2702d.d();
    }

    public synchronized void m() {
        l();
        Iterator<k> it = this.f2703e.a().iterator();
        while (it.hasNext()) {
            it.next().l();
        }
    }

    public synchronized void n() {
        this.f2702d.f();
    }

    public synchronized void o() {
        com.bumptech.glide.util.l.b();
        n();
        Iterator<k> it = this.f2703e.a().iterator();
        while (it.hasNext()) {
            it.next().n();
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.bumptech.glide.manager.i
    public synchronized void onDestroy() {
        this.f2704f.onDestroy();
        Iterator<p<?>> it = this.f2704f.c().iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        this.f2704f.b();
        this.f2702d.a();
        this.f2701c.b(this);
        this.f2701c.b(this.f2707i);
        this.f2706h.removeCallbacks(this.f2705g);
        this.a.b(this);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // com.bumptech.glide.manager.i
    public synchronized void onStart() {
        n();
        this.f2704f.onStart();
    }

    @Override // com.bumptech.glide.manager.i
    public synchronized void onStop() {
        l();
        this.f2704f.onStop();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        if (i2 == 60 && this.f2710l) {
            k();
        }
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.f2702d + ", treeNode=" + this.f2703e + "}";
    }

    private synchronized void d(@NonNull com.bumptech.glide.r.h hVar) {
        this.f2709k = this.f2709k.a(hVar);
    }

    @NonNull
    @CheckResult
    public j<Bitmap> b() {
        return a(Bitmap.class).a((com.bumptech.glide.r.a<?>) f2698m);
    }

    @NonNull
    @CheckResult
    public j<Drawable> c() {
        return a(Drawable.class);
    }

    k(com.bumptech.glide.b bVar, com.bumptech.glide.manager.h hVar, com.bumptech.glide.manager.l lVar, m mVar, com.bumptech.glide.manager.d dVar, Context context) {
        this.f2704f = new n();
        this.f2705g = new a();
        this.f2706h = new Handler(Looper.getMainLooper());
        this.a = bVar;
        this.f2701c = hVar;
        this.f2703e = lVar;
        this.f2702d = mVar;
        this.f2700b = context;
        this.f2707i = dVar.a(context.getApplicationContext(), new c(mVar));
        if (com.bumptech.glide.util.l.c()) {
            this.f2706h.post(this.f2705g);
        } else {
            hVar.a(this);
        }
        hVar.a(this.f2707i);
        this.f2708j = new CopyOnWriteArrayList<>(bVar.g().b());
        c(bVar.g().c());
        bVar.a(this);
    }

    private void c(@NonNull p<?> pVar) {
        boolean zB = b(pVar);
        com.bumptech.glide.r.d dVarA = pVar.a();
        if (zB || this.a.a(pVar) || dVarA == null) {
            return;
        }
        pVar.a((com.bumptech.glide.r.d) null);
        dVarA.clear();
    }

    @NonNull
    @CheckResult
    public j<File> b(@Nullable Object obj) {
        return f().a(obj);
    }

    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    public j<Drawable> d(@Nullable Drawable drawable) {
        return c().d(drawable);
    }

    synchronized boolean b(@NonNull p<?> pVar) {
        com.bumptech.glide.r.d dVarA = pVar.a();
        if (dVarA == null) {
            return true;
        }
        if (!this.f2702d.b(dVarA)) {
            return false;
        }
        this.f2704f.b(pVar);
        pVar.a((com.bumptech.glide.r.d) null);
        return true;
    }

    @NonNull
    @CheckResult
    public j<File> d() {
        return a(File.class).a((com.bumptech.glide.r.a<?>) com.bumptech.glide.r.h.e(true));
    }

    @NonNull
    public synchronized k a(@NonNull com.bumptech.glide.r.h hVar) {
        d(hVar);
        return this;
    }

    public k a(com.bumptech.glide.r.g<Object> gVar) {
        this.f2708j.add(gVar);
        return this;
    }

    public void a(boolean z) {
        this.f2710l = z;
    }

    @NonNull
    <T> l<?, T> b(Class<T> cls) {
        return this.a.g().a(cls);
    }

    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    public j<Drawable> a(@Nullable Bitmap bitmap) {
        return c().a(bitmap);
    }

    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    public j<Drawable> a(@Nullable String str) {
        return c().a(str);
    }

    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    public j<Drawable> a(@Nullable Uri uri) {
        return c().a(uri);
    }

    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    public j<Drawable> a(@Nullable File file) {
        return c().a(file);
    }

    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    public j<Drawable> a(@Nullable @DrawableRes @RawRes Integer num) {
        return c().a(num);
    }

    @Override // com.bumptech.glide.g
    @CheckResult
    @Deprecated
    public j<Drawable> a(@Nullable URL url) {
        return c().a(url);
    }

    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    public j<Drawable> a(@Nullable byte[] bArr) {
        return c().a(bArr);
    }

    @Override // com.bumptech.glide.g
    @NonNull
    @CheckResult
    public j<Drawable> a(@Nullable Object obj) {
        return c().a(obj);
    }

    @NonNull
    @CheckResult
    public <ResourceType> j<ResourceType> a(@NonNull Class<ResourceType> cls) {
        return new j<>(this.a, this, cls, this.f2700b);
    }

    public void a(@NonNull View view) {
        a((p<?>) new b(view));
    }

    public void a(@Nullable p<?> pVar) {
        if (pVar == null) {
            return;
        }
        c(pVar);
    }

    synchronized void a(@NonNull p<?> pVar, @NonNull com.bumptech.glide.r.d dVar) {
        this.f2704f.a(pVar);
        this.f2702d.c(dVar);
    }
}
