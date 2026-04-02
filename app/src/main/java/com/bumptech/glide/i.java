package com.bumptech.glide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.m;
import com.bumptech.glide.load.o.e;
import com.bumptech.glide.load.p.t;
import com.bumptech.glide.load.p.v;
import com.bumptech.glide.load.q.n;
import com.bumptech.glide.load.q.o;
import com.bumptech.glide.load.q.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: Registry.java */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: k */
    public static final String f2684k = "Gif";

    /* JADX INFO: renamed from: l */
    public static final String f2685l = "Bitmap";

    /* JADX INFO: renamed from: m */
    public static final String f2686m = "BitmapDrawable";

    /* JADX INFO: renamed from: n */
    private static final String f2687n = "legacy_prepend_all";
    private static final String o = "legacy_append";

    /* JADX INFO: renamed from: h */
    private final com.bumptech.glide.q.d f2694h = new com.bumptech.glide.q.d();

    /* JADX INFO: renamed from: i */
    private final com.bumptech.glide.q.c f2695i = new com.bumptech.glide.q.c();

    /* JADX INFO: renamed from: j */
    private final Pools.Pool<List<Throwable>> f2696j = com.bumptech.glide.util.n.a.b();
    private final p a = new p(this.f2696j);

    /* JADX INFO: renamed from: b */
    private final com.bumptech.glide.q.a f2688b = new com.bumptech.glide.q.a();

    /* JADX INFO: renamed from: c */
    private final com.bumptech.glide.q.e f2689c = new com.bumptech.glide.q.e();

    /* JADX INFO: renamed from: d */
    private final com.bumptech.glide.q.f f2690d = new com.bumptech.glide.q.f();

    /* JADX INFO: renamed from: e */
    private final com.bumptech.glide.load.o.f f2691e = new com.bumptech.glide.load.o.f();

    /* JADX INFO: renamed from: f */
    private final com.bumptech.glide.load.r.h.f f2692f = new com.bumptech.glide.load.r.h.f();

    /* JADX INFO: renamed from: g */
    private final com.bumptech.glide.q.b f2693g = new com.bumptech.glide.q.b();

    /* JADX INFO: compiled from: Registry.java */
    public static class a extends RuntimeException {
        public a(@NonNull String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: Registry.java */
    public static final class b extends a {
        public b() {
            super("Failed to find image header parser.");
        }
    }

    /* JADX INFO: compiled from: Registry.java */
    public static class c extends a {
        public c(@NonNull Object obj) {
            super("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }

        public <M> c(@NonNull M m2, @NonNull List<n<M, ?>> list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m2);
        }

        public c(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    /* JADX INFO: compiled from: Registry.java */
    public static class d extends a {
        public d(@NonNull Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    /* JADX INFO: compiled from: Registry.java */
    public static class e extends a {
        public e(@NonNull Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public i() {
        a(Arrays.asList(f2684k, f2685l, f2686m));
    }

    @NonNull
    public <Data> i a(@NonNull Class<Data> cls, @NonNull com.bumptech.glide.load.d<Data> dVar) {
        this.f2688b.a(cls, dVar);
        return this;
    }

    @NonNull
    public <Data> i b(@NonNull Class<Data> cls, @NonNull com.bumptech.glide.load.d<Data> dVar) {
        this.f2688b.b(cls, dVar);
        return this;
    }

    @NonNull
    @Deprecated
    public <Data> i c(@NonNull Class<Data> cls, @NonNull com.bumptech.glide.load.d<Data> dVar) {
        return a(cls, dVar);
    }

    @NonNull
    public <Data, TResource> i a(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull com.bumptech.glide.load.l<Data, TResource> lVar) {
        a(o, cls, cls2, lVar);
        return this;
    }

    @NonNull
    public <Data, TResource> i b(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull com.bumptech.glide.load.l<Data, TResource> lVar) {
        b(f2687n, cls, cls2, lVar);
        return this;
    }

    @NonNull
    @Deprecated
    public <TResource> i c(@NonNull Class<TResource> cls, @NonNull m<TResource> mVar) {
        return a((Class) cls, (m) mVar);
    }

    @NonNull
    public <Data, TResource> i a(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull com.bumptech.glide.load.l<Data, TResource> lVar) {
        this.f2689c.a(str, lVar, cls, cls2);
        return this;
    }

    @NonNull
    public <Data, TResource> i b(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull com.bumptech.glide.load.l<Data, TResource> lVar) {
        this.f2689c.b(str, lVar, cls, cls2);
        return this;
    }

    @NonNull
    public <Model, Data> i c(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        this.a.c(cls, cls2, oVar);
        return this;
    }

    @NonNull
    private <Data, TResource, Transcode> List<com.bumptech.glide.load.p.i<Data, TResource, Transcode>> c(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.f2689c.b(cls, cls2)) {
            for (Class cls5 : this.f2692f.b(cls4, cls3)) {
                arrayList.add(new com.bumptech.glide.load.p.i(cls, cls4, cls5, this.f2689c.a(cls, cls4), this.f2692f.a(cls4, cls5), this.f2696j));
            }
        }
        return arrayList;
    }

    @NonNull
    public final i a(@NonNull List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        arrayList.add(0, f2687n);
        arrayList.add(o);
        this.f2689c.a(arrayList);
        return this;
    }

    @NonNull
    public <TResource> i b(@NonNull Class<TResource> cls, @NonNull m<TResource> mVar) {
        this.f2690d.b(cls, mVar);
        return this;
    }

    @NonNull
    public <Model, Data> i b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<Model, Data> oVar) {
        this.a.b(cls, cls2, oVar);
        return this;
    }

    @NonNull
    public <Model, TResource, Transcode> List<Class<?>> b(@NonNull Class<Model> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        List<Class<?>> listA = this.f2694h.a(cls, cls2, cls3);
        if (listA == null) {
            listA = new ArrayList<>();
            Iterator<Class<?>> it = this.a.a((Class<?>) cls).iterator();
            while (it.hasNext()) {
                for (Class<?> cls4 : this.f2689c.b(it.next(), cls2)) {
                    if (!this.f2692f.b(cls4, cls3).isEmpty() && !listA.contains(cls4)) {
                        listA.add(cls4);
                    }
                }
            }
            this.f2694h.a(cls, cls2, cls3, Collections.unmodifiableList(listA));
        }
        return listA;
    }

    @NonNull
    public <TResource> i a(@NonNull Class<TResource> cls, @NonNull m<TResource> mVar) {
        this.f2690d.a(cls, mVar);
        return this;
    }

    @NonNull
    public i a(@NonNull e.a<?> aVar) {
        this.f2691e.a(aVar);
        return this;
    }

    @NonNull
    public <TResource, Transcode> i a(@NonNull Class<TResource> cls, @NonNull Class<Transcode> cls2, @NonNull com.bumptech.glide.load.r.h.e<TResource, Transcode> eVar) {
        this.f2692f.a(cls, cls2, eVar);
        return this;
    }

    @NonNull
    public i a(@NonNull ImageHeaderParser imageHeaderParser) {
        this.f2693g.a(imageHeaderParser);
        return this;
    }

    @NonNull
    public <Model, Data> i a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<Model, Data> oVar) {
        this.a.a(cls, cls2, oVar);
        return this;
    }

    @Nullable
    public <Data, TResource, Transcode> t<Data, TResource, Transcode> a(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        t<Data, TResource, Transcode> tVarA = this.f2695i.a(cls, cls2, cls3);
        if (this.f2695i.a(tVarA)) {
            return null;
        }
        if (tVarA == null) {
            List<com.bumptech.glide.load.p.i<Data, TResource, Transcode>> listC = c(cls, cls2, cls3);
            tVarA = listC.isEmpty() ? null : new t<>(cls, cls2, cls3, listC, this.f2696j);
            this.f2695i.a(cls, cls2, cls3, tVarA);
        }
        return tVarA;
    }

    @NonNull
    public <X> com.bumptech.glide.load.d<X> c(@NonNull X x) throws e {
        com.bumptech.glide.load.d<X> dVarA = this.f2688b.a(x.getClass());
        if (dVarA != null) {
            return dVarA;
        }
        throw new e(x.getClass());
    }

    @NonNull
    public <X> m<X> a(@NonNull v<X> vVar) throws d {
        m<X> mVarA = this.f2690d.a(vVar.b());
        if (mVarA != null) {
            return mVarA;
        }
        throw new d(vVar.b());
    }

    public boolean b(@NonNull v<?> vVar) {
        return this.f2690d.a(vVar.b()) != null;
    }

    @NonNull
    public <X> com.bumptech.glide.load.o.e<X> b(@NonNull X x) {
        return this.f2691e.a(x);
    }

    @NonNull
    public <Model> List<n<Model, ?>> a(@NonNull Model model) {
        return this.a.a(model);
    }

    @NonNull
    public List<ImageHeaderParser> a() {
        List<ImageHeaderParser> listA = this.f2693g.a();
        if (listA.isEmpty()) {
            throw new b();
        }
        return listA;
    }
}
