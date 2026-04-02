package com.google.gson.b0.q;

import com.google.gson.b0.q.k;
import com.google.gson.y;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: compiled from: TypeAdapterRuntimeTypeWrapper.java */
/* JADX INFO: loaded from: classes.dex */
final class n<T> extends y<T> {
    private final com.google.gson.e a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final y<T> f3729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Type f3730c;

    n(com.google.gson.e eVar, y<T> yVar, Type type) {
        this.a = eVar;
        this.f3729b = yVar;
        this.f3730c = type;
    }

    private static boolean a(y<?> yVar) {
        y<?> yVarA;
        while ((yVar instanceof l) && (yVarA = ((l) yVar).a()) != yVar) {
            yVar = yVarA;
        }
        return yVar instanceof k.b;
    }

    @Override // com.google.gson.y
    public T read(com.google.gson.e0.a aVar) throws IOException {
        return this.f3729b.read(aVar);
    }

    @Override // com.google.gson.y
    public void write(com.google.gson.e0.d dVar, T t) throws IOException {
        y<T> yVarA = this.f3729b;
        Type typeA = a(this.f3730c, t);
        if (typeA != this.f3730c) {
            yVarA = this.a.a((com.google.gson.d0.a) com.google.gson.d0.a.get(typeA));
            if ((yVarA instanceof k.b) && !a(this.f3729b)) {
                yVarA = this.f3729b;
            }
        }
        yVarA.write(dVar, t);
    }

    private static Type a(Type type, Object obj) {
        return obj != null ? ((type instanceof Class) || (type instanceof TypeVariable)) ? obj.getClass() : type : type;
    }
}
