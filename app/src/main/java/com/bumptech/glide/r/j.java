package com.bumptech.glide.r;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.p.k;
import com.bumptech.glide.load.p.q;
import com.bumptech.glide.load.p.v;
import com.bumptech.glide.r.l.o;
import com.bumptech.glide.r.l.p;
import com.bumptech.glide.util.l;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SingleRequest.java */
/* JADX INFO: loaded from: classes.dex */
public final class j<R> implements d, o, i {
    private static final String E = "Glide";

    @GuardedBy("requestLock")
    private int A;

    @GuardedBy("requestLock")
    private boolean B;

    @Nullable
    private RuntimeException C;

    @Nullable
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.util.n.c f3467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f3468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final g<R> f3469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final e f3470e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f3471f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.bumptech.glide.d f3472g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private final Object f3473h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Class<R> f3474i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final com.bumptech.glide.r.a<?> f3475j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f3476k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f3477l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final com.bumptech.glide.h f3478m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final p<R> f3479n;

    @Nullable
    private final List<g<R>> o;
    private final com.bumptech.glide.r.m.g<? super R> p;
    private final Executor q;

    @GuardedBy("requestLock")
    private v<R> r;

    @GuardedBy("requestLock")
    private k.d s;

    @GuardedBy("requestLock")
    private long t;
    private volatile com.bumptech.glide.load.p.k u;

    @GuardedBy("requestLock")
    private a v;

    @Nullable
    @GuardedBy("requestLock")
    private Drawable w;

    @Nullable
    @GuardedBy("requestLock")
    private Drawable x;

    @Nullable
    @GuardedBy("requestLock")
    private Drawable y;

    @GuardedBy("requestLock")
    private int z;
    private static final String D = "Request";
    private static final boolean F = Log.isLoggable(D, 2);

    /* JADX INFO: compiled from: SingleRequest.java */
    private enum a {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    private j(Context context, com.bumptech.glide.d dVar, @NonNull Object obj, @Nullable Object obj2, Class<R> cls, com.bumptech.glide.r.a<?> aVar, int i2, int i3, com.bumptech.glide.h hVar, p<R> pVar, @Nullable g<R> gVar, @Nullable List<g<R>> list, e eVar, com.bumptech.glide.load.p.k kVar, com.bumptech.glide.r.m.g<? super R> gVar2, Executor executor) {
        this.a = F ? String.valueOf(super.hashCode()) : null;
        this.f3467b = com.bumptech.glide.util.n.c.b();
        this.f3468c = obj;
        this.f3471f = context;
        this.f3472g = dVar;
        this.f3473h = obj2;
        this.f3474i = cls;
        this.f3475j = aVar;
        this.f3476k = i2;
        this.f3477l = i3;
        this.f3478m = hVar;
        this.f3479n = pVar;
        this.f3469d = gVar;
        this.o = list;
        this.f3470e = eVar;
        this.u = kVar;
        this.p = gVar2;
        this.q = executor;
        this.v = a.PENDING;
        if (this.C == null && dVar.g()) {
            this.C = new RuntimeException("Glide request origin trace");
        }
    }

    public static <R> j<R> a(Context context, com.bumptech.glide.d dVar, Object obj, Object obj2, Class<R> cls, com.bumptech.glide.r.a<?> aVar, int i2, int i3, com.bumptech.glide.h hVar, p<R> pVar, g<R> gVar, @Nullable List<g<R>> list, e eVar, com.bumptech.glide.load.p.k kVar, com.bumptech.glide.r.m.g<? super R> gVar2, Executor executor) {
        return new j<>(context, dVar, obj, obj2, cls, aVar, i2, i3, hVar, pVar, gVar, list, eVar, kVar, gVar2, executor);
    }

    @GuardedBy("requestLock")
    private void f() {
        if (this.B) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    @GuardedBy("requestLock")
    private boolean g() {
        e eVar = this.f3470e;
        return eVar == null || eVar.f(this);
    }

    @GuardedBy("requestLock")
    private boolean h() {
        e eVar = this.f3470e;
        return eVar == null || eVar.c(this);
    }

    @GuardedBy("requestLock")
    private boolean i() {
        e eVar = this.f3470e;
        return eVar == null || eVar.d(this);
    }

    @GuardedBy("requestLock")
    private void j() {
        f();
        this.f3467b.a();
        this.f3479n.a((o) this);
        k.d dVar = this.s;
        if (dVar != null) {
            dVar.a();
            this.s = null;
        }
    }

    @GuardedBy("requestLock")
    private Drawable k() {
        if (this.w == null) {
            this.w = this.f3475j.k();
            if (this.w == null && this.f3475j.j() > 0) {
                this.w = a(this.f3475j.j());
            }
        }
        return this.w;
    }

    @GuardedBy("requestLock")
    private Drawable l() {
        if (this.y == null) {
            this.y = this.f3475j.l();
            if (this.y == null && this.f3475j.m() > 0) {
                this.y = a(this.f3475j.m());
            }
        }
        return this.y;
    }

    @GuardedBy("requestLock")
    private Drawable m() {
        if (this.x == null) {
            this.x = this.f3475j.r();
            if (this.x == null && this.f3475j.s() > 0) {
                this.x = a(this.f3475j.s());
            }
        }
        return this.x;
    }

    @GuardedBy("requestLock")
    private boolean n() {
        e eVar = this.f3470e;
        return eVar == null || !eVar.getRoot().a();
    }

    @GuardedBy("requestLock")
    private void o() {
        e eVar = this.f3470e;
        if (eVar != null) {
            eVar.b(this);
        }
    }

    @GuardedBy("requestLock")
    private void p() {
        e eVar = this.f3470e;
        if (eVar != null) {
            eVar.e(this);
        }
    }

    @GuardedBy("requestLock")
    private void q() {
        if (h()) {
            Drawable drawableL = this.f3473h == null ? l() : null;
            if (drawableL == null) {
                drawableL = k();
            }
            if (drawableL == null) {
                drawableL = m();
            }
            this.f3479n.a(drawableL);
        }
    }

    @Override // com.bumptech.glide.r.d
    public boolean b() {
        boolean z;
        synchronized (this.f3468c) {
            z = this.v == a.CLEARED;
        }
        return z;
    }

    @Override // com.bumptech.glide.r.d
    public void c() {
        synchronized (this.f3468c) {
            f();
            this.f3467b.a();
            this.t = com.bumptech.glide.util.f.a();
            if (this.f3473h == null) {
                if (l.b(this.f3476k, this.f3477l)) {
                    this.z = this.f3476k;
                    this.A = this.f3477l;
                }
                a(new q("Received null model"), l() == null ? 5 : 3);
                return;
            }
            if (this.v == a.RUNNING) {
                throw new IllegalArgumentException("Cannot restart a running request");
            }
            if (this.v == a.COMPLETE) {
                a((v<?>) this.r, com.bumptech.glide.load.a.MEMORY_CACHE);
                return;
            }
            this.v = a.WAITING_FOR_SIZE;
            if (l.b(this.f3476k, this.f3477l)) {
                a(this.f3476k, this.f3477l);
            } else {
                this.f3479n.b(this);
            }
            if ((this.v == a.RUNNING || this.v == a.WAITING_FOR_SIZE) && h()) {
                this.f3479n.b(m());
            }
            if (F) {
                a("finished run method in " + com.bumptech.glide.util.f.a(this.t));
            }
        }
    }

    @Override // com.bumptech.glide.r.d
    public void clear() {
        v<R> vVar;
        synchronized (this.f3468c) {
            f();
            this.f3467b.a();
            if (this.v == a.CLEARED) {
                return;
            }
            j();
            if (this.r != null) {
                vVar = this.r;
                this.r = null;
            } else {
                vVar = null;
            }
            if (g()) {
                this.f3479n.c(m());
            }
            this.v = a.CLEARED;
            if (vVar != null) {
                this.u.b((v<?>) vVar);
            }
        }
    }

    @Override // com.bumptech.glide.r.d
    public boolean d() {
        boolean z;
        synchronized (this.f3468c) {
            z = this.v == a.COMPLETE;
        }
        return z;
    }

    @Override // com.bumptech.glide.r.i
    public Object e() {
        this.f3467b.a();
        return this.f3468c;
    }

    @Override // com.bumptech.glide.r.d
    public boolean isRunning() {
        boolean z;
        synchronized (this.f3468c) {
            z = this.v == a.RUNNING || this.v == a.WAITING_FOR_SIZE;
        }
        return z;
    }

    @Override // com.bumptech.glide.r.d
    public void pause() {
        synchronized (this.f3468c) {
            if (isRunning()) {
                clear();
            }
        }
    }

    @Override // com.bumptech.glide.r.d
    public boolean a() {
        boolean z;
        synchronized (this.f3468c) {
            z = this.v == a.COMPLETE;
        }
        return z;
    }

    @GuardedBy("requestLock")
    private Drawable a(@DrawableRes int i2) {
        return com.bumptech.glide.load.r.f.a.a(this.f3472g, i2, this.f3475j.x() != null ? this.f3475j.x() : this.f3471f.getTheme());
    }

    @Override // com.bumptech.glide.r.l.o
    public void a(int i2, int i3) throws Throwable {
        Object obj;
        this.f3467b.a();
        Object obj2 = this.f3468c;
        synchronized (obj2) {
            try {
                try {
                    if (F) {
                        a("Got onSizeReady in " + com.bumptech.glide.util.f.a(this.t));
                    }
                    if (this.v == a.WAITING_FOR_SIZE) {
                        this.v = a.RUNNING;
                        float fW = this.f3475j.w();
                        this.z = a(i2, fW);
                        this.A = a(i3, fW);
                        if (F) {
                            a("finished setup for calling load in " + com.bumptech.glide.util.f.a(this.t));
                        }
                        obj = obj2;
                        try {
                            this.s = this.u.a(this.f3472g, this.f3473h, this.f3475j.v(), this.z, this.A, this.f3475j.u(), this.f3474i, this.f3478m, this.f3475j.i(), this.f3475j.y(), this.f3475j.J(), this.f3475j.G(), this.f3475j.o(), this.f3475j.E(), this.f3475j.A(), this.f3475j.z(), this.f3475j.n(), this, this.q);
                            if (this.v != a.RUNNING) {
                                this.s = null;
                            }
                            if (F) {
                                a("finished onSizeReady in " + com.bumptech.glide.util.f.a(this.t));
                            }
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    obj = obj2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    private static int a(int i2, float f2) {
        return i2 == Integer.MIN_VALUE ? i2 : Math.round(f2 * i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004f, code lost:
    
        if (r6 == null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
    
        r5.u.b(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0056, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ad, code lost:
    
        if (r6 == null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00af, code lost:
    
        r5.u.b(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b4, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:?, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.r.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(v<?> vVar, com.bumptech.glide.load.a aVar) throws Throwable {
        this.f3467b.a();
        v<?> vVar2 = null;
        try {
            try {
                synchronized (this.f3468c) {
                    try {
                        this.s = null;
                        if (vVar == null) {
                            a(new q("Expected to receive a Resource<R> with an object of " + this.f3474i + " inside, but instead got null."));
                            return;
                        }
                        Object obj = vVar.get();
                        if (obj != null && this.f3474i.isAssignableFrom(obj.getClass())) {
                            if (!i()) {
                                this.r = null;
                                this.v = a.COMPLETE;
                            } else {
                                a(vVar, obj, aVar);
                                return;
                            }
                        }
                        this.r = null;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Expected to receive an object of ");
                        sb.append(this.f3474i);
                        sb.append(" but instead got ");
                        sb.append(obj != null ? obj.getClass() : "");
                        sb.append("{");
                        sb.append(obj);
                        sb.append("} inside Resource{");
                        sb.append(vVar);
                        sb.append("}.");
                        sb.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                        a(new q(sb.toString()));
                    } catch (Throwable th) {
                        th = th;
                        vVar = null;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
        try {
            throw th;
        } catch (Throwable th4) {
            th = th4;
            vVar2 = vVar;
            if (vVar2 != null) {
                this.u.b(vVar2);
            }
            throw th;
        }
    }

    @GuardedBy("requestLock")
    private void a(v<R> vVar, R r, com.bumptech.glide.load.a aVar) {
        boolean zA;
        boolean zN = n();
        this.v = a.COMPLETE;
        this.r = vVar;
        if (this.f3472g.e() <= 3) {
            String str = "Finished loading " + r.getClass().getSimpleName() + " from " + aVar + " for " + this.f3473h + " with size [" + this.z + "x" + this.A + "] in " + com.bumptech.glide.util.f.a(this.t) + " ms";
        }
        boolean z = true;
        this.B = true;
        try {
            if (this.o != null) {
                Iterator<g<R>> it = this.o.iterator();
                zA = false;
                while (it.hasNext()) {
                    zA |= it.next().a(r, this.f3473h, this.f3479n, aVar, zN);
                }
            } else {
                zA = false;
            }
            if (this.f3469d == null || !this.f3469d.a(r, this.f3473h, this.f3479n, aVar, zN)) {
                z = false;
            }
            if (!(z | zA)) {
                this.f3479n.a(r, this.p.a(aVar, zN));
            }
            this.B = false;
            p();
        } catch (Throwable th) {
            this.B = false;
            throw th;
        }
    }

    @Override // com.bumptech.glide.r.i
    public void a(q qVar) {
        a(qVar, 5);
    }

    private void a(q qVar, int i2) {
        boolean zA;
        this.f3467b.a();
        synchronized (this.f3468c) {
            qVar.setOrigin(this.C);
            int iE = this.f3472g.e();
            if (iE <= i2) {
                String str = "Load failed for " + this.f3473h + " with size [" + this.z + "x" + this.A + "]";
                if (iE <= 4) {
                    qVar.logRootCauses(E);
                }
            }
            this.s = null;
            this.v = a.FAILED;
            boolean z = true;
            this.B = true;
            try {
                if (this.o != null) {
                    Iterator<g<R>> it = this.o.iterator();
                    zA = false;
                    while (it.hasNext()) {
                        zA |= it.next().a(qVar, this.f3473h, this.f3479n, n());
                    }
                } else {
                    zA = false;
                }
                if (this.f3469d == null || !this.f3469d.a(qVar, this.f3473h, this.f3479n, n())) {
                    z = false;
                }
                if (!(zA | z)) {
                    q();
                }
                this.B = false;
                o();
            } catch (Throwable th) {
                this.B = false;
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.r.d
    public boolean a(d dVar) {
        int i2;
        int i3;
        Object obj;
        Class<R> cls;
        com.bumptech.glide.r.a<?> aVar;
        com.bumptech.glide.h hVar;
        int size;
        int i4;
        int i5;
        Object obj2;
        Class<R> cls2;
        com.bumptech.glide.r.a<?> aVar2;
        com.bumptech.glide.h hVar2;
        int size2;
        if (!(dVar instanceof j)) {
            return false;
        }
        synchronized (this.f3468c) {
            i2 = this.f3476k;
            i3 = this.f3477l;
            obj = this.f3473h;
            cls = this.f3474i;
            aVar = this.f3475j;
            hVar = this.f3478m;
            size = this.o != null ? this.o.size() : 0;
        }
        j jVar = (j) dVar;
        synchronized (jVar.f3468c) {
            i4 = jVar.f3476k;
            i5 = jVar.f3477l;
            obj2 = jVar.f3473h;
            cls2 = jVar.f3474i;
            aVar2 = jVar.f3475j;
            hVar2 = jVar.f3478m;
            size2 = jVar.o != null ? jVar.o.size() : 0;
        }
        return i2 == i4 && i3 == i5 && l.a(obj, obj2) && cls.equals(cls2) && aVar.equals(aVar2) && hVar == hVar2 && size == size2;
    }

    private void a(String str) {
        String str2 = str + " this: " + this.a;
    }
}
