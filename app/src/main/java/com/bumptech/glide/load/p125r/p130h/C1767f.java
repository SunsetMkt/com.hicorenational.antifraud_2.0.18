package com.bumptech.glide.load.p125r.p130h;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: TranscoderRegistry.java */
/* renamed from: com.bumptech.glide.load.r.h.f */
/* loaded from: classes.dex */
public class C1767f {

    /* renamed from: a */
    private final List<a<?, ?>> f4985a = new ArrayList();

    /* compiled from: TranscoderRegistry.java */
    /* renamed from: com.bumptech.glide.load.r.h.f$a */
    private static final class a<Z, R> {

        /* renamed from: a */
        private final Class<Z> f4986a;

        /* renamed from: b */
        private final Class<R> f4987b;

        /* renamed from: c */
        final InterfaceC1766e<Z, R> f4988c;

        a(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull InterfaceC1766e<Z, R> interfaceC1766e) {
            this.f4986a = cls;
            this.f4987b = cls2;
            this.f4988c = interfaceC1766e;
        }

        /* renamed from: a */
        public boolean m4437a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.f4986a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f4987b);
        }
    }

    /* renamed from: a */
    public synchronized <Z, R> void m4435a(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull InterfaceC1766e<Z, R> interfaceC1766e) {
        this.f4985a.add(new a<>(cls, cls2, interfaceC1766e));
    }

    @NonNull
    /* renamed from: b */
    public synchronized <Z, R> List<Class<R>> m4436b(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        Iterator<a<?, ?>> it = this.f4985a.iterator();
        while (it.hasNext()) {
            if (it.next().m4437a(cls, cls2)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }

    @NonNull
    /* renamed from: a */
    public synchronized <Z, R> InterfaceC1766e<Z, R> m4434a(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return C1768g.m4438a();
        }
        for (a<?, ?> aVar : this.f4985a) {
            if (aVar.m4437a(cls, cls2)) {
                return (InterfaceC1766e<Z, R>) aVar.f4988c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }
}
