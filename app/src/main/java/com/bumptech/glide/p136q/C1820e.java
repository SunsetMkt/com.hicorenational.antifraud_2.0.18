package com.bumptech.glide.p136q;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.InterfaceC1598l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: ResourceDecoderRegistry.java */
/* renamed from: com.bumptech.glide.q.e */
/* loaded from: classes.dex */
public class C1820e {

    /* renamed from: a */
    private final List<String> f5252a = new ArrayList();

    /* renamed from: b */
    private final Map<String, List<a<?, ?>>> f5253b = new HashMap();

    /* compiled from: ResourceDecoderRegistry.java */
    /* renamed from: com.bumptech.glide.q.e$a */
    private static class a<T, R> {

        /* renamed from: a */
        private final Class<T> f5254a;

        /* renamed from: b */
        final Class<R> f5255b;

        /* renamed from: c */
        final InterfaceC1598l<T, R> f5256c;

        public a(@NonNull Class<T> cls, @NonNull Class<R> cls2, InterfaceC1598l<T, R> interfaceC1598l) {
            this.f5254a = cls;
            this.f5255b = cls2;
            this.f5256c = interfaceC1598l;
        }

        /* renamed from: a */
        public boolean m4710a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.f5254a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f5255b);
        }
    }

    /* renamed from: a */
    public synchronized void m4707a(@NonNull List<String> list) {
        ArrayList<String> arrayList = new ArrayList(this.f5252a);
        this.f5252a.clear();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            this.f5252a.add(it.next());
        }
        for (String str : arrayList) {
            if (!list.contains(str)) {
                this.f5252a.add(str);
            }
        }
    }

    @NonNull
    /* renamed from: b */
    public synchronized <T, R> List<Class<R>> m4708b(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> it = this.f5252a.iterator();
        while (it.hasNext()) {
            List<a<?, ?>> list = this.f5253b.get(it.next());
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.m4710a(cls, cls2) && !arrayList.contains(aVar.f5255b)) {
                        arrayList.add(aVar.f5255b);
                    }
                }
            }
        }
        return arrayList;
    }

    @NonNull
    /* renamed from: a */
    public synchronized <T, R> List<InterfaceC1598l<T, R>> m4705a(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> it = this.f5252a.iterator();
        while (it.hasNext()) {
            List<a<?, ?>> list = this.f5253b.get(it.next());
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.m4710a(cls, cls2)) {
                        arrayList.add(aVar.f5256c);
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public synchronized <T, R> void m4709b(@NonNull String str, @NonNull InterfaceC1598l<T, R> interfaceC1598l, @NonNull Class<T> cls, @NonNull Class<R> cls2) {
        m4704a(str).add(0, new a<>(cls, cls2, interfaceC1598l));
    }

    /* renamed from: a */
    public synchronized <T, R> void m4706a(@NonNull String str, @NonNull InterfaceC1598l<T, R> interfaceC1598l, @NonNull Class<T> cls, @NonNull Class<R> cls2) {
        m4704a(str).add(new a<>(cls, cls2, interfaceC1598l));
    }

    @NonNull
    /* renamed from: a */
    private synchronized List<a<?, ?>> m4704a(@NonNull String str) {
        List<a<?, ?>> list;
        if (!this.f5252a.contains(str)) {
            this.f5252a.add(str);
        }
        list = this.f5253b.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.f5253b.put(str, list);
        }
        return list;
    }
}
