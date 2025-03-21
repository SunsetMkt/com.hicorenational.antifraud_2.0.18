package com.google.gson.b0.q;

import com.google.gson.r;
import com.google.gson.y;
import com.google.gson.z;

/* compiled from: JsonAdapterAnnotationTypeAdapterFactory.java */
/* loaded from: classes.dex */
public final class e implements z {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.gson.b0.c f5565a;

    public e(com.google.gson.b0.c cVar) {
        this.f5565a = cVar;
    }

    y<?> a(com.google.gson.b0.c cVar, com.google.gson.e eVar, com.google.gson.d0.a<?> aVar, com.google.gson.a0.b bVar) {
        y<?> mVar;
        Object a2 = cVar.a(com.google.gson.d0.a.get((Class) bVar.value())).a();
        boolean nullSafe = bVar.nullSafe();
        if (a2 instanceof y) {
            mVar = (y) a2;
        } else if (a2 instanceof z) {
            mVar = ((z) a2).create(eVar, aVar);
        } else {
            boolean z = a2 instanceof r;
            if (!z && !(a2 instanceof com.google.gson.j)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + a2.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            mVar = new m<>(z ? (r) a2 : null, a2 instanceof com.google.gson.j ? (com.google.gson.j) a2 : null, eVar, aVar, null, nullSafe);
            nullSafe = false;
        }
        return (mVar == null || !nullSafe) ? mVar : mVar.nullSafe();
    }

    @Override // com.google.gson.z
    public <T> y<T> create(com.google.gson.e eVar, com.google.gson.d0.a<T> aVar) {
        com.google.gson.a0.b bVar = (com.google.gson.a0.b) aVar.getRawType().getAnnotation(com.google.gson.a0.b.class);
        if (bVar == null) {
            return null;
        }
        return (y<T>) a(this.f5565a, eVar, aVar, bVar);
    }
}
