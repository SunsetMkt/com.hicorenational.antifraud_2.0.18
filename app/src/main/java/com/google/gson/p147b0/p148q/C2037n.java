package com.google.gson.p147b0.p148q;

import com.google.gson.AbstractC2077y;
import com.google.gson.C2051e;
import com.google.gson.p147b0.p148q.C2034k;
import com.google.gson.p152d0.C2049a;
import com.google.gson.p153e0.C2052a;
import com.google.gson.p153e0.C2055d;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* compiled from: TypeAdapterRuntimeTypeWrapper.java */
/* renamed from: com.google.gson.b0.q.n */
/* loaded from: classes.dex */
final class C2037n<T> extends AbstractC2077y<T> {

    /* renamed from: a */
    private final C2051e f5799a;

    /* renamed from: b */
    private final AbstractC2077y<T> f5800b;

    /* renamed from: c */
    private final Type f5801c;

    C2037n(C2051e c2051e, AbstractC2077y<T> abstractC2077y, Type type) {
        this.f5799a = c2051e;
        this.f5800b = abstractC2077y;
        this.f5801c = type;
    }

    /* renamed from: a */
    private static boolean m5482a(AbstractC2077y<?> abstractC2077y) {
        AbstractC2077y<?> mo5473a;
        while ((abstractC2077y instanceof AbstractC2035l) && (mo5473a = ((AbstractC2035l) abstractC2077y).mo5473a()) != abstractC2077y) {
            abstractC2077y = mo5473a;
        }
        return abstractC2077y instanceof C2034k.b;
    }

    @Override // com.google.gson.AbstractC2077y
    /* renamed from: read */
    public T read2(C2052a c2052a) throws IOException {
        return this.f5800b.read2(c2052a);
    }

    @Override // com.google.gson.AbstractC2077y
    public void write(C2055d c2055d, T t) throws IOException {
        AbstractC2077y<T> abstractC2077y = this.f5800b;
        Type m5481a = m5481a(this.f5801c, t);
        if (m5481a != this.f5801c) {
            abstractC2077y = this.f5799a.m5557a((C2049a) C2049a.get(m5481a));
            if ((abstractC2077y instanceof C2034k.b) && !m5482a(this.f5800b)) {
                abstractC2077y = this.f5800b;
            }
        }
        abstractC2077y.write(c2055d, t);
    }

    /* renamed from: a */
    private static Type m5481a(Type type, Object obj) {
        return obj != null ? ((type instanceof Class) || (type instanceof TypeVariable)) ? obj.getClass() : type : type;
    }
}
