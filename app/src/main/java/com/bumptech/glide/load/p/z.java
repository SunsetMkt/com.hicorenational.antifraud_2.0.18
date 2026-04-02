package com.bumptech.glide.load.p;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.o.d;
import com.bumptech.glide.load.p.f;
import com.bumptech.glide.load.q.n;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SourceGenerator.java */
/* JADX INFO: loaded from: classes.dex */
class z implements f, f.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f3047h = "SourceGenerator";
    private final g<?> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f.a f3048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c f3050d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Object f3051e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile n.a<?> f3052f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private d f3053g;

    z(g<?> gVar, f.a aVar) {
        this.a = gVar;
        this.f3048b = aVar;
    }

    private void b(n.a<?> aVar) {
        this.f3052f.f3091c.a(this.a.j(), new a(aVar));
    }

    private boolean c() {
        return this.f3049c < this.a.g().size();
    }

    @Override // com.bumptech.glide.load.p.f
    public boolean a() {
        Object obj = this.f3051e;
        if (obj != null) {
            this.f3051e = null;
            a(obj);
        }
        c cVar = this.f3050d;
        if (cVar != null && cVar.a()) {
            return true;
        }
        this.f3050d = null;
        this.f3052f = null;
        boolean z = false;
        while (!z && c()) {
            List<n.a<?>> listG = this.a.g();
            int i2 = this.f3049c;
            this.f3049c = i2 + 1;
            this.f3052f = listG.get(i2);
            if (this.f3052f != null && (this.a.e().a(this.f3052f.f3091c.c()) || this.a.c(this.f3052f.f3091c.a()))) {
                b(this.f3052f);
                z = true;
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.load.p.f
    public void cancel() {
        n.a<?> aVar = this.f3052f;
        if (aVar != null) {
            aVar.f3091c.cancel();
        }
    }

    /* JADX INFO: compiled from: SourceGenerator.java */
    class a implements d.a<Object> {
        final /* synthetic */ n.a a;

        a(n.a aVar) {
            this.a = aVar;
        }

        @Override // com.bumptech.glide.load.o.d.a
        public void a(@Nullable Object obj) {
            if (z.this.a(this.a)) {
                z.this.a(this.a, obj);
            }
        }

        @Override // com.bumptech.glide.load.o.d.a
        public void a(@NonNull Exception exc) {
            if (z.this.a(this.a)) {
                z.this.a(this.a, exc);
            }
        }
    }

    @Override // com.bumptech.glide.load.p.f.a
    public void b() {
        throw new UnsupportedOperationException();
    }

    boolean a(n.a<?> aVar) {
        n.a<?> aVar2 = this.f3052f;
        return aVar2 != null && aVar2 == aVar;
    }

    private void a(Object obj) {
        long jA = com.bumptech.glide.util.f.a();
        try {
            com.bumptech.glide.load.d<X> dVarA = this.a.a(obj);
            e eVar = new e(dVarA, obj, this.a.i());
            this.f3053g = new d(this.f3052f.a, this.a.l());
            this.a.d().a(this.f3053g, eVar);
            if (Log.isLoggable(f3047h, 2)) {
                String str = "Finished encoding source to cache, key: " + this.f3053g + ", data: " + obj + ", encoder: " + dVarA + ", duration: " + com.bumptech.glide.util.f.a(jA);
            }
            this.f3052f.f3091c.b();
            this.f3050d = new c(Collections.singletonList(this.f3052f.a), this.a, this);
        } catch (Throwable th) {
            this.f3052f.f3091c.b();
            throw th;
        }
    }

    void a(n.a<?> aVar, Object obj) {
        j jVarE = this.a.e();
        if (obj != null && jVarE.a(aVar.f3091c.c())) {
            this.f3051e = obj;
            this.f3048b.b();
        } else {
            f.a aVar2 = this.f3048b;
            com.bumptech.glide.load.g gVar = aVar.a;
            com.bumptech.glide.load.o.d<?> dVar = aVar.f3091c;
            aVar2.a(gVar, obj, dVar, dVar.c(), this.f3053g);
        }
    }

    void a(n.a<?> aVar, @NonNull Exception exc) {
        f.a aVar2 = this.f3048b;
        d dVar = this.f3053g;
        com.bumptech.glide.load.o.d<?> dVar2 = aVar.f3091c;
        aVar2.a(dVar, exc, dVar2, dVar2.c());
    }

    @Override // com.bumptech.glide.load.p.f.a
    public void a(com.bumptech.glide.load.g gVar, Object obj, com.bumptech.glide.load.o.d<?> dVar, com.bumptech.glide.load.a aVar, com.bumptech.glide.load.g gVar2) {
        this.f3048b.a(gVar, obj, dVar, this.f3052f.f3091c.c(), gVar);
    }

    @Override // com.bumptech.glide.load.p.f.a
    public void a(com.bumptech.glide.load.g gVar, Exception exc, com.bumptech.glide.load.o.d<?> dVar, com.bumptech.glide.load.a aVar) {
        this.f3048b.a(gVar, exc, dVar, this.f3052f.f3091c.c());
    }
}
