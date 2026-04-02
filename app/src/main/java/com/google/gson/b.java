package com.google.gson;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

/* JADX INFO: compiled from: FieldAttributes.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    private final Field a;

    public b(Field field) {
        this.a = (Field) Objects.requireNonNull(field);
    }

    public <T extends Annotation> T a(Class<T> cls) {
        return (T) this.a.getAnnotation(cls);
    }

    public Class<?> b() {
        return this.a.getType();
    }

    public Type c() {
        return this.a.getGenericType();
    }

    public Class<?> d() {
        return this.a.getDeclaringClass();
    }

    public String e() {
        return this.a.getName();
    }

    public String toString() {
        return this.a.toString();
    }

    public Collection<Annotation> a() {
        return Arrays.asList(this.a.getAnnotations());
    }

    public boolean a(int i2) {
        return (i2 & this.a.getModifiers()) != 0;
    }
}
