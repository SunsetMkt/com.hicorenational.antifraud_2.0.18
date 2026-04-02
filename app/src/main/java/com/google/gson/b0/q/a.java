package com.google.gson.b0.q;

import com.google.gson.y;
import com.google.gson.z;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* JADX INFO: compiled from: ArrayTypeAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public final class a<E> extends y<Object> {

    /* JADX INFO: renamed from: c */
    public static final z f3680c = new C0074a();
    private final Class<E> a;

    /* JADX INFO: renamed from: b */
    private final y<E> f3681b;

    /* JADX INFO: renamed from: com.google.gson.b0.q.a$a */
    /* JADX INFO: compiled from: ArrayTypeAdapter.java */
    class C0074a implements z {
        C0074a() {
        }

        @Override // com.google.gson.z
        public <T> y<T> create(com.google.gson.e eVar, com.google.gson.d0.a<T> aVar) {
            Type type = aVar.getType();
            if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class) type).isArray())) {
                return null;
            }
            Type typeD = com.google.gson.b0.b.d(type);
            return new a(eVar, eVar.a((com.google.gson.d0.a) com.google.gson.d0.a.get(typeD)), com.google.gson.b0.b.e(typeD));
        }
    }

    public a(com.google.gson.e eVar, y<E> yVar, Class<E> cls) {
        this.f3681b = new n(eVar, yVar, cls);
        this.a = cls;
    }

    @Override // com.google.gson.y
    public Object read(com.google.gson.e0.a aVar) throws IOException {
        if (aVar.peek() == com.google.gson.e0.c.NULL) {
            aVar.r();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.c();
        while (aVar.j()) {
            arrayList.add(this.f3681b.read(aVar));
        }
        aVar.f();
        int size = arrayList.size();
        if (!this.a.isPrimitive()) {
            return arrayList.toArray((Object[]) Array.newInstance((Class<?>) this.a, size));
        }
        Object objNewInstance = Array.newInstance((Class<?>) this.a, size);
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(objNewInstance, i2, arrayList.get(i2));
        }
        return objNewInstance;
    }

    @Override // com.google.gson.y
    public void write(com.google.gson.e0.d dVar, Object obj) throws IOException {
        if (obj == null) {
            dVar.j();
            return;
        }
        dVar.c();
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            this.f3681b.write(dVar, (E) Array.get(obj, i2));
        }
        dVar.e();
    }
}
