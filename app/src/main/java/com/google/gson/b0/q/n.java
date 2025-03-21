package com.google.gson.b0.q;

import com.google.gson.b0.q.k;
import com.google.gson.y;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* compiled from: TypeAdapterRuntimeTypeWrapper.java */
/* loaded from: classes.dex */
final class n<T> extends y<T> {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.gson.e f5621a;

    /* renamed from: b, reason: collision with root package name */
    private final y<T> f5622b;

    /* renamed from: c, reason: collision with root package name */
    private final Type f5623c;

    n(com.google.gson.e eVar, y<T> yVar, Type type) {
        this.f5621a = eVar;
        this.f5622b = yVar;
        this.f5623c = type;
    }

    private static boolean a(y<?> yVar) {
        y<?> a2;
        while ((yVar instanceof l) && (a2 = ((l) yVar).a()) != yVar) {
            yVar = a2;
        }
        return yVar instanceof k.b;
    }

    @Override // com.google.gson.y
    /* renamed from: read */
    public T read2(com.google.gson.e0.a aVar) throws IOException {
        return this.f5622b.read2(aVar);
    }

    @Override // com.google.gson.y
    public void write(com.google.gson.e0.d dVar, T t) throws IOException {
        y<T> yVar = this.f5622b;
        Type a2 = a(this.f5623c, t);
        if (a2 != this.f5623c) {
            yVar = this.f5621a.a((com.google.gson.d0.a) com.google.gson.d0.a.get(a2));
            if ((yVar instanceof k.b) && !a(this.f5622b)) {
                yVar = this.f5622b;
            }
        }
        yVar.write(dVar, t);
    }

    private static Type a(Type type, Object obj) {
        return obj != null ? ((type instanceof Class) || (type instanceof TypeVariable)) ? obj.getClass() : type : type;
    }
}
