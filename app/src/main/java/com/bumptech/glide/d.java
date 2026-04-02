package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.b;
import com.bumptech.glide.r.l.r;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: GlideContext.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends ContextWrapper {

    /* JADX INFO: renamed from: k */
    @VisibleForTesting
    static final l<?, ?> f2663k = new a();
    private final com.bumptech.glide.load.p.a0.b a;

    /* JADX INFO: renamed from: b */
    private final i f2664b;

    /* JADX INFO: renamed from: c */
    private final com.bumptech.glide.r.l.k f2665c;

    /* JADX INFO: renamed from: d */
    private final b.a f2666d;

    /* JADX INFO: renamed from: e */
    private final List<com.bumptech.glide.r.g<Object>> f2667e;

    /* JADX INFO: renamed from: f */
    private final Map<Class<?>, l<?, ?>> f2668f;

    /* JADX INFO: renamed from: g */
    private final com.bumptech.glide.load.p.k f2669g;

    /* JADX INFO: renamed from: h */
    private final boolean f2670h;

    /* JADX INFO: renamed from: i */
    private final int f2671i;

    /* JADX INFO: renamed from: j */
    @Nullable
    @GuardedBy("this")
    private com.bumptech.glide.r.h f2672j;

    public d(@NonNull Context context, @NonNull com.bumptech.glide.load.p.a0.b bVar, @NonNull i iVar, @NonNull com.bumptech.glide.r.l.k kVar, @NonNull b.a aVar, @NonNull Map<Class<?>, l<?, ?>> map, @NonNull List<com.bumptech.glide.r.g<Object>> list, @NonNull com.bumptech.glide.load.p.k kVar2, boolean z, int i2) {
        super(context.getApplicationContext());
        this.a = bVar;
        this.f2664b = iVar;
        this.f2665c = kVar;
        this.f2666d = aVar;
        this.f2667e = list;
        this.f2668f = map;
        this.f2669g = kVar2;
        this.f2670h = z;
        this.f2671i = i2;
    }

    @NonNull
    public <T> l<?, T> a(@NonNull Class<T> cls) {
        l<?, T> lVar = (l) this.f2668f.get(cls);
        if (lVar == null) {
            for (Map.Entry<Class<?>, l<?, ?>> entry : this.f2668f.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    lVar = (l) entry.getValue();
                }
            }
        }
        return lVar == null ? (l<?, T>) f2663k : lVar;
    }

    public List<com.bumptech.glide.r.g<Object>> b() {
        return this.f2667e;
    }

    public synchronized com.bumptech.glide.r.h c() {
        if (this.f2672j == null) {
            this.f2672j = this.f2666d.build().M();
        }
        return this.f2672j;
    }

    @NonNull
    public com.bumptech.glide.load.p.k d() {
        return this.f2669g;
    }

    public int e() {
        return this.f2671i;
    }

    @NonNull
    public i f() {
        return this.f2664b;
    }

    public boolean g() {
        return this.f2670h;
    }

    @NonNull
    public <X> r<ImageView, X> a(@NonNull ImageView imageView, @NonNull Class<X> cls) {
        return this.f2665c.a(imageView, cls);
    }

    @NonNull
    public com.bumptech.glide.load.p.a0.b a() {
        return this.a;
    }
}
