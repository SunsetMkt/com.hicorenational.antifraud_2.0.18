package com.bumptech.glide;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.os.BuildCompat;
import com.bumptech.glide.ComponentCallbacks2C1576b;
import com.bumptech.glide.load.p118p.C1666k;
import com.bumptech.glide.load.p118p.p119a0.C1627f;
import com.bumptech.glide.load.p118p.p119a0.C1631j;
import com.bumptech.glide.load.p118p.p119a0.C1632k;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1623b;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e;
import com.bumptech.glide.load.p118p.p120b0.C1646h;
import com.bumptech.glide.load.p118p.p120b0.C1647i;
import com.bumptech.glide.load.p118p.p120b0.C1650l;
import com.bumptech.glide.load.p118p.p120b0.InterfaceC1639a;
import com.bumptech.glide.load.p118p.p120b0.InterfaceC1648j;
import com.bumptech.glide.load.p118p.p121c0.ExecutorServiceC1653a;
import com.bumptech.glide.manager.C1792f;
import com.bumptech.glide.manager.C1797k;
import com.bumptech.glide.manager.InterfaceC1790d;
import com.bumptech.glide.p137r.C1829h;
import com.bumptech.glide.p137r.InterfaceC1828g;
import com.bumptech.glide.util.C1876j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: GlideBuilder.java */
/* renamed from: com.bumptech.glide.c */
/* loaded from: classes.dex */
public final class C1577c {

    /* renamed from: b */
    private C1666k f4079b;

    /* renamed from: c */
    private InterfaceC1626e f4080c;

    /* renamed from: d */
    private InterfaceC1623b f4081d;

    /* renamed from: e */
    private InterfaceC1648j f4082e;

    /* renamed from: f */
    private ExecutorServiceC1653a f4083f;

    /* renamed from: g */
    private ExecutorServiceC1653a f4084g;

    /* renamed from: h */
    private InterfaceC1639a.a f4085h;

    /* renamed from: i */
    private C1650l f4086i;

    /* renamed from: j */
    private InterfaceC1790d f4087j;

    /* renamed from: m */
    @Nullable
    private C1797k.b f4090m;

    /* renamed from: n */
    private ExecutorServiceC1653a f4091n;

    /* renamed from: o */
    private boolean f4092o;

    /* renamed from: p */
    @Nullable
    private List<InterfaceC1828g<Object>> f4093p;

    /* renamed from: q */
    private boolean f4094q;

    /* renamed from: r */
    private boolean f4095r;

    /* renamed from: a */
    private final Map<Class<?>, AbstractC1586l<?, ?>> f4078a = new ArrayMap();

    /* renamed from: k */
    private int f4088k = 4;

    /* renamed from: l */
    private ComponentCallbacks2C1576b.a f4089l = new a();

    /* compiled from: GlideBuilder.java */
    /* renamed from: com.bumptech.glide.c$a */
    class a implements ComponentCallbacks2C1576b.a {
        a() {
        }

        @Override // com.bumptech.glide.ComponentCallbacks2C1576b.a
        @NonNull
        public C1829h build() {
            return new C1829h();
        }
    }

    /* compiled from: GlideBuilder.java */
    /* renamed from: com.bumptech.glide.c$b */
    class b implements ComponentCallbacks2C1576b.a {

        /* renamed from: a */
        final /* synthetic */ C1829h f4097a;

        b(C1829h c1829h) {
            this.f4097a = c1829h;
        }

        @Override // com.bumptech.glide.ComponentCallbacks2C1576b.a
        @NonNull
        public C1829h build() {
            C1829h c1829h = this.f4097a;
            return c1829h != null ? c1829h : new C1829h();
        }
    }

    @NonNull
    /* renamed from: a */
    public C1577c m3670a(@Nullable InterfaceC1626e interfaceC1626e) {
        this.f4080c = interfaceC1626e;
        return this;
    }

    @NonNull
    /* renamed from: b */
    public C1577c m3683b(@Nullable ExecutorServiceC1653a executorServiceC1653a) {
        this.f4084g = executorServiceC1653a;
        return this;
    }

    @Deprecated
    /* renamed from: c */
    public C1577c m3685c(@Nullable ExecutorServiceC1653a executorServiceC1653a) {
        return m3687d(executorServiceC1653a);
    }

    @NonNull
    /* renamed from: d */
    public C1577c m3687d(@Nullable ExecutorServiceC1653a executorServiceC1653a) {
        this.f4083f = executorServiceC1653a;
        return this;
    }

    @NonNull
    /* renamed from: a */
    public C1577c m3669a(@Nullable InterfaceC1623b interfaceC1623b) {
        this.f4081d = interfaceC1623b;
        return this;
    }

    @NonNull
    /* renamed from: b */
    public C1577c m3684b(boolean z) {
        this.f4092o = z;
        return this;
    }

    /* renamed from: c */
    public C1577c m3686c(boolean z) {
        this.f4094q = z;
        return this;
    }

    @NonNull
    /* renamed from: a */
    public C1577c m3672a(@Nullable InterfaceC1648j interfaceC1648j) {
        this.f4082e = interfaceC1648j;
        return this;
    }

    @NonNull
    /* renamed from: a */
    public C1577c m3671a(@Nullable InterfaceC1639a.a aVar) {
        this.f4085h = aVar;
        return this;
    }

    @NonNull
    /* renamed from: a */
    public C1577c m3675a(@Nullable ExecutorServiceC1653a executorServiceC1653a) {
        this.f4091n = executorServiceC1653a;
        return this;
    }

    @NonNull
    /* renamed from: a */
    public C1577c m3679a(@Nullable C1829h c1829h) {
        return m3668a(new b(c1829h));
    }

    @NonNull
    /* renamed from: a */
    public C1577c m3668a(@NonNull ComponentCallbacks2C1576b.a aVar) {
        this.f4089l = (ComponentCallbacks2C1576b.a) C1876j.m4985a(aVar);
        return this;
    }

    @NonNull
    /* renamed from: a */
    public <T> C1577c m3680a(@NonNull Class<T> cls, @Nullable AbstractC1586l<?, T> abstractC1586l) {
        this.f4078a.put(cls, abstractC1586l);
        return this;
    }

    @NonNull
    /* renamed from: a */
    public C1577c m3673a(@NonNull C1650l.a aVar) {
        return m3674a(aVar.m4016a());
    }

    @NonNull
    /* renamed from: a */
    public C1577c m3674a(@Nullable C1650l c1650l) {
        this.f4086i = c1650l;
        return this;
    }

    @NonNull
    /* renamed from: a */
    public C1577c m3677a(@Nullable InterfaceC1790d interfaceC1790d) {
        this.f4087j = interfaceC1790d;
        return this;
    }

    @NonNull
    /* renamed from: a */
    public C1577c m3667a(int i2) {
        if (i2 >= 2 && i2 <= 6) {
            this.f4088k = i2;
            return this;
        }
        throw new IllegalArgumentException("Log level must be one of Log.VERBOSE, Log.DEBUG, Log.INFO, Log.WARN, or Log.ERROR");
    }

    @NonNull
    /* renamed from: a */
    public C1577c m3678a(@NonNull InterfaceC1828g<Object> interfaceC1828g) {
        if (this.f4093p == null) {
            this.f4093p = new ArrayList();
        }
        this.f4093p.add(interfaceC1828g);
        return this;
    }

    /* renamed from: a */
    public C1577c m3681a(boolean z) {
        if (!BuildCompat.isAtLeastQ()) {
            return this;
        }
        this.f4095r = z;
        return this;
    }

    /* renamed from: a */
    void m3682a(@Nullable C1797k.b bVar) {
        this.f4090m = bVar;
    }

    /* renamed from: a */
    C1577c m3676a(C1666k c1666k) {
        this.f4079b = c1666k;
        return this;
    }

    @NonNull
    /* renamed from: a */
    ComponentCallbacks2C1576b m3666a(@NonNull Context context) {
        if (this.f4083f == null) {
            this.f4083f = ExecutorServiceC1653a.m4038g();
        }
        if (this.f4084g == null) {
            this.f4084g = ExecutorServiceC1653a.m4036e();
        }
        if (this.f4091n == null) {
            this.f4091n = ExecutorServiceC1653a.m4034c();
        }
        if (this.f4086i == null) {
            this.f4086i = new C1650l.a(context).m4016a();
        }
        if (this.f4087j == null) {
            this.f4087j = new C1792f();
        }
        if (this.f4080c == null) {
            int m4010b = this.f4086i.m4010b();
            if (m4010b > 0) {
                this.f4080c = new C1632k(m4010b);
            } else {
                this.f4080c = new C1627f();
            }
        }
        if (this.f4081d == null) {
            this.f4081d = new C1631j(this.f4086i.m4009a());
        }
        if (this.f4082e == null) {
            this.f4082e = new C1647i(this.f4086i.m4011c());
        }
        if (this.f4085h == null) {
            this.f4085h = new C1646h(context);
        }
        if (this.f4079b == null) {
            this.f4079b = new C1666k(this.f4082e, this.f4085h, this.f4084g, this.f4083f, ExecutorServiceC1653a.m4039h(), this.f4091n, this.f4092o);
        }
        List<InterfaceC1828g<Object>> list = this.f4093p;
        if (list == null) {
            this.f4093p = Collections.emptyList();
        } else {
            this.f4093p = Collections.unmodifiableList(list);
        }
        return new ComponentCallbacks2C1576b(context, this.f4079b, this.f4082e, this.f4080c, this.f4081d, new C1797k(this.f4090m), this.f4087j, this.f4088k, this.f4089l, this.f4078a, this.f4093p, this.f4094q, this.f4095r);
    }
}
