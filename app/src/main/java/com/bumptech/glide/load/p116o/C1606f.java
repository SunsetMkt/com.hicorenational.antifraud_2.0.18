package com.bumptech.glide.load.p116o;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.p116o.InterfaceC1605e;
import com.bumptech.glide.util.C1876j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: DataRewinderRegistry.java */
/* renamed from: com.bumptech.glide.load.o.f */
/* loaded from: classes.dex */
public class C1606f {

    /* renamed from: b */
    private static final InterfaceC1605e.a<?> f4208b = new a();

    /* renamed from: a */
    private final Map<Class<?>, InterfaceC1605e.a<?>> f4209a = new HashMap();

    /* compiled from: DataRewinderRegistry.java */
    /* renamed from: com.bumptech.glide.load.o.f$a */
    class a implements InterfaceC1605e.a<Object> {
        a() {
        }

        @Override // com.bumptech.glide.load.p116o.InterfaceC1605e.a
        @NonNull
        /* renamed from: a */
        public InterfaceC1605e<Object> mo3860a(@NonNull Object obj) {
            return new b(obj);
        }

        @Override // com.bumptech.glide.load.p116o.InterfaceC1605e.a
        @NonNull
        /* renamed from: a */
        public Class<Object> mo3861a() {
            throw new UnsupportedOperationException("Not implemented");
        }
    }

    /* compiled from: DataRewinderRegistry.java */
    /* renamed from: com.bumptech.glide.load.o.f$b */
    private static final class b implements InterfaceC1605e<Object> {

        /* renamed from: a */
        private final Object f4210a;

        b(@NonNull Object obj) {
            this.f4210a = obj;
        }

        @Override // com.bumptech.glide.load.p116o.InterfaceC1605e
        @NonNull
        /* renamed from: a */
        public Object mo3858a() {
            return this.f4210a;
        }

        @Override // com.bumptech.glide.load.p116o.InterfaceC1605e
        /* renamed from: b */
        public void mo3859b() {
        }
    }

    /* renamed from: a */
    public synchronized void m3863a(@NonNull InterfaceC1605e.a<?> aVar) {
        this.f4209a.put(aVar.mo3861a(), aVar);
    }

    @NonNull
    /* renamed from: a */
    public synchronized <T> InterfaceC1605e<T> m3862a(@NonNull T t) {
        InterfaceC1605e.a<?> aVar;
        C1876j.m4985a(t);
        aVar = this.f4209a.get(t.getClass());
        if (aVar == null) {
            Iterator<InterfaceC1605e.a<?>> it = this.f4209a.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                InterfaceC1605e.a<?> next = it.next();
                if (next.mo3861a().isAssignableFrom(t.getClass())) {
                    aVar = next;
                    break;
                }
            }
        }
        if (aVar == null) {
            aVar = f4208b;
        }
        return (InterfaceC1605e<T>) aVar.mo3860a(t);
    }
}
