package com.bumptech.glide.r;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.n;
import com.bumptech.glide.load.r.d.j0;
import com.bumptech.glide.load.r.d.m;
import com.bumptech.glide.load.r.d.p;
import com.bumptech.glide.load.r.d.q;
import com.bumptech.glide.load.r.d.s;
import com.bumptech.glide.load.r.d.u;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.r.a;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import com.bumptech.glide.util.l;
import java.util.Map;

/* JADX INFO: compiled from: BaseRequestOptions.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a<T extends a<T>> implements Cloneable {
    private static final int A = -1;
    private static final int B = 2;
    private static final int C = 4;
    private static final int D = 8;
    private static final int E = 16;
    private static final int F = 32;
    private static final int G = 64;
    private static final int H = 128;
    private static final int I = 256;
    private static final int J = 512;
    private static final int K = 1024;
    private static final int L = 2048;
    private static final int M = 4096;
    private static final int N = 8192;
    private static final int O = 16384;
    private static final int b0 = 32768;
    private static final int c0 = 65536;
    private static final int d0 = 131072;
    private static final int e0 = 262144;
    private static final int f0 = 524288;
    private static final int g0 = 1048576;
    private int a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private Drawable f3442e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f3443f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private Drawable f3444g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f3445h;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f3450m;

    @Nullable
    private Drawable o;
    private int p;
    private boolean t;

    @Nullable
    private Resources.Theme u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f3439b = 1.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    private com.bumptech.glide.load.p.j f3440c = com.bumptech.glide.load.p.j.f2964e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    private com.bumptech.glide.h f3441d = com.bumptech.glide.h.NORMAL;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f3446i = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f3447j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f3448k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    private com.bumptech.glide.load.g f3449l = com.bumptech.glide.s.c.a();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f3451n = true;

    @NonNull
    private com.bumptech.glide.load.j q = new com.bumptech.glide.load.j();

    @NonNull
    private Map<Class<?>, n<?>> r = new CachedHashCodeArrayMap();

    @NonNull
    private Class<?> s = Object.class;
    private boolean y = true;

    private T R() {
        return this;
    }

    @NonNull
    private T S() {
        if (this.t) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return (T) R();
    }

    private static boolean b(int i2, int i3) {
        return (i2 & i3) != 0;
    }

    public final boolean A() {
        return this.w;
    }

    protected boolean B() {
        return this.v;
    }

    public final boolean C() {
        return g(4);
    }

    public final boolean D() {
        return this.t;
    }

    public final boolean E() {
        return this.f3446i;
    }

    public final boolean F() {
        return g(8);
    }

    boolean G() {
        return this.y;
    }

    public final boolean H() {
        return g(256);
    }

    public final boolean I() {
        return this.f3451n;
    }

    public final boolean J() {
        return this.f3450m;
    }

    public final boolean K() {
        return g(2048);
    }

    public final boolean L() {
        return l.b(this.f3448k, this.f3447j);
    }

    @NonNull
    public T M() {
        this.t = true;
        return (T) R();
    }

    @NonNull
    @CheckResult
    public T N() {
        return (T) a(p.f3203e, new com.bumptech.glide.load.r.d.l());
    }

    @NonNull
    @CheckResult
    public T O() {
        return (T) c(p.f3202d, new m());
    }

    @NonNull
    @CheckResult
    public T P() {
        return (T) a(p.f3203e, new com.bumptech.glide.load.r.d.n());
    }

    @NonNull
    @CheckResult
    public T Q() {
        return (T) c(p.f3201c, new u());
    }

    @NonNull
    @CheckResult
    public T a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (this.v) {
            return (T) mo34clone().a(f2);
        }
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.f3439b = f2;
        this.a |= 2;
        return (T) S();
    }

    @NonNull
    @CheckResult
    public T b(@Nullable Drawable drawable) {
        if (this.v) {
            return (T) mo34clone().b(drawable);
        }
        this.o = drawable;
        this.a |= 8192;
        this.p = 0;
        this.a &= -16385;
        return (T) S();
    }

    @NonNull
    @CheckResult
    public T c(boolean z) {
        if (this.v) {
            return (T) mo34clone().c(z);
        }
        this.z = z;
        this.a |= 1048576;
        return (T) S();
    }

    @NonNull
    @CheckResult
    public T d(boolean z) {
        if (this.v) {
            return (T) mo34clone().d(z);
        }
        this.w = z;
        this.a |= 262144;
        return (T) S();
    }

    @NonNull
    @CheckResult
    public T e(@DrawableRes int i2) {
        if (this.v) {
            return (T) mo34clone().e(i2);
        }
        this.f3445h = i2;
        this.a |= 128;
        this.f3444g = null;
        this.a &= -65;
        return (T) S();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Float.compare(aVar.f3439b, this.f3439b) == 0 && this.f3443f == aVar.f3443f && l.b(this.f3442e, aVar.f3442e) && this.f3445h == aVar.f3445h && l.b(this.f3444g, aVar.f3444g) && this.p == aVar.p && l.b(this.o, aVar.o) && this.f3446i == aVar.f3446i && this.f3447j == aVar.f3447j && this.f3448k == aVar.f3448k && this.f3450m == aVar.f3450m && this.f3451n == aVar.f3451n && this.w == aVar.w && this.x == aVar.x && this.f3440c.equals(aVar.f3440c) && this.f3441d == aVar.f3441d && this.q.equals(aVar.q) && this.r.equals(aVar.r) && this.s.equals(aVar.s) && l.b(this.f3449l, aVar.f3449l) && l.b(this.u, aVar.u);
    }

    @NonNull
    @CheckResult
    public T f(@IntRange(from = 0) int i2) {
        return (T) a((com.bumptech.glide.load.i<Integer>) com.bumptech.glide.load.q.y.b.f3113b, Integer.valueOf(i2));
    }

    @NonNull
    @CheckResult
    public T g() {
        if (this.v) {
            return (T) mo34clone().g();
        }
        this.r.clear();
        this.a &= -2049;
        this.f3450m = false;
        this.a &= -131073;
        this.f3451n = false;
        this.a |= 65536;
        this.y = true;
        return (T) S();
    }

    @NonNull
    @CheckResult
    public T h() {
        return (T) d(p.f3201c, new u());
    }

    public int hashCode() {
        return l.a(this.u, l.a(this.f3449l, l.a(this.s, l.a(this.r, l.a(this.q, l.a(this.f3441d, l.a(this.f3440c, l.a(this.x, l.a(this.w, l.a(this.f3451n, l.a(this.f3450m, l.a(this.f3448k, l.a(this.f3447j, l.a(this.f3446i, l.a(this.o, l.a(this.p, l.a(this.f3444g, l.a(this.f3445h, l.a(this.f3442e, l.a(this.f3443f, l.a(this.f3439b)))))))))))))))))))));
    }

    @NonNull
    public final com.bumptech.glide.load.p.j i() {
        return this.f3440c;
    }

    public final int j() {
        return this.f3443f;
    }

    @Nullable
    public final Drawable k() {
        return this.f3442e;
    }

    @Nullable
    public final Drawable l() {
        return this.o;
    }

    public final int m() {
        return this.p;
    }

    public final boolean n() {
        return this.x;
    }

    @NonNull
    public final com.bumptech.glide.load.j o() {
        return this.q;
    }

    public final int p() {
        return this.f3447j;
    }

    public final int q() {
        return this.f3448k;
    }

    @Nullable
    public final Drawable r() {
        return this.f3444g;
    }

    public final int s() {
        return this.f3445h;
    }

    @NonNull
    public final com.bumptech.glide.h t() {
        return this.f3441d;
    }

    @NonNull
    public final Class<?> u() {
        return this.s;
    }

    @NonNull
    public final com.bumptech.glide.load.g v() {
        return this.f3449l;
    }

    public final float w() {
        return this.f3439b;
    }

    @Nullable
    public final Resources.Theme x() {
        return this.u;
    }

    @NonNull
    public final Map<Class<?>, n<?>> y() {
        return this.r;
    }

    public final boolean z() {
        return this.z;
    }

    @Override // 
    @CheckResult
    /* JADX INFO: renamed from: clone */
    public T mo34clone() {
        try {
            T t = (T) super.clone();
            t.q = new com.bumptech.glide.load.j();
            t.q.a(this.q);
            t.r = new CachedHashCodeArrayMap();
            t.r.putAll(this.r);
            t.t = false;
            t.v = false;
            return t;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    @NonNull
    @CheckResult
    public T f() {
        return (T) a((com.bumptech.glide.load.i<boolean>) com.bumptech.glide.load.resource.gif.h.f3301b, true);
    }

    @NonNull
    @CheckResult
    public T c(@Nullable Drawable drawable) {
        if (this.v) {
            return (T) mo34clone().c(drawable);
        }
        this.f3444g = drawable;
        this.a |= 64;
        this.f3445h = 0;
        this.a &= -129;
        return (T) S();
    }

    @NonNull
    @CheckResult
    public T d(int i2) {
        return (T) a(i2, i2);
    }

    @NonNull
    @CheckResult
    public T a(boolean z) {
        if (this.v) {
            return (T) mo34clone().a(z);
        }
        this.x = z;
        this.a |= 524288;
        return (T) S();
    }

    @NonNull
    @CheckResult
    public T d() {
        return (T) b(p.f3202d, new com.bumptech.glide.load.r.d.n());
    }

    @NonNull
    private T d(@NonNull p pVar, @NonNull n<Bitmap> nVar) {
        return (T) a(pVar, nVar, true);
    }

    @NonNull
    @CheckResult
    public T b(@DrawableRes int i2) {
        if (this.v) {
            return (T) mo34clone().b(i2);
        }
        this.f3443f = i2;
        this.a |= 32;
        this.f3442e = null;
        this.a &= -17;
        return (T) S();
    }

    @NonNull
    @CheckResult
    public T e() {
        return (T) a((com.bumptech.glide.load.i<boolean>) q.f3213k, false);
    }

    private boolean g(int i2) {
        return b(this.a, i2);
    }

    @NonNull
    @CheckResult
    public T a(@NonNull com.bumptech.glide.load.p.j jVar) {
        if (this.v) {
            return (T) mo34clone().a(jVar);
        }
        this.f3440c = (com.bumptech.glide.load.p.j) com.bumptech.glide.util.j.a(jVar);
        this.a |= 4;
        return (T) S();
    }

    @NonNull
    @CheckResult
    public T c(@DrawableRes int i2) {
        if (this.v) {
            return (T) mo34clone().c(i2);
        }
        this.p = i2;
        this.a |= 16384;
        this.o = null;
        this.a &= -8193;
        return (T) S();
    }

    @NonNull
    @CheckResult
    public T b(boolean z) {
        if (this.v) {
            return (T) mo34clone().b(true);
        }
        this.f3446i = !z;
        this.a |= 256;
        return (T) S();
    }

    @NonNull
    @CheckResult
    public T a(@NonNull com.bumptech.glide.h hVar) {
        if (this.v) {
            return (T) mo34clone().a(hVar);
        }
        this.f3441d = (com.bumptech.glide.h) com.bumptech.glide.util.j.a(hVar);
        this.a |= 8;
        return (T) S();
    }

    @NonNull
    @CheckResult
    public T b() {
        return (T) b(p.f3203e, new com.bumptech.glide.load.r.d.l());
    }

    @NonNull
    @CheckResult
    public T c() {
        return (T) d(p.f3202d, new m());
    }

    @NonNull
    private T c(@NonNull p pVar, @NonNull n<Bitmap> nVar) {
        return (T) a(pVar, nVar, false);
    }

    @NonNull
    @CheckResult
    final T b(@NonNull p pVar, @NonNull n<Bitmap> nVar) {
        if (this.v) {
            return (T) mo34clone().b(pVar, nVar);
        }
        a(pVar);
        return (T) b(nVar);
    }

    @NonNull
    @CheckResult
    public T a(@Nullable Drawable drawable) {
        if (this.v) {
            return (T) mo34clone().a(drawable);
        }
        this.f3442e = drawable;
        this.a |= 16;
        this.f3443f = 0;
        this.a &= -33;
        return (T) S();
    }

    @NonNull
    @CheckResult
    public T b(@NonNull n<Bitmap> nVar) {
        return (T) a(nVar, true);
    }

    @NonNull
    @CheckResult
    @Deprecated
    public T b(@NonNull n<Bitmap>... nVarArr) {
        return (T) a((n<Bitmap>) new com.bumptech.glide.load.h(nVarArr), true);
    }

    @NonNull
    @CheckResult
    public <Y> T b(@NonNull Class<Y> cls, @NonNull n<Y> nVar) {
        return (T) a((Class) cls, (n) nVar, true);
    }

    @NonNull
    @CheckResult
    public T a(@Nullable Resources.Theme theme) {
        if (this.v) {
            return (T) mo34clone().a(theme);
        }
        this.u = theme;
        this.a |= 32768;
        return (T) S();
    }

    @NonNull
    @CheckResult
    public T a(int i2, int i3) {
        if (this.v) {
            return (T) mo34clone().a(i2, i3);
        }
        this.f3448k = i2;
        this.f3447j = i3;
        this.a |= 512;
        return (T) S();
    }

    @NonNull
    @CheckResult
    public T a(@NonNull com.bumptech.glide.load.g gVar) {
        if (this.v) {
            return (T) mo34clone().a(gVar);
        }
        this.f3449l = (com.bumptech.glide.load.g) com.bumptech.glide.util.j.a(gVar);
        this.a |= 1024;
        return (T) S();
    }

    @NonNull
    @CheckResult
    public <Y> T a(@NonNull com.bumptech.glide.load.i<Y> iVar, @NonNull Y y) {
        if (this.v) {
            return (T) mo34clone().a(iVar, y);
        }
        com.bumptech.glide.util.j.a(iVar);
        com.bumptech.glide.util.j.a(y);
        this.q.a(iVar, y);
        return (T) S();
    }

    @NonNull
    @CheckResult
    public T a(@NonNull Class<?> cls) {
        if (this.v) {
            return (T) mo34clone().a(cls);
        }
        this.s = (Class) com.bumptech.glide.util.j.a(cls);
        this.a |= 4096;
        return (T) S();
    }

    @NonNull
    @CheckResult
    public T a(@NonNull Bitmap.CompressFormat compressFormat) {
        return (T) a((com.bumptech.glide.load.i<Object>) com.bumptech.glide.load.r.d.e.f3151c, com.bumptech.glide.util.j.a(compressFormat));
    }

    @NonNull
    @CheckResult
    public T a(@IntRange(from = 0, to = e.d.z) int i2) {
        return (T) a((com.bumptech.glide.load.i<Integer>) com.bumptech.glide.load.r.d.e.f3150b, Integer.valueOf(i2));
    }

    @NonNull
    @CheckResult
    public T a(@IntRange(from = 0) long j2) {
        return (T) a((com.bumptech.glide.load.i<Long>) j0.f3174g, Long.valueOf(j2));
    }

    @NonNull
    @CheckResult
    public T a(@NonNull com.bumptech.glide.load.b bVar) {
        com.bumptech.glide.util.j.a(bVar);
        return (T) a((com.bumptech.glide.load.i<com.bumptech.glide.load.b>) q.f3209g, bVar).a(com.bumptech.glide.load.resource.gif.h.a, bVar);
    }

    @NonNull
    @CheckResult
    public T a(@NonNull p pVar) {
        return (T) a((com.bumptech.glide.load.i<Object>) p.f3206h, com.bumptech.glide.util.j.a(pVar));
    }

    @NonNull
    final T a(@NonNull p pVar, @NonNull n<Bitmap> nVar) {
        if (this.v) {
            return (T) mo34clone().a(pVar, nVar);
        }
        a(pVar);
        return (T) a(nVar, false);
    }

    @NonNull
    private T a(@NonNull p pVar, @NonNull n<Bitmap> nVar, boolean z) {
        T t;
        if (z) {
            t = (T) b(pVar, nVar);
        } else {
            t = (T) a(pVar, nVar);
        }
        t.y = true;
        return t;
    }

    @NonNull
    @CheckResult
    public T a(@NonNull n<Bitmap>... nVarArr) {
        if (nVarArr.length > 1) {
            return (T) a((n<Bitmap>) new com.bumptech.glide.load.h(nVarArr), true);
        }
        if (nVarArr.length == 1) {
            return (T) b(nVarArr[0]);
        }
        return (T) S();
    }

    @NonNull
    @CheckResult
    public T a(@NonNull n<Bitmap> nVar) {
        return (T) a(nVar, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    T a(@NonNull n<Bitmap> nVar, boolean z) {
        if (this.v) {
            return (T) mo34clone().a(nVar, z);
        }
        s sVar = new s(nVar, z);
        a(Bitmap.class, nVar, z);
        a(Drawable.class, sVar, z);
        a(BitmapDrawable.class, sVar.a(), z);
        a(GifDrawable.class, new com.bumptech.glide.load.resource.gif.e(nVar), z);
        return (T) S();
    }

    @NonNull
    @CheckResult
    public <Y> T a(@NonNull Class<Y> cls, @NonNull n<Y> nVar) {
        return (T) a((Class) cls, (n) nVar, false);
    }

    @NonNull
    <Y> T a(@NonNull Class<Y> cls, @NonNull n<Y> nVar, boolean z) {
        if (this.v) {
            return (T) mo34clone().a(cls, nVar, z);
        }
        com.bumptech.glide.util.j.a(cls);
        com.bumptech.glide.util.j.a(nVar);
        this.r.put(cls, nVar);
        this.a |= 2048;
        this.f3451n = true;
        this.a |= 65536;
        this.y = false;
        if (z) {
            this.a |= 131072;
            this.f3450m = true;
        }
        return (T) S();
    }

    @NonNull
    @CheckResult
    public T a(@NonNull a<?> aVar) {
        if (this.v) {
            return (T) mo34clone().a(aVar);
        }
        if (b(aVar.a, 2)) {
            this.f3439b = aVar.f3439b;
        }
        if (b(aVar.a, 262144)) {
            this.w = aVar.w;
        }
        if (b(aVar.a, 1048576)) {
            this.z = aVar.z;
        }
        if (b(aVar.a, 4)) {
            this.f3440c = aVar.f3440c;
        }
        if (b(aVar.a, 8)) {
            this.f3441d = aVar.f3441d;
        }
        if (b(aVar.a, 16)) {
            this.f3442e = aVar.f3442e;
            this.f3443f = 0;
            this.a &= -33;
        }
        if (b(aVar.a, 32)) {
            this.f3443f = aVar.f3443f;
            this.f3442e = null;
            this.a &= -17;
        }
        if (b(aVar.a, 64)) {
            this.f3444g = aVar.f3444g;
            this.f3445h = 0;
            this.a &= -129;
        }
        if (b(aVar.a, 128)) {
            this.f3445h = aVar.f3445h;
            this.f3444g = null;
            this.a &= -65;
        }
        if (b(aVar.a, 256)) {
            this.f3446i = aVar.f3446i;
        }
        if (b(aVar.a, 512)) {
            this.f3448k = aVar.f3448k;
            this.f3447j = aVar.f3447j;
        }
        if (b(aVar.a, 1024)) {
            this.f3449l = aVar.f3449l;
        }
        if (b(aVar.a, 4096)) {
            this.s = aVar.s;
        }
        if (b(aVar.a, 8192)) {
            this.o = aVar.o;
            this.p = 0;
            this.a &= -16385;
        }
        if (b(aVar.a, 16384)) {
            this.p = aVar.p;
            this.o = null;
            this.a &= -8193;
        }
        if (b(aVar.a, 32768)) {
            this.u = aVar.u;
        }
        if (b(aVar.a, 65536)) {
            this.f3451n = aVar.f3451n;
        }
        if (b(aVar.a, 131072)) {
            this.f3450m = aVar.f3450m;
        }
        if (b(aVar.a, 2048)) {
            this.r.putAll(aVar.r);
            this.y = aVar.y;
        }
        if (b(aVar.a, 524288)) {
            this.x = aVar.x;
        }
        if (!this.f3451n) {
            this.r.clear();
            this.a &= -2049;
            this.f3450m = false;
            this.a &= -131073;
            this.y = true;
        }
        this.a |= aVar.a;
        this.q.a(aVar.q);
        return (T) S();
    }

    @NonNull
    public T a() {
        if (this.t && !this.v) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.v = true;
        return (T) M();
    }
}
