package com.bumptech.glide.load.p118p;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.C1578d;
import com.bumptech.glide.C1583i;
import com.bumptech.glide.EnumC1582h;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.EnumC1587a;
import com.bumptech.glide.load.EnumC1589c;
import com.bumptech.glide.load.InterfaceC1593g;
import com.bumptech.glide.load.InterfaceC1599m;
import com.bumptech.glide.load.InterfaceC1600n;
import com.bumptech.glide.load.p116o.InterfaceC1604d;
import com.bumptech.glide.load.p116o.InterfaceC1605e;
import com.bumptech.glide.load.p118p.C1664i;
import com.bumptech.glide.load.p118p.InterfaceC1661f;
import com.bumptech.glide.load.p118p.p120b0.InterfaceC1639a;
import com.bumptech.glide.load.p125r.p126d.C1742q;
import com.bumptech.glide.util.C1872f;
import com.bumptech.glide.util.p141n.AbstractC1882c;
import com.bumptech.glide.util.p141n.C1880a;
import com.bumptech.glide.util.p141n.C1881b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: DecodeJob.java */
/* renamed from: com.bumptech.glide.load.p.h */
/* loaded from: classes.dex */
class RunnableC1663h<R> implements InterfaceC1661f.a, Runnable, Comparable<RunnableC1663h<?>>, C1880a.f {

    /* renamed from: F */
    private static final String f4486F = "DecodeJob";

    /* renamed from: A */
    private EnumC1587a f4487A;

    /* renamed from: B */
    private InterfaceC1604d<?> f4488B;

    /* renamed from: C */
    private volatile InterfaceC1661f f4489C;

    /* renamed from: D */
    private volatile boolean f4490D;

    /* renamed from: E */
    private volatile boolean f4491E;

    /* renamed from: d */
    private final e f4495d;

    /* renamed from: e */
    private final Pools.Pool<RunnableC1663h<?>> f4496e;

    /* renamed from: h */
    private C1578d f4499h;

    /* renamed from: i */
    private InterfaceC1593g f4500i;

    /* renamed from: j */
    private EnumC1582h f4501j;

    /* renamed from: k */
    private C1669n f4502k;

    /* renamed from: l */
    private int f4503l;

    /* renamed from: m */
    private int f4504m;

    /* renamed from: n */
    private AbstractC1665j f4505n;

    /* renamed from: o */
    private C1596j f4506o;

    /* renamed from: p */
    private b<R> f4507p;

    /* renamed from: q */
    private int f4508q;

    /* renamed from: r */
    private h f4509r;

    /* renamed from: s */
    private g f4510s;

    /* renamed from: t */
    private long f4511t;

    /* renamed from: u */
    private boolean f4512u;

    /* renamed from: v */
    private Object f4513v;

    /* renamed from: w */
    private Thread f4514w;

    /* renamed from: x */
    private InterfaceC1593g f4515x;

    /* renamed from: y */
    private InterfaceC1593g f4516y;

    /* renamed from: z */
    private Object f4517z;

    /* renamed from: a */
    private final C1662g<R> f4492a = new C1662g<>();

    /* renamed from: b */
    private final List<Throwable> f4493b = new ArrayList();

    /* renamed from: c */
    private final AbstractC1882c f4494c = AbstractC1882c.m5029b();

    /* renamed from: f */
    private final d<?> f4497f = new d<>();

    /* renamed from: g */
    private final f f4498g = new f();

    /* compiled from: DecodeJob.java */
    /* renamed from: com.bumptech.glide.load.p.h$a */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f4518a;

        /* renamed from: b */
        static final /* synthetic */ int[] f4519b;

        /* renamed from: c */
        static final /* synthetic */ int[] f4520c = new int[EnumC1589c.values().length];

        static {
            try {
                f4520c[EnumC1589c.SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4520c[EnumC1589c.TRANSFORMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f4519b = new int[h.values().length];
            try {
                f4519b[h.RESOURCE_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4519b[h.DATA_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4519b[h.SOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4519b[h.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4519b[h.INITIALIZE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            f4518a = new int[g.values().length];
            try {
                f4518a[g.INITIALIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4518a[g.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f4518a[g.DECODE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* compiled from: DecodeJob.java */
    /* renamed from: com.bumptech.glide.load.p.h$b */
    interface b<R> {
        /* renamed from: a */
        void mo4121a(RunnableC1663h<?> runnableC1663h);

        /* renamed from: a */
        void mo4122a(C1672q c1672q);

        /* renamed from: a */
        void mo4123a(InterfaceC1677v<R> interfaceC1677v, EnumC1587a enumC1587a);
    }

    /* compiled from: DecodeJob.java */
    /* renamed from: com.bumptech.glide.load.p.h$c */
    private final class c<Z> implements C1664i.a<Z> {

        /* renamed from: a */
        private final EnumC1587a f4521a;

        c(EnumC1587a enumC1587a) {
            this.f4521a = enumC1587a;
        }

        @Override // com.bumptech.glide.load.p118p.C1664i.a
        @NonNull
        /* renamed from: a */
        public InterfaceC1677v<Z> mo4124a(@NonNull InterfaceC1677v<Z> interfaceC1677v) {
            return RunnableC1663h.this.m4117a(this.f4521a, interfaceC1677v);
        }
    }

    /* compiled from: DecodeJob.java */
    /* renamed from: com.bumptech.glide.load.p.h$e */
    interface e {
        /* renamed from: a */
        InterfaceC1639a mo4129a();
    }

    /* compiled from: DecodeJob.java */
    /* renamed from: com.bumptech.glide.load.p.h$g */
    private enum g {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* compiled from: DecodeJob.java */
    /* renamed from: com.bumptech.glide.load.p.h$h */
    private enum h {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    RunnableC1663h(e eVar, Pools.Pool<RunnableC1663h<?>> pool) {
        this.f4495d = eVar;
        this.f4496e = pool;
    }

    /* renamed from: e */
    private void m4105e() {
        if (Log.isLoggable(f4486F, 2)) {
            m4103a("Retrieved data", this.f4511t, "data: " + this.f4517z + ", cache key: " + this.f4515x + ", fetcher: " + this.f4488B);
        }
        InterfaceC1677v<R> interfaceC1677v = null;
        try {
            interfaceC1677v = m4098a(this.f4488B, (InterfaceC1604d<?>) this.f4517z, this.f4487A);
        } catch (C1672q e2) {
            e2.setLoggingDetails(this.f4516y, this.f4487A);
            this.f4493b.add(e2);
        }
        if (interfaceC1677v != null) {
            m4104b(interfaceC1677v, this.f4487A);
        } else {
            m4112l();
        }
    }

    /* renamed from: f */
    private InterfaceC1661f m4106f() {
        int i2 = a.f4519b[this.f4509r.ordinal()];
        if (i2 == 1) {
            return new C1678w(this.f4492a, this);
        }
        if (i2 == 2) {
            return new C1652c(this.f4492a, this);
        }
        if (i2 == 3) {
            return new C1681z(this.f4492a, this);
        }
        if (i2 == 4) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.f4509r);
    }

    /* renamed from: g */
    private int m4107g() {
        return this.f4501j.ordinal();
    }

    /* renamed from: h */
    private void m4108h() {
        m4114n();
        this.f4507p.mo4122a(new C1672q("Failed to load resource", new ArrayList(this.f4493b)));
        m4110j();
    }

    /* renamed from: i */
    private void m4109i() {
        if (this.f4498g.m4131a()) {
            m4111k();
        }
    }

    /* renamed from: j */
    private void m4110j() {
        if (this.f4498g.m4133b()) {
            m4111k();
        }
    }

    /* renamed from: k */
    private void m4111k() {
        this.f4498g.m4134c();
        this.f4497f.m4125a();
        this.f4492a.m4076a();
        this.f4490D = false;
        this.f4499h = null;
        this.f4500i = null;
        this.f4506o = null;
        this.f4501j = null;
        this.f4502k = null;
        this.f4507p = null;
        this.f4509r = null;
        this.f4489C = null;
        this.f4514w = null;
        this.f4515x = null;
        this.f4517z = null;
        this.f4487A = null;
        this.f4488B = null;
        this.f4511t = 0L;
        this.f4491E = false;
        this.f4513v = null;
        this.f4493b.clear();
        this.f4496e.release(this);
    }

    /* renamed from: l */
    private void m4112l() {
        this.f4514w = Thread.currentThread();
        this.f4511t = C1872f.m4970a();
        boolean z = false;
        while (!this.f4491E && this.f4489C != null && !(z = this.f4489C.mo4026a())) {
            this.f4509r = m4097a(this.f4509r);
            this.f4489C = m4106f();
            if (this.f4509r == h.SOURCE) {
                mo4071b();
                return;
            }
        }
        if ((this.f4509r == h.FINISHED || this.f4491E) && !z) {
            m4108h();
        }
    }

    /* renamed from: m */
    private void m4113m() {
        int i2 = a.f4518a[this.f4510s.ordinal()];
        if (i2 == 1) {
            this.f4509r = m4097a(h.INITIALIZE);
            this.f4489C = m4106f();
            m4112l();
        } else if (i2 == 2) {
            m4112l();
        } else {
            if (i2 == 3) {
                m4105e();
                return;
            }
            throw new IllegalStateException("Unrecognized run reason: " + this.f4510s);
        }
    }

    /* renamed from: n */
    private void m4114n() {
        Throwable th;
        this.f4494c.mo5030a();
        if (!this.f4490D) {
            this.f4490D = true;
            return;
        }
        if (this.f4493b.isEmpty()) {
            th = null;
        } else {
            List<Throwable> list = this.f4493b;
            th = list.get(list.size() - 1);
        }
        throw new IllegalStateException("Already notified", th);
    }

    /* renamed from: a */
    RunnableC1663h<R> m4116a(C1578d c1578d, Object obj, C1669n c1669n, InterfaceC1593g interfaceC1593g, int i2, int i3, Class<?> cls, Class<R> cls2, EnumC1582h enumC1582h, AbstractC1665j abstractC1665j, Map<Class<?>, InterfaceC1600n<?>> map, boolean z, boolean z2, boolean z3, C1596j c1596j, b<R> bVar, int i4) {
        this.f4492a.m4077a(c1578d, obj, interfaceC1593g, i2, i3, abstractC1665j, cls, cls2, enumC1582h, c1596j, map, z, z2, this.f4495d);
        this.f4499h = c1578d;
        this.f4500i = interfaceC1593g;
        this.f4501j = enumC1582h;
        this.f4502k = c1669n;
        this.f4503l = i2;
        this.f4504m = i3;
        this.f4505n = abstractC1665j;
        this.f4512u = z3;
        this.f4506o = c1596j;
        this.f4507p = bVar;
        this.f4508q = i4;
        this.f4510s = g.INITIALIZE;
        this.f4513v = obj;
        return this;
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1661f.a
    /* renamed from: b */
    public void mo4071b() {
        this.f4510s = g.SWITCH_TO_SOURCE_SERVICE;
        this.f4507p.mo4121a((RunnableC1663h<?>) this);
    }

    @Override // com.bumptech.glide.util.p141n.C1880a.f
    @NonNull
    /* renamed from: c */
    public AbstractC1882c mo4024c() {
        return this.f4494c;
    }

    /* renamed from: d */
    boolean m4120d() {
        h m4097a = m4097a(h.INITIALIZE);
        return m4097a == h.RESOURCE_CACHE || m4097a == h.DATA_CACHE;
    }

    @Override // java.lang.Runnable
    public void run() {
        C1881b.m5025a("DecodeJob#run(model=%s)", this.f4513v);
        InterfaceC1604d<?> interfaceC1604d = this.f4488B;
        try {
            try {
                try {
                    if (this.f4491E) {
                        m4108h();
                        if (interfaceC1604d != null) {
                            interfaceC1604d.mo3851b();
                        }
                        C1881b.m5023a();
                        return;
                    }
                    m4113m();
                    if (interfaceC1604d != null) {
                        interfaceC1604d.mo3851b();
                    }
                    C1881b.m5023a();
                } catch (C1638b e2) {
                    throw e2;
                }
            } catch (Throwable th) {
                if (Log.isLoggable(f4486F, 3)) {
                    String str = "DecodeJob threw unexpectedly, isCancelled: " + this.f4491E + ", stage: " + this.f4509r;
                }
                if (this.f4509r != h.ENCODE) {
                    this.f4493b.add(th);
                    m4108h();
                }
                if (!this.f4491E) {
                    throw th;
                }
                throw th;
            }
        } catch (Throwable th2) {
            if (interfaceC1604d != null) {
                interfaceC1604d.mo3851b();
            }
            C1881b.m5023a();
            throw th2;
        }
    }

    /* compiled from: DecodeJob.java */
    /* renamed from: com.bumptech.glide.load.p.h$f */
    private static class f {

        /* renamed from: a */
        private boolean f4526a;

        /* renamed from: b */
        private boolean f4527b;

        /* renamed from: c */
        private boolean f4528c;

        f() {
        }

        /* renamed from: a */
        synchronized boolean m4132a(boolean z) {
            this.f4526a = true;
            return m4130b(z);
        }

        /* renamed from: b */
        synchronized boolean m4133b() {
            this.f4528c = true;
            return m4130b(false);
        }

        /* renamed from: c */
        synchronized void m4134c() {
            this.f4527b = false;
            this.f4526a = false;
            this.f4528c = false;
        }

        /* renamed from: b */
        private boolean m4130b(boolean z) {
            return (this.f4528c || z || this.f4527b) && this.f4526a;
        }

        /* renamed from: a */
        synchronized boolean m4131a() {
            this.f4527b = true;
            return m4130b(false);
        }
    }

    /* compiled from: DecodeJob.java */
    /* renamed from: com.bumptech.glide.load.p.h$d */
    private static class d<Z> {

        /* renamed from: a */
        private InterfaceC1593g f4523a;

        /* renamed from: b */
        private InterfaceC1599m<Z> f4524b;

        /* renamed from: c */
        private C1676u<Z> f4525c;

        d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: a */
        <X> void m4126a(InterfaceC1593g interfaceC1593g, InterfaceC1599m<X> interfaceC1599m, C1676u<X> c1676u) {
            this.f4523a = interfaceC1593g;
            this.f4524b = interfaceC1599m;
            this.f4525c = c1676u;
        }

        /* renamed from: b */
        boolean m4128b() {
            return this.f4525c != null;
        }

        /* renamed from: a */
        void m4127a(e eVar, C1596j c1596j) {
            C1881b.m5024a("DecodeJob.encode");
            try {
                eVar.mo4129a().mo3981a(this.f4523a, new C1660e(this.f4524b, this.f4525c, c1596j));
            } finally {
                this.f4525c.m4207d();
                C1881b.m5023a();
            }
        }

        /* renamed from: a */
        void m4125a() {
            this.f4523a = null;
            this.f4524b = null;
            this.f4525c = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    private void m4104b(InterfaceC1677v<R> interfaceC1677v, EnumC1587a enumC1587a) {
        if (interfaceC1677v instanceof InterfaceC1673r) {
            ((InterfaceC1673r) interfaceC1677v).mo4195c();
        }
        C1676u c1676u = 0;
        if (this.f4497f.m4128b()) {
            interfaceC1677v = C1676u.m4205b(interfaceC1677v);
            c1676u = interfaceC1677v;
        }
        m4101a((InterfaceC1677v) interfaceC1677v, enumC1587a);
        this.f4509r = h.ENCODE;
        try {
            if (this.f4497f.m4128b()) {
                this.f4497f.m4127a(this.f4495d, this.f4506o);
            }
            m4109i();
        } finally {
            if (c1676u != 0) {
                c1676u.m4207d();
            }
        }
    }

    /* renamed from: a */
    void m4119a(boolean z) {
        if (this.f4498g.m4132a(z)) {
            m4111k();
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NonNull RunnableC1663h<?> runnableC1663h) {
        int m4107g = m4107g() - runnableC1663h.m4107g();
        return m4107g == 0 ? this.f4508q - runnableC1663h.f4508q : m4107g;
    }

    /* renamed from: a */
    public void m4118a() {
        this.f4491E = true;
        InterfaceC1661f interfaceC1661f = this.f4489C;
        if (interfaceC1661f != null) {
            interfaceC1661f.cancel();
        }
    }

    /* renamed from: a */
    private void m4101a(InterfaceC1677v<R> interfaceC1677v, EnumC1587a enumC1587a) {
        m4114n();
        this.f4507p.mo4123a(interfaceC1677v, enumC1587a);
    }

    /* renamed from: a */
    private h m4097a(h hVar) {
        int i2 = a.f4519b[hVar.ordinal()];
        if (i2 == 1) {
            if (this.f4505n.mo4138a()) {
                return h.DATA_CACHE;
            }
            return m4097a(h.DATA_CACHE);
        }
        if (i2 == 2) {
            return this.f4512u ? h.FINISHED : h.SOURCE;
        }
        if (i2 == 3 || i2 == 4) {
            return h.FINISHED;
        }
        if (i2 == 5) {
            if (this.f4505n.mo4141b()) {
                return h.RESOURCE_CACHE;
            }
            return m4097a(h.RESOURCE_CACHE);
        }
        throw new IllegalArgumentException("Unrecognized stage: " + hVar);
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1661f.a
    /* renamed from: a */
    public void mo4070a(InterfaceC1593g interfaceC1593g, Object obj, InterfaceC1604d<?> interfaceC1604d, EnumC1587a enumC1587a, InterfaceC1593g interfaceC1593g2) {
        this.f4515x = interfaceC1593g;
        this.f4517z = obj;
        this.f4488B = interfaceC1604d;
        this.f4487A = enumC1587a;
        this.f4516y = interfaceC1593g2;
        if (Thread.currentThread() != this.f4514w) {
            this.f4510s = g.DECODE_DATA;
            this.f4507p.mo4121a((RunnableC1663h<?>) this);
        } else {
            C1881b.m5024a("DecodeJob.decodeFromRetrievedData");
            try {
                m4105e();
            } finally {
                C1881b.m5023a();
            }
        }
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1661f.a
    /* renamed from: a */
    public void mo4069a(InterfaceC1593g interfaceC1593g, Exception exc, InterfaceC1604d<?> interfaceC1604d, EnumC1587a enumC1587a) {
        interfaceC1604d.mo3851b();
        C1672q c1672q = new C1672q("Fetching data failed", exc);
        c1672q.setLoggingDetails(interfaceC1593g, enumC1587a, interfaceC1604d.mo3846a());
        this.f4493b.add(c1672q);
        if (Thread.currentThread() != this.f4514w) {
            this.f4510s = g.SWITCH_TO_SOURCE_SERVICE;
            this.f4507p.mo4121a((RunnableC1663h<?>) this);
        } else {
            m4112l();
        }
    }

    /* renamed from: a */
    private <Data> InterfaceC1677v<R> m4098a(InterfaceC1604d<?> interfaceC1604d, Data data, EnumC1587a enumC1587a) throws C1672q {
        if (data == null) {
            return null;
        }
        try {
            long m4970a = C1872f.m4970a();
            InterfaceC1677v<R> m4099a = m4099a((RunnableC1663h<R>) data, enumC1587a);
            if (Log.isLoggable(f4486F, 2)) {
                m4102a("Decoded result " + m4099a, m4970a);
            }
            return m4099a;
        } finally {
            interfaceC1604d.mo3851b();
        }
    }

    /* renamed from: a */
    private <Data> InterfaceC1677v<R> m4099a(Data data, EnumC1587a enumC1587a) throws C1672q {
        return m4100a((RunnableC1663h<R>) data, enumC1587a, (C1675t<RunnableC1663h<R>, ResourceType, R>) this.f4492a.m4074a((Class) data.getClass()));
    }

    @NonNull
    /* renamed from: a */
    private C1596j m4096a(EnumC1587a enumC1587a) {
        C1596j c1596j = this.f4506o;
        if (Build.VERSION.SDK_INT < 26) {
            return c1596j;
        }
        boolean z = enumC1587a == EnumC1587a.RESOURCE_DISK_CACHE || this.f4492a.m4095o();
        Boolean bool = (Boolean) c1596j.m3840a(C1742q.f4922k);
        if (bool != null && (!bool.booleanValue() || z)) {
            return c1596j;
        }
        C1596j c1596j2 = new C1596j();
        c1596j2.m3841a(this.f4506o);
        c1596j2.m3839a(C1742q.f4922k, Boolean.valueOf(z));
        return c1596j2;
    }

    /* renamed from: a */
    private <Data, ResourceType> InterfaceC1677v<R> m4100a(Data data, EnumC1587a enumC1587a, C1675t<Data, ResourceType, R> c1675t) throws C1672q {
        C1596j m4096a = m4096a(enumC1587a);
        InterfaceC1605e<Data> m3742b = this.f4499h.m3695f().m3742b((C1583i) data);
        try {
            return c1675t.m4202a(m3742b, m4096a, this.f4503l, this.f4504m, new c(enumC1587a));
        } finally {
            m3742b.mo3859b();
        }
    }

    /* renamed from: a */
    private void m4102a(String str, long j2) {
        m4103a(str, j2, (String) null);
    }

    /* renamed from: a */
    private void m4103a(String str, long j2, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(C1872f.m4969a(j2));
        sb.append(", load key: ");
        sb.append(this.f4502k);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        sb.toString();
    }

    @NonNull
    /* renamed from: a */
    <Z> InterfaceC1677v<Z> m4117a(EnumC1587a enumC1587a, @NonNull InterfaceC1677v<Z> interfaceC1677v) {
        InterfaceC1677v<Z> interfaceC1677v2;
        InterfaceC1600n<Z> interfaceC1600n;
        EnumC1589c enumC1589c;
        InterfaceC1593g c1655d;
        Class<?> cls = interfaceC1677v.get().getClass();
        InterfaceC1599m<Z> interfaceC1599m = null;
        if (enumC1587a != EnumC1587a.RESOURCE_DISK_CACHE) {
            InterfaceC1600n<Z> m4079b = this.f4492a.m4079b(cls);
            interfaceC1600n = m4079b;
            interfaceC1677v2 = m4079b.mo3828a(this.f4499h, interfaceC1677v, this.f4503l, this.f4504m);
        } else {
            interfaceC1677v2 = interfaceC1677v;
            interfaceC1600n = null;
        }
        if (!interfaceC1677v.equals(interfaceC1677v2)) {
            interfaceC1677v.recycle();
        }
        if (this.f4492a.m4081b((InterfaceC1677v<?>) interfaceC1677v2)) {
            interfaceC1599m = this.f4492a.m4073a((InterfaceC1677v) interfaceC1677v2);
            enumC1589c = interfaceC1599m.mo3844a(this.f4506o);
        } else {
            enumC1589c = EnumC1589c.NONE;
        }
        InterfaceC1599m interfaceC1599m2 = interfaceC1599m;
        if (!this.f4505n.mo4140a(!this.f4492a.m4078a(this.f4515x), enumC1587a, enumC1589c)) {
            return interfaceC1677v2;
        }
        if (interfaceC1599m2 != null) {
            int i2 = a.f4520c[enumC1589c.ordinal()];
            if (i2 == 1) {
                c1655d = new C1655d(this.f4515x, this.f4500i);
            } else if (i2 == 2) {
                c1655d = new C1679x(this.f4492a.m4080b(), this.f4515x, this.f4500i, this.f4503l, this.f4504m, interfaceC1600n, cls, this.f4506o);
            } else {
                throw new IllegalArgumentException("Unknown strategy: " + enumC1589c);
            }
            C1676u m4205b = C1676u.m4205b(interfaceC1677v2);
            this.f4497f.m4126a(c1655d, interfaceC1599m2, m4205b);
            return m4205b;
        }
        throw new C1583i.d(interfaceC1677v2.get().getClass());
    }
}
