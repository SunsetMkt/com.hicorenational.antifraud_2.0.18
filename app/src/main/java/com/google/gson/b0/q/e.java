package com.google.gson.b0.q;

import com.google.gson.r;
import com.google.gson.y;
import com.google.gson.z;

/* JADX INFO: compiled from: JsonAdapterAnnotationTypeAdapterFactory.java */
/* JADX INFO: loaded from: classes.dex */
public final class e implements z {
    private final com.google.gson.b0.c a;

    public e(com.google.gson.b0.c cVar) {
        this.a = cVar;
    }

    y<?> a(com.google.gson.b0.c cVar, com.google.gson.e eVar, com.google.gson.d0.a<?> aVar, com.google.gson.a0.b bVar) {
        y<?> mVar;
        Object objA = cVar.a(com.google.gson.d0.a.get((Class) bVar.value())).a();
        boolean zNullSafe = bVar.nullSafe();
        if (objA instanceof y) {
            mVar = (y) objA;
        } else if (objA instanceof z) {
            mVar = ((z) objA).create(eVar, aVar);
        } else {
            boolean z = objA instanceof r;
            if (!z && !(objA instanceof com.google.gson.j)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + objA.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            mVar = new m<>(z ? (r) objA : null, objA instanceof com.google.gson.j ? (com.google.gson.j) objA : null, eVar, aVar, null, zNullSafe);
            zNullSafe = false;
        }
        return (mVar == null || !zNullSafe) ? mVar : mVar.nullSafe();
    }

    @Override // com.google.gson.z
    public <T> y<T> create(com.google.gson.e eVar, com.google.gson.d0.a<T> aVar) {
        com.google.gson.a0.b bVar = (com.google.gson.a0.b) aVar.getRawType().getAnnotation(com.google.gson.a0.b.class);
        if (bVar == null) {
            return null;
        }
        return (y<T>) a(this.a, eVar, aVar, bVar);
    }
}
