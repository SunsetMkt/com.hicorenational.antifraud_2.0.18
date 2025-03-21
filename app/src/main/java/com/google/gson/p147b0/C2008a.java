package com.google.gson.p147b0;

/* compiled from: $Gson$Preconditions.java */
/* renamed from: com.google.gson.b0.a */
/* loaded from: classes.dex */
public final class C2008a {
    private C2008a() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    /* renamed from: a */
    public static <T> T m5310a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    public static void m5311a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }
}
