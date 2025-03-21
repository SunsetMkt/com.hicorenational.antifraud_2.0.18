package com.bumptech.glide.util;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;

/* compiled from: Preconditions.java */
/* renamed from: com.bumptech.glide.util.j */
/* loaded from: classes.dex */
public final class C1876j {
    private C1876j() {
    }

    /* renamed from: a */
    public static void m4989a(boolean z, @NonNull String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    @NonNull
    /* renamed from: a */
    public static <T> T m4985a(@Nullable T t) {
        return (T) m4986a(t, "Argument must not be null");
    }

    @NonNull
    /* renamed from: a */
    public static <T> T m4986a(@Nullable T t, @NonNull String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    @NonNull
    /* renamed from: a */
    public static String m4987a(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must not be null or empty");
        }
        return str;
    }

    @NonNull
    /* renamed from: a */
    public static <T extends Collection<Y>, Y> T m4988a(@NonNull T t) {
        if (t.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        return t;
    }
}
