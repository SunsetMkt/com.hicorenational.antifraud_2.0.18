package com.google.gson;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

/* compiled from: FieldAttributes.java */
/* renamed from: com.google.gson.b */
/* loaded from: classes.dex */
public final class C2007b {

    /* renamed from: a */
    private final Field f5646a;

    public C2007b(Field field) {
        this.f5646a = (Field) Objects.requireNonNull(field);
    }

    /* renamed from: a */
    public <T extends Annotation> T m5303a(Class<T> cls) {
        return (T) this.f5646a.getAnnotation(cls);
    }

    /* renamed from: b */
    public Class<?> m5306b() {
        return this.f5646a.getType();
    }

    /* renamed from: c */
    public Type m5307c() {
        return this.f5646a.getGenericType();
    }

    /* renamed from: d */
    public Class<?> m5308d() {
        return this.f5646a.getDeclaringClass();
    }

    /* renamed from: e */
    public String m5309e() {
        return this.f5646a.getName();
    }

    public String toString() {
        return this.f5646a.toString();
    }

    /* renamed from: a */
    public Collection<Annotation> m5304a() {
        return Arrays.asList(this.f5646a.getAnnotations());
    }

    /* renamed from: a */
    public boolean m5305a(int i2) {
        return (i2 & this.f5646a.getModifiers()) != 0;
    }
}
