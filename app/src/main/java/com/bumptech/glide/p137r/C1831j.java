package com.bumptech.glide.p137r;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.C1578d;
import com.bumptech.glide.EnumC1582h;
import com.bumptech.glide.load.EnumC1587a;
import com.bumptech.glide.load.p118p.C1666k;
import com.bumptech.glide.load.p118p.C1672q;
import com.bumptech.glide.load.p118p.InterfaceC1677v;
import com.bumptech.glide.load.p125r.p128f.C1754a;
import com.bumptech.glide.p137r.p138l.InterfaceC1847o;
import com.bumptech.glide.p137r.p138l.InterfaceC1848p;
import com.bumptech.glide.p137r.p139m.InterfaceC1857g;
import com.bumptech.glide.util.C1872f;
import com.bumptech.glide.util.C1878l;
import com.bumptech.glide.util.p141n.AbstractC1882c;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: SingleRequest.java */
/* renamed from: com.bumptech.glide.r.j */
/* loaded from: classes.dex */
public final class C1831j<R> implements InterfaceC1825d, InterfaceC1847o, InterfaceC1830i {

    /* renamed from: E */
    private static final String f5334E = "Glide";

    /* renamed from: A */
    @GuardedBy("requestLock")
    private int f5336A;

    /* renamed from: B */
    @GuardedBy("requestLock")
    private boolean f5337B;

    /* renamed from: C */
    @Nullable
    private RuntimeException f5338C;

    /* renamed from: a */
    @Nullable
    private final String f5339a;

    /* renamed from: b */
    private final AbstractC1882c f5340b;

    /* renamed from: c */
    private final Object f5341c;

    /* renamed from: d */
    @Nullable
    private final InterfaceC1828g<R> f5342d;

    /* renamed from: e */
    private final InterfaceC1826e f5343e;

    /* renamed from: f */
    private final Context f5344f;

    /* renamed from: g */
    private final C1578d f5345g;

    /* renamed from: h */
    @Nullable
    private final Object f5346h;

    /* renamed from: i */
    private final Class<R> f5347i;

    /* renamed from: j */
    private final AbstractC1822a<?> f5348j;

    /* renamed from: k */
    private final int f5349k;

    /* renamed from: l */
    private final int f5350l;

    /* renamed from: m */
    private final EnumC1582h f5351m;

    /* renamed from: n */
    private final InterfaceC1848p<R> f5352n;

    /* renamed from: o */
    @Nullable
    private final List<InterfaceC1828g<R>> f5353o;

    /* renamed from: p */
    private final InterfaceC1857g<? super R> f5354p;

    /* renamed from: q */
    private final Executor f5355q;

    /* renamed from: r */
    @GuardedBy("requestLock")
    private InterfaceC1677v<R> f5356r;

    /* renamed from: s */
    @GuardedBy("requestLock")
    private C1666k.d f5357s;

    /* renamed from: t */
    @GuardedBy("requestLock")
    private long f5358t;

    /* renamed from: u */
    private volatile C1666k f5359u;

    /* renamed from: v */
    @GuardedBy("requestLock")
    private a f5360v;

    /* renamed from: w */
    @Nullable
    @GuardedBy("requestLock")
    private Drawable f5361w;

    /* renamed from: x */
    @Nullable
    @GuardedBy("requestLock")
    private Drawable f5362x;

    /* renamed from: y */
    @Nullable
    @GuardedBy("requestLock")
    private Drawable f5363y;

    /* renamed from: z */
    @GuardedBy("requestLock")
    private int f5364z;

    /* renamed from: D */
    private static final String f5333D = "Request";

    /* renamed from: F */
    private static final boolean f5335F = Log.isLoggable(f5333D, 2);

    /* compiled from: SingleRequest.java */
    /* renamed from: com.bumptech.glide.r.j$a */
    private enum a {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    private C1831j(Context context, C1578d c1578d, @NonNull Object obj, @Nullable Object obj2, Class<R> cls, AbstractC1822a<?> abstractC1822a, int i2, int i3, EnumC1582h enumC1582h, InterfaceC1848p<R> interfaceC1848p, @Nullable InterfaceC1828g<R> interfaceC1828g, @Nullable List<InterfaceC1828g<R>> list, InterfaceC1826e interfaceC1826e, C1666k c1666k, InterfaceC1857g<? super R> interfaceC1857g, Executor executor) {
        this.f5339a = f5335F ? String.valueOf(super.hashCode()) : null;
        this.f5340b = AbstractC1882c.m5029b();
        this.f5341c = obj;
        this.f5344f = context;
        this.f5345g = c1578d;
        this.f5346h = obj2;
        this.f5347i = cls;
        this.f5348j = abstractC1822a;
        this.f5349k = i2;
        this.f5350l = i3;
        this.f5351m = enumC1582h;
        this.f5352n = interfaceC1848p;
        this.f5342d = interfaceC1828g;
        this.f5353o = list;
        this.f5343e = interfaceC1826e;
        this.f5359u = c1666k;
        this.f5354p = interfaceC1857g;
        this.f5355q = executor;
        this.f5360v = a.PENDING;
        if (this.f5338C == null && c1578d.m3696g()) {
            this.f5338C = new RuntimeException("Glide request origin trace");
        }
    }

    /* renamed from: a */
    public static <R> C1831j<R> m4851a(Context context, C1578d c1578d, Object obj, Object obj2, Class<R> cls, AbstractC1822a<?> abstractC1822a, int i2, int i3, EnumC1582h enumC1582h, InterfaceC1848p<R> interfaceC1848p, InterfaceC1828g<R> interfaceC1828g, @Nullable List<InterfaceC1828g<R>> list, InterfaceC1826e interfaceC1826e, C1666k c1666k, InterfaceC1857g<? super R> interfaceC1857g, Executor executor) {
        return new C1831j<>(context, c1578d, obj, obj2, cls, abstractC1822a, i2, i3, enumC1582h, interfaceC1848p, interfaceC1828g, list, interfaceC1826e, c1666k, interfaceC1857g, executor);
    }

    @GuardedBy("requestLock")
    /* renamed from: f */
    private void m4855f() {
        if (this.f5337B) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    @GuardedBy("requestLock")
    /* renamed from: g */
    private boolean m4856g() {
        InterfaceC1826e interfaceC1826e = this.f5343e;
        return interfaceC1826e == null || interfaceC1826e.mo4814f(this);
    }

    @GuardedBy("requestLock")
    /* renamed from: h */
    private boolean m4857h() {
        InterfaceC1826e interfaceC1826e = this.f5343e;
        return interfaceC1826e == null || interfaceC1826e.mo4810c(this);
    }

    @GuardedBy("requestLock")
    /* renamed from: i */
    private boolean m4858i() {
        InterfaceC1826e interfaceC1826e = this.f5343e;
        return interfaceC1826e == null || interfaceC1826e.mo4812d(this);
    }

    @GuardedBy("requestLock")
    /* renamed from: j */
    private void m4859j() {
        m4855f();
        this.f5340b.mo5030a();
        this.f5352n.mo3708a((InterfaceC1847o) this);
        C1666k.d dVar = this.f5357s;
        if (dVar != null) {
            dVar.m4159a();
            this.f5357s = null;
        }
    }

    @GuardedBy("requestLock")
    /* renamed from: k */
    private Drawable m4860k() {
        if (this.f5361w == null) {
            this.f5361w = this.f5348j.m4784k();
            if (this.f5361w == null && this.f5348j.m4783j() > 0) {
                this.f5361w = m4850a(this.f5348j.m4783j());
            }
        }
        return this.f5361w;
    }

    @GuardedBy("requestLock")
    /* renamed from: l */
    private Drawable m4861l() {
        if (this.f5363y == null) {
            this.f5363y = this.f5348j.m4785l();
            if (this.f5363y == null && this.f5348j.m4786m() > 0) {
                this.f5363y = m4850a(this.f5348j.m4786m());
            }
        }
        return this.f5363y;
    }

    @GuardedBy("requestLock")
    /* renamed from: m */
    private Drawable m4862m() {
        if (this.f5362x == null) {
            this.f5362x = this.f5348j.m4791r();
            if (this.f5362x == null && this.f5348j.m4792s() > 0) {
                this.f5362x = m4850a(this.f5348j.m4792s());
            }
        }
        return this.f5362x;
    }

    @GuardedBy("requestLock")
    /* renamed from: n */
    private boolean m4863n() {
        InterfaceC1826e interfaceC1826e = this.f5343e;
        return interfaceC1826e == null || !interfaceC1826e.getRoot().mo4805a();
    }

    @GuardedBy("requestLock")
    /* renamed from: o */
    private void m4864o() {
        InterfaceC1826e interfaceC1826e = this.f5343e;
        if (interfaceC1826e != null) {
            interfaceC1826e.mo4807b(this);
        }
    }

    @GuardedBy("requestLock")
    /* renamed from: p */
    private void m4865p() {
        InterfaceC1826e interfaceC1826e = this.f5343e;
        if (interfaceC1826e != null) {
            interfaceC1826e.mo4813e(this);
        }
    }

    @GuardedBy("requestLock")
    /* renamed from: q */
    private void m4866q() {
        if (m4857h()) {
            Drawable m4861l = this.f5346h == null ? m4861l() : null;
            if (m4861l == null) {
                m4861l = m4860k();
            }
            if (m4861l == null) {
                m4861l = m4862m();
            }
            this.f5352n.mo3706a(m4861l);
        }
    }

    @Override // com.bumptech.glide.p137r.InterfaceC1825d
    /* renamed from: b */
    public boolean mo4808b() {
        boolean z;
        synchronized (this.f5341c) {
            z = this.f5360v == a.CLEARED;
        }
        return z;
    }

    @Override // com.bumptech.glide.p137r.InterfaceC1825d
    /* renamed from: c */
    public void mo4809c() {
        synchronized (this.f5341c) {
            m4855f();
            this.f5340b.mo5030a();
            this.f5358t = C1872f.m4970a();
            if (this.f5346h == null) {
                if (C1878l.m5008b(this.f5349k, this.f5350l)) {
                    this.f5364z = this.f5349k;
                    this.f5336A = this.f5350l;
                }
                m4852a(new C1672q("Received null model"), m4861l() == null ? 5 : 3);
                return;
            }
            if (this.f5360v == a.RUNNING) {
                throw new IllegalArgumentException("Cannot restart a running request");
            }
            if (this.f5360v == a.COMPLETE) {
                mo4847a((InterfaceC1677v<?>) this.f5356r, EnumC1587a.MEMORY_CACHE);
                return;
            }
            this.f5360v = a.WAITING_FOR_SIZE;
            if (C1878l.m5008b(this.f5349k, this.f5350l)) {
                mo4867a(this.f5349k, this.f5350l);
            } else {
                this.f5352n.mo3711b(this);
            }
            if ((this.f5360v == a.RUNNING || this.f5360v == a.WAITING_FOR_SIZE) && m4857h()) {
                this.f5352n.mo3710b(m4862m());
            }
            if (f5335F) {
                m4854a("finished run method in " + C1872f.m4969a(this.f5358t));
            }
        }
    }

    @Override // com.bumptech.glide.p137r.InterfaceC1825d
    public void clear() {
        InterfaceC1677v<R> interfaceC1677v;
        synchronized (this.f5341c) {
            m4855f();
            this.f5340b.mo5030a();
            if (this.f5360v == a.CLEARED) {
                return;
            }
            m4859j();
            if (this.f5356r != null) {
                interfaceC1677v = this.f5356r;
                this.f5356r = null;
            } else {
                interfaceC1677v = null;
            }
            if (m4856g()) {
                this.f5352n.mo3712c(m4862m());
            }
            this.f5360v = a.CLEARED;
            if (interfaceC1677v != null) {
                this.f5359u.m4154b((InterfaceC1677v<?>) interfaceC1677v);
            }
        }
    }

    @Override // com.bumptech.glide.p137r.InterfaceC1825d
    /* renamed from: d */
    public boolean mo4811d() {
        boolean z;
        synchronized (this.f5341c) {
            z = this.f5360v == a.COMPLETE;
        }
        return z;
    }

    @Override // com.bumptech.glide.p137r.InterfaceC1830i
    /* renamed from: e */
    public Object mo4848e() {
        this.f5340b.mo5030a();
        return this.f5341c;
    }

    @Override // com.bumptech.glide.p137r.InterfaceC1825d
    public boolean isRunning() {
        boolean z;
        synchronized (this.f5341c) {
            z = this.f5360v == a.RUNNING || this.f5360v == a.WAITING_FOR_SIZE;
        }
        return z;
    }

    @Override // com.bumptech.glide.p137r.InterfaceC1825d
    public void pause() {
        synchronized (this.f5341c) {
            if (isRunning()) {
                clear();
            }
        }
    }

    @Override // com.bumptech.glide.p137r.InterfaceC1825d
    /* renamed from: a */
    public boolean mo4805a() {
        boolean z;
        synchronized (this.f5341c) {
            z = this.f5360v == a.COMPLETE;
        }
        return z;
    }

    @GuardedBy("requestLock")
    /* renamed from: a */
    private Drawable m4850a(@DrawableRes int i2) {
        return C1754a.m4413a(this.f5345g, i2, this.f5348j.m4797x() != null ? this.f5348j.m4797x() : this.f5344f.getTheme());
    }

    @Override // com.bumptech.glide.p137r.p138l.InterfaceC1847o
    /* renamed from: a */
    public void mo4867a(int i2, int i3) {
        Object obj;
        this.f5340b.mo5030a();
        Object obj2 = this.f5341c;
        synchronized (obj2) {
            try {
                try {
                    if (f5335F) {
                        m4854a("Got onSizeReady in " + C1872f.m4969a(this.f5358t));
                    }
                    if (this.f5360v == a.WAITING_FOR_SIZE) {
                        this.f5360v = a.RUNNING;
                        float m4796w = this.f5348j.m4796w();
                        this.f5364z = m4849a(i2, m4796w);
                        this.f5336A = m4849a(i3, m4796w);
                        if (f5335F) {
                            m4854a("finished setup for calling load in " + C1872f.m4969a(this.f5358t));
                        }
                        obj = obj2;
                        try {
                            this.f5357s = this.f5359u.m4148a(this.f5345g, this.f5346h, this.f5348j.m4795v(), this.f5364z, this.f5336A, this.f5348j.m4794u(), this.f5347i, this.f5351m, this.f5348j.m4782i(), this.f5348j.m4798y(), this.f5348j.m4731J(), this.f5348j.m4728G(), this.f5348j.m4788o(), this.f5348j.m4726E(), this.f5348j.m4722A(), this.f5348j.m4799z(), this.f5348j.m4787n(), this, this.f5355q);
                            if (this.f5360v != a.RUNNING) {
                                this.f5357s = null;
                            }
                            if (f5335F) {
                                m4854a("finished onSizeReady in " + C1872f.m4969a(this.f5358t));
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

    /* renamed from: a */
    private static int m4849a(int i2, float f2) {
        return i2 == Integer.MIN_VALUE ? i2 : Math.round(f2 * i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004f, code lost:
    
        if (r6 == null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0051, code lost:
    
        r5.f5359u.m4154b(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0056, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ad, code lost:
    
        if (r6 == null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00af, code lost:
    
        r5.f5359u.m4154b(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b4, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:?, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.p137r.InterfaceC1830i
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo4847a(com.bumptech.glide.load.p118p.InterfaceC1677v<?> r6, com.bumptech.glide.load.EnumC1587a r7) {
        /*
            r5 = this;
            com.bumptech.glide.util.n.c r0 = r5.f5340b
            r0.mo5030a()
            r0 = 0
            java.lang.Object r1 = r5.f5341c     // Catch: java.lang.Throwable -> Lbf
            monitor-enter(r1)     // Catch: java.lang.Throwable -> Lbf
            r5.f5357s = r0     // Catch: java.lang.Throwable -> Lb5
            if (r6 != 0) goto L2f
            com.bumptech.glide.load.p.q r6 = new com.bumptech.glide.load.p.q     // Catch: java.lang.Throwable -> Lb5
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb5
            r7.<init>()     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r2 = "Expected to receive a Resource<R> with an object of "
            r7.append(r2)     // Catch: java.lang.Throwable -> Lb5
            java.lang.Class<R> r2 = r5.f5347i     // Catch: java.lang.Throwable -> Lb5
            r7.append(r2)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r2 = " inside, but instead got null."
            r7.append(r2)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> Lb5
            r6.<init>(r7)     // Catch: java.lang.Throwable -> Lb5
            r5.mo4846a(r6)     // Catch: java.lang.Throwable -> Lb5
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lb5
            return
        L2f:
            java.lang.Object r2 = r6.get()     // Catch: java.lang.Throwable -> Lb5
            if (r2 == 0) goto L5c
            java.lang.Class<R> r3 = r5.f5347i     // Catch: java.lang.Throwable -> Lb5
            java.lang.Class r4 = r2.getClass()     // Catch: java.lang.Throwable -> Lb5
            boolean r3 = r3.isAssignableFrom(r4)     // Catch: java.lang.Throwable -> Lb5
            if (r3 != 0) goto L42
            goto L5c
        L42:
            boolean r3 = r5.m4858i()     // Catch: java.lang.Throwable -> Lb5
            if (r3 != 0) goto L57
            r5.f5356r = r0     // Catch: java.lang.Throwable -> Lbd
            com.bumptech.glide.r.j$a r7 = com.bumptech.glide.p137r.C1831j.a.COMPLETE     // Catch: java.lang.Throwable -> Lbd
            r5.f5360v = r7     // Catch: java.lang.Throwable -> Lbd
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lbd
            if (r6 == 0) goto L56
            com.bumptech.glide.load.p.k r7 = r5.f5359u
            r7.m4154b(r6)
        L56:
            return
        L57:
            r5.m4853a(r6, r2, r7)     // Catch: java.lang.Throwable -> Lb5
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lb5
            return
        L5c:
            r5.f5356r = r0     // Catch: java.lang.Throwable -> Lbd
            com.bumptech.glide.load.p.q r7 = new com.bumptech.glide.load.p.q     // Catch: java.lang.Throwable -> Lbd
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lbd
            r0.<init>()     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r3 = "Expected to receive an object of "
            r0.append(r3)     // Catch: java.lang.Throwable -> Lbd
            java.lang.Class<R> r3 = r5.f5347i     // Catch: java.lang.Throwable -> Lbd
            r0.append(r3)     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r3 = " but instead got "
            r0.append(r3)     // Catch: java.lang.Throwable -> Lbd
            if (r2 == 0) goto L7b
            java.lang.Class r3 = r2.getClass()     // Catch: java.lang.Throwable -> Lbd
            goto L7d
        L7b:
            java.lang.String r3 = ""
        L7d:
            r0.append(r3)     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r3 = "{"
            r0.append(r3)     // Catch: java.lang.Throwable -> Lbd
            r0.append(r2)     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r3 = "} inside Resource{"
            r0.append(r3)     // Catch: java.lang.Throwable -> Lbd
            r0.append(r6)     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r3 = "}."
            r0.append(r3)     // Catch: java.lang.Throwable -> Lbd
            if (r2 == 0) goto L9d
            java.lang.String r2 = ""
            goto L9f
        L9d:
            java.lang.String r2 = " To indicate failure return a null Resource object, rather than a Resource object containing null data."
        L9f:
            r0.append(r2)     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Lbd
            r7.<init>(r0)     // Catch: java.lang.Throwable -> Lbd
            r5.mo4846a(r7)     // Catch: java.lang.Throwable -> Lbd
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lbd
            if (r6 == 0) goto Lb4
            com.bumptech.glide.load.p.k r7 = r5.f5359u
            r7.m4154b(r6)
        Lb4:
            return
        Lb5:
            r6 = move-exception
            r7 = r6
            r6 = r0
        Lb8:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lbd
            throw r7     // Catch: java.lang.Throwable -> Lba
        Lba:
            r7 = move-exception
            r0 = r6
            goto Lc0
        Lbd:
            r7 = move-exception
            goto Lb8
        Lbf:
            r7 = move-exception
        Lc0:
            if (r0 == 0) goto Lc7
            com.bumptech.glide.load.p.k r6 = r5.f5359u
            r6.m4154b(r0)
        Lc7:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.p137r.C1831j.mo4847a(com.bumptech.glide.load.p.v, com.bumptech.glide.load.a):void");
    }

    @GuardedBy("requestLock")
    /* renamed from: a */
    private void m4853a(InterfaceC1677v<R> interfaceC1677v, R r, EnumC1587a enumC1587a) {
        boolean z;
        boolean m4863n = m4863n();
        this.f5360v = a.COMPLETE;
        this.f5356r = interfaceC1677v;
        if (this.f5345g.m3694e() <= 3) {
            String str = "Finished loading " + r.getClass().getSimpleName() + " from " + enumC1587a + " for " + this.f5346h + " with size [" + this.f5364z + "x" + this.f5336A + "] in " + C1872f.m4969a(this.f5358t) + " ms";
        }
        boolean z2 = true;
        this.f5337B = true;
        try {
            if (this.f5353o != null) {
                Iterator<InterfaceC1828g<R>> it = this.f5353o.iterator();
                z = false;
                while (it.hasNext()) {
                    z |= it.next().mo4817a(r, this.f5346h, this.f5352n, enumC1587a, m4863n);
                }
            } else {
                z = false;
            }
            if (this.f5342d == null || !this.f5342d.mo4817a(r, this.f5346h, this.f5352n, enumC1587a, m4863n)) {
                z2 = false;
            }
            if (!(z2 | z)) {
                this.f5352n.mo3709a(r, this.f5354p.mo4934a(enumC1587a, m4863n));
            }
            this.f5337B = false;
            m4865p();
        } catch (Throwable th) {
            this.f5337B = false;
            throw th;
        }
    }

    @Override // com.bumptech.glide.p137r.InterfaceC1830i
    /* renamed from: a */
    public void mo4846a(C1672q c1672q) {
        m4852a(c1672q, 5);
    }

    /* renamed from: a */
    private void m4852a(C1672q c1672q, int i2) {
        boolean z;
        this.f5340b.mo5030a();
        synchronized (this.f5341c) {
            c1672q.setOrigin(this.f5338C);
            int m3694e = this.f5345g.m3694e();
            if (m3694e <= i2) {
                String str = "Load failed for " + this.f5346h + " with size [" + this.f5364z + "x" + this.f5336A + "]";
                if (m3694e <= 4) {
                    c1672q.logRootCauses(f5334E);
                }
            }
            this.f5357s = null;
            this.f5360v = a.FAILED;
            boolean z2 = true;
            this.f5337B = true;
            try {
                if (this.f5353o != null) {
                    Iterator<InterfaceC1828g<R>> it = this.f5353o.iterator();
                    z = false;
                    while (it.hasNext()) {
                        z |= it.next().mo4816a(c1672q, this.f5346h, this.f5352n, m4863n());
                    }
                } else {
                    z = false;
                }
                if (this.f5342d == null || !this.f5342d.mo4816a(c1672q, this.f5346h, this.f5352n, m4863n())) {
                    z2 = false;
                }
                if (!(z | z2)) {
                    m4866q();
                }
                this.f5337B = false;
                m4864o();
            } catch (Throwable th) {
                this.f5337B = false;
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.p137r.InterfaceC1825d
    /* renamed from: a */
    public boolean mo4806a(InterfaceC1825d interfaceC1825d) {
        int i2;
        int i3;
        Object obj;
        Class<R> cls;
        AbstractC1822a<?> abstractC1822a;
        EnumC1582h enumC1582h;
        int size;
        int i4;
        int i5;
        Object obj2;
        Class<R> cls2;
        AbstractC1822a<?> abstractC1822a2;
        EnumC1582h enumC1582h2;
        int size2;
        if (!(interfaceC1825d instanceof C1831j)) {
            return false;
        }
        synchronized (this.f5341c) {
            i2 = this.f5349k;
            i3 = this.f5350l;
            obj = this.f5346h;
            cls = this.f5347i;
            abstractC1822a = this.f5348j;
            enumC1582h = this.f5351m;
            size = this.f5353o != null ? this.f5353o.size() : 0;
        }
        C1831j c1831j = (C1831j) interfaceC1825d;
        synchronized (c1831j.f5341c) {
            i4 = c1831j.f5349k;
            i5 = c1831j.f5350l;
            obj2 = c1831j.f5346h;
            cls2 = c1831j.f5347i;
            abstractC1822a2 = c1831j.f5348j;
            enumC1582h2 = c1831j.f5351m;
            size2 = c1831j.f5353o != null ? c1831j.f5353o.size() : 0;
        }
        return i2 == i4 && i3 == i5 && C1878l.m5004a(obj, obj2) && cls.equals(cls2) && abstractC1822a.equals(abstractC1822a2) && enumC1582h == enumC1582h2 && size == size2;
    }

    /* renamed from: a */
    private void m4854a(String str) {
        String str2 = str + " this: " + this.f5339a;
    }
}
