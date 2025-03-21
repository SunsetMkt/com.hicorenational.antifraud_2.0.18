package com.google.gson.p147b0;

import java.lang.reflect.Type;

/* compiled from: Primitives.java */
/* renamed from: com.google.gson.b0.m */
/* loaded from: classes.dex */
public final class C2020m {
    private C2020m() {
    }

    /* renamed from: a */
    public static boolean m5379a(Type type) {
        return (type instanceof Class) && ((Class) type).isPrimitive();
    }

    /* renamed from: b */
    public static boolean m5381b(Type type) {
        return type == Integer.class || type == Float.class || type == Byte.class || type == Double.class || type == Long.class || type == Character.class || type == Boolean.class || type == Short.class || type == Void.class;
    }

    /* renamed from: a */
    public static <T> Class<T> m5378a(Class<T> cls) {
        return cls == Integer.class ? Integer.TYPE : cls == Float.class ? Float.TYPE : cls == Byte.class ? Byte.TYPE : cls == Double.class ? Double.TYPE : cls == Long.class ? Long.TYPE : cls == Character.class ? Character.TYPE : cls == Boolean.class ? Boolean.TYPE : cls == Short.class ? Short.TYPE : cls == Void.class ? Void.TYPE : cls;
    }

    /* renamed from: b */
    public static <T> Class<T> m5380b(Class<T> cls) {
        return cls == Integer.TYPE ? Integer.class : cls == Float.TYPE ? Float.class : cls == Byte.TYPE ? Byte.class : cls == Double.TYPE ? Double.class : cls == Long.TYPE ? Long.class : cls == Character.TYPE ? Character.class : cls == Boolean.TYPE ? Boolean.class : cls == Short.TYPE ? Short.class : cls == Void.TYPE ? Void.class : cls;
    }
}
