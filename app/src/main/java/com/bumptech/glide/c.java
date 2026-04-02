package com.bumptech.glide;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.os.BuildCompat;
import com.bumptech.glide.b;
import com.bumptech.glide.load.p.b0.a;
import com.bumptech.glide.load.p.b0.l;
import com.bumptech.glide.manager.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: GlideBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: b */
    private com.bumptech.glide.load.p.k f2649b;

    /* JADX INFO: renamed from: c */
    private com.bumptech.glide.load.p.a0.e f2650c;

    /* JADX INFO: renamed from: d */
    private com.bumptech.glide.load.p.a0.b f2651d;

    /* JADX INFO: renamed from: e */
    private com.bumptech.glide.load.p.b0.j f2652e;

    /* JADX INFO: renamed from: f */
    private com.bumptech.glide.load.p.c0.a f2653f;

    /* JADX INFO: renamed from: g */
    private com.bumptech.glide.load.p.c0.a f2654g;

    /* JADX INFO: renamed from: h */
    private a.InterfaceC0046a f2655h;

    /* JADX INFO: renamed from: i */
    private com.bumptech.glide.load.p.b0.l f2656i;

    /* JADX INFO: renamed from: j */
    private com.bumptech.glide.manager.d f2657j;

    /* JADX INFO: renamed from: m */
    @Nullable
    private k.b f2660m;

    /* JADX INFO: renamed from: n */
    private com.bumptech.glide.load.p.c0.a f2661n;
    private boolean o;

    @Nullable
    private List<com.bumptech.glide.r.g<Object>> p;
    private boolean q;
    private boolean r;
    private final Map<Class<?>, l<?, ?>> a = new ArrayMap();

    /* JADX INFO: renamed from: k */
    private int f2658k = 4;

    /* JADX INFO: renamed from: l */
    private b.a f2659l = new a();

    /* JADX INFO: compiled from: GlideBuilder.java */
    class a implements b.a {
        a() {
        }

        @Override // com.bumptech.glide.b.a
        @NonNull
        public com.bumptech.glide.r.h build() {
            return new com.bumptech.glide.r.h();
        }
    }

    /* JADX INFO: compiled from: GlideBuilder.java */
    class b implements b.a {
        final /* synthetic */ com.bumptech.glide.r.h a;

        b(com.bumptech.glide.r.h hVar) {
            this.a = hVar;
        }

        @Override // com.bumptech.glide.b.a
        @NonNull
        public com.bumptech.glide.r.h build() {
            com.bumptech.glide.r.h hVar = this.a;
            return hVar != null ? hVar : new com.bumptech.glide.r.h();
        }
    }

    @NonNull
    public c a(@Nullable com.bumptech.glide.load.p.a0.e eVar) {
        this.f2650c = eVar;
        return this;
    }

    @NonNull
    public c b(@Nullable com.bumptech.glide.load.p.c0.a aVar) {
        this.f2654g = aVar;
        return this;
    }

    @Deprecated
    public c c(@Nullable com.bumptech.glide.load.p.c0.a aVar) {
        return d(aVar);
    }

    @NonNull
    public c d(@Nullable com.bumptech.glide.load.p.c0.a aVar) {
        this.f2653f = aVar;
        return this;
    }

    @NonNull
    public c a(@Nullable com.bumptech.glide.load.p.a0.b bVar) {
        this.f2651d = bVar;
        return this;
    }

    @NonNull
    public c b(boolean z) {
        this.o = z;
        return this;
    }

    public c c(boolean z) {
        this.q = z;
        return this;
    }

    @NonNull
    public c a(@Nullable com.bumptech.glide.load.p.b0.j jVar) {
        this.f2652e = jVar;
        return this;
    }

    @NonNull
    public c a(@Nullable a.InterfaceC0046a interfaceC0046a) {
        this.f2655h = interfaceC0046a;
        return this;
    }

    @NonNull
    public c a(@Nullable com.bumptech.glide.load.p.c0.a aVar) {
        this.f2661n = aVar;
        return this;
    }

    @NonNull
    public c a(@Nullable com.bumptech.glide.r.h hVar) {
        return a(new b(hVar));
    }

    @NonNull
    public c a(@NonNull b.a aVar) {
        this.f2659l = (b.a) com.bumptech.glide.util.j.a(aVar);
        return this;
    }

    @NonNull
    public <T> c a(@NonNull Class<T> cls, @Nullable l<?, T> lVar) {
        this.a.put(cls, lVar);
        return this;
    }

    @NonNull
    public c a(@NonNull l.a aVar) {
        return a(aVar.a());
    }

    @NonNull
    public c a(@Nullable com.bumptech.glide.load.p.b0.l lVar) {
        this.f2656i = lVar;
        return this;
    }

    @NonNull
    public c a(@Nullable com.bumptech.glide.manager.d dVar) {
        this.f2657j = dVar;
        return this;
    }

    @NonNull
    public c a(int i2) {
        if (i2 >= 2 && i2 <= 6) {
            this.f2658k = i2;
            return this;
        }
        throw new IllegalArgumentException("Log level must be one of Log.VERBOSE, Log.DEBUG, Log.INFO, Log.WARN, or Log.ERROR");
    }

    @NonNull
    public c a(@NonNull com.bumptech.glide.r.g<Object> gVar) {
        if (this.p == null) {
            this.p = new ArrayList();
        }
        this.p.add(gVar);
        return this;
    }

    public c a(boolean z) {
        if (!BuildCompat.isAtLeastQ()) {
            return this;
        }
        this.r = z;
        return this;
    }

    void a(@Nullable k.b bVar) {
        this.f2660m = bVar;
    }

    c a(com.bumptech.glide.load.p.k kVar) {
        this.f2649b = kVar;
        return this;
    }

    @NonNull
    com.bumptech.glide.b a(@NonNull Context context) {
        if (this.f2653f == null) {
            this.f2653f = com.bumptech.glide.load.p.c0.a.g();
        }
        if (this.f2654g == null) {
            this.f2654g = com.bumptech.glide.load.p.c0.a.e();
        }
        if (this.f2661n == null) {
            this.f2661n = com.bumptech.glide.load.p.c0.a.c();
        }
        if (this.f2656i == null) {
            this.f2656i = new l.a(context).a();
        }
        if (this.f2657j == null) {
            this.f2657j = new com.bumptech.glide.manager.f();
        }
        if (this.f2650c == null) {
            int iB = this.f2656i.b();
            if (iB > 0) {
                this.f2650c = new com.bumptech.glide.load.p.a0.k(iB);
            } else {
                this.f2650c = new com.bumptech.glide.load.p.a0.f();
            }
        }
        if (this.f2651d == null) {
            this.f2651d = new com.bumptech.glide.load.p.a0.j(this.f2656i.a());
        }
        if (this.f2652e == null) {
            this.f2652e = new com.bumptech.glide.load.p.b0.i(this.f2656i.c());
        }
        if (this.f2655h == null) {
            this.f2655h = new com.bumptech.glide.load.p.b0.h(context);
        }
        if (this.f2649b == null) {
            this.f2649b = new com.bumptech.glide.load.p.k(this.f2652e, this.f2655h, this.f2654g, this.f2653f, com.bumptech.glide.load.p.c0.a.h(), this.f2661n, this.o);
        }
        List<com.bumptech.glide.r.g<Object>> list = this.p;
        if (list == null) {
            this.p = Collections.emptyList();
        } else {
            this.p = Collections.unmodifiableList(list);
        }
        return new com.bumptech.glide.b(context, this.f2649b, this.f2652e, this.f2650c, this.f2651d, new com.bumptech.glide.manager.k(this.f2660m), this.f2657j, this.f2658k, this.f2659l, this.a, this.p, this.q, this.r);
    }
}
