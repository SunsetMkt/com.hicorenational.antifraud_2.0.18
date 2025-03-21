package com.bumptech.glide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.InterfaceC1590d;
import com.bumptech.glide.load.InterfaceC1598l;
import com.bumptech.glide.load.InterfaceC1599m;
import com.bumptech.glide.load.p116o.C1606f;
import com.bumptech.glide.load.p116o.InterfaceC1605e;
import com.bumptech.glide.load.p118p.C1664i;
import com.bumptech.glide.load.p118p.C1675t;
import com.bumptech.glide.load.p118p.InterfaceC1677v;
import com.bumptech.glide.load.p123q.C1697p;
import com.bumptech.glide.load.p123q.InterfaceC1695n;
import com.bumptech.glide.load.p123q.InterfaceC1696o;
import com.bumptech.glide.load.p125r.p130h.C1767f;
import com.bumptech.glide.load.p125r.p130h.InterfaceC1766e;
import com.bumptech.glide.p136q.C1816a;
import com.bumptech.glide.p136q.C1817b;
import com.bumptech.glide.p136q.C1818c;
import com.bumptech.glide.p136q.C1819d;
import com.bumptech.glide.p136q.C1820e;
import com.bumptech.glide.p136q.C1821f;
import com.bumptech.glide.util.p141n.C1880a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: Registry.java */
/* renamed from: com.bumptech.glide.i */
/* loaded from: classes.dex */
public class C1583i {

    /* renamed from: k */
    public static final String f4126k = "Gif";

    /* renamed from: l */
    public static final String f4127l = "Bitmap";

    /* renamed from: m */
    public static final String f4128m = "BitmapDrawable";

    /* renamed from: n */
    private static final String f4129n = "legacy_prepend_all";

    /* renamed from: o */
    private static final String f4130o = "legacy_append";

    /* renamed from: h */
    private final C1819d f4138h = new C1819d();

    /* renamed from: i */
    private final C1818c f4139i = new C1818c();

    /* renamed from: j */
    private final Pools.Pool<List<Throwable>> f4140j = C1880a.m5019b();

    /* renamed from: a */
    private final C1697p f4131a = new C1697p(this.f4140j);

    /* renamed from: b */
    private final C1816a f4132b = new C1816a();

    /* renamed from: c */
    private final C1820e f4133c = new C1820e();

    /* renamed from: d */
    private final C1821f f4134d = new C1821f();

    /* renamed from: e */
    private final C1606f f4135e = new C1606f();

    /* renamed from: f */
    private final C1767f f4136f = new C1767f();

    /* renamed from: g */
    private final C1817b f4137g = new C1817b();

    /* compiled from: Registry.java */
    /* renamed from: com.bumptech.glide.i$a */
    public static class a extends RuntimeException {
        public a(@NonNull String str) {
            super(str);
        }
    }

    /* compiled from: Registry.java */
    /* renamed from: com.bumptech.glide.i$b */
    public static final class b extends a {
        public b() {
            super("Failed to find image header parser.");
        }
    }

    /* compiled from: Registry.java */
    /* renamed from: com.bumptech.glide.i$c */
    public static class c extends a {
        public c(@NonNull Object obj) {
            super("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }

        public <M> c(@NonNull M m2, @NonNull List<InterfaceC1695n<M, ?>> list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m2);
        }

        public c(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    /* compiled from: Registry.java */
    /* renamed from: com.bumptech.glide.i$d */
    public static class d extends a {
        public d(@NonNull Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    /* compiled from: Registry.java */
    /* renamed from: com.bumptech.glide.i$e */
    public static class e extends a {
        public e(@NonNull Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public C1583i() {
        m3732a(Arrays.asList(f4126k, f4127l, f4128m));
    }

    @NonNull
    /* renamed from: a */
    public <Data> C1583i m3726a(@NonNull Class<Data> cls, @NonNull InterfaceC1590d<Data> interfaceC1590d) {
        this.f4132b.m4692a(cls, interfaceC1590d);
        return this;
    }

    @NonNull
    /* renamed from: b */
    public <Data> C1583i m3737b(@NonNull Class<Data> cls, @NonNull InterfaceC1590d<Data> interfaceC1590d) {
        this.f4132b.m4693b(cls, interfaceC1590d);
        return this;
    }

    @NonNull
    @Deprecated
    /* renamed from: c */
    public <Data> C1583i m3745c(@NonNull Class<Data> cls, @NonNull InterfaceC1590d<Data> interfaceC1590d) {
        return m3726a(cls, interfaceC1590d);
    }

    @NonNull
    /* renamed from: a */
    public <Data, TResource> C1583i m3728a(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull InterfaceC1598l<Data, TResource> interfaceC1598l) {
        m3731a(f4130o, cls, cls2, interfaceC1598l);
        return this;
    }

    @NonNull
    /* renamed from: b */
    public <Data, TResource> C1583i m3739b(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull InterfaceC1598l<Data, TResource> interfaceC1598l) {
        m3741b(f4129n, cls, cls2, interfaceC1598l);
        return this;
    }

    @NonNull
    @Deprecated
    /* renamed from: c */
    public <TResource> C1583i m3746c(@NonNull Class<TResource> cls, @NonNull InterfaceC1599m<TResource> interfaceC1599m) {
        return m3727a((Class) cls, (InterfaceC1599m) interfaceC1599m);
    }

    @NonNull
    /* renamed from: a */
    public <Data, TResource> C1583i m3731a(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull InterfaceC1598l<Data, TResource> interfaceC1598l) {
        this.f4133c.m4706a(str, interfaceC1598l, cls, cls2);
        return this;
    }

    @NonNull
    /* renamed from: b */
    public <Data, TResource> C1583i m3741b(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull InterfaceC1598l<Data, TResource> interfaceC1598l) {
        this.f4133c.m4709b(str, interfaceC1598l, cls, cls2);
        return this;
    }

    @NonNull
    /* renamed from: c */
    public <Model, Data> C1583i m3747c(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull InterfaceC1696o<? extends Model, ? extends Data> interfaceC1696o) {
        this.f4131a.m4267c(cls, cls2, interfaceC1696o);
        return this;
    }

    @NonNull
    /* renamed from: c */
    private <Data, TResource, Transcode> List<C1664i<Data, TResource, Transcode>> m3723c(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.f4133c.m4708b(cls, cls2)) {
            for (Class cls5 : this.f4136f.m4436b(cls4, cls3)) {
                arrayList.add(new C1664i(cls, cls4, cls5, this.f4133c.m4705a(cls, cls4), this.f4136f.m4434a(cls4, cls5), this.f4140j));
            }
        }
        return arrayList;
    }

    @NonNull
    /* renamed from: a */
    public final C1583i m3732a(@NonNull List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        arrayList.add(0, f4129n);
        arrayList.add(f4130o);
        this.f4133c.m4707a(arrayList);
        return this;
    }

    @NonNull
    /* renamed from: b */
    public <TResource> C1583i m3738b(@NonNull Class<TResource> cls, @NonNull InterfaceC1599m<TResource> interfaceC1599m) {
        this.f4134d.m4713b(cls, interfaceC1599m);
        return this;
    }

    @NonNull
    /* renamed from: b */
    public <Model, Data> C1583i m3740b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull InterfaceC1696o<Model, Data> interfaceC1696o) {
        this.f4131a.m4266b(cls, cls2, interfaceC1696o);
        return this;
    }

    @NonNull
    /* renamed from: b */
    public <Model, TResource, Transcode> List<Class<?>> m3743b(@NonNull Class<Model> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        List<Class<?>> m4701a = this.f4138h.m4701a(cls, cls2, cls3);
        if (m4701a == null) {
            m4701a = new ArrayList<>();
            Iterator<Class<?>> it = this.f4131a.m4262a((Class<?>) cls).iterator();
            while (it.hasNext()) {
                for (Class<?> cls4 : this.f4133c.m4708b(it.next(), cls2)) {
                    if (!this.f4136f.m4436b(cls4, cls3).isEmpty() && !m4701a.contains(cls4)) {
                        m4701a.add(cls4);
                    }
                }
            }
            this.f4138h.m4703a(cls, cls2, cls3, Collections.unmodifiableList(m4701a));
        }
        return m4701a;
    }

    @NonNull
    /* renamed from: a */
    public <TResource> C1583i m3727a(@NonNull Class<TResource> cls, @NonNull InterfaceC1599m<TResource> interfaceC1599m) {
        this.f4134d.m4712a(cls, interfaceC1599m);
        return this;
    }

    @NonNull
    /* renamed from: a */
    public C1583i m3725a(@NonNull InterfaceC1605e.a<?> aVar) {
        this.f4135e.m3863a(aVar);
        return this;
    }

    @NonNull
    /* renamed from: a */
    public <TResource, Transcode> C1583i m3730a(@NonNull Class<TResource> cls, @NonNull Class<Transcode> cls2, @NonNull InterfaceC1766e<TResource, Transcode> interfaceC1766e) {
        this.f4136f.m4435a(cls, cls2, interfaceC1766e);
        return this;
    }

    @NonNull
    /* renamed from: a */
    public C1583i m3724a(@NonNull ImageHeaderParser imageHeaderParser) {
        this.f4137g.m4696a(imageHeaderParser);
        return this;
    }

    @NonNull
    /* renamed from: a */
    public <Model, Data> C1583i m3729a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull InterfaceC1696o<Model, Data> interfaceC1696o) {
        this.f4131a.m4264a(cls, cls2, interfaceC1696o);
        return this;
    }

    @Nullable
    /* renamed from: a */
    public <Data, TResource, Transcode> C1675t<Data, TResource, Transcode> m3734a(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        C1675t<Data, TResource, Transcode> m4698a = this.f4139i.m4698a(cls, cls2, cls3);
        if (this.f4139i.m4700a(m4698a)) {
            return null;
        }
        if (m4698a == null) {
            List<C1664i<Data, TResource, Transcode>> m3723c = m3723c(cls, cls2, cls3);
            m4698a = m3723c.isEmpty() ? null : new C1675t<>(cls, cls2, cls3, m3723c, this.f4140j);
            this.f4139i.m4699a(cls, cls2, cls3, m4698a);
        }
        return m4698a;
    }

    @NonNull
    /* renamed from: c */
    public <X> InterfaceC1590d<X> m3748c(@NonNull X x) throws e {
        InterfaceC1590d<X> m4691a = this.f4132b.m4691a(x.getClass());
        if (m4691a != null) {
            return m4691a;
        }
        throw new e(x.getClass());
    }

    @NonNull
    /* renamed from: a */
    public <X> InterfaceC1599m<X> m3733a(@NonNull InterfaceC1677v<X> interfaceC1677v) throws d {
        InterfaceC1599m<X> m4711a = this.f4134d.m4711a(interfaceC1677v.mo4184b());
        if (m4711a != null) {
            return m4711a;
        }
        throw new d(interfaceC1677v.mo4184b());
    }

    /* renamed from: b */
    public boolean m3744b(@NonNull InterfaceC1677v<?> interfaceC1677v) {
        return this.f4134d.m4711a(interfaceC1677v.mo4184b()) != null;
    }

    @NonNull
    /* renamed from: b */
    public <X> InterfaceC1605e<X> m3742b(@NonNull X x) {
        return this.f4135e.m3862a((C1606f) x);
    }

    @NonNull
    /* renamed from: a */
    public <Model> List<InterfaceC1695n<Model, ?>> m3736a(@NonNull Model model) {
        return this.f4131a.m4263a((C1697p) model);
    }

    @NonNull
    /* renamed from: a */
    public List<ImageHeaderParser> m3735a() {
        List<ImageHeaderParser> m4695a = this.f4137g.m4695a();
        if (m4695a.isEmpty()) {
            throw new b();
        }
        return m4695a;
    }
}
