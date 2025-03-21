package com.google.gson.p147b0.p148q;

import com.google.gson.AbstractC2077y;
import com.google.gson.C2051e;
import com.google.gson.InterfaceC2062j;
import com.google.gson.InterfaceC2070r;
import com.google.gson.InterfaceC2078z;
import com.google.gson.p146a0.InterfaceC2002b;
import com.google.gson.p147b0.C2010c;
import com.google.gson.p152d0.C2049a;

/* compiled from: JsonAdapterAnnotationTypeAdapterFactory.java */
/* renamed from: com.google.gson.b0.q.e */
/* loaded from: classes.dex */
public final class C2028e implements InterfaceC2078z {

    /* renamed from: a */
    private final C2010c f5732a;

    public C2028e(C2010c c2010c) {
        this.f5732a = c2010c;
    }

    /* renamed from: a */
    AbstractC2077y<?> m5409a(C2010c c2010c, C2051e c2051e, C2049a<?> c2049a, InterfaceC2002b interfaceC2002b) {
        AbstractC2077y<?> c2036m;
        Object mo5339a = c2010c.m5338a(C2049a.get((Class) interfaceC2002b.value())).mo5339a();
        boolean nullSafe = interfaceC2002b.nullSafe();
        if (mo5339a instanceof AbstractC2077y) {
            c2036m = (AbstractC2077y) mo5339a;
        } else if (mo5339a instanceof InterfaceC2078z) {
            c2036m = ((InterfaceC2078z) mo5339a).create(c2051e, c2049a);
        } else {
            boolean z = mo5339a instanceof InterfaceC2070r;
            if (!z && !(mo5339a instanceof InterfaceC2062j)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + mo5339a.getClass().getName() + " as a @JsonAdapter for " + c2049a.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            c2036m = new C2036m<>(z ? (InterfaceC2070r) mo5339a : null, mo5339a instanceof InterfaceC2062j ? (InterfaceC2062j) mo5339a : null, c2051e, c2049a, null, nullSafe);
            nullSafe = false;
        }
        return (c2036m == null || !nullSafe) ? c2036m : c2036m.nullSafe();
    }

    @Override // com.google.gson.InterfaceC2078z
    public <T> AbstractC2077y<T> create(C2051e c2051e, C2049a<T> c2049a) {
        InterfaceC2002b interfaceC2002b = (InterfaceC2002b) c2049a.getRawType().getAnnotation(InterfaceC2002b.class);
        if (interfaceC2002b == null) {
            return null;
        }
        return (AbstractC2077y<T>) m5409a(this.f5732a, c2051e, c2049a, interfaceC2002b);
    }
}
