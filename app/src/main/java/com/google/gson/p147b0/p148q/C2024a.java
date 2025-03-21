package com.google.gson.p147b0.p148q;

import com.google.gson.AbstractC2077y;
import com.google.gson.C2051e;
import com.google.gson.InterfaceC2078z;
import com.google.gson.p147b0.C2009b;
import com.google.gson.p152d0.C2049a;
import com.google.gson.p153e0.C2052a;
import com.google.gson.p153e0.C2055d;
import com.google.gson.p153e0.EnumC2054c;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* compiled from: ArrayTypeAdapter.java */
/* renamed from: com.google.gson.b0.q.a */
/* loaded from: classes.dex */
public final class C2024a<E> extends AbstractC2077y<Object> {

    /* renamed from: c */
    public static final InterfaceC2078z f5719c = new a();

    /* renamed from: a */
    private final Class<E> f5720a;

    /* renamed from: b */
    private final AbstractC2077y<E> f5721b;

    /* compiled from: ArrayTypeAdapter.java */
    /* renamed from: com.google.gson.b0.q.a$a */
    class a implements InterfaceC2078z {
        a() {
        }

        @Override // com.google.gson.InterfaceC2078z
        public <T> AbstractC2077y<T> create(C2051e c2051e, C2049a<T> c2049a) {
            Type type = c2049a.getType();
            if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class) type).isArray())) {
                return null;
            }
            Type m5327d = C2009b.m5327d(type);
            return new C2024a(c2051e, c2051e.m5557a((C2049a) C2049a.get(m5327d)), C2009b.m5328e(m5327d));
        }
    }

    public C2024a(C2051e c2051e, AbstractC2077y<E> abstractC2077y, Class<E> cls) {
        this.f5721b = new C2037n(c2051e, abstractC2077y, cls);
        this.f5720a = cls;
    }

    @Override // com.google.gson.AbstractC2077y
    /* renamed from: read */
    public Object read2(C2052a c2052a) throws IOException {
        if (c2052a.peek() == EnumC2054c.NULL) {
            c2052a.mo5429r();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        c2052a.mo5417c();
        while (c2052a.mo5423j()) {
            arrayList.add(this.f5721b.read2(c2052a));
        }
        c2052a.mo5419f();
        int size = arrayList.size();
        if (!this.f5720a.isPrimitive()) {
            return arrayList.toArray((Object[]) Array.newInstance((Class<?>) this.f5720a, size));
        }
        Object newInstance = Array.newInstance((Class<?>) this.f5720a, size);
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(newInstance, i2, arrayList.get(i2));
        }
        return newInstance;
    }

    @Override // com.google.gson.AbstractC2077y
    public void write(C2055d c2055d, Object obj) throws IOException {
        if (obj == null) {
            c2055d.mo5448j();
            return;
        }
        c2055d.mo5442c();
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            this.f5721b.write(c2055d, Array.get(obj, i2));
        }
        c2055d.mo5446e();
    }
}
