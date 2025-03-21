package com.google.gson.p147b0.p148q;

import com.google.gson.AbstractC2077y;
import com.google.gson.C2051e;
import com.google.gson.InterfaceC2078z;
import com.google.gson.p147b0.C2009b;
import com.google.gson.p147b0.C2010c;
import com.google.gson.p147b0.InterfaceC2018k;
import com.google.gson.p152d0.C2049a;
import com.google.gson.p153e0.C2052a;
import com.google.gson.p153e0.C2055d;
import com.google.gson.p153e0.EnumC2054c;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: CollectionTypeAdapterFactory.java */
/* renamed from: com.google.gson.b0.q.b */
/* loaded from: classes.dex */
public final class C2025b implements InterfaceC2078z {

    /* renamed from: a */
    private final C2010c f5722a;

    /* compiled from: CollectionTypeAdapterFactory.java */
    /* renamed from: com.google.gson.b0.q.b$a */
    private static final class a<E> extends AbstractC2077y<Collection<E>> {

        /* renamed from: a */
        private final AbstractC2077y<E> f5723a;

        /* renamed from: b */
        private final InterfaceC2018k<? extends Collection<E>> f5724b;

        public a(C2051e c2051e, Type type, AbstractC2077y<E> abstractC2077y, InterfaceC2018k<? extends Collection<E>> interfaceC2018k) {
            this.f5723a = new C2037n(c2051e, abstractC2077y, type);
            this.f5724b = interfaceC2018k;
        }

        @Override // com.google.gson.AbstractC2077y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(C2055d c2055d, Collection<E> collection) throws IOException {
            if (collection == null) {
                c2055d.mo5448j();
                return;
            }
            c2055d.mo5442c();
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                this.f5723a.write(c2055d, it.next());
            }
            c2055d.mo5446e();
        }

        @Override // com.google.gson.AbstractC2077y
        /* renamed from: read */
        public Collection<E> read2(C2052a c2052a) throws IOException {
            if (c2052a.peek() == EnumC2054c.NULL) {
                c2052a.mo5429r();
                return null;
            }
            Collection<E> mo5339a = this.f5724b.mo5339a();
            c2052a.mo5417c();
            while (c2052a.mo5423j()) {
                mo5339a.add(this.f5723a.read2(c2052a));
            }
            c2052a.mo5419f();
            return mo5339a;
        }
    }

    public C2025b(C2010c c2010c) {
        this.f5722a = c2010c;
    }

    @Override // com.google.gson.InterfaceC2078z
    public <T> AbstractC2077y<T> create(C2051e c2051e, C2049a<T> c2049a) {
        Type type = c2049a.getType();
        Class<? super T> rawType = c2049a.getRawType();
        if (!Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type m5316a = C2009b.m5316a(type, (Class<?>) rawType);
        return new a(c2051e, m5316a, c2051e.m5557a((C2049a) C2049a.get(m5316a)), this.f5722a.m5338a(c2049a));
    }
}
